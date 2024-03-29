package com.bookMyTicket.controller;

import com.bookMyTicket.dto.BookingDto;
import com.bookMyTicket.entity.BookingEntity;
import com.bookMyTicket.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<BookingEntity> createBooking(
            @RequestBody BookingDto bookingDto){
        BookingEntity booking = bookingService.createBooking(bookingDto);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingEntity> getBookingDetails(
            @PathVariable Long bookingId){
        BookingEntity booking = bookingService.getBookingDetails(bookingId);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<BookingEntity> deleteBooking(
            @PathVariable Long bookingId){
        BookingEntity bookginDetails = bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok(bookginDetails);
    }
}
