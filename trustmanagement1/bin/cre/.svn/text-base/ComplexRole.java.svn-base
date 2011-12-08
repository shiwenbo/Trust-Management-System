package cre;

public class ComplexRole {

	private Role role;
	private RoleName roleName;
	private TMSPrincipal[] semantics;
	private int i;
	public ComplexRole(Role r, RoleName rn)
	{
		this.role = r;
		this.roleName = rn;
		this.semantics = new TMSPrincipal[10];
		this.i = 0;
	}
	
	public Role getRole()
	{
		return role;
	}
	
	public RoleName getRoleName()
	{
		return roleName;
	}
	
	public void addValue(TMSPrincipal p)
	{
		boolean exit = false;
		for(int j = 0; j< i; j++)
		{
			if(p.getTMSPrincipal().equals(semantics[j].getTMSPrincipal()))
				exit = true;
		}
		if(false == exit)
		{
			semantics[i] = p;
			i ++;
		}		
	}
	public void printSemantics()
	{
		//System.out.println(semantics[0].getTMSPrincipal());
		for(int j = 0; j < i; j ++)
		{
			System.out.println(semantics[j].getTMSPrincipal());
		}
		System.out.println("-------------------------");
	}
	public int getPricipalNum()
	{
		return i;
	}
	public TMSPrincipal[] getTMSPincipals()
	{
		return semantics;
	}
}
