package com.cg.accountThird.exception;



import com.cg.accountThird.service.AccountServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidLocationException extends Exception {
	
	
	private String errorMsg;
	private String srcResName;

}
