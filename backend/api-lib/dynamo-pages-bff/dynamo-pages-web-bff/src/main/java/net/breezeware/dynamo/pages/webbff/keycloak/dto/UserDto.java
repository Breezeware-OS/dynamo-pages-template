package net.breezeware.dynamo.pages.webbff.keycloak.dto;

import lombok.Data;

@Data
public class UserDto {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;
}
