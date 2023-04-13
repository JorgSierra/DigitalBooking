package com.dh.digital_booking_back.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.dh.digital_booking_back.model.AuthenticationRequest;
import org.junit.jupiter.api.Test;

public class AuthenticationRequestTest {

    @Test
    public void gettersAndSettersShouldWorkProperly() {
        // Arrange
        AuthenticationRequest authRequest = new AuthenticationRequest();
        String username = "testUser";
        String password = "testPassword";

        // Act
        authRequest.setUsername(username);
        authRequest.setPassword(password);

        // Assert
        assertThat(authRequest.getUsername()).isEqualTo(username);
        assertThat(authRequest.getPassword()).isEqualTo(password);
    }

    @Test
    public void constructorShouldWorkProperly() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        // Act
        AuthenticationRequest authRequest = new AuthenticationRequest(username, password);

        // Assert
        assertThat(authRequest.getUsername()).isEqualTo(username);
        assertThat(authRequest.getPassword()).isEqualTo(password);
    }
}
