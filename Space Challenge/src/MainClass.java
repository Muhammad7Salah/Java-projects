import java.util.ArrayList;

public class MainClass {
	
	public static void main(String[] args) {
		
		Simulation simulation = new Simulation();
		
		ArrayList<Item> phase1Items=simulation.loadItems("phase-1.txt");
		ArrayList<Item> phase2Items=simulation.loadItems("phase-2.txt");

		ArrayList<Rocket> U1P1 = simulation.loadU1(phase1Items);
		ArrayList<Rocket> U1P2 = simulation.loadU2(phase2Items);
		
		ArrayList<Rocket> U2P1 = simulation.loadU1(phase1Items);
		ArrayList<Rocket> U2P2 = simulation.loadU2(phase2Items);
		
		System.out.println("The budget for U1 rockets phase 1 = "+ simulation.runSimulation(U1P1));
		System.out.println("The budget for U1 rockets phase 2 = "+ simulation.runSimulation(U1P2));
		System.out.println("The budget for U2 rockets phase 1 = "+ simulation.runSimulation(U2P1));
		System.out.println("The budget for U2 rockets phase 2 = "+ simulation.runSimulation(U2P2));
	}

}
