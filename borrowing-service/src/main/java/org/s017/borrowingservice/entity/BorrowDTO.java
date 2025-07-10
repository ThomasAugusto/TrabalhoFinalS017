package org.s017.borrowingservice.entity;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BorrowDTO(@NotNull Client client, @NotNull List<Book> books) {}