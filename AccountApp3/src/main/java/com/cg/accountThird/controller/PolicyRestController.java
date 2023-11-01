package com.cg.accountThird.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.accountThird.entity.Policy;
import com.cg.accountThird.service.IPolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyRestController {
	@Autowired
	IPolicyService policyService;
	@PostMapping("/save")
	public int addPolicy(@RequestBody Policy policy) {
		int savedPolicyCode=policyService.savePolicy(policy);
		return savedPolicyCode;
	}
	@GetMapping("/getpolicy")
	public Policy getPolicy(@RequestParam int id) {
		return policyService.getPolicyByPolicyCode(id);
	}
	

}
