import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;




public class TSP 
{
	double x[], y[];
	int n;

	public TSP(double x[], double y[], int n) 
	{
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.n = n;

	}
        
        private void solve() throws IOException {
		// TODO Auto-generated method stub
		Route route = new Route(this);
                
                System.out.print("Initial Route ---> ");
                route.print();
		
		//System.out.println("Before cost "+route.getCost());
                
                    
                  /*Double cost = 0.0;
                  Double count = 0.0;
                  ArrayList<Double> c = new ArrayList<Double>();
                  */
                   
               
		FirstChoiceHillClimb fchc = new FirstChoiceHillClimb(this, 5000);
		SolutionInfo si = fchc.run();
                
		//System.out.println(si.solution.getCost());
                
                //cost+=si.solution.getCost();
                //count+=si.loopCount;
                //c.add(si.solution.getCost());
                System.out.print("Solution Route ---> ");
		si.solution.print();
                System.out.println("Loop Count = "+si.loopCount);
                System.out.println("Cost = "+si.solution.cost);
	}
	
	/*private void solve() throws IOException {
		// TODO Auto-generated method stub
		Route route = new Route(this);
		//route.print();
		//System.out.println("Before cost "+route.getCost());
                for(int sigma = 1000; sigma<=10000; sigma = sigma + 1000){
                    
                  Double cost = 0.0;
                  Double count = 0.0;
                  ArrayList<Double> c = new ArrayList<Double>();
                  
                   
                for(int i = 0; i<10; i++){
		FirstChoiceHillClimb fchc = new FirstChoiceHillClimb(this, sigma);
		SolutionInfo si = fchc.run();
                
		//System.out.println(si.solution.getCost());
                
                cost+=si.solution.getCost();
                count+=si.loopCount;
                c.add(si.solution.getCost());
		//si.solution.print();
                //System.out.println("loop count = "+si.loopCount);
                }
                 
                    //System.out.println("Sigma :"+sigma);
                    //System.out.println("Avg cost :"+cost/10);
                    //System.out.println("Avg count :"+count/10);
                    //System.out.println("Minimum Cost :  "+Collections.min(c));
                    //System.out.println("Sigma         AVG COST    AVG COUNT      MIN COST");
                    System.out.format("%5d%15f%20f%15f", sigma, count/10, cost/10,Collections.min(c));
                    System.out.println("");
                }
                
                //System.out.println("cost = "+si.solution.cost);
	}
        
        */
	void print()
	{
		System.out.println("Dimension: "+n);
		for (int i = 0; i < n; i++) {
			System.out.println(x[i] + " " + y[i]);
		}
               
	}
        
	
	/**
	 * Returns the distance between the node a and b
	 * @param a
	 * @param b
	 * @return
	 */
	public double edgeCost(int a, int b){
            
	double n ,m, d, f;
          
              m = (x[a] - x[b])*(x[a] - x[b]);
              n = (y[a] - y[b])*(y[a] - y[b]);
              f = m + n ;
              d = Math.sqrt(f);
              
              return d;
             
	}
	
	public static void main(String[] args)
	{
		try 
		{
			Scanner in = new Scanner(new File("test.tsp"));
			//Scanner in = new Scanner(new File("att48.tsp"));
			//Scanner in = new Scanner(new File("burma14.tsp"));
			//Scanner in = new Scanner(new File("st70.tsp"));
			//Scanner in = new Scanner(new File("ulysses16.tsp"));
			//Scanner in = new Scanner(new File("ulysses22.tsp"));
			
			String line = "";
			int n;
			
			//three comment lines
			in.nextLine();
			in.nextLine();
			in.nextLine();
			//get n
			line = in.nextLine();
			line = line.substring(11).trim();
			n = Integer.parseInt(line);
			
			//System.out.println("" +n);
			
			//two comment lines
			in.nextLine();
			in.nextLine();
			
			double x[] = new double[n];
			double y[] = new double[n];
			
			for (int i = 0; i < n; i++)
			{
				in.nextInt();
				x[i] = in.nextDouble();
				y[i] = in.nextDouble();
			}
			
			TSP tsp = new TSP (x,y,n);
			//tsp.print();
			tsp.solve();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
