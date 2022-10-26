package plWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.jpl7.Query;
import beans.VaxRegState;

public class GeneratePL {

	static boolean connect( String location ) 
	{
		String qs = "consult('"+location+"')";
		Query q1 = new Query( qs );
		boolean connected = q1.hasSolution();
		q1.close();
		return connected;
	}
	public static void AddtoFile(String filepath,String line){
        try{
            File f = new File(filepath);
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(line);
            bw.newLine();
            pw.close();
        }
        catch (IOException Ex)
        {
            Ex.printStackTrace();
        }
    }


	public static void createPL() {
		File oldf = new File("total_vax_reg_state.pl");
		oldf.delete();
		// TODO Auto-generated method stub
		
		List<VaxRegState> dataList=VaxRegState.getVaxRegStateList();
		List<String> allStateList = new ArrayList<String>();
		dataList.stream().forEach(elem->{
			allStateList.add(elem.getState());
		});
		List<String> stateList = allStateList.stream().distinct().collect(Collectors.toList());
		AddtoFile("total_vax_reg_state.pl","%Facts");
		stateList.stream().forEach(state->{
			List<VaxRegState> stateDataList = dataList.stream().filter(elem->elem.getState().equals(state)).collect(Collectors.toList());
			VaxRegState vaxRegState = Collections.max(stateDataList,Comparator.comparing(s->Integer.parseInt(s.getTotal())));
			String prologEntry = "registered("+state.toLowerCase().replaceAll("\\s", "_").replace(".", "_")+","+vaxRegState.getTotal()+").";
			AddtoFile("total_vax_reg_state.pl",prologEntry);
		}
		);
		AddtoFile("total_vax_reg_state.pl","\r\n%Rules");
		AddtoFile("total_vax_reg_state.pl","merge_registered_to_list(List) :- findall((State, Total), registered(State, Total), List).");
		AddtoFile("total_vax_reg_state.pl","get_state_total_list(List) :- findall((Total), registered(_, Total), List).\r\n");
		AddtoFile("total_vax_reg_state.pl","sum_total([],0).");
		AddtoFile("total_vax_reg_state.pl","sum_total([H|T], TotalSum):-sum_total(T, Sum1),TotalSum is H+Sum1.\r\n");
		/*
		*    Title: Sorting
		*    Author: Barták, J
		*    Date: n.d.
		*    Availability: http://kti.ms.mff.cuni.cz/~bartak/prolog/sorting.html
		*
		*/
		
		AddtoFile("total_vax_reg_state.pl","asc_pivot(_, [], [], []).\r\n"
				+ "asc_pivot((P1, P2), [(H1, H2)|T], [(H1, H2)|LessOrEqualThan], GreaterThan) :- P2 >= H2, asc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan). \r\n"
				+ "asc_pivot((P1, P2), [(H1, H2)|T], LessOrEqualThan, [(H1, H2)|GreaterThan]) :- H2> P2, asc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan).\r\n"
				+ "\r\n"
				+ "asc_quicksort([], []).\r\n"
				+ "asc_quicksort([(H1, H2)|T], Sorted) :- asc_pivot((H1, H2), T, LessOrEqualThan, Greater), asc_quicksort(LessOrEqualThan, SortedLessOrEqualThan), asc_quicksort(Greater, SortedGreater), append(SortedLessOrEqualThan, [(H1, H2)| SortedGreater], Sorted).\r\n"
				+ "\r\n"
				+ "append([],Ys,Ys).\r\n"
				+ "append([X|Xs],Ys,[X|Zs]) :- append(Xs,Ys,Zs).\r\n"
				+ "\r\n"
				+ "desc_pivot(_, [], [], []).\r\n"
				+ "desc_pivot((P1, P2), [(H1, H2)|T], [(H1, H2)|LessOrEqualThan], GreaterThan) :- P2 < H2, desc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan). \r\n"
				+ "desc_pivot((P1, P2), [(H1, H2)|T], LessOrEqualThan, [(H1, H2)|GreaterThan]) :- H2 =< P2, desc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan).\r\n"
				+ "\r\n"
				+ "desc_quicksort([], []).\r\n"
				+ "desc_quicksort([(H1, H2)|T], Sorted) :- desc_pivot((H1, H2), T, LessOrEqualThan, Greater), desc_quicksort(LessOrEqualThan, SortedLessOrEqualThan), desc_quicksort(Greater, SortedGreater), append(SortedLessOrEqualThan, [(H1, H2)| SortedGreater], Sorted).");
		
		
		AddtoFile("total_vax_reg_state.pl","state_total_asc(Output):- merge_registered_to_list(List), asc_quicksort(List, Output).\r\n"
				+ "state_total_desc(Output):- merge_registered_to_list(List), desc_quicksort(List, Output).");
		AddtoFile("total_vax_reg_state.pl","sum(Sum):-get_state_total_list(List), sum_total(List, Sum).");
				
String loc = "total_vax_reg_state.pl";
		
		if ( connect( loc ) ) {
			System.out.println( ">> "+ loc + " connected!" );

			
		} else {
			System.out.println( ">>> "+ loc + " not connected!" );
		}
	}
	
}
