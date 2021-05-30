package com.room.repository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	
	public List<Room> findByName(String name);

}
