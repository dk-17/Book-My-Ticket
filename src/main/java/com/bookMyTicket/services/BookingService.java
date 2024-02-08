package com.bookMyTicket.services;

import com.bookMyTicket.dto.BookingDto;
import com.bookMyTicket.entity.BookingEntity;
import com.bookMyTicket.entity.MovieShowEntity;
import com.bookMyTicket.exception.NotFoundException;
import com.bookMyTicket.exception.SeatsNotAvailableException;
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
    public BookingEntity createBooking(BookingDto bookingDto) throws SeatsNotAvailableException, NotFoundException {
        Optional<MovieShowEntity> optionalMovieShow = movieShowRepository.findById(bookingDto.getShowId());
        if (optionalMovieShow.isPresent()) {
            MovieShowEntity movieShowEntity = optionalMovieShow.get();
            Integer availableSeats = movieShowEntity.getAvailableSeats();

            if(bookingDto.getNumberOfSeats() > availableSeats) {
                throw new SeatsNotAvailableException(availableSeats + " number of seats are not available for the show");
            }
        } else {
            throw new NotFoundException("Show is not available");
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

    public BookingEntity getBookingDetails(Long bookingId) throws NotFoundException {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        return optionalBookingEntity.orElseThrow(() -> new NotFoundException("Booking not found with id " + bookingId));
    }

    public  BookingEntity  deleteBooking(Long bookingId) throws NotFoundException {
        //TODO: validate that booking can be cancel only before show start time.
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        if (optionalBookingEntity.isPresent()) {
            BookingEntity booking = optionalBookingEntity.get();
            Long showId = booking.getShowId();
            Integer numberOfSeats = booking.getNumberOfSeats();

            bookingRepository.delete(booking);
            log.info("Booking is canceled with id {}", bookingId);

            Optional<MovieShowEntity> optionalMovieShowEntity = movieShowRepository.findById(showId);
            if (optionalMovieShowEntity.isPresent()) {
                MovieShowEntity movieShowEntity = optionalMovieShowEntity.get();
                Integer currentAvailableSeats = movieShowEntity.getAvailableSeats();
                movieShowEntity.setAvailableSeats(currentAvailableSeats + numberOfSeats);
                movieShowRepository.save(movieShowEntity);
                log.info("{} seats are now available for show {}", numberOfSeats, showId);
            } else {
                throw new NotFoundException("Movie show with id " + showId + " not found");
            }
        } else {
            throw new NotFoundException("Booking with id " + bookingId + " not found");
        }

        return optionalBookingEntity.get();
    }

}
