package Entities;

import cre.ComplexRole;
import cre.Credential1;
import cre.Credential2;
import cre.Credential3;
import cre.Credentials;
import cre.Role;
import cre.RoleName;
import cre.TMSPrincipal;

public class EOrg implements Entity{

	private Credentials cres;
	private TMSPrincipal principal;
	public EOrg()
	{
		cres = new Credentials();
		principal = new TMSPrincipal("EOrg");
		TMSPrincipal p1 = new TMSPrincipal("EOrg");
		TMSPrincipal p2 = new TMSPrincipal("ABU");
		RoleName rn1 = new RoleName("preferred");
		RoleName rn2 = new RoleName("university");
		RoleName rn3 = new RoleName("student");
		RoleName rn4 = new RoleName("accredited");
		Role r1 = new Role(p1, rn1);
		Role r2 = new Role(p1, rn2);
		Role r3 = new Role(p2, rn4);
		ComplexRole cr = new ComplexRole(r2, rn3);
		Credential3 cr3 = new Credential3(r1, cr);
		Credential2 cr2 = new Credential2(r2, r3);
		this.addCredential2(cr2);
		this.addCredential3(cr3);
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
