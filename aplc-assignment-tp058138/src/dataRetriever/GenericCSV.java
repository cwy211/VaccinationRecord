package dataRetriever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;


public class GenericCSV<T> {
	private Class<T> csvClass;
	
	public GenericCSV(Class<T> csvClass) {
		super();
		this.csvClass = csvClass;
	}

	public Class<T> getCsvClass() {
		return csvClass;
	}

	public void setCsvClass(Class<T> csvClass) {
		this.csvClass = csvClass;
	}
	
	/*
	*    Title: How to read and parse CSV file in Java
	*    Author: MkYong
	*    Date: 2020
	*    Availability: https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
	*
	*/
	public List<T> retrieveDataList(String link){
		java.net.URL url = null;
		List<T> dataList = null;
        try {
            url = new java.net.URL(link);
            java.net.URLConnection uc;
            uc = url.openConnection();

            uc.setRequestProperty("X-Requested-With", "Curl");
            BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            dataList = new CsvToBeanBuilder(new CSVReader(reader))
                    .withType(this.csvClass)
                    .build()
                    .parse();
            dataList.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return dataList;
	}

}
