package com.roomac.lil.leaning_spring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
