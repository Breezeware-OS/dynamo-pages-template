package net.breezeware.dynamo.pages.webbff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.breezeware.dynamo.pages.svc.entity.Revision;
import net.breezeware.dynamo.pages.webbff.dto.RevisionDto;

/**
 * Service for mapping between different objects and entities.
 */
@Mapper(componentModel = "spring")
public interface RevisionMapper {

    /**
     * Converts a Revision entity to a RevisionDto.
     * @param  revision The Revision entity to convert.
     * @return          The corresponding RevisionDto.
     */
    @Mapping(target = "htmlContent", ignore = true)
    // @Mapping(target = "editedUserLastName", source = "editedByUser.lastName")
    // @Mapping(target = "editedUserFirstName", source = "editedByUser.firstName")
    @Mapping(target = "editedByUserId", source = "editedByUserId")
    @Mapping(target = "documentId", source = "document.uniqueId")
    @Mapping(target = "collectionId", source = "document.collection.uniqueId")
    RevisionDto revisionToRevisionDto(Revision revision);

    /**
     * Converts a RevisionDto to a Revision entity.
     * @param  revisionDto The RevisionDto to convert.
     * @return             The corresponding Revision entity.
     */
    @Mapping(target = "editedByUserId", ignore = true)
    @Mapping(target = "document", ignore = true)
    Revision revisionDtoToRevision(RevisionDto revisionDto);

}
