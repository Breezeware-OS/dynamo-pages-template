package net.breezeware.dynamo.pages.svc.entity;

import java.util.UUID;

import net.breezeware.dynamo.generics.crud.entity.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a collection entity in the Dynamo document service. This entity
 * stores information about a collection, such as its name, description,
 * permissions, and the user who created it.
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "collection", schema = "dynamo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({ @AttributeOverride(name = "createdOn", column = @Column(name = "created_on")),
    @AttributeOverride(name = "modifiedOn", column = @Column(name = "modified_on")) })
public class Collection extends GenericEntity {

    /**
     * The unique identifier of the collection.
     */
    @Schema(example = "f29a44c8-2e94-4891-9b3d-44c0dc0d52c6", description = "The unique identifier of the collection.")
    @Column(name = "unique_id")
    private UUID uniqueId;

    /**
     * The name of the collection.
     */
    @Schema(example = "My Collection", description = "The name of the collection.")
    @Column(name = "name")
    private String name;

    /**
     * The description of the collection.
     */
    @Schema(example = "A collection of documents related to project management.",
            description = "The description of the collection.")
    @Column(name = "description")
    private String description;

    /**
     * The permission settings of the collection.
     */
    @Schema(example = "READ_WRITE", description = "The permission settings of the collection.")
    @Column(name = "permission")
    private String permission;

    /**
     * The user who created the collection.
     */
    @Schema(example = "4985a786-5b6d-4f90-b599-717c67c3954b",
            description = "The unique identifier of the user who created the collection.")
    @Column(name = "created_by_user_id")
    @NotNull(message = "Collection created user id missing")
    private String createdByUserId;
}
