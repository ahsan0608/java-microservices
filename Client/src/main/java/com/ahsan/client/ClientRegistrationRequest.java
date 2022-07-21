package com.ahsan.client;

public record ClientRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
