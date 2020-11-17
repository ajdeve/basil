package burger.view;

import java.util.ArrayList;

import burger.model.dto.Customer;

public class FailView {

	public static void invalidateReq(String message) {
		System.out.println("�߻��� ����: " + message);
	}

	public static void validateReq(String message) {
		System.out.println("���� ����: " + message);
	}

	public static void viewCust(Customer cust) {
		System.err.println("�˻��� �� ����: " + cust);// cust.toString()
	}

	public static void viewCustAll(ArrayList<Customer> all) {
		System.err.println("��� �� ����");
		for (Customer v : all) {
			System.out.println(v);
		}

	}
}
