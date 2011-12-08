package cre;

public class Credential2 {
	Role pre;
	Role post;
	public Credential2(Role f, Role b)
	{
		this.pre = f;
		this.post = b;
	}
	
	public Role getCredentialPre()
	{
		return this.pre;
	}
	public Role getCredentialPost()
	{
		return this.post;
	}
	
}
