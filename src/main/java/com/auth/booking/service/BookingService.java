package com.auth.booking.service;

import com.auth.booking.dto.BookingRequest;
import com.auth.booking.model.Booking;
import com.auth.booking.model.Room;
import com.auth.booking.model.RoomStatus;
import com.auth.booking.repository.BookingRepository;
import com.auth.booking.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public BookingService(RoomRepository roomRepository, BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public Booking bookRoom(BookingRequest request) {

        Room room = roomRepository.findByIdWithLock(request.roomId())
                .orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));

        if (room.getStatus() == RoomStatus.BOOKED) {
            throw new IllegalStateException("Quarto já reservado! Tente outro.");
        }

        room.setStatus(RoomStatus.BOOKED);
        roomRepository.save(room);

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setGuestName(request.guestName());
        booking.setCheckInDate(request.checkInDate());
        booking.setCheckOutDate(request.checkOutDate());

        return bookingRepository.save(booking);
    }
}