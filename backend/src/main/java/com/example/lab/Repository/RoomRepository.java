package com.example.lab.Repository;

import com.example.lab.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByroomNumber(String roomNumber);
}
