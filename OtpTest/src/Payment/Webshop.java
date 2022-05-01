package Payment;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Webshop {
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Payment> paymentList = new ArrayList<Payment>();
	
	public void CustomerBeolvas(String path) throws IOException {
		FileReader fr = new FileReader(path, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while ((line = br.readLine()) != null) {
			String[] splitLine = line.split(";");

			Customer c = new Customer(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
			customerList.add(c);
		}
		
		br.close();
		fr.close();
	}
	
	public void PaymentBeolvas(String path) throws IOException {
		FileReader fr = new FileReader(path, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while ((line = br.readLine()) != null) {
			String[] splitLine = line.split(";");

			if (splitLine[2].equals("card") && splitLine[4].isEmpty()) {
				Payment p = new Payment(splitLine[0], splitLine[1], splitLine[2], Integer.parseInt(splitLine[3]), "", splitLine[5], splitLine[6]);
				paymentList.add(p);
			} else if (splitLine[2].equals("transfer") && splitLine[5].isEmpty()) {
				Payment p = new Payment(splitLine[0], splitLine[1], splitLine[2], Integer.parseInt(splitLine[3]), splitLine[4], "", splitLine[6]);
				paymentList.add(p);
			} else {
				Log("Kártyás vagy utalásos fizetésnél nem a megfelelő szám (bankszámlaszám vagy kártyaszám) van megadva", line);
			}
		}
		
		br.close();
		fr.close();
	}
	
	private void Log(String message, String errorLine) throws IOException {
		File f = new File("application.log");
		FileOutputStream fos = new FileOutputStream(f);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));
		
		bw.write(message);
		bw.newLine();
		bw.write(errorLine);
		bw.newLine();
		
		bw.close();
		fos.close();
	}
	
	public void PurchaseSummary() throws IOException {
		File f = new File("report01.csv");
		FileOutputStream fos = new FileOutputStream(f);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));
		
		Dictionary<String, Integer> sums = new Hashtable<String, Integer>();

		for (int i = 0; i < customerList.size(); i++) {
			int sum = 0;
			
			for (int j = 0; j < paymentList.size(); j++) {
				if (paymentList.get(j).getCustomerId().equals(customerList.get(i).getCustomerId()) && paymentList.get(j).getWebshopId().equals(customerList.get(i).getWebsopId())) {
					sum = sum + paymentList.get(j).getSum();
				}
			}
			sums.put(customerList.get(i).getCustomerName(), sum);
		}
		
		for (int i = 0; i < customerList.size(); i++) {
			bw.write(customerList.get(i).getCustomerName() + ";" + customerList.get(i).getCustomerAddress() + ";" + sums.get(customerList.get(i).getCustomerName()));
			bw.newLine();
		}
		
		bw.close();
		fos.close();
	}
}
