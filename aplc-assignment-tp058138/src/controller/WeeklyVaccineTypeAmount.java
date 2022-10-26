package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import beans.VaxMalaysia;

public class WeeklyVaccineTypeAmount {

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
	
private static Function<Integer,Function<Integer,Function<Integer,Integer>>> curryingTotalVaccine = x -> y -> z -> x + y + z;
	

	private static BiFunction<String,List<VaxMalaysia>,Integer> weeklyTotalPfizer = (weekyear, dataList)->{
		int[] weeklyPfizer=dataList.stream().filter(elem->
		new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(elem.getDate())).equals(weekyear))
				.mapToInt(n->curryingTotalVaccine.apply(Integer.parseInt(n.getPfizer1())).apply(Integer.parseInt(n.getPfizer2())).apply(Integer.parseInt(n.getPfizer3()))).toArray();
		return Arrays.stream(weeklyPfizer).sum();
	};

	private static BiFunction<String,List<VaxMalaysia>,Integer> weeklyTotalSinovac = (weekyear, dataList)->{
		int[] weeklySinovac=dataList.stream().filter(elem->
		new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(elem.getDate())).equals(weekyear))
				.mapToInt(n->curryingTotalVaccine.apply(Integer.parseInt(n.getSinovac1())).apply(Integer.parseInt(n.getSinovac2())).apply(Integer.parseInt(n.getSinovac3()))).toArray();
		return Arrays.stream(weeklySinovac).sum();
	};
	
	private static BiFunction<String,List<VaxMalaysia>,Integer> weeklyTotalAstra = (weekyear, dataList)->{
		int[] weeklyAstra=dataList.stream().filter(elem->
		new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(elem.getDate())).equals(weekyear))
				.mapToInt(n->curryingTotalVaccine.apply(Integer.parseInt(n.getAstra1())).apply(Integer.parseInt(n.getAstra2())).apply(Integer.parseInt(n.getAstra3()))).toArray();
		return Arrays.stream(weeklyAstra).sum();
	};
	
	private static BiFunction<String,List<VaxMalaysia>,Integer> weeklyTotalSinopharm = (weekyear, dataList)->{
		int[] weeklySinopharm=dataList.stream().filter(elem->
		new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(elem.getDate())).equals(weekyear))
				.mapToInt(n->curryingTotalVaccine.apply(Integer.parseInt(n.getSinopharm1())).apply(Integer.parseInt(n.getSinopharm2())).apply(Integer.parseInt(n.getSinopharm3()))).toArray();
		return Arrays.stream(weeklySinopharm).sum();
	};
	
	private static BiFunction<String,List<VaxMalaysia>,Integer> weeklyTotalCansino = (weekyear, dataList)->{
		int[] weeklyCansino=dataList.stream().filter(elem->
		new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(elem.getDate())).equals(weekyear))
				.mapToInt(n->Integer.parseInt(n.getCansino())+Integer.parseInt(n.getCansino3())).toArray();
		return Arrays.stream(weeklyCansino).sum();
	};

	
	public static List<String> getUniqueWeekYearList(List<VaxMalaysia> dataList){
		List<String> uniqueWeekYearList = new ArrayList<String>();
		dataList.stream().forEach(elem->{
			uniqueWeekYearList.add(new SimpleDateFormat("'Week:'ww',Year:'Y").format(convertStringToDate(elem.getDate())));
		});
		return uniqueWeekYearList.stream().distinct().collect(Collectors.toList());
	}
	
	public static List<Integer> getResult(List<VaxMalaysia> dataList, String weekYear){
		List<Integer> result = new ArrayList<Integer>();
		result.add(weeklyTotalPfizer.apply(weekYear,dataList));
		result.add(weeklyTotalSinovac.apply(weekYear,dataList));
		result.add(weeklyTotalAstra.apply(weekYear,dataList));
		result.add(weeklyTotalSinopharm.apply(weekYear,dataList));
		result.add(weeklyTotalCansino.apply(weekYear,dataList));
		return result;
	}
}
