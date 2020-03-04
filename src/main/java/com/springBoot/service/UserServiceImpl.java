package com.springBoot.service;

import java.util.ArrayList;
import java.util.List;

import com.springBoot.dto.UsersDto;
import com.springBoot.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.entity.Users;
import com.springBoot.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    UserMapper mapper = Mappers.getMapper(UserMapper.class);
    
    @Override
    public List<UsersDto> getUsersById(long userId) {
        List<UsersDto> result = new ArrayList<UsersDto>();
        List<Users> users = userRepository.findByUsId(userId);
        for (Users us : users) {
        	result.add(mapper.usersToUsersDto(us));
        }
        return result;
    }


	@Override
	public List<UsersDto> getAllUsers() {
		List<UsersDto> result = new ArrayList<UsersDto>();
		List<Users> users = userRepository.findAll();
		for (Users us : users) {
        	result.add(mapper.usersToUsersDto(us));
        }
		return result;
	}


	@Override
	public void save(Users user) {
		userRepository.save(user);
	}


	@Override
	public Users findByUsLogin(String usLogin) {
		return userRepository.findByUsLogin(usLogin);
	}
	
}
