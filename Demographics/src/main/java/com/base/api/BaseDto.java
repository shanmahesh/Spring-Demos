/**
 * 
 */
package com.base.api;

import java.util.List;

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
public class BaseDto {

	private List errorList;
	private List messageList;
	private List warningList;
	
	
}
