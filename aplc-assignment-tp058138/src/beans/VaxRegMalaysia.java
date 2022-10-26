package beans;

import java.util.Arrays;
import java.util.List;

import com.opencsv.bean.CsvBindByPosition;

import dataRetriever.GenericCSV;

public class VaxRegMalaysia {
	
	@CsvBindByPosition(position = 0)
	private String date;
	
	@CsvBindByPosition(position = 1)
	private String state;
	
	@CsvBindByPosition(position = 2)
	private String total;
	
	@CsvBindByPosition(position = 3)
	private String phase2;
	
	@CsvBindByPosition(position = 4)
	private String mysj;
	
	@CsvBindByPosition(position = 5)
	private String call;
	
	@CsvBindByPosition(position = 6)
	private String web;
	
	@CsvBindByPosition(position = 7)
	private String children;
	
	@CsvBindByPosition(position = 8)
	private String children_solo;
	
	@CsvBindByPosition(position = 9)
	private String adolescents;
	
	@CsvBindByPosition(position = 10)
	private String elderly;
	
	@CsvBindByPosition(position = 11)
	private String comorb;
	
	@CsvBindByPosition(position = 12)
	private String oku;
	
	private final static String VaxRegMalaysiaApi = "https://raw.githubusercontent.com/CITF-Malaysia/citf-public/main/registration/vaxreg_malaysia.csv";

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getPhase2() {
		return phase2;
	}

	public void setPhase2(String phase2) {
		this.phase2 = phase2;
	}

	public String getMysj() {
		return mysj;
	}

	public void setMysj(String mysj) {
		this.mysj = mysj;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getChildren_solo() {
		return children_solo;
	}

	public void setChildren_solo(String children_solo) {
		this.children_solo = children_solo;
	}

	public String getAdolescents() {
		return adolescents;
	}

	public void setAdolescents(String adolescents) {
		this.adolescents = adolescents;
	}

	public String getElderly() {
		return elderly;
	}

	public void setElderly(String elderly) {
		this.elderly = elderly;
	}

	public String getComorb() {
		return comorb;
	}

	public void setComorb(String comorb) {
		this.comorb = comorb;
	}

	public String getOku() {
		return oku;
	}

	public void setOku(String oku) {
		this.oku = oku;
	}
	
	public static List<String> getColumns() {
		List<String> columnList=Arrays.asList("Date","State","Total","Phase2","Mysj","Call","Web","Children","Children Solo"
				,"Adolescents","Elderly","Comorb","OKU");

		return columnList;
	}

	@Override
	public String toString() {
		return "VaxRegMalaysia [date=" + date + ", state=" + state + ", total=" + total + ", phase2=" + phase2
				+ ", mysj=" + mysj + ", call=" + call + ", web=" + web + ", children=" + children + ", children_solo="
				+ children_solo + ", adolescents=" + adolescents + ", elderly=" + elderly + ", comorb=" + comorb
				+ ", oku=" + oku + "]";
	}
	
	public static List<VaxRegMalaysia> getVaxRegMalaysiaList(){
		GenericCSV<VaxRegMalaysia> gcsv = new GenericCSV<>(VaxRegMalaysia.class);
		return gcsv.retrieveDataList(VaxRegMalaysiaApi);
	}
	
	

}
