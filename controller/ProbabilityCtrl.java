package controller;

import java.util.ArrayList;
import java.util.List;
import model.Probability;

public class ProbabilityCtrl {
	
	public static void main(String[] args) {
		Probability p = new Probability();	
		List<Double> list= new ArrayList<Double>();
		list.add(1.85);
		list.add(1.85);
		p.defaultOdds = list;
		p.dynamicOddsKey = 104;
		p.calculateUsingDefaultOdds();
		p = new Probability();
		p.probability.add(30.0);
		p.probability.add(70.0);
		p.dynamicOddsKey = 104;
		p.calculateUsingProbability();
		p = new Probability();
		p.fairOdds.add(3.8);
		p.fairOdds.add(1.42);
		p.dynamicOddsKey = 104;
		p.calculateUsingFairOdds();
		
		
		System.out.println(p.defaultOdds);
		System.out.println(p.defaultOddsKey);
		System.out.println(p.probability);
		System.out.println(p.fairOdds);
		System.out.println(p.dynamicOdds);
		
	}
	
	
}
