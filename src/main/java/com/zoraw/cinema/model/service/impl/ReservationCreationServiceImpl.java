package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.db.mongo.ReservationRepository;
import com.zoraw.cinema.model.db.mongo.ScreeningRepository;
import com.zoraw.cinema.model.db.mongo.dao.ScreeningDao;
import com.zoraw.cinema.model.db.mongo.mapper.ReservationDaoMapper;
import com.zoraw.cinema.model.db.mongo.mapper.ScreeningDaoMapper;
import com.zoraw.cinema.model.domain.Reservation;
import com.zoraw.cinema.model.domain.Screening;
import com.zoraw.cinema.model.domain.Seat;
import com.zoraw.cinema.model.exception.ScreeningNotFoundException;
import com.zoraw.cinema.model.service.ReservationCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ReservationCreationServiceImpl implements ReservationCreationService {

    private final ScreeningRepository screeningRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationDaoMapper reservationDaoMapper;
    private final ScreeningDaoMapper screeningDaoMapper;

    @Override
    public boolean create(Reservation reservation) {

        ScreeningDao screeningDao = getScreening(reservation.getScreeningId());
        Screening screening = screeningDaoMapper.toScreening(screeningDao);

        Set<Seat> seatsToReserve = reservation.getSeats();
        if (screening.getRoom().canReserveSeats(seatsToReserve)) {
            updateSeats(screening, seatsToReserve);

            try {
                screeningRepository.save(getUpdatedScreening(screening, screeningDao.getVersion()));
            } catch (OptimisticLockingFailureException ex) {
                this.create(reservation);
            }
            reservationRepository.save(reservationDaoMapper.toReservationDao(reservation));
            return true;
        }

        return false;
    }

    private ScreeningDao getUpdatedScreening(Screening screening, Long version) {
        ScreeningDao screeningDaoAfterUpdate = screeningDaoMapper.toScreeningDao(screening);
        screeningDaoAfterUpdate.setVersion(version);
        return screeningDaoAfterUpdate;
    }

    private void updateSeats(Screening screening, Set<Seat> seatsToReserve) {
        screening.getRoom().getSeats()
                .stream()
                .filter(seatsToReserve::contains)
                .forEach(seat -> seat.setAvailable(false));
    }

    private ScreeningDao getScreening(String screeningId) {
        return screeningRepository.findById(screeningId)
                .orElseThrow(() -> new ScreeningNotFoundException(screeningId));

    }
}
