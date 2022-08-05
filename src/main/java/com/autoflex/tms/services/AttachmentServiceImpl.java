package com.autoflex.tms.services;

import com.autoflex.tms.dto.AttachmentDto;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.repositories.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public void create(AttachmentDto attachmentDto) {
        attachmentRepository.save(Mapper.convertToAttachment(attachmentDto));
    }

    @Override
    public List<AttachmentDto> findAll() {
        return attachmentRepository.findAll().stream()
                .map(Mapper::convertToAttachmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void update(String id, AttachmentDto attachmentDto) {
        attachmentRepository.deleteById(Long.valueOf(id));
        attachmentRepository.save(Mapper.convertToAttachment(attachmentDto));
    }

    @Override
    public void remove(String id) {
        attachmentRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public AttachmentDto getById(String id) {
        return Mapper.convertToAttachmentDto(attachmentRepository.getReferenceById(Long.valueOf(id)));
    }
}
