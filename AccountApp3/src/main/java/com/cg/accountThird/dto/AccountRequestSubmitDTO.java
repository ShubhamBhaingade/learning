package com.cg.accountThird.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestSubmitDTO {
	@Min(value = 1000,message="Your balance must be minimum 1000")
	private int balance;
	@Size(min = 2,max=5,message = "only city name having length bw 2-5 are allowed")
	private String loc;
	@NotNull(message = "mobile pin cannot be null")
	private int mobilePin;
	@NotNull(message = "mobile pin cannot be null")
	private String accountType;
	private String panNumber;

}
