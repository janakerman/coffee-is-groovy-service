package com.janakerman.service

import com.janakerman.entity.DrinkOrder
import com.janakerman.entity.Item
import com.janakerman.entity.Trip
import com.janakerman.repository.ItemRepository
import com.janakerman.repository.OrderRepository
import com.janakerman.repository.PersonRepository
import com.janakerman.repository.ShopRepository
import com.janakerman.repository.TripRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.time.LocalDateTime

/**
 * Created by jakerman on 16/03/2017.
 */
@Service
class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository
    @Autowired
    private ItemRepository itemRepository
    @Autowired
    private PersonRepository personRepository
    @Autowired
    private ShopRepository shopRepository
    @Autowired
    private OrderRepository orderRepository

    @Override
    @Transactional
    Trip create(Integer buyerId, Integer shopId) {
        def buyer = personRepository.getOne(buyerId)
        def shop = shopRepository.getOne(shopId)

        if (!buyer || !shop) {
            // TODO: Throw an error!
        }

        // Create a time in the future for now.
        LocalDateTime time = LocalDateTime.now().plusHours(2)

        def trip = new Trip(buyer: buyer, shop: shop, time: time)
        tripRepository.saveAndFlush(trip)
    }

    @Override
    @Transactional
    Trip get(Integer tripId) { tripRepository.findOne tripId }

    @Override
    @Transactional
    List<Trip> get(Boolean open) { tripRepository.get open }

    @Override
    @Transactional
    List<Trip> get(Integer personId, Boolean open) { tripRepository.get(personId, open) }

    @Override
    @Transactional
    DrinkOrder addOrder(Integer tripId, Integer itemId, Integer personId) {
        def trip = tripRepository.getOne tripId
        def item = itemRepository.getOne itemId
        def person = personRepository.getOne personId

        def order = new DrinkOrder(item: item, person: person, trip: trip)
        trip.addOrder(order)

        tripRepository.saveAndFlush(trip)
        return order // TODO: Work out why returned order id is null here?
    }
}
