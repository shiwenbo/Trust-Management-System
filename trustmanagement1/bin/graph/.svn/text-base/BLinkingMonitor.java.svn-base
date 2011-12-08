package graph;

import cre.ComplexRole;
import cre.Role;
import cre.Roles;
import cre.TMSPrincipal;

public class BLinkingMonitor implements Node{

	/*public void add_b_solution(ComplexRole cr, TMSPrincipal p, Graph g)
	{
		//g.addNode(p);
		//g.addEdge();
	}*/

	ComplexRole cr;
	Graph g;
	Roles roles;
	public BLinkingMonitor(Graph graph, ComplexRole cr)
	{
		this.g = graph;
		this.cr = cr;
		this.roles = g.getRoles();
	}
	@Override
	public void changeFlag(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFlag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void b_process() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add_b_sol_monitor(Node n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b_activate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add_b_solution(TMSPrincipal principal) {
		// TODO Auto-generated method stub
		Role role = this.roles.getRole(principal,cr.getRoleName());
		if(null == role)
			return;
		Node n1 = g.addNode(role);
		Node n2 = g.addNode(this.cr);
		g.addEdge(n1, n2);
	}
	@Override
	public void printSolutions() {
		// TODO Auto-generated method stub
		
	}
}
