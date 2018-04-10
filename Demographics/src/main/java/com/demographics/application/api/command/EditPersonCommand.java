/**
 * 
 */
package com.demographics.application.api.command;

import com.demographics.application.api.dto.PersonDto;

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
public class EditPersonCommand {
	private PersonDto personDto;
}
