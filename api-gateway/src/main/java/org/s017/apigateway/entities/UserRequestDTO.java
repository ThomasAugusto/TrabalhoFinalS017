package org.s017.apigateway.entities;

import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(@NotNull String email, @NotNull String password) {}