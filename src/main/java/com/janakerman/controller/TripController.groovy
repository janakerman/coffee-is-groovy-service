package com.janakerman.controller

import com.janakerman.dto.NewOrderDTO
import com.janakerman.dto.NewTripDTO
import com.janakerman.dto.OpenTripDTO
import com.janakerman.entity.DrinkOrder
import com.janakerman.entity.Trip
import com.janakerman.service.TripService
import org.omg.CORBA.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.sql.Timestamp
import java.util.stream.Collectors

@CrossOrigin
@RestController
class TripController {

    @Autowired
    TripService tripService

    @RequestMapping(value = "/trip", method = RequestMethod.POST)
    Trip post(@RequestBody NewTripDTO newTrip) {
        tripService.create(newTrip.getBuyerId(), newTrip.getShopId())
    }

    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    List<OpenTripDTO> getOpen() {
        tripService.getOpen().stream().map({ trip -> new OpenTripDTO(
                id: trip.getId(),
                buyer: trip.getBuyer(),
                shop: trip.getShop(),
                time: Timestamp.valueOf(trip.getTime())
        )}).collect(Collectors.toList())
    }

    @RequestMapping(value = "/trip/{id}", method = RequestMethod.GET)
    Trip get(@PathVariable Integer id) {
        tripService.get id
    }

    @RequestMapping(value = "/trip?open&personId", method = RequestMethod.GET)
    List<Trip> get(@RequestParam("open") Boolean open, @RequestParam("personId") Integer personId) {
        tripService.get(personId, open)
    }

    @RequestMapping(value = "/trip/{tripId}/order")
    DrinkOrder addOrder(@PathVariable Integer tripId, @RequestBody NewOrderDTO orderDto) {
        tripService.addOrder(tripId, orderDto.getItemId(), orderDto.getPersonId())
    }

}
