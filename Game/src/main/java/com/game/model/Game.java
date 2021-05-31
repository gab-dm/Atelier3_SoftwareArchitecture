package com.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int roomId;

    public Game() { }

        public Game( int roomId) {
            this.roomId = roomId;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }



        @Override
        public String toString() {
            return "Game ["+this.id+"]";
        }

    }
