package net.breezeware.dynamo.pages.svc.dao;

import org.springframework.stereotype.Repository;

import net.breezeware.dynamo.pages.svc.entity.Attachment;
import net.breezeware.dynamo.generics.crud.dao.GenericRepository;

@Repository
public interface AttachmentRepository extends GenericRepository<Attachment> {
}
