package edu.iu.c322.moalnass.homework8.trackingservice.Controller;

import edu.iu.c322.moalnass.homework8.trackingservice.Model.Tracking;
import edu.iu.c322.moalnass.homework8.trackingservice.Repository.TrackingInfoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/trackings")
public class TrackingController {
    private TrackingInfoRepository repository;

    public TrackingController(TrackingInfoRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/{orderId}/{itemId}")
    public List<Tracking> find(@PathVariable int orderId,
                               @PathVariable int itemId){
        return repository.findByOrderIdAndItemId(orderId, itemId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{orderId}")
    public void update(@RequestBody Tracking tracking, @PathVariable int orderId){
        tracking.setOrderId(orderId);
        tracking.setDate(new Date());
        repository.save(tracking);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{orderId}")
    public long create(@RequestBody Tracking tracking, @PathVariable int orderId){
        tracking.setOrderId(orderId);
        tracking.setDate(new Date());
        Tracking addedTracking = repository.save(tracking);
        return addedTracking.getId();
    }
}
