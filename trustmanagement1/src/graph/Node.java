package graph;

import cre.TMSPrincipal;

public interface Node {

	public void changeFlag(int i);
	public int getFlag();
	public void b_process();
	public void add_b_sol_monitor(Node n);
	public void b_activate();
	public void add_b_solution(TMSPrincipal principal);
	public void printSolutions();
}
