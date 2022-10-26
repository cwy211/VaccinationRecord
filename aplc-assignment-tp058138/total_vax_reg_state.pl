%Facts
registered(johor,3515716).
registered(kedah,1644080).
registered(kelantan,1116009).
registered(melaka,811602).
registered(negeri_sembilan,1040905).
registered(pahang,1229615).
registered(perak,1971720).
registered(perlis,200460).
registered(pulau_pinang,1637418).
registered(sabah,2014719).
registered(sarawak,2091318).
registered(selangor,6198689).
registered(terengganu,879144).
registered(w_p__kuala_lumpur,2302745).
registered(w_p__labuan,78810).
registered(w_p__putrajaya,117528).

%Rules
merge_registered_to_list(List) :- findall((State, Total), registered(State, Total), List).
get_state_total_list(List) :- findall((Total), registered(_, Total), List).

sum_total([],0).
sum_total([H|T], TotalSum):-sum_total(T, Sum1),TotalSum is H+Sum1.

asc_pivot(_, [], [], []).
asc_pivot((P1, P2), [(H1, H2)|T], [(H1, H2)|LessOrEqualThan], GreaterThan) :- P2 >= H2, asc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan). 
asc_pivot((P1, P2), [(H1, H2)|T], LessOrEqualThan, [(H1, H2)|GreaterThan]) :- H2> P2, asc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan).

asc_quicksort([], []).
asc_quicksort([(H1, H2)|T], Sorted) :- asc_pivot((H1, H2), T, LessOrEqualThan, Greater), asc_quicksort(LessOrEqualThan, SortedLessOrEqualThan), asc_quicksort(Greater, SortedGreater), append(SortedLessOrEqualThan, [(H1, H2)| SortedGreater], Sorted).

append([],Ys,Ys).
append([X|Xs],Ys,[X|Zs]) :- append(Xs,Ys,Zs).

desc_pivot(_, [], [], []).
desc_pivot((P1, P2), [(H1, H2)|T], [(H1, H2)|LessOrEqualThan], GreaterThan) :- P2 < H2, desc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan). 
desc_pivot((P1, P2), [(H1, H2)|T], LessOrEqualThan, [(H1, H2)|GreaterThan]) :- H2 =< P2, desc_pivot((P1, P2), T, LessOrEqualThan, GreaterThan).

desc_quicksort([], []).
desc_quicksort([(H1, H2)|T], Sorted) :- desc_pivot((H1, H2), T, LessOrEqualThan, Greater), desc_quicksort(LessOrEqualThan, SortedLessOrEqualThan), desc_quicksort(Greater, SortedGreater), append(SortedLessOrEqualThan, [(H1, H2)| SortedGreater], Sorted).
state_total_asc(Output):- merge_registered_to_list(List), asc_quicksort(List, Output).
state_total_desc(Output):- merge_registered_to_list(List), desc_quicksort(List, Output).
sum(Sum):-get_state_total_list(List), sum_total(List, Sum).
