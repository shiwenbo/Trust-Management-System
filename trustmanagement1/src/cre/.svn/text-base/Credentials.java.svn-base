package cre;

public class Credentials {
	private Credential1[] c1;
	private Credential2[] c2;
	private Credential3[] c3;
	private int num1;
	private int num2;
	private int num3;
	public Credentials()
	{
		c1 = new Credential1[10];
		c2 = new Credential2[10];
		c3 = new Credential3[10];
		num1 = 0;
		num2 = 0;
		num3 = 0;
	}
	public void addCredential1(Credential1 cre)
	{
		c1[num1] = cre;
		num1 ++;
	}
	public void addCredential2(Credential2 cre)
	{
		c2[num2] = cre;
		num2 ++;
	}
	public void addCredential3(Credential3 cre)
	{
		c3[num3] = cre;
		num3 ++;
	}
	public int getCre1Num()
	{
		return num1;
	}
	public int getCre2Num()
	{
		return num2;
	}
	public int getCre3Num()
	{
		return num3;
	}
	public Credential1 getCredential1(int i)
	{
		if(i < num1)
			return c1[i];
		else 
			return null;
	}
	public Credential2 getCredential2(int i)
	{
		if(i < num2)
			return c2[i];
		else
			return null;
	}
	public Credential3 getCredential3(int i)
	{
		if(i < num3)
			return c3[i];
		else 
			return null;
	}
}
