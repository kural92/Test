package com.Nm.Andriod_prod;

import java.awt.List;
import java.util.ArrayList;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;

import com.Nm.Base.MobileBaseClass;

public class Test extends MobileBaseClass {
	static String username=null;
public static void main(String[] args) {
	String s="induja";
	java.util.List ss = driver.findElements(By.xpath(""));
	ArrayList l=new ArrayList();
	l.add(10);
	l.add(20);
	l.add(30);
	l.add(40);
	for (int i = 0; i <ss.size(); i++) {
		System.out.println(l.get(i));
		
	}
	
	
	
	
}
}
