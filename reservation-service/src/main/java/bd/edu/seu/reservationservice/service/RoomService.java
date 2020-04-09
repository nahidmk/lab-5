package bd.edu.seu.reservationservice.service;

import bd.edu.seu.reservationservice.Exception.RecourceNotFoundException;
import bd.edu.seu.reservationservice.Exception.ResourceAlreadyExistException;
import bd.edu.seu.reservationservice.model.Room;
import bd.edu.seu.reservationservice.model.RoomType;
import bd.edu.seu.reservationservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll()
    {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    public Room findById(int id) throws RecourceNotFoundException
    {
       return roomRepository.findById(id).orElseThrow(RecourceNotFoundException::new);
    }

    public Room deleteRoom(int id) throws RecourceNotFoundException
    {
        if (roomRepository.existsById(id))
        {
            Room room= roomRepository.findById(id).get();
            roomRepository.deleteById(id);
            return room;
        }else {
            throw new RecourceNotFoundException();
        }
    }

    public Room updateRoom(Room room) throws RecourceNotFoundException
    {
        if(roomRepository.existsById(room.getId()))
        {
            roomRepository.save(room);
            return roomRepository.findById(room.getId()).get();
        }else {
            throw new RecourceNotFoundException();
        }
    }

    public Room CreateRoom(Room room) throws ResourceAlreadyExistException
    {
        if(roomRepository.existsById(room.getId()))
        {
            throw new ResourceAlreadyExistException();
        }else {
            return roomRepository.save(room);
        }
    }

    public Room findByNumber(int Number) throws RecourceNotFoundException
    {
        return roomRepository.findRoomByNumber(Number).orElseThrow(RecourceNotFoundException::new);
    }


    public List<Room> findAllByRoomType(RoomType roomType)
    {
        return roomRepository.findRoomByRoomType(roomType);
    }

    // TODO add necessary methods heres
}
