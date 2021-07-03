package com.everis.msaccount.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private String id;
	private String numberAccount;
    private String owner;
    private Date date;
}
