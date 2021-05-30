package com.room.restcontroler;


import com.room.model.Room;
import com.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomRestControler {

    @Autowired
    private RoomService roomService;



    @GetMapping(value = "/{id}")
    private Room getRoom(@PathVariable int id, HttpServletResponse response) {
        Room room = roomService.getRoom(id);
        if (room == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return room;
    }


    @PutMapping(value="/{id}")
    public void updateRoom(@RequestBody Room room,@PathVariable int id) {
        room.setId(id);
        roomService.updateRoom(room);
    }


    @DeleteMapping(value="/{id}")
    public void deleteRoom(@PathVariable int id) {
        roomService.deleteRoom(id);
    }




}
