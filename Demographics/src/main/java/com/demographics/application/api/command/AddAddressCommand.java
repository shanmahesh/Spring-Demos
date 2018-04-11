/**
 * 
 */
package com.demographics.application.api.command;

import com.demographics.application.api.dto.AddressDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mahesh S
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class AddAddressCommand {
	private AddressDto addressDto;
}
