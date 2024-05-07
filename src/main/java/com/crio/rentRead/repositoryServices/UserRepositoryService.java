package com.crio.rentRead.repositoryServices;

import com.crio.rentRead.dto.User;

public interface UserRepositoryService {
    
    User registerUser(String firstName, String lastName, String email, String password, String role);

    User findUserByEmail(String email);
    
}
