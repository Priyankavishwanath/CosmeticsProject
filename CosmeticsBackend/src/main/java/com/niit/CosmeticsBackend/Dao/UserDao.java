package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.User;

public interface UserDao {
	
	public boolean saveorupdateuser(User user);
	public boolean deleteuser(User user);
	public User getuser(String userId);
	public List<User> list();
	public User isValid(String umail, String pwd);
	public User getUseremail(String currusername);
	
}
