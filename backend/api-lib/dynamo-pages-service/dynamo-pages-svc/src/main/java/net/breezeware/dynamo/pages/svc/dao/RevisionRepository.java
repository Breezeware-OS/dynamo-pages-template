package net.breezeware.dynamo.pages.svc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import net.breezeware.dynamo.pages.svc.entity.Document;
import net.breezeware.dynamo.pages.svc.entity.Revision;
import net.breezeware.dynamo.generics.crud.dao.GenericRepository;

@Repository
public interface RevisionRepository extends GenericRepository<Revision> {
    List<Revision> findByDocument(Document updatedDocument);

    Optional<Revision> findByDocumentAndStatus(Document document, String status);
}
