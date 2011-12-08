package graph;

import java.util.LinkedList;

import cre.ComplexRole;
import cre.Credentials;
import cre.Role;
import cre.Roles;
import cre.TMSPrincipal;

public class Graph {

	private LinkedList<Node>[] head;
	private int headNum;
	private LinkedList<Node> b_proc_queue;
	private Nodes nodes;
	private Credentials cres;
	private Roles roles;
	
	public Graph()
	{
		head = new LinkedList[10];
		b_proc_queue = new LinkedList<Node>();
		headNum = 0;
		nodes = new Nodes();
		cres = new Credentials();
		roles = new Roles();
	}
	public void setCredentials(Credentials credentials)
	{
		this.cres = credentials;
	}
	public Credentials getCredentials()
	{
		return this.cres;
	}
	public void run()
	{
		while(b_proc_queue.size() != 0)
		{
			Node n = b_proc_queue.getFirst();
			b_proc_queue.removeFirst();			
			n.b_process();
		}
	}
	public void addHead(Node n)
	{
		head[headNum] = new LinkedList<Node>();
		head[headNum].add(n);
		headNum ++;
	}
	public int getHeadNum(Node n)
	{
		for(int i = 0; i < headNum; i ++)
		{
			if(head[i].getFirst().equals(n))
				return i;				
		}
		return -1;
	}
	public Node getRoot()
	{
		return head[0].getFirst();
	}
	public Node addNode(TMSPrincipal principal) {
		// TODO Auto-generated method stub
		Node1 n1 = nodes.getNode1(principal);
		if(null == n1)
		{
			n1 = new Node1(principal,this);
			nodes.addNode1(n1);
		}
		boolean f = false;
		for(int i = 0; i < headNum; i ++)
		{
			if(head[i].getFirst().equals(n1))
					f = true;
		}
		if(false == f)
			addHead(n1);
		return n1;
	}
	public Node addNode(Role role)
	{
		Node2 n2 = nodes.getNode2(role);
		if(null == n2)
		{
			n2 = new Node2(role, this);
			nodes.addNode2(n2);
		}
		boolean f = false;
		for(int i = 0; i < headNum; i ++)
		{
			if(head[i].getFirst().equals(n2))
				f = true;
		}
		if(false == f)
			addHead(n2);
		return n2;
	}
	public Node addNode(ComplexRole cr)
	{
		Node3 n3 = nodes.getNode3(cr);
		if(null == n3)
		{
			n3 = new Node3(cr, this);
			nodes.addNode3(n3);
		}
		boolean f = false;
		for(int i = 0; i < headNum; i ++)
		{
			if(head[i].getFirst().equals(n3))
					f = true;
		}
		if(false == f)
			addHead(n3);
		return n3;
	}
	public void addEdge(Node n1, Node n2)
	{
		int num = getHeadNum(n1);
		for(int i = 1; i < head[num].size(); i ++)
		{
			if(head[num].get(i).equals(n2))
				return;
		}
		head[num].add(n2);
		n1.add_b_sol_monitor(n2);
		if(0 != n2.getFlag())
		{
			n1.b_activate();
		}
	}
	public void enqueue(Node n)
	{
		b_proc_queue.add(n);
	}
	public LinkedList<Node> getOutEdges(Node n)
	{
		int num = getHeadNum(n);
		return head[num];
	}
	public LinkedList<Node> getInEdges(Node n)
	{
		LinkedList<Node> inNode = new LinkedList<Node>();
		for(int i = 0; i < headNum; i ++)
		{
			for(int j = 1; j < head[i].size(); j ++)
			{
				if(head[i].get(j).equals(n))
					inNode.add(head[i].getFirst());
			}
		}
		return inNode;
	}
	public void setRoles(Roles roles) {
		// TODO Auto-generated method stub
		
		this.roles = roles;
	}
	public Roles getRoles()
	{
		return this.roles;
	}
}
