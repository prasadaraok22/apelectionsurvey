package com.election.apsurvey.dto;

public class AssemblyConstituencyDTO implements Comparable<String>{

	private String constituencytName;
	private int constituencytCode;
	public String getConstituencytName() {
		return constituencytName;
	}
	public void setConstituencytName(String constituencytName) {
		this.constituencytName = constituencytName;
	}
	public int getConstituencytCode() {
		return constituencytCode;
	}
	public void setConstituencytCode(int constituencytCode) {
		this.constituencytCode = constituencytCode;
	}
	
	@Override
	public int compareTo(String o) {
		return this.constituencytName.compareTo(o);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return constituencytCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true   
        if (obj == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of AssemblyConstituencyDTO or not 
          "null instanceof [type]" also returns false */
        if (!(obj instanceof AssemblyConstituencyDTO)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        AssemblyConstituencyDTO c = (AssemblyConstituencyDTO) obj; 
          
        // Compare the data members and return accordingly  
        return this.constituencytName.equals(c.constituencytName); 
	}
}
