package com.auth.booking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private BigDecimal pricePerNight;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;
}