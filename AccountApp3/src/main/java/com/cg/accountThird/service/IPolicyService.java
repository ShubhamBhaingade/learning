package com.cg.accountThird.service;

import org.springframework.stereotype.Service;

import com.cg.accountThird.entity.Policy;

@Service
public interface IPolicyService {
	
	public int savePolicy(Policy policy );
	public Policy getPolicyByPolicyCode(int code);

}
