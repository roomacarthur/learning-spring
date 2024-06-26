package com.roomac.lil.leaning_spring.webservice;

import com.roomac.lil.leaning_spring.business.ReservationService;
import com.roomac.lil.leaning_spring.business.RoomReservation;
import com.roomac.lil.leaning_spring.data.Guest;
import com.roomac.lil.leaning_spring.data.Room;
import com.roomac.lil.leaning_spring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class webServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public webServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method= RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date", required=false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests(){
        return this.reservationService.getHotelGuests();
    }
    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest){
        this.reservationService.addGuest(guest);
    }
    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }


}
