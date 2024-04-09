/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.datatier.businesslayer;

import com.fwrp.datatier.dao.CharitableOrganizationDao;
import com.fwrp.datatier.dao.CharitableOrganizationlmpl;
import com.fwrp.datatier.dao.ConsumerDao;
import com.fwrp.datatier.dao.ConsumerDaoImpl;
import com.fwrp.datatier.dao.RetailerDao;
import com.fwrp.datatier.dao.RetailerDaoImpl;
import com.fwrp.datatier.dao.UserDao;
import com.fwrp.datatier.dao.UserDaoImpl;
import com.fwrp.models.CharitableOrganization;
import com.fwrp.models.Consumer;
import com.fwrp.models.Retailer;
import com.fwrp.models.User;
import com.fwrp.models.UserRole;
import com.fwrp.utilities.LoginResult;
import com.fwrp.utilities.PasswordService;
import com.fwrp.utilities.Result;
import java.util.List;

/**
 *
 * @author Jessica Gunawan
 */
public class UserManager {

    private final UserDao userDAO;
    private final RetailerDao retailerDAO;
    private final ConsumerDao consumerDAO;
    private final CharitableOrganizationDao charitableOrganizationDAO;

    public UserManager() {

        userDAO = new UserDaoImpl();
        retailerDAO = new RetailerDaoImpl();
        consumerDAO = new ConsumerDaoImpl();
        charitableOrganizationDAO = new CharitableOrganizationlmpl();

    }

    public void createUser(User user) {
        userDAO.insert(user);
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public boolean isEmailInUse(String email) {
        return userDAO.isEmailInUse(email);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public User getUserById(int id) {
        return userDAO.get(id);
    }

    public void createRetailerrDetail(Retailer retailer) {
        retailerDAO.insert(retailer);
    }

    public void updateRetailerrDetail(Retailer retailer) {
        retailerDAO.update(retailer);
    }
    public Retailer getRetailerByUserId(int userId) {
      return  retailerDAO.getRetailerByUserId(userId);
    }
    
    public void createCharitableOrganizationDetail(CharitableOrganization charitableOrganization) {
        charitableOrganizationDAO.insert(charitableOrganization);
    }
    public CharitableOrganization getCharitableOrganizationByUserId(int userId) {
      return  charitableOrganizationDAO.getCharitableOrganizationByUserId(userId);
    }
    
    public void updateCharitableOrganizationDetail(CharitableOrganization charitableOrganization) {
        charitableOrganizationDAO.update(charitableOrganization);
    }

    public void createConsumerDetail(Consumer consumer) {
        consumerDAO.insert(consumer);
    }
    public Consumer getConsumerByUserId(int userId) {
      return  consumerDAO.getConsumerByUserId(userId);
    }
    
    public void updateConsumerDetail(Consumer consumer) {
        consumerDAO.update(consumer);
    }

    public LoginResult Login(String email, String password) {
        User user = getUserByEmail(email);
        if (user == null) {
            return new LoginResult(false,"your email or password wrong!",-1);
        }
        //check password
        if (!PasswordService.verifyPassword(password, user.getPassword())) {
            return new LoginResult(false,"your email or password wrong!",-1);
        }

        return new LoginResult(true,"Login success!",user.getUserId());

    }


    public List<User> getUsersSubscribedToSurplusFoodAlerts() {
    return userDAO.getUsersSubscribedToSurplusFoodAlerts();
    }


}
