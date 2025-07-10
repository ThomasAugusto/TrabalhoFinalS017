package org.s017.apigateway.entities;

import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String name,@NotNull String email,@NotNull String password) {}