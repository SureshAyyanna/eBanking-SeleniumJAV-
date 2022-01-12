package com.ans.Banking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ans.Banking.pageObjects.LoginPage;
import com.ans.Banking.utilities.XLUtils;

public class TestCase_002 extends TestBase {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String Pswd) {
		LoginPage lp=new LoginPage(driver);	
		lp.setUsername(username);
		lp.setPassword(password);
	}
	
	@DataProvider (name ="LoginData")
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\ans\\Banking\\testData\\LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
}
