package com.Spring_exp9;

import jakarta.persistence.*;
import jakarta.persistence.Id;
@Entity
public class Student {

		@Id
		private int id;
		
		private String name;
		private String email;

		private String roll_no;

		public Student() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRoll_no() {
			return roll_no;
		}

		public void setRoll_no(String roll_no) {
			this.roll_no = roll_no;
		}
	

}
