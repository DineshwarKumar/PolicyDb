package com.policyapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.util.DbConnection;

public class PolicyDAOImpl implements IPolicyDAO {
	 
	@Override
	public void addPolicy(Policy policy) {
	String sql="insert into policy (policy_Name,premium,type,duration,coverage,brand,category,sum_assured) values (?,?,?,?,?,?,?,?)";
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, policy.getPolicyName());
			preparedStatement.setDouble(2,policy.getPremium());
			preparedStatement.setString(3, policy.getType());
			preparedStatement.setInt(4, policy.getDuration());
			preparedStatement.setString(5, policy.getCoverage());
			preparedStatement.setString(6, policy.getBrand());
			preparedStatement.setString(7, policy.getCategory());
			preparedStatement.setDouble(8, policy.getSumAssured());
			boolean result=preparedStatement.execute();
			System.out.println("Inserted "+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		
				DbConnection.closeConnection();
				try {
					if(preparedStatement==null)
						preparedStatement.close();
					if(resultSet==null)
						resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

	@Override
	public void deletePolicy(int policyId) {
		String sql="delete from policy where policy_id= ?";
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, policyId);
			boolean result=preparedStatement.execute();
			System.out.println("Deleted "+result);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DbConnection.closeConnection();
			
				try {
					if(preparedStatement==null)
						preparedStatement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		String sql="update  policy set coverage= ? where policy_id= ?";
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, coverage);
			preparedStatement.setInt(2, policyId);
			boolean result=preparedStatement.execute();
			System.out.println("Updated "+result);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	}

	@Override
	public List<Policy> findAll() {
		Connection connection=DbConnection.openConnection();
		List<Policy> policies=new ArrayList<Policy>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			String sql="select * from policy";
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				Policy policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policies;
	}

	@Override
	public List<Policy> findByType(String ntype) throws PolicyNotFoundException {
		Connection connection=DbConnection.openConnection();
		List<Policy> policies=new ArrayList<Policy>();
		PreparedStatement preparedStatement =null;
		ResultSet resultSet=null;
		try {
			String sql="select * from policy where type= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ntype);
			resultSet=preparedStatement.executeQuery();	
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				Policy policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policies;
		
	}

	@Override
	public List<Policy> findByCategory(String ncategory) throws PolicyNotFoundException {
		Connection connection=DbConnection.openConnection();
		List<Policy> policies=new ArrayList<Policy>();
		ResultSet resultSet=null;
		PreparedStatement preparedStatement =null;
		try {
			String sql="select * from policy where category= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ncategory);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				Policy policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policies;
		
	}

	@Override
	public List<Policy> findByHighSumAssured(double nsumAssured) throws PolicyNotFoundException {
		Connection connection=DbConnection.openConnection();
		List<Policy> policies=new ArrayList<Policy>();
		ResultSet resultSet=null;
		PreparedStatement preparedStatement =null;
		try {
			String sql="select * from policy where sum_Assured>= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, nsumAssured );
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				Policy policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policies;
		
	}

	@Override
	public List<Policy> findByCoverage(String ncoverage) throws PolicyNotFoundException {
		Connection connection=DbConnection.openConnection();
		List<Policy> policies=new ArrayList<Policy>();
		ResultSet resultSet=null;
		PreparedStatement preparedStatement =null;
		try {
			String sql="select * from policy where coverage= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ncoverage);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				Policy policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policies;
	}

	@Override
	public List<Policy> findBYLessPremium(double npremium) throws PolicyNotFoundException {
		Connection connection=DbConnection.openConnection();
		List<Policy> policies=new ArrayList<Policy>();
		ResultSet resultSet=null;
		PreparedStatement preparedStatement =null;
		try {
			String sql="select * from policy where premium<= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, npremium);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				Policy policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policies;
	}

	@Override
	public Policy findById(int npolicyId) throws IdNotFoundException {
		Connection connection=DbConnection.openConnection();
		Policy policy = null ;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement =null;
		try {
			String sql="select * from policy where policy_id= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, npolicyId);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policy;
	}

	@Override
	public List<Policy> findByBrand(String nbrand) throws PolicyNotFoundException {
		Connection connection=DbConnection.openConnection();
		List<Policy> policies=new ArrayList<Policy>();
		ResultSet resultSet=null;
		PreparedStatement preparedStatement =null;
		try {
			String sql="select * from policy where brand= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nbrand);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				String  name=resultSet.getString("policy_Name");
				Integer  Number=resultSet.getInt("policy_id");
				double  Premium=resultSet.getDouble("premium");
				String  type=resultSet.getString("type");
				int  duration=resultSet.getInt("duration");
				String  coverage=resultSet.getString("coverage");
				String  brand=resultSet.getString("brand");
				String  category=resultSet.getString("category");
				double  sumAssured=resultSet.getDouble("sum_Assured");
				Policy policy  =new Policy(name, Number, Premium, type, duration, coverage, brand, category, sumAssured);
				policies.add(policy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			DbConnection.closeConnection();
			
			try {
				if(preparedStatement==null)
					preparedStatement.close();
				if(resultSet==null)
					resultSet.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return policies;
	}

	
	

	
}
