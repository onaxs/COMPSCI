/*
import java.util.Scanner;

public class leapYearCalculator{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a year:");
		int year = scanner.nextInt();
		Boolean leap;
		if(year%100==0 && year%400==0){
			leap = true;
		}
		else if(year%4 == 0){
			leap = true;
		}
		else{
			leap = false;
		}
		if(leap==true){
			System.out.println(year+" is a leap year");
		}
		else{
			System.out.println(year+" is not a leap year");
		}
	}
}
