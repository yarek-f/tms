package com.autoflex.tms.services;

import com.autoflex.tms.dto.bugDto.CreateBugDto;
import com.autoflex.tms.dto.bugDto.GetAllBugDto;

import java.util.List;

public interface BugService {
    void createBug(CreateBugDto createBugDto);
    GetAllBugDto getBugById(String id);
    void remove(String id);
    void update(CreateBugDto createBugDto, String id);
    List<GetAllBugDto> findAll();
    List<GetAllBugDto> findByStatusAndUrgent(String status, String urgent);
    List<GetAllBugDto> findByUrgentAndDetectedVersion(String urgent, String detectedVersion);
    List<GetAllBugDto> findByUrgentAndImportantAndDetectedVersion(String urgent, String important, String detectedVersion);
}
