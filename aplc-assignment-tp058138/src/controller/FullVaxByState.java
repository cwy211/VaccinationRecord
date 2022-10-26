package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import beans.VaxState;

public class FullVaxByState {
	//predicate to check for specific state
		private static Predicate<VaxState> checkState (String state){
			return predicate -> predicate.getState().equals(state);
		}
		
		

		//return data list of specific state
		private static BiFunction<List<VaxState>,Predicate<VaxState>,List<VaxState>> getSpecificState = 
				(originalList,predicate)->originalList.stream().filter(predicate).collect(Collectors.toList());
				
		//get last object of list
	    private static Function<List<VaxState>,VaxState> getLastRow = lastRow -> lastRow.get(lastRow.size()-1);
	    
	    //function composition
	    private static BiFunction<List<VaxState>, Predicate<VaxState>, VaxState> Vcomposed = getSpecificState.andThen(getLastRow);
		
	    //generate list of states
	  		private static Function<List<VaxState>,List <String>> generateStateList = dataList->{
	  			List<String> allStateList = new ArrayList<String>();
	  			dataList.stream().forEach(elem->{
	  				allStateList.add(elem.getState());
	  			});
	  			return allStateList.stream().distinct().collect(Collectors.toList());
	  		};	 
	  	
	  		public static List<VaxState> getResult(List<VaxState> dataList){
	  			
	  			//generate state list
	  			List<String> stateList = generateStateList.apply(dataList);
	  			
	  			//get cumulative fully vaccinated people from last object of list of each state
	  			List<VaxState> resultList = new ArrayList<VaxState>();
	  			stateList.stream()
	  					.forEach(elem->{
	  						VaxState lastRow = Vcomposed.apply(dataList, checkState(elem));
	  						resultList.add(lastRow);
	  						
	  					});
	  			return resultList;
	  		}
	  		
}
