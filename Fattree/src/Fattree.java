
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fattree {

	public static void main(String[] args) {

		System.out.println("Hello enter k please.");
		Scanner in = new Scanner(System.in);

		int k = in.nextInt();

		Map<Integer, String> topoMap = CreateTopology(k);

		PrintMap(topoMap);
		
		

		in.close();
	}

	private static void PrintMap(Map<Integer, String> topoMap) {

		System.out.println("\n------------------------Pm and all Switches----------------------------");
		
		for(Map.Entry<Integer, String> entry : topoMap.entrySet()) {
			System.out.println(entry.getValue() + "Id: " + entry.getKey());
			//System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		System.out.println("-----------------------------------------------------------------------");

	}

	private static Map<Integer, String> CreateTopology(int k) {
		//initialize map and variables needed
		Map<Integer, String> map = new HashMap<Integer, String>();

		//int total = (int) (((5 * Math.pow(k, 2))+(Math.pow(k, 3)))/4);
		int numCores = (int) ( Math.pow(k, 2)/4 );
		int numAgg = (int) (Math.pow(k, 2)/2);
		int numEdge = (int) (Math.pow(k, 2)/2);
		int numPm = (int) (Math.pow(k, 3)/4);		
		int idNum = 0;
		int localTotal = numPm;


		//assign map
		//assign PMs 
		while(idNum < localTotal){
			map.put(idNum, "Pm");
			idNum++;
		}

		//assign Edge
		localTotal += numEdge;
		while(idNum < localTotal) {
			map.put(idNum, "Edge");
			idNum++;
		}

		//assign Aggregation
		localTotal += numAgg;
		while(idNum < localTotal) {
			map.put(idNum, "Aggregation");
			idNum++;
		}

		//assign Cores
		localTotal += numCores;
		while(idNum < localTotal) {
			map.put(idNum, "Core");
			idNum++;
		}		

		return map;		
	}

}
