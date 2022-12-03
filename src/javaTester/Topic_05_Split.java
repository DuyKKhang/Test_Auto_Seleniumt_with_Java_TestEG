package javaTester;

import java.util.Random;

public class Topic_05_Split {

	public static void main(String[] args) {
		String url ="https://the-internet.herokuapp.com/";
		String[] urlArray = url.split("//");
		System.out.println(urlArray[0]);
		System.out.println(urlArray[1]);
		
		url = urlArray[0]+"//"+"admin"+":"+"admin"+"@"+urlArray[1];
		
		
		
	}

}
