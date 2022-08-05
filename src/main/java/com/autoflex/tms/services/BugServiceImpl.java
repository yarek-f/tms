package com.autoflex.tms.services;

import com.autoflex.tms.dto.bugDto.CreateBugDto;
import com.autoflex.tms.dto.bugDto.GetAllBugDto;
import com.autoflex.tms.entities.Status;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.repositories.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BugServiceImpl implements BugService{
    @Autowired
    private BugRepository bugRepository;

    @Override
    public void createBug(CreateBugDto createBugDto) {
        bugRepository.save(Mapper.convertToBug(createBugDto));
    }

    @Override
    public GetAllBugDto getBugById(String id) {
        return Mapper.convertToGetAllBugDto(bugRepository.findById(Long.valueOf(id)).get());
    }

    @Override
    public List<GetAllBugDto> findByStatusAndUrgent(String status, String urgent){
        return bugRepository.findByStatusAndUrgent(Status.valueOf(status), Boolean.parseBoolean(urgent)).stream()
                .map(Mapper::convertToGetAllBugDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetAllBugDto> findByUrgentAndDetectedVersion(String urgent, String detectedVersion){
        return bugRepository.findByUrgentAndDetectedVersion(Boolean.parseBoolean(urgent), detectedVersion).stream()
                .map(Mapper::convertToGetAllBugDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetAllBugDto> findByUrgentAndImportantAndDetectedVersion(String urgent, String important, String detectedVersion){
        return bugRepository.findByUrgentAndImportantAndDetectedVersion(Boolean.parseBoolean(urgent), Boolean.parseBoolean(important), detectedVersion).stream()
                .map(Mapper::convertToGetAllBugDto)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(String id) {
        bugRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void update(CreateBugDto createBugDto, String id) {
        bugRepository.deleteById(Long.valueOf(id));
        bugRepository.save(Mapper.convertToBug(createBugDto));
    }

    @Override
    public List<GetAllBugDto> findAll() {
        return bugRepository.findAll().stream()
                .map(Mapper::convertToGetAllBugDto)
                .collect(Collectors.toList());
    }
}
