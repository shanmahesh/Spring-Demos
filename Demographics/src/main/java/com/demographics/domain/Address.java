package com.demographics.domain;

import java.util.Date;

import javax.persistence.Entity;

import  com.base.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author Mahesh S
 *
 */

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Address extends BaseEntity{
	
	private String addrLine1;
	private String addrLine2;
	private String city;
	private String state;
	private String zip;
	public Date effectiveDate;
	
}
