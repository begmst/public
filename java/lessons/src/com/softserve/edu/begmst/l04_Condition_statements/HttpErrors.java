package com.softserve.edu.begmst.l04_Condition_statements;

import java.util.Scanner;

public class HttpErrors {
	
	enum HTTPError {
		ERROR_400(400, "Bad Request"),
		ERROR_401(401, "Unauthorized"),
		ERROR_402(402, "Payment Required"),
		ERROR_403(403, "Forbidden"),
		ERROR_404(404, "Not Found");
		
		public final int code;
		public final String error;
		
		private HTTPError(int code, String error) {
			this.code = code;
			this.error = error;
		}
	}

	public static void main(String[] args) {
		int code = 0;
		do {
			Scanner s = new Scanner(System.in);
			System.out.print("Enter HTTP code or 0: ");
			code = s.nextInt();
			switch (code) {
				case 400:
					System.out.println(HTTPError.ERROR_400.error);
					break;
				case 401:
					System.out.println(HTTPError.ERROR_401.error);
					break;
				case 402:
					System.out.println(HTTPError.ERROR_402.error);
					break;
				case 403:
					System.out.println(HTTPError.ERROR_403.error);
					break;
				case 404:
					System.out.println(HTTPError.ERROR_404.error);
					break;
				default:
					System.out.println("No such code.");
					break;
			}
		} while (code != 0);
	}

}
