package bd.edu.seu.reservationservice.controller;

import bd.edu.seu.reservationservice.Exception.RecourceNotFoundException;
import bd.edu.seu.reservationservice.Exception.ResourceAlreadyExistException;
import bd.edu.seu.reservationservice.model.Reservation;
import bd.edu.seu.reservationservice.model.Room;
import bd.edu.seu.reservationservice.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> findAll()
    {
        List<Reservation> reservations = reservationService.findAll();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findReservation(@PathVariable int id)
    {
        try {
            Reservation byId = reservationService.findById(id);
            return ResponseEntity.ok(byId);
        } catch (RecourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("")
    public ResponseEntity<Reservation> updateReservation( @RequestBody Reservation reservation)
    {
        try {
            Reservation reservation1 = reservationService.updateReservation(reservation);
            return ResponseEntity.ok(reservation1);
        } catch (RecourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable int id)
    {
        try {
            Reservation reservation = reservationService.deleteReservation(id);
            return ResponseEntity.ok(reservation);
        } catch (RecourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation)
    {
        try {
            Reservation reservation1 = reservationService.CreateReservation(reservation);
            return ResponseEntity.ok(reservation1);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/between/{fromDate1}/to/{fromDate2}")
    public ResponseEntity<List<Reservation>> findReservationByFromDateBetween (@PathVariable String fromDate1, @PathVariable String fromDate2)
    {
       List<Reservation> reservationList = reservationService.findReservationByFromDateBetween(LocalDate.parse(fromDate1),LocalDate.parse(fromDate2));
       return ResponseEntity.ok(reservationList);
    }

    // TODO add necessary REST endpoints to support CRUD operations

    // TODO add necessary REST endpoint to do reservation queries for a given date ranges
}
