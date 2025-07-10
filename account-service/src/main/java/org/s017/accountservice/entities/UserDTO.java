package org.s017.accountservice.entities;

import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String name,@NotNull String email,@NotNull String password) {}