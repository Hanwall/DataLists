package other.src.com.hafao.information.utils;

import other.src.com.hafao.inforamtion.InitApplicaiton;

public class PrintHelper {

	public static void print(String message) {
		if (InitApplicaiton.DEBUGSTATUS.equals("YES")) {
			System.out.println(message);
		}
	}
}
