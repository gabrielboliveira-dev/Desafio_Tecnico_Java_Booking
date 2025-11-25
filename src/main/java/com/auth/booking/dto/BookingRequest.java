package com.auth.booking.dto;

import java.time.LocalDate;

public record BookingRequest(
        Long roomId,
        String guestName,
        LocalDate checkInDate,
        LocalDate checkOutDate
) {}