package com.ayush.UserManagement.service;


import com.ayush.UserManagement.model.UsersModel;
import com.ayush.UserManagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsersService {

    @Autowired
    private  UsersRepository usersRepository;



    public UsersModel registerUser(String fullName, String email, String password, String dob, String address,
                                   String state, String contact, String gender) {

        if (email == null || password == null) {

            return null;
        } else {
            if(usersRepository.findFirstByEmail(email).isPresent()){
                System.out.println("Email Id Already Exists!");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setEmail(email);
            usersModel.setPassword(password);
            usersModel.setFullName(fullName);
            usersModel.setAddress(address);
            usersModel.setState(state);
            usersModel.setGender(gender);
            usersModel.setContact(contact);
            usersModel.setDob(dob);
            return usersRepository.save(usersModel);
        }

    }
    public UsersModel authenticate(String email, String password) {

        return usersRepository.findByEmailAndPassword(email,password).orElse(null);
    }


}
