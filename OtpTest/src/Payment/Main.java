package Payment;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Webshop w = new Webshop();
		
		try {
			w.CustomerBeolvas("customer.csv");
			w.PaymentBeolvas("payments.csv");
			w.PurchaseSummary();
		}  catch (IOException e) {
			System.out.println("A file nem található");
			e.printStackTrace();
		}
		
	}

}
