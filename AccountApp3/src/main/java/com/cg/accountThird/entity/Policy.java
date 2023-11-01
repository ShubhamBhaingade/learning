package com.cg.accountThird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="my_policy")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyCode;
	@Column(unique = true)
	private String policyName;
	private int sumAssuredAmount;

}
