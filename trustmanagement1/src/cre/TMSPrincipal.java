package cre;

import java.security.Principal;

public class TMSPrincipal implements Principal{

	public static final String tmsString  = "trust management system";
	private String principal;
	
	public TMSPrincipal(String s)
	{
		this.principal = s;
	}
	
	public String getTMSPrincipal()
	{
		return principal;
	}
	
	//extends
	public int hashCode()
    {
        return tmsString.hashCode();
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		 return tmsString;
	    
	}
}
