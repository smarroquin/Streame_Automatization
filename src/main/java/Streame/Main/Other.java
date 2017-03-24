package Streame.Test_UI;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

class Test {
public static void main(String[] args){
	TestListenerAdapter tla = new TestListenerAdapter();
	 
	TestNG testng = new TestNG();
	 
	testng.setTestClasses(new Class[] { Test.class });
	 
	testng.addListener(tla);
	 
	testng.run();
}
}