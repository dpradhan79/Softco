package tests;

import java.util.Hashtable;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.pages.SoftCoLoginPage;

public class TestDocumentSearch extends TestTemplate{
	
	private static final Logger LOG = Logger.getLogger(TestDocumentSearch.class);
	@Test(dataProvider = "getDataFromExcel", groups = {"ARGlobalSearch"})
	public void ValidateDocumentSearch(Hashtable<String, String> data) throws Exception
	{
		String userName = data.get("UserName");
		String password = data.get("Password");
		String isAddButtonVisisble = data.get("isAddButtonVisisble");
		
		SoftCoLoginPage loginPage = new SoftCoLoginPage(this.webDriver);
		boolean isSuccess = loginPage.Login(this.url, userName, password);
		if(isSuccess)
		{
			LOG.info(String.format("Login Successful for user - %s", userName));
		}
		else
		{
			LOG.error(String.format("Login Not Successful for user - %s", userName));
		}
		
	}

}
