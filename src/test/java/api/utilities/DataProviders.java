package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir")+"//Test-Data/APITestData.xlsx";
		excelUtilities xl = new excelUtilities(path);
		
		int rownum = xl.getRowCount("Data");
		int colcount = xl.getCellCount("Data",1);
		
		String apidata[][] = new String[rownum-1][colcount];
		
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colcount;j++) {
				apidata[i-1][j]=xl.getCellData("Data",i, j);
			}
		}
		
		return apidata;
	}
	
	@DataProvider(name="UserName")
	public String[] getUserName() throws IOException {
			String path = System.getProperty("user.dir")+"//Test-Data/APITestData.xlsx";
			excelUtilities xl = new excelUtilities(path);
			int rownum = xl.getRowCount("Data");
			String apidata[] = new String[rownum-1];
			for(int i=1;i<rownum;i++) {
				apidata[i-1] = xl.getCellData("Data",i,1);
		}
			return apidata;
	}

}
