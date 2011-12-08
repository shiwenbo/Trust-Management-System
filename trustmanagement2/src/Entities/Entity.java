package Entities;

import cre.Credential1;
import cre.Credential2;
import cre.Credential3;
import cre.Credentials;
import cre.Role;
import cre.TMSPrincipal;

public interface Entity {

	public Credentials getCredentials(Role role);
	public void addCredential1(Credential1 cr1);
	public void addCredential2(Credential2 cr2);
	public void addCredential3(Credential3 cr3);
	public TMSPrincipal getEntityPrincipal();
}
