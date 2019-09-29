
import java.util.Random;
import java.util.Collections;

public class OneOneExchange {
    
    private static Random random = new Random(System.currentTimeMillis());
	public static Route apply(Route rt) 
	{
		
		    Route route = new Route (rt);
                
                    int n = route.tsp.n;
                    int  ran = random.nextInt(n);
                    int ran2 = random.nextInt(n);
                    while(ran==ran2)
                    {ran2 = random.nextInt(n);}
                    //route.print();
                    //System.out.println("Before cost "+route.cost);
                    Collections.swap(route.route, ran, ran2);
                    //route.print();

                    route.updateCost();
                    //System.out.println("after cost "+route.cost);
                    
		    return route;
	}
    
}
