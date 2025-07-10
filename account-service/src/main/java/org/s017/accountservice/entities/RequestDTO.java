package org.s017.accountservice.entities;

import jakarta.validation.constraints.NotNull;

public record RequestDTO(@NotNull String email,@NotNull String password) {}