package com.zoraw.cinema.config.init;

import com.zoraw.cinema.model.db.mongo.ScreeningRepository;
import com.zoraw.cinema.model.db.mongo.dao.MovieDao;
import com.zoraw.cinema.model.db.mongo.dao.RoomDao;
import com.zoraw.cinema.model.db.mongo.dao.ScreeningDao;
import com.zoraw.cinema.model.db.mongo.dao.SeatDao;
import com.zoraw.cinema.util.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
@Profile("demo")
@Component
public class MongoInit implements CommandLineRunner {

    private final ScreeningRepository screeningRepository;

    @Override
    public void run(String... args) {
        create3RoomsWith3ScreeningOf3Movies();
    }

    private void create3RoomsWith3ScreeningOf3Movies() {
        String[] movies = {
                "Zażółć gęślą jaźń - w poszukiwaniu polskich liter",
                "Clean Code - the movie",
                "Film testowy nr 3"
        };
        Set<SeatDao> seatDaoArrangement = getSeats4x5();
        Random random = RandomGenerator.getRandom();

        for (String movie : movies) {
            for (int roomIndex = 1; roomIndex < 4; roomIndex++) {
                screeningRepository.save(ScreeningDao.builder()
                        .movie(MovieDao.builder()
                                .title(movie)
                                .build())
                        .time(LocalDateTime.of(2020, Month.JANUARY, getRandomDayOfMonth(random, roomIndex), 20, 0))
                        .room(RoomDao.builder()
                                .name(String.valueOf(roomIndex))
                                .seats(seatDaoArrangement)
                                .build())
                        .build());
            }
        }
        screeningRepository.save((ScreeningDao.builder()
                .movie(MovieDao.builder()
                        .title(movies[0])
                        .build())
                .time(LocalDateTime.of(2020, Month.MAY, 6, 20, 0))
                .id("testId")
                .room(RoomDao.builder()
                        .name(String.valueOf(1))
                        .seats(seatDaoArrangement)
                        .build())
                .build()));
    }

    private int getRandomDayOfMonth(Random random, int roomIndex) {
        return random.nextInt(roomIndex * 10) + 1;
    }

    private Set<SeatDao> getSeats4x5() {
        String[] rows = {"A", "B", "C", "D"};

        Set<SeatDao> seatDaos = new HashSet<>();

        for (int i = 1; i < 6; i++) {
            for (String row : rows) {
                SeatDao seatDao = SeatDao.builder()
                        .row(row)
                        .number(String.valueOf(i))
                        .available(true)
                        .build();
                if (i == 1 || i == 5) {
                    seatDao.setEdge(true);
                }
                seatDaos.add(seatDao);
            }
        }
        return seatDaos;
    }
}



