package com.auth.booking.util;

import com.auth.booking.model.Room;
import com.auth.booking.model.RoomStatus;
import com.auth.booking.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public DataSeeder(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Room room = new Room();
        room.setRoomNumber("101-Deluxe");
        room.setPricePerNight(new BigDecimal("150.00"));
        room.setStatus(RoomStatus.AVAILABLE);

        roomRepository.save(room);

        System.out.println("🏨 Quarto de Teste criado com ID: " + room.getId());
    }
}