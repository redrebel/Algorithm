package p140916;

public class Weekday {

	/**
	 * print weekday at d'after
	 * @param d
	 */
	public void run(int d){
		int remainDay = d%7;
		System.out.println(remainDay);
		
		switch(remainDay){
		case 0:
			System.out.println("sunday");
			break;
		case 1:
			System.out.println("monday");
			break;
		case 2:
			System.out.println("tuesday");
			break;
		case 3:
			System.out.println("wednesday");
			break;
		case 4:
			System.out.println("thursday");
			break;
		case 5:
			System.out.println("friday");
			break;
		case 6:
			System.out.println("saturday");
			break;
		}
		
	}
	
	/**
	 * print weekday at n-after
	 * @param n
	 */
	public void run2(int n){
		/*
		 * 10^0 / 7 = 1
		 * 10^1 / 7 = 3
		 * 10^2 / 7 = 2
		 * 10^3 / 7 = 6
		 * 10^4 / 7 = 4
		 * 10^5 / 7 = 5
		 * 10^6 / 7 = 1
		 * 10^7 / 7 = 3
		 * ...
		 * ... 
		 */
		int remainDay = n%6;
		
		switch(remainDay){
		case 0:
			System.out.println("monday");
			break;
		case 1:
			System.out.println("wednesday");
			break;
		case 2:
			System.out.println("tuesday");
			break;
		case 3:
			System.out.println("saturday");
			break;
		case 4:
			System.out.println("thursday");
			break;
		case 5:
			System.out.println("friday");
			break;
		}
		
	}
	public static void main(String[] args) {
		Weekday wd = new Weekday();
		
		// what is weekday at 100day after? 
		wd.run(100);
		
		// what is weekday at 10^100 day after?
		wd.run(100);
	}

}
