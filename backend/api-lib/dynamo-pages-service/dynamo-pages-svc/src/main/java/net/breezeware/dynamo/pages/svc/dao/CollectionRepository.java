package net.breezeware.dynamo.pages.svc.dao;

import net.breezeware.dynamo.generics.crud.dao.GenericRepository;
import net.breezeware.dynamo.pages.svc.entity.Collection;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CollectionRepository extends GenericRepository<Collection> {

    Optional<Collection> findByUniqueId(UUID id);

    Optional<Collection> findByName(String name);
}