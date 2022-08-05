package com.autoflex.tms.services;

import com.autoflex.tms.dto.userDto.CreateUserDto;
import com.autoflex.tms.dto.userDto.GetAllUserDto;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(CreateUserDto createUserDto) {
        userRepository.save(Mapper.convertToUser(createUserDto));
    }

    @Override
    public void update(CreateUserDto createUserDto , String email) {
        userRepository.deleteByEmail(email);
        userRepository.save(Mapper.convertToUser(createUserDto));
    }

    @Override
    public void remove(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public GetAllUserDto getByEmail(String email) {
        return Mapper.convertToGetAllUserDto(userRepository.findByEmail(email));
    }

    @Override
    public List<GetAllUserDto> getAll() {
        return userRepository.findAll().stream()
                .map(Mapper::convertToGetAllUserDto)
                .collect(Collectors.toList());
    }
}
