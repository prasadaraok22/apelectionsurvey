package com.election.apsurvey.dto;

import java.util.Set;
import java.util.TreeSet;


public class DistrictDTO implements Comparable<DistrictDTO>{

	public DistrictDTO(int districtCode, String districtName) {
		this.districtCode = districtCode;
		this.districtName = districtName;
	}
	private int districtCode;
	private String districtName;
	
	
	
	public int getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(int districtCode) {
		this.districtCode = districtCode;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	@Override
	public int compareTo(DistrictDTO o) {
		return this.districtName.compareTo((o.getDistrictName()));
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return districtCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true   
        if (obj == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of DistrictDTO or not 
          "null instanceof [type]" also returns false */
        if (!(obj instanceof DistrictDTO)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        DistrictDTO c = (DistrictDTO) obj; 
          
        // Compare the data members and return accordingly  
        return this.districtName.equals(c.districtName); 
	}
}
