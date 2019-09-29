/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;



public class Or_Opt {
    
    /**
	 * improves the route by repeatedly applying the first better Or-opt move
	 * @param individual
	 * @param period
	 * @param vehicle
	 * @return false if cost is not decreased
 	 */
	public static Route apply(Route rt)
	{
                int n = rt.n;
                //rt.print();
                for(int chain_size=3; chain_size>0; chain_size--){
                
                     for(int i = 0; i+chain_size-1<n; i++){
                             
                            ArrayList<Integer> chain = new ArrayList<Integer>(rt.route.subList(i, i+chain_size));
                             //System.out.println("SubList stored in ArrayList: "+chain);
                             
                            Route Tmp_route = new Route(rt); 
                            Tmp_route.route.removeAll(chain);
                           // Tmp_route.print();
                            int nm = Tmp_route.n;
                            
                            for(int j =0; j<nm-chain_size+1; j++){
                            
                               Tmp_route.route.addAll(j, chain);
                               //Tmp_route.print();
                              //System.out.print("cost temp "+Tmp_route.updateCost());
                             //System.out.print("cost rt "+rt.updateCost());
                                //System.out.println("");
                               if(Tmp_route.updateCost()<rt.updateCost())
                               {  
                                   //System.out.print("cost temp "+Tmp_route.getCost());
                                   //System.out.print("cost rt "+rt.getCost());
                                   //System.out.println("");
                                   return Tmp_route;
                               }
                               
                               Tmp_route.route.removeAll(chain);
                               
                               
                            }
                     }
                }
		return rt;
	}
	
    
}
