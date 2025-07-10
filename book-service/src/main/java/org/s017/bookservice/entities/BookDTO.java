package org.s017.bookservice.entities;

import jakarta.validation.constraints.NotNull;

public record BookDTO(@NotNull String title, @NotNull String author) {}