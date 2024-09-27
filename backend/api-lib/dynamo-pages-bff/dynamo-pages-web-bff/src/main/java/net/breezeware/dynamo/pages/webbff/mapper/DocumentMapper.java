package net.breezeware.dynamo.pages.webbff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.breezeware.dynamo.pages.svc.entity.Document;
import net.breezeware.dynamo.pages.webbff.dto.DocumentDto;

/**
 * Service for mapping between different objects and entities.
 */
@Mapper(componentModel = "spring")
public interface DocumentMapper {

    /**
     * Converts a Document entity to a DocumentDto.
     * @param  document The Document entity to convert.
     * @return          The corresponding DocumentDto.
     */
    // @Mapping(target = "createdUserLastName", source = "createdByUser.lastName")
    // @Mapping(target = "createdUserFirstName", source = "createdByUser.firstName")
    // @Mapping(target = "createdByUserId", source = "createdByUserId")
    @Mapping(target = "parentId", source = "parent.uniqueId")
    @Mapping(target = "htmlContent", ignore = true)
    @Mapping(target = "collectionId", source = "collection.uniqueId")
    DocumentDto documentToDocumentDto(Document document);

    /**
     * Converts a DocumentDto to a Document entity.
     * @param  documentDto The DocumentDto to convert.
     * @return             The corresponding Document entity.
     */
    @Mapping(target = "createdByUserId", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "collection", ignore = true)
    @Mapping(target = "children", ignore = true)
    Document documentDtoToDocument(DocumentDto documentDto);

}
