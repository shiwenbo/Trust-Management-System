package tms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import graph.Graph;
import graph.Node;
import graph.Nodes;
import cre.ComplexRole;
import cre.Credential1;
import cre.Credential2;
import cre.Credential3;
import cre.Credentials;
import cre.Role;
import cre.RoleName;
import cre.Roles;
import cre.TMSPrincipal;

public class DBackwardAlgorithm {

	static Credentials cres = new Credentials(); 
	static Roles roles = new Roles();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//credential:A.r1<-B.r2;B.r2<-C
		/*TMSPrincipal pa = new TMSPrincipal("A");
		RoleName rna = new RoleName("r1");
		Role ra = new Role(pa,rna);
		roles.addRole(ra);
		
		TMSPrincipal pb = new TMSPrincipal("B");
		RoleName rnb = new RoleName("r2");
		Role rb = new Role(pb,rnb);
		roles.addRole(rb);
		
		TMSPrincipal pc = new TMSPrincipal("C");
		
		Credential2 c1 = new Credential2(ra,rb);
		Credential1 c2 = new Credential1(rb,pc);
		
		
		cres.addCredential2(c1);
		cres.addCredential1(c2);*/
		
		getCredentialInput();
		dBackward(cres.getCredential2(0).getCredentialPre());
	}
	
	public static void dBackward(Role r)
	{
		Graph g = new Graph();
		g.setCredentials(cres);
		Node n = g.addNode(r);
		n.b_activate();
		g.run();
		n.printSolutions();
	}
	
	
	public static void getCredentialInput() throws IOException
	{
		System.out.println("Input Credentials:");
		BufferedReader   stdin   =   new   BufferedReader(new   InputStreamReader(System.in));
		String cre = "";
		int category;
		while(!cre.equalsIgnoreCase("no"))
		{
			System.out.println("please input the category of credential");
			category = Integer.parseInt(stdin.readLine());
			switch(category)
			{
			case 1:
			{
				System.out.println("please input the Principal of Pre Role");
				String principalPre = stdin.readLine();
				System.out.println("please input the RoleName of Pre Role");
				String rolenamePre = stdin.readLine();
				System.out.println("please input the Principal of Post Role");
				String principalPost = stdin.readLine();
				TMSPrincipal pPre = new TMSPrincipal(principalPre);
				TMSPrincipal pPost = new TMSPrincipal(principalPost);
				RoleName rnPre = new RoleName(rolenamePre);
				Role rolePre = roles.getRole(pPre, rnPre);
				if(null == rolePre)
				{
					rolePre = new Role(pPre, rnPre);
					roles.addRole(rolePre);
				}				 
				Credential1 c1 = new Credential1(rolePre, pPost);
				cres.addCredential1(c1);
				break;
			}
			case 2:
			{
				System.out.println("please input the Principal of Pre Role");
				String principalPre = stdin.readLine();
				System.out.println("please input the RoleName of Pre Role");
				String rolenamePre = stdin.readLine();
				System.out.println("please input the Principal of Post Role");
				String principalPost = stdin.readLine();
				System.out.println("please input the RoleName of Post Role");
				String rolenamePost = stdin.readLine();
				TMSPrincipal pPre = new TMSPrincipal(principalPre);
				TMSPrincipal pPost = new TMSPrincipal(principalPost);
				RoleName rnPre = new RoleName(rolenamePre);
				RoleName rnPost = new RoleName(rolenamePost);
				Role rolePre = roles.getRole(pPre, rnPre);
				if(null == rolePre)
				{
					rolePre = new Role(pPre, rnPre);
					roles.addRole(rolePre);
				}
				Role rolePost = roles.getRole(pPost, rnPost);
				if(null == rolePost)
				{
					rolePost = new Role(pPost, rnPost);
					roles.addRole(rolePost);
				}
				Credential2 c2 = new Credential2(rolePre, rolePost);
				cres.addCredential2(c2);
				break;
			}
			case 3:
			{
				System.out.println("The two roles of the credential must have the same principal");
				System.out.println("please input the Principal of Pre Role");
				String principalPre = stdin.readLine();
				System.out.println("please input the RoleName of Pre Role");
				String rolenamePre = stdin.readLine();
				System.out.println("please input the first RoleName of Post Role");
				String rolenamePost1 = stdin.readLine();
				System.out.println("please input the second RoleName of Post Role");
				String rolenamePost2 = stdin.readLine();
				TMSPrincipal pPre = new TMSPrincipal(principalPre);
				RoleName rnPre = new RoleName(rolenamePre);
				RoleName rnPost1 = new RoleName(rolenamePost1);
				RoleName rnPost2 = new RoleName(rolenamePost2);
				Role rolePre = roles.getRole(pPre, rnPre);
				if(null == rolePre)
				{
					rolePre = new Role(pPre, rnPre);
					roles.addRole(rolePre);
				}
					
				Role tempRolePost = roles.getRole(pPre, rnPost1);
				//of course it have
				if(null == tempRolePost)
				{
					tempRolePost = new Role(pPre, rnPost1);
				}
				ComplexRole rolePost = new ComplexRole(tempRolePost, rnPost2);				
				Credential3 c3 = new Credential3(rolePre, rolePost);
				cres.addCredential3(c3);
				break;
			}
			case 4:
			{
				break;
			}
			default:
				break;
			}
			System.out.println("go on(yes or no)");
			cre = stdin.readLine();
		}
	}
}
