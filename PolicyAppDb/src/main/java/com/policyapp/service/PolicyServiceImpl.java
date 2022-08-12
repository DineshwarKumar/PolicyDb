package com.policyapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
	IPolicyDAO policyDao=new PolicyDAOImpl();
	@Override
	public void addPolicy(Policy policy) {
		policyDao.addPolicy(policy);
	}

	@Override
	public void deletePolicy(int policyId) {
		policyDao.deletePolicy(policyId);
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		policyDao.updatePolicy(policyId, coverage);
	}

	@Override
	public List<Policy> getAll() {
		List<Policy> list=policyDao.findAll();
		return list;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy> list=policyDao.findByType(type);
		return list;
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy> list=policyDao.findByCategory(category);
		return list;
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> list=policyDao.findByHighSumAssured(sumAssured);
		return list;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> list=policyDao.findByCoverage(coverage);
		return list;
	}

	@Override
	public List<Policy> getBYLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy> list=policyDao.findBYLessPremium(premium);
		return list;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy list=policyDao.findById(policyId);
		return list;
	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {
		List<Policy> list=policyDao.findByBrand(brand);
		return list;
	}

	
	
	

}
