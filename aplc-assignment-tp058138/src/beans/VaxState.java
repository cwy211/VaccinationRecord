package beans;

import java.util.List;

import com.opencsv.bean.CsvBindByPosition;

import dataRetriever.GenericCSV;

public class VaxState {
	@CsvBindByPosition(position = 0)
	private String date;
	
	@CsvBindByPosition(position = 1)
	private String state;
	
	@CsvBindByPosition(position = 2)
	private String daily_partial;
	
	@CsvBindByPosition(position = 3)
	private String daily_full;
	
	@CsvBindByPosition(position = 4)
	private String daily_booster;
	
	@CsvBindByPosition(position = 5)
	private String daily;
	
	@CsvBindByPosition(position = 6)
	private String daily_partial_adol;
	
	@CsvBindByPosition(position = 7)
	private String daily_full_adol;
	
	@CsvBindByPosition(position = 8)
	private String daily_partial_child;
	
	@CsvBindByPosition(position = 9)
	private String daily_full_child;
	
	@CsvBindByPosition(position = 10)
	private String cumul_partial;
	
	@CsvBindByPosition(position = 11)
	private String cumul_full;
	
	@CsvBindByPosition(position = 12)
	private String cumul_booster;
	
	@CsvBindByPosition(position = 13)
	private String cumul;
	
	@CsvBindByPosition(position = 14)
	private String cumul_partial_adol;
	
	@CsvBindByPosition(position = 15)
	private String cumul_full_adol;
	
	@CsvBindByPosition(position = 16)
	private String cumul_partial_child;
	
	@CsvBindByPosition(position = 17)
	private String cumul_full_child;
	
	@CsvBindByPosition(position = 18)
	private String pfizer1;
	
	@CsvBindByPosition(position = 19)
	private String pfizer2;
	
	@CsvBindByPosition(position = 20)
	private String pfizer3;
	
	@CsvBindByPosition(position = 21)
	private String sinovac1;
	
	@CsvBindByPosition(position = 22)
	private String sinovac2;
	
	@CsvBindByPosition(position = 23)
	private String sinovac3;
	
	@CsvBindByPosition(position = 24)
	private String astra1;
	
	@CsvBindByPosition(position = 25)
	private String astra2;
	
	@CsvBindByPosition(position = 26)
	private String astra3;
	
	@CsvBindByPosition(position = 27)
	private String sinopharm1;
	
	@CsvBindByPosition(position = 28)
	private String sinopharm2;

	@CsvBindByPosition(position = 29)
	private String sinopharm3;
	
	@CsvBindByPosition(position = 30)
	private String cansino;
	
	@CsvBindByPosition(position = 31)
	private String cansino3;
	
	@CsvBindByPosition(position = 32)
	private String pending1;
	
	@CsvBindByPosition(position = 33)
	private String pending2;
	
	@CsvBindByPosition(position = 34)
	private String pending3;

	private final static String VaxStateApi = "https://raw.githubusercontent.com/CITF-Malaysia/citf-public/main/vaccination/vax_state.csv";
	
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

	public String getDaily_partial() {
		return daily_partial;
	}

	public void setDaily_partial(String daily_partial) {
		this.daily_partial = daily_partial;
	}

	public String getDaily_full() {
		return daily_full;
	}

	public void setDaily_full(String daily_full) {
		this.daily_full = daily_full;
	}

	public String getDaily_booster() {
		return daily_booster;
	}

	public void setDaily_booster(String daily_booster) {
		this.daily_booster = daily_booster;
	}

	public String getDaily() {
		return daily;
	}

	public void setDaily(String daily) {
		this.daily = daily;
	}

	public String getDaily_partial_adol() {
		return daily_partial_adol;
	}

	public void setDaily_partial_adol(String daily_partial_adol) {
		this.daily_partial_adol = daily_partial_adol;
	}

	public String getDaily_full_adol() {
		return daily_full_adol;
	}

	public void setDaily_full_adol(String daily_full_adol) {
		this.daily_full_adol = daily_full_adol;
	}

	public String getDaily_partial_child() {
		return daily_partial_child;
	}

	public void setDaily_partial_child(String daily_partial_child) {
		this.daily_partial_child = daily_partial_child;
	}

	public String getDaily_full_child() {
		return daily_full_child;
	}

	public void setDaily_full_child(String daily_full_child) {
		this.daily_full_child = daily_full_child;
	}

	public String getCumul_partial() {
		return cumul_partial;
	}

	public void setCumul_partial(String cumul_partial) {
		this.cumul_partial = cumul_partial;
	}

	public String getCumul_full() {
		return cumul_full;
	}

	public void setCumul_full(String cumul_full) {
		this.cumul_full = cumul_full;
	}

	public String getCumul_booster() {
		return cumul_booster;
	}

	public void setCumul_booster(String cumul_booster) {
		this.cumul_booster = cumul_booster;
	}

	public String getCumul() {
		return cumul;
	}

	public void setCumul(String cumul) {
		this.cumul = cumul;
	}

	public String getCumul_partial_adol() {
		return cumul_partial_adol;
	}

	public void setCumul_partial_adol(String cumul_partial_adol) {
		this.cumul_partial_adol = cumul_partial_adol;
	}

	public String getCumul_full_adol() {
		return cumul_full_adol;
	}

	public void setCumul_full_adol(String cumul_full_adol) {
		this.cumul_full_adol = cumul_full_adol;
	}

	public String getCumul_partial_child() {
		return cumul_partial_child;
	}

	public void setCumul_partial_child(String cumul_partial_child) {
		this.cumul_partial_child = cumul_partial_child;
	}

	public String getCumul_full_child() {
		return cumul_full_child;
	}

	public void setCumul_full_child(String cumul_full_child) {
		this.cumul_full_child = cumul_full_child;
	}

	public String getPfizer1() {
		return pfizer1;
	}

	public void setPfizer1(String pfizer1) {
		this.pfizer1 = pfizer1;
	}

	public String getPfizer2() {
		return pfizer2;
	}

	public void setPfizer2(String pfizer2) {
		this.pfizer2 = pfizer2;
	}

	public String getPfizer3() {
		return pfizer3;
	}

	public void setPfizer3(String pfizer3) {
		this.pfizer3 = pfizer3;
	}

	public String getSinovac1() {
		return sinovac1;
	}

	public void setSinovac1(String sinovac1) {
		this.sinovac1 = sinovac1;
	}

	public String getSinovac2() {
		return sinovac2;
	}

	public void setSinovac2(String sinovac2) {
		this.sinovac2 = sinovac2;
	}

	public String getSinovac3() {
		return sinovac3;
	}

	public void setSinovac3(String sinovac3) {
		this.sinovac3 = sinovac3;
	}

	public String getAstra1() {
		return astra1;
	}

	public void setAstra1(String astra1) {
		this.astra1 = astra1;
	}

	public String getAstra2() {
		return astra2;
	}

	public void setAstra2(String astra2) {
		this.astra2 = astra2;
	}

	public String getAstra3() {
		return astra3;
	}

	public void setAstra3(String astra3) {
		this.astra3 = astra3;
	}

	public String getSinopharm1() {
		return sinopharm1;
	}

	public void setSinopharm1(String sinopharm1) {
		this.sinopharm1 = sinopharm1;
	}

	public String getSinopharm2() {
		return sinopharm2;
	}

	public void setSinopharm2(String sinopharm2) {
		this.sinopharm2 = sinopharm2;
	}

	public String getSinopharm3() {
		return sinopharm3;
	}

	public void setSinopharm3(String sinopharm3) {
		this.sinopharm3 = sinopharm3;
	}

	public String getCansino() {
		return cansino;
	}

	public void setCansino(String cansino) {
		this.cansino = cansino;
	}

	public String getCansino3() {
		return cansino3;
	}

	public void setCansino3(String cansino3) {
		this.cansino3 = cansino3;
	}

	public String getPending1() {
		return pending1;
	}

	public void setPending1(String pending1) {
		this.pending1 = pending1;
	}

	public String getPending2() {
		return pending2;
	}

	public void setPending2(String pending2) {
		this.pending2 = pending2;
	}

	public String getPending3() {
		return pending3;
	}

	public void setPending3(String pending3) {
		this.pending3 = pending3;
	}

	@Override
	public String toString() {
		return "VaxState [date=" + date + ", state=" + state + ", daily_partial=" + daily_partial + ", daily_full="
				+ daily_full + ", daily_booster=" + daily_booster + ", daily=" + daily + ", daily_partial_adol="
				+ daily_partial_adol + ", daily_full_adol=" + daily_full_adol + ", daily_partial_child="
				+ daily_partial_child + ", daily_full_child=" + daily_full_child + ", cumul_partial=" + cumul_partial
				+ ", cumul_full=" + cumul_full + ", cumul_booster=" + cumul_booster + ", cumul=" + cumul
				+ ", cumul_partial_adol=" + cumul_partial_adol + ", cumul_full_adol=" + cumul_full_adol
				+ ", cumul_partial_child=" + cumul_partial_child + ", cumul_full_child=" + cumul_full_child
				+ ", pfizer1=" + pfizer1 + ", pfizer2=" + pfizer2 + ", pfizer3=" + pfizer3 + ", sinovac1=" + sinovac1
				+ ", sinovac2=" + sinovac2 + ", sinovac3=" + sinovac3 + ", astra1=" + astra1 + ", astra2=" + astra2
				+ ", astra3=" + astra3 + ", sinopharm1=" + sinopharm1 + ", sinopharm2=" + sinopharm2 + ", sinopharm3="
				+ sinopharm3 + ", cansino=" + cansino + ", cansino3=" + cansino3 + ", pending1=" + pending1
				+ ", pending2=" + pending2 + ", pending3=" + pending3 + "]";
	}
	
	public static List<VaxState> getVaxStateList(){
		GenericCSV<VaxState> gcsv = new GenericCSV<>(VaxState.class);
		return gcsv.retrieveDataList(VaxStateApi);
	}
	
}
