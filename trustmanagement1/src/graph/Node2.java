package graph;

import java.util.LinkedList;

import cre.Credentials;
import cre.Role;
import cre.TMSPrincipal;

public class Node2 implements Node{

	private Role role;
	private Graph g;
	private int b_proc_state;
	private LinkedList<TMSPrincipal> solutions;
	
	//include backward linking monitors, and all the nodes that the current node 
	//  can reach directly through an edge
	private LinkedList<Node> b_sol_monitors;
	private Credentials cres;
	
	public Node2(Role r, Graph graph)
	{
		this.role = r;
		this.g = graph;
		this.b_proc_state = 0;  //unprocessed
		solutions = new LinkedList<TMSPrincipal>();
		b_sol_monitors = new LinkedList<Node>();
		this.cres = graph.getCredentials();
	}
	public Role getNodeSemantics()
	{
		return this.role;
	}
	public void add_b_sol_monitor(Node n)
	{
		for(int i = 0; i < b_sol_monitors.size(); i ++)
		{
			if(b_sol_monitors.get(i).equals(n));
			return;
		}
		b_sol_monitors.add(n);
		for(int i = 0; i < solutions.size(); i ++)
		{
			n.add_b_solution(solutions.get(i));
		}
	}
	@Override
	public void changeFlag(int i) {
		// TODO Auto-generated method stub
		this.b_proc_state = i;
	}

	@Override
	public int getFlag() {
		// TODO Auto-generated method stub
		return b_proc_state;
	}

	@Override
	public void b_process() {
		// TODO Auto-generated method stub
		this.b_proc_state = 2;
		for(int i = 0; i < cres.getCre1Num(); i ++)
		{
			if(cres.getCredential1(i).getCredentialPre().equals(this.role))
			{
				Node n1 = g.addNode(cres.getCredential1(i).getCredentialPost());
				g.addEdge(n1, this);
			}
		}
		
		for(int j = 0; j < cres.getCre2Num(); j ++)
		{
			if(cres.getCredential2(j).getCredentialPre().equals(this.role))
			{
				Node n2 = g.addNode(cres.getCredential2(j).getCredentialPost());
				g.addEdge(n2, this);
			}
		}
		
		for(int k = 0; k < cres.getCre3Num(); k ++)
		{
			if(cres.getCredential3(k).getCredentialPre().equals(this.role))
			{
				Node n3 = g.addNode(cres.getCredential3(k).getCredentialPost());
				g.addEdge(n3, this);
			}
		}
	}

	@Override
	public void b_activate() {
		// TODO Auto-generated method stub
		if(0 != b_proc_state)
			return;
		b_proc_state = 1;
		g.enqueue(this);
		LinkedList<Node> l = g.getInEdges(this);
		for(int i = 0; i < l.size(); i ++)
		{
			l.get(i).b_activate();
		}		
		
	}

	@Override
	public void add_b_solution(TMSPrincipal principal) {
		// TODO Auto-generated method stub
		for(int i = 0; i < solutions.size(); i ++)
		{
			if(solutions.get(i).equals(principal))
				return;
		}
		solutions.add(principal);
		for(int j = 0; j < b_sol_monitors.size(); j ++)
		{
			b_sol_monitors.get(j).add_b_solution(principal);
		}
	}
	@Override
	public void printSolutions() {
		// TODO Auto-generated method stub
		for(int i = 0; i < solutions.size(); i ++)
		{
			System.out.println(solutions.get(i).getTMSPrincipal());
		}
		System.out.println("---------------------");
	}

}
