package net.breezeware.dynamo.pages.svc.service;

import org.springframework.stereotype.Service;

import net.breezeware.dynamo.pages.svc.dao.AttachmentRepository;
import net.breezeware.dynamo.pages.svc.entity.Attachment;
import net.breezeware.dynamo.generics.crud.service.GenericService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AttachmentService extends GenericService<Attachment> {
    /**
     * Constructs a new GenericService with the provided GenericRepository.
     * @param attachmentRepository the repository for accessing and managing entity
     *                             data.
     */
    public AttachmentService(AttachmentRepository attachmentRepository) {
        super(attachmentRepository);
    }
}
