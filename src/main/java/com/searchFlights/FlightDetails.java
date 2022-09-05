package com.searchFlights;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight_details")
public class FlightDetails {
	//@GeneratedValue(strategy = GenerationType.AUTO)
		@Id 
		private String flight_name;
		private String origin;
		private String destination;
		private String flight_date;
		private String origin_time;
		private String destination_time;
		private String flight_duration;
		private int economy_price;
		private int business_price;
		private String economy_available;
		private String business_available;
		
		
		public String getFlight_name() {
			return flight_name;
		}


		public void setFlight_name(String flight_name) {
			this.flight_name = flight_name;
		}


		public String getOrigin() {
			return origin;
		}


		public void setOrigin(String origin) {
			this.origin = origin;
		}


		public String getDestination() {
			return destination;
		}


		public void setDestination(String destination) {
			this.destination = destination;
		}


		public String getFlight_date() {
			return flight_date;
		}


		public void setFlight_date(String flight_date) {
			this.flight_date = flight_date;
		}


		public String getOrigin_time() {
			return origin_time;
		}


		public void setOrigin_time(String origin_time) {
			this.origin_time = origin_time;
		}


		public String getDestination_time() {
			return destination_time;
		}


		public void setDestination_time(String destination_time) {
			this.destination_time = destination_time;
		}


		public String getFlight_duration() {
			return flight_duration;
		}


		public void setFlight_duration(String flight_duration) {
			this.flight_duration = flight_duration;
		}


		public int getEconomy_price() {
			return economy_price;
		}


		public void setEconomy_price(int economy_price) {
			this.economy_price = economy_price;
		}


		public int getBusiness_price() {
			return business_price;
		}


		public void setBusiness_price(int business_price) {
			this.business_price = business_price;
		}


		public String getEconomy_available() {
			return economy_available;
		}


		public void setEconomy_available(String economy_available) {
			this.economy_available = economy_available;
		}


		public String getBusiness_available() {
			return business_available;
		}


		public void setBusiness_available(String business_available) {
			this.business_available = business_available;
		}


		@Override
		public String toString() {
			return " [ flight_name="+flight_name+" origin=" + origin + ", destination=" + destination + ", flight_date=" + flight_date
					+ ", origin_time=" + origin_time + ", destination_time=" + destination_time + ", flight_duration="
					+ flight_duration + ", economy_price=" + economy_price + ", business_price=" + business_price
					+ ", economy_available=" + economy_available + ", business_available=" + business_available + "]";
		}
}
