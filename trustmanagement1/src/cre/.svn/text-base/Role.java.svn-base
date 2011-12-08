package cre;

public class Role {

	private TMSPrincipal principal;
	private RoleName name;
	
	private TMSPrincipal[] semantics;
	private int i;
	public Role(TMSPrincipal p, RoleName n)
	{
		this.principal = p;
		this.name = n;
		semantics = new TMSPrincipal[10];
		i = 0;
	}
	public TMSPrincipal getPre()
	{
		return this.principal;
	}
	public RoleName getPost()
	{
		return this.name;
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
	public int getPricipalNum()
	{
		return i;
	}
	public TMSPrincipal[] getTMSPincipals()
	{
		return semantics;
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
}
