/**
 * 
 */
package com.demographics.application.api.dto;

import java.util.Date;

import javax.persistence.Entity;

import com.base.api.BaseDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mahesh S
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto extends BaseDto{
	
	private Long addrId;
	private String addrLine1;
	private String addrLine2;
	private String city;
	private String state;
	private String zip;
	public Date effectiveDate;
	public String prsnId;
	
}
