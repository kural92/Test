package com.Nm.Msite_stage;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="(528, 2061)";
String replace = s.replace("(", "").replace(")", "").replace(" ", "");
String[] split = replace.split(",");

System.out.println(split[0]);
System.out.println(split[1]);
	}

}
