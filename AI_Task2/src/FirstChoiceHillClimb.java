
import java.util.Random;


public class FirstChoiceHillClimb 
{
	TSP tsp;
	int sigma;
	
	public FirstChoiceHillClimb(TSP tsp, int sigma) 
	{
		// TODO Auto-generated constructor stub
		this.tsp = tsp;
		this.sigma = sigma;
	}
	
	/**
	 * Main loop of your local search algorithm. 
	 * After the search is complete, create a SolutionInfo Object 
	 * with related information and return to the caller to generate aggregated results
	 * @return
	 */
	public SolutionInfo run() 
	{
             
             Route current = new Route(tsp);
             Route neighbor = new Route(current);
             int i;
             int count = 0;
             while(true){
               for(i = 0; i<sigma; i++){
                    Random rand = new Random();
                    double  n = rand.nextDouble();
                    if(n<0.5)   neighbor = OneOneExchange.apply(current);
                    //if(n<0.5)   neighbor = Or_Opt.apply(current);
                    else  neighbor = Or_Opt.apply(current);
                    //else neighbor = OneOneExchange.apply(current);
                    
                    //System.out.println("n cost"+neighbor.getCost()+" current cost "+current.getCost());
                    if(neighbor.getCost()<current.getCost()) break;
                    }
               if(i==sigma){
               SolutionInfo si = new SolutionInfo(current,count);
                return si;
               }
               current = neighbor;
               //System.out.println("HERE");
               count++;
               }
             
		//Main loop of your local search algorithm. 
		
	
//		SolutionInfo si = new SolutionInfo(neighbor,count);	
//		return si;
	}
	
	
	
	
	
}
