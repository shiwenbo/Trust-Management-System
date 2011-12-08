package Entities;

import cre.Credential1;
import cre.Credential2;
import cre.Credential3;
import cre.Credentials;
import cre.Role;
import cre.RoleName;
import cre.TMSPrincipal;

public class RegistrarB implements Entity{

	private Credentials cres;
	private TMSPrincipal principal;
	public RegistrarB()
	{
		cres = new Credentials();
		principal = new TMSPrincipal("RegistrarB");
		TMSPrincipal p1 = new TMSPrincipal("RegistrarB");
		TMSPrincipal p2 = new TMSPrincipal("Alice");
		RoleName rn = new RoleName("student");
		Role r = new Role(p1, rn);
		Credential1 c1 = new Credential1(r, p2);
		this.addCredential1(c1);
	}
	@Override
	public Credentials getCredentials(Role role) {
		// TODO Auto-generated method stub
		Credentials credentials = new Credentials();
		for(int i = 0; i < cres.getCre1Num(); i ++)
		{
			if((cres.getCredential1(i).getCredentialPre().getPre().getTMSPrincipal().equals(role.getPre().getTMSPrincipal()))
					&& (cres.getCredential1(i).getCredentialPre().getPost().getRoleName().equals(role.getPost().getRoleName())))
				credentials.addCredential1(cres.getCredential1(i));
		}
		for(int j = 0; j < cres.getCre2Num(); j ++)
		{
			if((cres.getCredential2(j).getCredentialPre().getPre().getTMSPrincipal().equals(role.getPre().getTMSPrincipal()))
					&& (cres.getCredential2(j).getCredentialPre().getPost().getRoleName().equals(role.getPost().getRoleName())))
				credentials.addCredential2(cres.getCredential2(j));
		}
		for(int k = 0; k < cres.getCre3Num(); k ++)
		{
			if((cres.getCredential3(k).getCredentialPre().getPre().getTMSPrincipal().equals(role.getPre().getTMSPrincipal()))
					&& (cres.getCredential3(k).getCredentialPre().getPost().getRoleName().equals(role.getPost().getRoleName())))
				credentials.addCredential3(cres.getCredential3(k));
		}
		return credentials;
	}
	@Override
	public void addCredential1(Credential1 cr1) {
		// TODO Auto-generated method stub
		this.cres.addCredential1(cr1);
	}
	@Override
	public void addCredential2(Credential2 cr2) {
		// TODO Auto-generated method stub
		this.cres.addCredential2(cr2);
	}
	@Override
	public void addCredential3(Credential3 cr3) {
		// TODO Auto-generated method stub
		this.cres.addCredential3(cr3);
	}
	@Override
	public TMSPrincipal getEntityPrincipal() {
		// TODO Auto-generated method stub
		return this.principal;
	}

}
