package graph;

import java.util.LinkedList;

import cre.ComplexRole;
import cre.TMSPrincipal;

public class Node3 implements Node{

	private ComplexRole role;
	private Graph g;
	private LinkedList<TMSPrincipal> solutions;
	private LinkedList<Node> b_sol_monitors;
	private int b_proc_state;
	
	public Node3(ComplexRole cr, Graph graph)
	{
		this.role = cr;
		this.g = graph;
		solutions = new LinkedList<TMSPrincipal>();
		b_sol_monitors = new LinkedList<Node>();
		this.b_proc_state = 0;
	}
	
	public ComplexRole getNodeSemantics()
	{
		return this.role;
	}

	@Override
	public void changeFlag(int i) {
		// TODO Auto-generated method stub
		this.b_proc_state = i;
	}

	@Override
	public int getFlag() {
		// TODO Auto-generated method stub
		return this.b_proc_state;
	}

	@Override
	public void b_process() {
		// TODO Auto-generated method stub
		changeFlag(2);
		Node n = g.addNode(this.role.getRole());
		n.add_b_sol_monitor(new BLinkingMonitor(g, role));
		n.b_activate();
	}

	@Override
	public void add_b_sol_monitor(Node n) {
		// TODO Auto-generated method stub
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
