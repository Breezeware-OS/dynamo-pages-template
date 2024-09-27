package net.breezeware.dynamo.pages.webbff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.breezeware.dynamo.pages.svc.entity.Collection;
import net.breezeware.dynamo.pages.webbff.dto.CollectionDto;

@Mapper(componentModel = "spring")
public interface CollectionMapper {

    /**
     * Converts a Collection entity to a CollectionDto.
     * @param  collection The Collection entity to convert.
     * @return            The corresponding CollectionDto.
     */
    @Mapping(target = "documentList", ignore = true)
    @Mapping(target = "createdByUserId", source = "createdByUserId")
    CollectionDto collectionToCollectionDto(Collection collection);

    /**
     * Converts a CollectionDto to a Collection entity.
     * @param  collectionDto The CollectionDto to convert.
     * @return               The corresponding Collection entity.
     */
    @Mapping(target = "createdByUserId", ignore = true)
    Collection collectionDtoToCollection(CollectionDto collectionDto);
}
