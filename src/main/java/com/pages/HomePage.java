package com.pages;

public class HomePage extends LoginPage {

	/*private static final Logger LOG = Logger.getLogger(HomePage.class);
	LoginPage obj = new LoginPage();
	
	*//**
	 * Navigates to Search for document page
	 * @throws InterruptedException 
	 *//*
	public void navigateToSearchForADocument() throws InterruptedException
	{
		//Read the status if ARInvoice expand icon
		boolean ARInvoiceIconStatus = expandStatusOfARInvoice();
		System.out.println(ARInvoiceIconStatus);
	    LOG.info(String.format("ARInvoiceIconStatus = %s", ARInvoiceIconStatus));
		//Validate if ARInvoiceIcon status and click on icon if it is not expanded
		if(ARInvoiceIconStatus)
		{
			System.out.println("ARInvoiceIcon is expanded");
			LOG.info("ARInvoiceIcon is expanded");
		}
		else
			driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoiceExpand/CollapseICon"))).click();
		Thread.sleep(3000);
		
		//Read the status if ARProcessing queue expand icon
		boolean ARProcessingQueueIconStatus = expandStatusOfARProcessingQueue();
		System.out.println(ARProcessingQueueIconStatus);	
		LOG.info("ARProcessingQueueIconStatus");
		//Validate if ARProcessing queue status and click on icon if it is not expanded
		if(ARProcessingQueueIconStatus)
		{
			System.out.println("ARProcessingQueueIcon is expanded");
			LOG.info("ARProcessingQueueIcon is expanded");
		}
		else
			driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARProcessingQueueExpand/CollapseICon"))).click();
		Thread.sleep(3000);
		
		//Read the status if ARGlobal search expand icon
		boolean ARGlobalSearchIconStatus = expandStatusOfARGlobalSearch();
		System.out.println(ARGlobalSearchIconStatus);				
		//Validate if ARGlobal search status and click on icon if it is not expanded
		if(ARGlobalSearchIconStatus)
			System.out.println("ARGlobal Search is expanded");
		else
			driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARGlobalSearchExpand/CollapseICon"))).click();
		Thread.sleep(3000);
		
		//Click on search for a document link
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoice_SearchForADocument"))).click();
		Thread.sleep(3000);
		
		//validate whether application navigated to Search for a document page
		Assert.assertEquals(driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "CaptionText"))).isDisplayed(), true);
		System.out.println("Succesfully navigated to Search for adocument page");
	}
	
	*//**
	 * Verifies and returns expand/collapse icon status of ARInvoice
	 * @return
	 * @throws InterruptedException 
	 *//*
	public boolean expandStatusOfARInvoice() throws InterruptedException
	{
		Thread.sleep(5000);
		boolean status = false;
		
		//Storing ARInvoice to ARInvoiceExpand_CollapseIcon
		WebElement ARInvoiceExpand_CollapseIcon = driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoiceExpand/CollapseICon")));
		
		//Reading class name of ARInvoice and storing to String type
		String className = ARInvoiceExpand_CollapseIcon.getAttribute("class");
		
		//Validating whether the ICON is in expand / collapse status 
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
		
			//Returning the status
			return status;
	}
	
	*//**
	 * Verifies and returns expand/collapse icon status of ARProcessing queue
	 * @return
	 *//*
	public boolean expandStatusOfARProcessingQueue()
	{
		boolean status = false;
		
		//Storing ARProcessing queue to ARProcessingQueueExpand_CollapseIcon
		WebElement ARProcessingQueueExpand_CollapseIcon = driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARProcessingQueueExpand/CollapseICon")));
		
		//Reading class name of ARProcessing queue and storing to String type
		String className = ARProcessingQueueExpand_CollapseIcon.getAttribute("class");
		
		//Validating whether the ICON is in expand / collapse status 
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
		
			//Returning the status
			return status;
	}
	
	*//**
	 * Verifies and returns expand/collapse icon status of ARGlobal Search
	 * @return
	 *//*
	public boolean expandStatusOfARGlobalSearch()
	{
		boolean status = false;
		
		//Storing ARGlobal Search to ARGlobalSearch_CollapseIcon
		WebElement ARGlobalSearch_CollapseIcon = driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARGlobalSearchExpand/CollapseICon")));
		
		//Reading class name of ARGlobal Search and storing to String type
		String className = ARGlobalSearch_CollapseIcon.getAttribute("class");
		
		//Validating whether the ICON is in expand / collapse status 
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
		
			//Returning the status
			return status;
	}
	
	public void expandARInvoice() throws InterruptedException
	{
		Thread.sleep(5000);
		boolean status = false;
		
		//Storing ARInvoice to ARInvoiceExpand_CollapseIcon
		WebElement ARInvoiceExpand_CollapseIcon = driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoiceExpand/CollapseICon")));
		
		//Reading class name of ARInvoice and storing to String type
		String className = ARInvoiceExpand_CollapseIcon.getAttribute("class");
		
		//Validating whether the ICON is in expand / collapse status 
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
			
			if(status){
				System.out.println("ARInvoiceIcon is expanded");}
			else{
				driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARInvoiceExpand/CollapseICon"))).click();
			Thread.sleep(3000);}
	}
	
	public void expandARProcessingQueue() throws InterruptedException
	{
		boolean status = false;
		
		//Storing ARProcessing queue to ARProcessingQueueExpand_CollapseIcon
		WebElement ARProcessingQueueExpand_CollapseIcon = driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARProcessingQueueExpand/CollapseICon")));
		
		//Reading class name of ARProcessing queue and storing to String type
		String className = ARProcessingQueueExpand_CollapseIcon.getAttribute("class");
		
		//Validating whether the ICON is in expand / collapse status 
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;

			if(status){
				System.out.println("ARProcessingQueueIcon is expanded");}
			else{
				driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARProcessingQueueExpand/CollapseICon"))).click();
			Thread.sleep(3000);}
	}
	
	public void navigateToMissingClient() throws InterruptedException
	{
		//Expand ARInvoce link
		expandARInvoice();
		
		//Expand AR processing queue link
		expandARProcessingQueue();
		
		//Click on missing client link
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "MissingClientLink"))).click();
		Thread.sleep(3000);
	}
	
	*//**
	 * Verifies and returns expand/collapse icon status of ARGlobal Search
	 * @return
	 * @throws InterruptedException 
	 *//*
	public void expandARGlobalSearch() throws InterruptedException
	{
		boolean status = false;
		
		//Storing ARGlobal Search to ARGlobalSearch_CollapseIcon
		WebElement ARGlobalSearch_CollapseIcon = driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARGlobalSearchExpand/CollapseICon")));
		
		//Reading class name of ARGlobal Search and storing to String type
		String className = ARGlobalSearch_CollapseIcon.getAttribute("class");
		
		//Validating whether the ICON is in expand / collapse status 
			if(className.contains("closed"))
				status = false;	
			else if(className.contains("open"))
				status = true;
			
			if(status){
				System.out.println("ARGlobal Search is expanded");}
			else{
				driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "ARGlobalSearchExpand/CollapseICon"))).click();
			Thread.sleep(3000);}
	}
	
	public void navigateToSearchForInvoice() throws InterruptedException
	{
		//Expand ARInvoce link
		expandARInvoice();
		
		//Expand AR processing queue link
		expandARProcessingQueue();
		
		//Expand AR Global Search
		expandARGlobalSearch();
		
		//Click on missing client link
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchForInvoiceLink"))).click();
		Thread.sleep(3000);
	}
	
	public void navigateToSearchForTimeSheet() throws InterruptedException
	{
		//Expand ARInvoce link
		expandARInvoice();
		
		//Expand AR processing queue link
		expandARProcessingQueue();
		
		//Expand AR Global Search
		expandARGlobalSearch();
		
		//Click on missing client link
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "searchForTimeSheet"))).click();
		Thread.sleep(3000);
	}
	
	public void logout()
	{
		//Click on logout
		driver.findElement(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "LogoutButton"))).click();
		
		//wait until application logged out
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(objReusableLib.getElementLocator(IConstants.LOCATORSFILENAME, "LoginButton"))));
		System.out.println("Application logged out successfully");
	}*/
}


