package com.cg.accountThird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.accountThird.entity.Policy;
import com.cg.accountThird.repository.IPolicyRepository;

@Service
public class PolicyServiceImpl implements IPolicyService {
	@Autowired
	IPolicyRepository policyRepository;

	@Override
	public int savePolicy(Policy policy) {
		int polCode=0;
		if (policy!=null) {
			Policy savedPolicy=policyRepository.save(policy);
			polCode=savedPolicy.getPolicyCode();
		}
		return polCode;
	}

	@Override
	public Policy getPolicyByPolicyCode(int code) {
		return policyRepository.findById(code).get();
	}

}
