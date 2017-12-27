package tests;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.pages.SoftCoGlobalSearchPage;
import com.pages.SoftCoLoginPage;

public class TC002ediatble extends TestTemplate{
	
	private static final Logger LOG = Logger.getLogger(TC002ediatble.class);
	@Test(dataProvider = "getDataFromExcel", groups = {"ARGlobalSearch"})
	public void ValidateMissingClient(Hashtable<String, String> data) throws Exception
	{
		String userName = data.get("UserName");
		String password = data.get("Password");
		String isAddButtonVisisble = data.get("isAddButtonVisisble");
		
		SoftCoLoginPage loginPage = new SoftCoLoginPage(this.webDriver);
		boolean isSuccess = loginPage.login(this.url, userName, password);
		if(isSuccess)
		{
			LOG.info(String.format("Login Successful for user - %s", userName));
		}
		else
		{
			LOG.error(String.format("Login Not Successful for user - %s", userName));
		}
		
		SoftCoGlobalSearchPage searchPage = new SoftCoGlobalSearchPage(this.webDriver);
		searchPage.validateSearchForDocument(isAddButtonVisisble);
		
		loginPage.logout();
	}

}
