package com.js.intbuffetproject.util;

public class Util {
	public enum Paymentmethod {
		CASH_PAYMENT("CASH PAYMENT"), 
		PAYMENY_BY_CARD("PAYMENY BY CARD");

		private String name;

		private Paymentmethod(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public enum Deliverymethod {
		SELF_DELIVERY("SELF DELIVERY"), 
		HOME_DELIVERY("HOME DELIVERY");

		private String name;

		private Deliverymethod(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public enum Orderstatus {
		PENDING_PAYMENT("PENDING PAYMENT"), // warten auf Bezahlung
		PENDING_DELIVERY("PENDING DELIVERY"), 
		FULLY_PAID("FULLY PAID"), 
		DELIVERED("DELIVERED");

		private String name;

		private Orderstatus(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
