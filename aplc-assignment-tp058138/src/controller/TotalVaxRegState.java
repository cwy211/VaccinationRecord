package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.jpl7.Query;
import org.jpl7.Term;

public class TotalVaxRegState {


	
	public static List<String> getResult(){
		Query q1 = new Query("merge_registered_to_list(List)");
		Map<String, Term> sol = q1.oneSolution();
		return getStateTotal(sol,"List");
	}
	
	public static String getSum() {
		Query q2 = new Query("sum(Sum)");
		Map<String, Term> sol2 = q2.oneSolution();
		return sol2.get("Sum").toString();	
	}
	
	public static List<String> getAscendingResult(){
		Query q3 = new Query("state_total_asc(Output)");
		Map<String, Term> sol3 = q3.oneSolution();
		return getStateTotal(sol3,"Output");
	}
	
	public static List<String> getDescendingResult(){
		Query q4 = new Query("state_total_desc(Output)");
		Map<String, Term> sol4 = q4.oneSolution();
		return getStateTotal(sol4,"Output");
	}
	
	private static List<String> getStateTotal(Map<String, Term> sol, String key){
		String[] stateTotal = sol.get(key).toString().replace("','", "").replace("[(", "").replace(")]", "").split(Pattern.quote("), ("));
		List<String> stateTotalList = Arrays.asList(stateTotal);
		return stateTotalList;
	}
}


