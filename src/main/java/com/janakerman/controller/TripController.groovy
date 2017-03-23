package com.janakerman.controller

import com.fasterxml.jackson.annotation.JsonView
import com.janakerman.dto.NewOrderDTO
import com.janakerman.dto.NewTripDTO
import com.janakerman.dto.ShopDTO
import com.janakerman.dto.TripDTO
import com.janakerman.entity.DrinkOrder
import com.janakerman.entity.Trip
import com.janakerman.service.TripService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.stream.Collectors

@CrossOrigin
@RestController
class TripController {

    @Autowired
    TripService tripService



    @GetMapping(value = "/trips")
    @JsonView(TripDTO.View.Summary)
    List<TripDTO> getOpen() {
        tripService.getOpen().stream().map({ trip -> new TripDTO(trip) }).collect(Collectors.toList())
    }

    @GetMapping(value = "/trip/{id}")
    @JsonView(TripDTO.View.Summary)
    Trip get(@PathVariable Integer id) {
        tripService.get id
    }

    @GetMapping(value = "/trip?open&personId")
    @JsonView(TripDTO.View.Summary)
    List<Trip> get(@RequestParam("open") Boolean open, @RequestParam("personId") Integer personId) {
        tripService.get(personId, open)
    }

    @PostMapping(value = "/trip")
    @JsonView(TripDTO.View.Summary)
    Trip post(@RequestBody NewTripDTO newTrip) {
        tripService.create(newTrip.getBuyerId(), newTrip.getShopId())
    }

    @PostMapping(value = "/trip/{tripId}/order")
    @JsonView(TripDTO.View.Summary)
    DrinkOrder addOrder(@PathVariable Integer tripId, @RequestBody NewOrderDTO orderDto) {
        tripService.addOrder(tripId, orderDto.getItemId(), orderDto.getPersonId())
    }

}
