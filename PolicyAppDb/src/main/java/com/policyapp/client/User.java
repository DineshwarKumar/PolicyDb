package com.policyapp.client;

import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {

		IPolicyService policyService= new PolicyServiceImpl();
//		Policy policy=new Policy("BajajAllianz",1001,2000,"endowment",5,"accident","Bajaj","Motor",200000);
//		policyService.addPolicy(policy);
//		System.out.println("Policy added");
//		
//		policyService.getAll().forEach(System.out::println);
		try {
			policyService.getByType("pension").forEach(System.out::println);
			System.out.println();
		policyService.getByCategory("motor").forEach(System.out::println);
		System.out.println();
		policyService.getByCoverage("illness").forEach(System.out::println);
		System.out.println();
		policyService.getByHighSumAssured(250000).forEach(System.out::println);
		System.out.println();
		policyService.getBYLessPremium(3400).forEach(System.out::println);
		System.out.println();
		System.out.println(policyService.getById(4));

		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		policyService.deletePolicy(5);
		
//		policyService.updatePolicy(4, "Illness");
		
		
//		try {
//			policyService.getByType("term").forEach(System.out::println);
//		} catch (PolicyNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
