package com.example.demo.binding;

import java.time.LocalDate;


import lombok.Data;

@Data
public class ContactForm 
{
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Integer activesw;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	

}
