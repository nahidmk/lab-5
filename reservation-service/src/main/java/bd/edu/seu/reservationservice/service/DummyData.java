package bd.edu.seu.reservationservice.service;

import bd.edu.seu.reservationservice.Exception.ResourceAlreadyExistException;
import bd.edu.seu.reservationservice.model.Reservation;
import bd.edu.seu.reservationservice.model.Room;
import bd.edu.seu.reservationservice.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DummyData {
    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    public void saveData() throws ResourceAlreadyExistException {
        Room room1 = new Room(1,101, RoomType.SUIT);
        Room room2 = new Room(2,102, RoomType.DOUBLE);
        Room room3 = new Room(3,103, RoomType.SINGLE);
        Room room4 = new Room(4,104, RoomType.SUIT);

        roomService.CreateRoom(room1);
        roomService.CreateRoom(room2);
        roomService.CreateRoom(room3);
        roomService.CreateRoom(room4);

        List<Room> rooms1 = Arrays.asList(room1,room2);
        List<Room> rooms2 = Arrays.asList(room3);
        List<Room> rooms3 = Arrays.asList(room4);

        Reservation reservation = new Reservation(110,"Nahid", LocalDate.of(2019,04,23),LocalDate.of(2019,04,27),rooms3);
        Reservation reservation1 = new Reservation(210,"juwel", LocalDate.of(2019,03,24),LocalDate.of(2019,04,26),rooms2);
        Reservation reservation2 = new Reservation(310,"joniyed", LocalDate.of(2019,04,13),LocalDate.of(2019,05,5),rooms1);

        reservationService.CreateReservation(reservation);
        reservationService.CreateReservation(reservation1);
        reservationService.CreateReservation(reservation2);
    }

}
