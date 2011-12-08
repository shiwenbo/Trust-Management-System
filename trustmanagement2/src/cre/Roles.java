package cre;

public class Roles {
	private Role[] roles; 
	private int num;
	public Roles()
	{
		roles = new Role[10];
		num = 0;
	}
	public void addRole(Role r)
	{
		roles[num] = r;
		num ++;
	}
	public Role getRole(int i)
	{
		if(i >= num)
			return null;
		else
			return roles[i];
	}
	public int getNum()
	{
		return num;
	}
	public TMSPrincipal[] getRolePrincipal(Role r)
	{
		int i = 0;
		while((i < num)&&(!roles[i].equals(r)) )
		{
			i++;
		}
		/*while((i < num)&&(!(roles[i].getPre().getName().equals(r.getPre().getName()))&& (roles[i].getPost().getRoleName().equals(r.getPost().getRoleName()))) )
		{
			i++;
		}*/
		if(i == num)
			return null;
		else
			return roles[i].getTMSPincipals();
	}
	
	public int getRolePrincipalNum(Role r)
	{
		int i = 0;
		while((!roles[i].equals(r))&& (i < num))
		{
			i++;
		}
		/*while((i < num)&&(!(roles[i].getPre().getName().equals(r.getPre().getName()))&& (roles[i].getPost().getRoleName().equals(r.getPost().getRoleName()))) )
		{
			i++;
		}
		System.out.println("bbb" + i);*/
		if(i == num)
			return 0;
		else
			return roles[i].getPricipalNum();
	}
	public Role getRole(TMSPrincipal p, RoleName rn)
	{
		for(int i = 0; i<num; i++)
		{
			if((p.getTMSPrincipal().equals(roles[i].getPre().getTMSPrincipal())
					&& (rn.getRoleName().equals(roles[i].getPost().getRoleName()))))
				return roles[i];
		}
		return null;
	}

}
