package model;

import java.util.ArrayList;
import java.util.List;

public class Probability {
	
	public List<Double> defaultOdds;
	public double defaultOddsKey;
	public List<Double> probability;
	public double dynamicOddsKey;
	public List<Double> dynamicOdds;
	public List<Double> fairOdds;
	
	public Probability() {
		this.defaultOdds = new ArrayList<Double>();
		this.defaultOddsKey = 0;
		this.probability = new ArrayList<Double>();
		this.dynamicOddsKey = 0;
		this.dynamicOdds= new ArrayList<Double>();
		this.fairOdds= new ArrayList<Double>();
	}
	
	public void calculateUsingDefaultOdds() {
		calculateOddsKey();
		calculateProbability();
		calculateFairOdds();
		calculateDynamicOdds();
	}
	
	public void calculateUsingProbability() {
		calculateFairOddsUsingProbability();
		calculateDefaultOdds();
		calculateDynamicOdds();
	}
	
	public void calculateUsingFairOdds() {
		double sum = 0;
		for(double d : fairOdds) {
			sum+=(100/d);
		}
		if(sum >= 99.5 && sum <=100.5) {
			calculateDefaultOdds();
			calculateProbability();
			calculateDynamicOdds();
		}
		
	}
	
	private void calculateOddsKey () {	
		double oddsKey = 0;
		for(double d : defaultOdds) {
			oddsKey += (100/d);
		}
		defaultOddsKey = oddsKey;		
	}
	
	private void calculateProbability() {
		for(int i = 0; i < defaultOdds.size(); i++) {
			double value = 100*(100/defaultOdds.get(i))/defaultOddsKey;
			probability.add(i, value);
		}
	}
	
	private void calculateFairOdds() {
		for(int i = 0; i < defaultOdds.size(); i++) {
			double value = defaultOdds.get(i)*defaultOddsKey/100;
			fairOdds.add(i,value);
		}
	}
	
	private void calculateFairOddsUsingProbability() {
		for(int i= 0; i< probability.size(); i++) {
			double value = 100 / probability.get(i);
			fairOdds.add(i,value);
		}
	}
	
	private void calculateDynamicOdds() {
		for(int i = 0; i < defaultOdds.size(); i++) {
			double value = fairOdds.get(i)/(dynamicOddsKey/100);
			dynamicOdds.add(i,value);
		}
	}
	
	private void calculateDefaultOdds() {
		defaultOddsKey = 108;
		for(int i= 0; i< fairOdds.size(); i++) {
			double value = fairOdds.get(i)/(defaultOddsKey/100);
			defaultOdds.add(i,value);
		}
	}
}
