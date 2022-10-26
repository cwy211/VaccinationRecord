package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import beans.VaxMalaysia;

public class WeeklyHighLowVax {

	private static Date convertStringToDate(String date){
		String dateFormat[]=date.split("-",3);
		String newDateFormat=dateFormat[2]+"/"+dateFormat[1]+"/"+dateFormat[0];
		try {
		Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDateFormat);
		return newDate;
		}catch(ParseException e) {
			return null;
		}
	}
		
	
	private static Predicate<VaxMalaysia> checkWeekYear (String monthYear){
		return predicate ->String.valueOf(new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(predicate.getDate()))).equals(monthYear);
	}

	private static BiFunction<List<VaxMalaysia>,Predicate<VaxMalaysia>,List<VaxMalaysia>> getSpecificWeekYear = 
			(originalList,predicate)->originalList.stream().filter(predicate).collect(Collectors.toList());

			
	
	private static Function<List<VaxMalaysia>,List <String>> generateWeekYearList = dataList->{
		List<String> weekYearList = new ArrayList<String>();
		dataList.stream().forEach(elem->{
			weekYearList.add(new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(elem.getDate())));
		});
		return weekYearList.stream().distinct().collect(Collectors.toList());
	};

	public static List<String> getUniqueWeekYearList (List<VaxMalaysia> dataList){
		return generateWeekYearList.apply(dataList);
	}
	
	public static List<Integer> getResult(List<VaxMalaysia> dataList, String weekyear) {

		List<VaxMalaysia> monthDataList=getSpecificWeekYear.apply(dataList,checkWeekYear(weekyear));
		VaxMalaysia vaxMalaysia = Collections.max(monthDataList,Comparator.comparing(s->Integer.parseInt(s.getDaily_full_adol())+Integer.parseInt(s.getDaily_partial_adol())));
		VaxMalaysia vaxMalaysia1 = Collections.min(monthDataList,Comparator.comparing(s->Integer.parseInt(s.getDaily_full_adol())+Integer.parseInt(s.getDaily_partial_adol())));
		VaxMalaysia vaxMalaysia2 = Collections.max(monthDataList,Comparator.comparing(s->Integer.parseInt(s.getDaily_full_child())+Integer.parseInt(s.getDaily_partial_child())));
		VaxMalaysia vaxMalaysia3 = Collections.min(monthDataList,Comparator.comparing(s->Integer.parseInt(s.getDaily_full_child())+Integer.parseInt(s.getDaily_partial_child())));
		List<Integer> result = new ArrayList<Integer>();
		result.add(Integer.parseInt(vaxMalaysia.getDaily_full_adol())+Integer.parseInt(vaxMalaysia.getDaily_partial_adol()));
		result.add(Integer.parseInt(vaxMalaysia1.getDaily_full_adol())+Integer.parseInt(vaxMalaysia1.getDaily_partial_adol()));
		result.add(Integer.parseInt(vaxMalaysia2.getDaily_full_child())+Integer.parseInt(vaxMalaysia2.getDaily_partial_child()));
		result.add(Integer.parseInt(vaxMalaysia3.getDaily_full_child())+Integer.parseInt(vaxMalaysia3.getDaily_partial_child()));
		return result;
	}
	
}
