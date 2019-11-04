package edu.gyc.myrbac.service;


import edu.gyc.myrbac.model.Role;
import edu.gyc.myrbac.model.User;

import java.util.List;


public interface UserService {


    public int add(User user);
    public User get(Integer id);
    public List<User> getAllUser();

    public List<Role> getUserRoles(Integer id);
    public void updateRoles(Integer id, int[] roleIds);

    public User selectUserByUsernameAndPassword(String username, String password);

    public List<String> getUserPersmission(Integer userId);
}
