package algorithmJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostVisited {

	public static class Place{
		int id;
		int visitiedCount;
	}
	
	private static void updateCount(Map<Integer, Integer> visitMap, Place maxVisitedPlace, int stop, int localCount) {
		// TODO Auto-generated method stub
		visitMap.put(stop, localCount);
		if(localCount > maxVisitedPlace.visitiedCount) {
			maxVisitedPlace.id = stop;
			maxVisitedPlace.visitiedCount = localCount;
		}
	}

	public static Place stopWithMaxVisits(List<int []> _travel) {
		Place maxVisitedPlace = null;
		
		//Base Case
		if(_travel.size()==0) {
			return maxVisitedPlace;
		}
		maxVisitedPlace = new Place();
		
		Map<Integer,Integer> visitMap = new TreeMap<>(); 
	
		for (int [] travelList: _travel) {
			for(int stop:travelList) {
				if(visitMap.containsKey(stop)) {
					int localCount = visitMap.get(stop)+1;
					updateCount(visitMap,maxVisitedPlace,stop,localCount);
					
				}
				else {
					int localCount = 1;
					updateCount(visitMap,maxVisitedPlace,stop,localCount);
				}
			}
		}
		
		return maxVisitedPlace;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int []> travelDetails = new ArrayList<>();
		
		int[] stop1 = {1,3,6,7};
		int[] stop2 = {2,3,4,5};
		int[] stop3 = {1,2,3,7,8};		
		travelDetails.add(stop1);
		travelDetails.add(stop2);
		travelDetails.add(stop3);
		
		System.out.println(stopWithMaxVisits(travelDetails).id);

	}

}
