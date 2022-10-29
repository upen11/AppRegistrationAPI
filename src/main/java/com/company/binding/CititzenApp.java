package com.company.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CititzenApp {

	private String fullName;

	private String email;

	private Long phnNo;

	private String gender;

	private LocalDate dob;

	private Long ssn;

}
