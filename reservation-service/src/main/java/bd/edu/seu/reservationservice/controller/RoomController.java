package bd.edu.seu.reservationservice.controller;

import bd.edu.seu.reservationservice.Exception.RecourceNotFoundException;
import bd.edu.seu.reservationservice.Exception.ResourceAlreadyExistException;
import bd.edu.seu.reservationservice.model.Room;
import bd.edu.seu.reservationservice.model.RoomType;
import bd.edu.seu.reservationservice.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("")
    public ResponseEntity<List<Room>> findAll()
    {
        List<Room> rooms = roomService.findAll();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findRoom(@PathVariable int id)
    {
        try {
            Room byId = roomService.findById(id);
            return ResponseEntity.ok(byId);
        } catch (RecourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("")
    public ResponseEntity<Room> updateRoom( @RequestBody Room room)
    {
        try {
            Room room1 = roomService.updateRoom(room);
            return ResponseEntity.ok(room1);
        } catch (RecourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable int id)
    {
        try {
            Room room = roomService.deleteRoom(id);
            return ResponseEntity.ok(room);
        } catch (RecourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Room> createRoom(@RequestBody Room room)
    {
        try {
            Room room1 = roomService.CreateRoom(room);
            return ResponseEntity.ok(room1);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/room-Number/{number}")
    public ResponseEntity<Room> findByNumber(@PathVariable int number)
    {
        try {
            Room byNumber = roomService.findByNumber(number);
            return ResponseEntity.ok(byNumber);
        } catch (RecourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/room-type/{roomType}")
    public ResponseEntity<List<Room>> findByRoomType(@PathVariable RoomType roomType)
    {
        List<Room> allByRoomType = roomService.findAllByRoomType(roomType);
        return ResponseEntity.ok(allByRoomType);
    }

    // TODO add necessary REST endpoints to support CRUD operations

    // TODO add necessary REST endpoints for RoomType based query
}
