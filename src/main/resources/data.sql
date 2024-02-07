--SELECT * FROM CITIES
--DELETE FROM cities;

INSERT INTO cities (id, name, state) VALUES (1, 'City1', 'State1');
INSERT INTO cities (id, name, state) VALUES (2, 'City12', 'State1');
INSERT INTO cities (id, name, state) VALUES (3, 'City2', 'State2');




--SELECT * FROM THEATRES
--DELETE FROM THEATRES;

INSERT INTO theatres (id, name, city_id, address, number_of_screen)
VALUES
    (1, 'Theatre 1', 1, 'Address 1', 3),
    (2, 'Theatre 2', 1, 'Address 2', 2),
    (3, 'Theatre 3', 2, 'Address 3', 10);



--SELECT * FROM SCREENS
--DELETE FROM SCREENS;
INSERT INTO screens (id, theatre_id, number_of_seats)
VALUES
(1, 1, 100),
(2, 1, 120),
(3, 2, 150),
(4, 2, 140),
(5, 3, 110);


--SELECT * FROM MOVIES
--DELETE FROM MOVIES;
INSERT INTO movies (id, name, description, duration, release_date, languages)
VALUES (1, 'Movie 1', 'Description of Movie 1', 120, '2023-01-01', ARRAY['English', 'French']),
       (2, 'Movie 2', 'Description of Movie 2', 150, '2023-02-15', ARRAY['English', 'Spanish']),
       (3, 'Movie 3', 'Description of Movie 3', 130, '2023-03-30', ARRAY['English']);





--SELECT * FROM MOVIE_SHOW
--DELETE FROM MOVIE_SHOW
INSERT INTO movie_show (id, movie_id, screen_id, theatre_id, available_seats, created_on, start_time, end_time)
VALUES
    (1, 1, 1, 1, 100, '2024-01-01', '2024-01-01 10:00:00', '2024-01-01 12:00:00'),
    (2, 2, 2, 1, 120, '2024-01-02', '2024-01-02 10:00:00', '2024-01-02 12:00:00'),
    (3, 3, 3, 2, 80, '2024-01-03', '2024-01-03 10:00:00', '2024-01-03 12:00:00');



