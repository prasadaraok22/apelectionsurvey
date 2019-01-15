package com.election.apsurvey.apelectionsurvey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * It reads data from Election Commission of India API and exports to mysql DB.
 * @author Prasadarao K
 *
 */
public class ExportElectionCommissionofIndiaData {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/apelectionsurvey";
	private static final String DB_USER = "apsurveyuser";
	private static final String DB_PASSWORD = "apsurveyPWD9563";

	public static void main(String[] args) {
		
		List<LinkedHashMap<String, String>> districtsList = getDistricts("S01");
		int ac = 0;
		for(LinkedHashMap<String, String> district : districtsList) {
			
			String dist_no1 = district.get("dist_no");
			String dist_name1 = district.get("dist_name");
			String ST_CODE1 = district.get("ST_CODE");
			System.out.println("dist_no1 " + dist_no1);
			System.out.println("dist_name1 " + dist_name1);
			System.out.println("ST_CODE1 " + ST_CODE1);
			
			System.out.println("Retrieving assemblyConstituencyList for district : " + dist_no1);
			List<LinkedHashMap<String, String>> assemblyConstituencyList = getAssemblyConstituencyData(ST_CODE1, dist_no1);
			int i = 0;
			for(LinkedHashMap<String, String> assemblyConstituency : assemblyConstituencyList) {
				
				String ac_no = assemblyConstituency.get("ac_no");
				String ac_name = assemblyConstituency.get("ac_name");
				String DIST_NO = assemblyConstituency.get("DIST_NO");
				String ST_CODE = assemblyConstituency.get("ST_CODE");
				System.out.println("ac_no " + ac_no);
				System.out.println("ac_name " + ac_name);
				System.out.println("DIST_NO " + DIST_NO);
				System.out.println("ST_CODE " + ST_CODE);
				try {
					if(insertRecordIntoTable(ac_no, ac_name, DIST_NO, ST_CODE)) {
						i++;
						ac++;
					}
				} catch (SQLException e) {
					System.out.println("Error occured for : " + ac_no);
					e.printStackTrace();
				}
				
			}
			System.out.println("assemblyConstituency successfully inserted count: " + i);
		}
		
		System.out.println("Total assemblyConstituencies statewise successfully inserted count: " + ac);
	}
	
	public static List<LinkedHashMap<String, String>> getDistricts(String state) {
		String acURL = "https://electoralsearch.in/Home/GetDistList?st_code=" + state;
		List<LinkedHashMap<String, String>> districts = null;
		try {

			URL url = new URL(acURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			ObjectMapper mapper = new ObjectMapper();
			//JSON from file to Object
			districts = mapper.readValue(br, ArrayList.class);
			System.out.println("districts size: " + districts.size());
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return districts;

	}

	public static List<LinkedHashMap<String, String>> getAssemblyConstituencyData(String state, String district) {
		String acURL = "https://electoralsearch.in/Home/GetAcList?dist_no=" + district + "&st_code=" + state;
		List<LinkedHashMap<String, String>> assemblyConstituencies = null;
		try {

			URL url = new URL(acURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			ObjectMapper mapper = new ObjectMapper();
			//JSON from file to Object
			assemblyConstituencies = mapper.readValue(br, ArrayList.class);
			System.out.println("assemblyConstituencies size: " + assemblyConstituencies.size());
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return assemblyConstituencies;

	}
	
	private static boolean insertRecordIntoTable(String ac_no, String ac_name, String DIST_NO, String ST_CODE) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		boolean status = false;

		String insertTableSQL = "INSERT INTO AssemblyConstituency"
				+ "(constituencycode, constituencyname, districtcode, stateid) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, ac_no);
			preparedStatement.setString(2, ac_name);
			preparedStatement.setString(3, DIST_NO);
			preparedStatement.setString(4, ST_CODE);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into AssemblyConstituency table!");
			status = true;
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return status;
	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}
