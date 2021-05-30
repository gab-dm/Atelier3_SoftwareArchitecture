package com.room.repository;

import com.room.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    public List<Room> findByName(String name);
    public Room findById(int id);

}