package com.bookMyTicket.services;

import com.bookMyTicket.dto.BookingDto;
import com.bookMyTicket.entity.BookingEntity;
import com.bookMyTicket.entity.MovieShowEntity;
import com.bookMyTicket.repository.BookingRepository;
import com.bookMyTicket.repository.MovieShowRepository;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private MovieService movieService;

    @Transactional
    @Synchronized
    public BookingEntity createBooking(BookingDto bookingDto) {
        // validate the seats are available or not,
        Optional<MovieShowEntity> optionalMovieShow = movieShowRepository.findById(bookingDto.getShowId());
        if (optionalMovieShow.isPresent()) {
            MovieShowEntity movieShowEntity = optionalMovieShow.get();
            Integer availableSeats = movieShowEntity.getAvailableSeats();

            if(bookingDto.getNumberOfSeats() > availableSeats) {
                //throw exception as seats are full;
                log.error("{} number of seats are not available", availableSeats);
            }
            // Use the availableSeats value as needed
        } else {
            //TODO: throw exception
            log.error("Show is not available with id");
        }

        BookingEntity booking = new BookingEntity();
        booking.setShowId(bookingDto.getShowId());
        booking.setNumberOfSeats(bookingDto.getNumberOfSeats());
        booking.setCreatedOn(bookingDto.getCreatedOn());
        booking.setUserId(bookingDto.getUserId());

        bookingRepository.save(booking);

        movieService.updateAvailableSeats(bookingDto.getShowId(), booking.getNumberOfSeats());

        return booking;

    }

    public Optional<BookingEntity> getBookingDetails(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public Long deleteBooking(Long bookingId) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        if (optionalBookingEntity.isPresent()) {
            BookingEntity booking = optionalBookingEntity.get();
            bookingRepository.delete(booking);
            log.info("Booking is canceled with id {}", bookingId);
        } else {
            //TODO: throw exception
            log.error("booking with this id {} is not present", bookingId);
        }

        return bookingId;

    }
}
