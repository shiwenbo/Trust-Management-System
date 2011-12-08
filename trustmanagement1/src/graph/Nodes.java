package graph;

import cre.ComplexRole;
import cre.Role;
import cre.TMSPrincipal;

public class Nodes {

	private Node1[] node1;
	private int num1;
	private Node2[] node2;
	private int num2;
	private Node3[] node3;
	private int num3;
	
	public Nodes()
	{
		node1 = new Node1[10];
		num1 = 0;
		node2 = new Node2[10];
		num2 = 0;
		node3 = new Node3[10];
		num3 = 0;
	}
	public void addNode1(Node1 n1)
	{
		node1[num1] = n1;
		num1 ++;
	}
	public void addNode2(Node2 n2)
	{
		node2[num2]  = n2;
		num2 ++;
	}
	public void addNode3(Node3 n3)
	{
		node3[num3] = n3;
		num3 ++;
	}
	public Node1 getNode1(int i)
	{
		return node1[i];
	}
	public int getNode1Num()
	{
		return num1;
	}
	public int getNode2Num()
	{
		return num2;
	}
	public Node2 getNode2(int i)
	{
		return node2[i];
	}
	public Node3 getNode3(int i)
	{
		return node3[i];
	}
	public int getNode3Num()
	{
		return num3;
	}
	public Node1 getNode1(TMSPrincipal p)
	{
		for(int i = 0; i < num1; i ++)
		{
			if(node1[i].getNodeSemantics().equals(p))
				return node1[i];
		}
		return null;
	}
	public Node2 getNode2(Role r)
	{
		for(int i = 0; i < num2; i ++)
		{
			if(node2[i].getNodeSemantics().equals(r))
				return node2[i];
		}
		return null;
	}
	public Node3 getNode3(ComplexRole cr)
	{
		for(int i = 0; i < num3; i ++)
		{
			if(node3[i].getNodeSemantics().equals(cr))
				return node3[i];
		}
		return null;
	}
}
