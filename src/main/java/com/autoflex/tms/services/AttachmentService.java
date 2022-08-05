package com.autoflex.tms.services;

import com.autoflex.tms.dto.AttachmentDto;

import java.util.List;

public interface AttachmentService {
    void create (AttachmentDto attachmentDto);
    List<AttachmentDto> findAll();
    void update (String id, AttachmentDto attachmentDto);
    void remove (String id);
    AttachmentDto getById (String id);
}
