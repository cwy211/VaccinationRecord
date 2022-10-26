package controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import beans.VaxMalaysia;

public class FullVaxByMonth {

	
	//recursion used to sum of daily full vaccination
		private static int daily_full_sum(int sum,List<VaxMalaysia> dataList, int counter) {
			if(counter<dataList.size()) {	
				int dailyFull=sum+Integer.parseInt(dataList.get(counter).getDaily_full());
				return dailyFull + daily_full_sum(sum,dataList,counter+1);
			}else {
				return sum;
			}
		}
		
		//predicate function that checks for monthYear
		private static Predicate<VaxMalaysia> checkMonthYear (String monthYear){
			return predicate ->String.valueOf(YearMonth.from(LocalDate.parse(predicate.getDate()))).equals(monthYear);
		}

		//bifunction that filters datalist according to monthYear
		private static BiFunction<List<VaxMalaysia>,Predicate<VaxMalaysia>,List<VaxMalaysia>> getSpecificMonthYear = 
				(originalList,predicate)->originalList.stream().filter(predicate).collect(Collectors.toList());

		//biconsumer that generates monthYear from datalist		
		private static Function<List<VaxMalaysia>, List<String>> getMonthYear = dataList ->{
			List<String> monthYear= new ArrayList<String>();
			dataList.stream().forEach(elem->{
				String yearMonth = YearMonth.from(LocalDate.parse(elem.getDate())).toString();
				Optional<String> result= monthYear.stream().filter(monthyear->monthyear.equals(yearMonth)).findAny();
				if(!result.isPresent()) {
					monthYear.add(yearMonth);
				}
			}
			
			);
			return monthYear;
		};
		
		public static Map<String,Integer> getResult(List<VaxMalaysia> dataList){
			Map<String,Integer> result = new HashMap<String,Integer>();
			//generate month year
			List<String> monthYearList = getMonthYear.apply(dataList);
			
			monthYearList.stream().forEach(monthyear->{
				
				//filter according list according to monthyear
				List<VaxMalaysia> monthDataList=getSpecificMonthYear.apply(dataList,checkMonthYear(monthyear));
				//recursion to get sum of daily full vaccination
				int sum = daily_full_sum(0,monthDataList,0);
				result.put(monthyear, sum);
			});
			return result;
		}
		
		public static List<String> getMonthYearList(List<VaxMalaysia> dataList){
			//generate month year
			return getMonthYear.apply(dataList);
		}
		
		public static String searchByMonth(List<VaxMalaysia> dataList,String monthYear) {
			return getResult(dataList).get(monthYear).toString();
		}
		
		
}
