package com.Nm.Website_live;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer  { 

	  private int count = 0; 

	  private int maxCount = 0;

	  @Override

	  public boolean retry(ITestResult result) { 

	    if(count < maxCount) {  

	       count++;

	       return true;        

	    }        

	    return false; 

	 }

	}