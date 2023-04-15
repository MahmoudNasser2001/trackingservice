package edu.iu.c322.moalnass.homework8.trackingservice.Controller;

import edu.iu.c322.moalnass.homework8.trackingservice.Model.Tracking;
import edu.iu.c322.moalnass.homework8.trackingservice.Repository.TrackingInfoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/trackings")
public class TrackingController {
    private TrackingInfoRepository repository;

    public TrackingController(TrackingInfoRepository repository) {
        this.repository = repository;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{orderId}")
    public void update(@RequestBody Tracking tracking, @PathVariable int orderId){
        tracking.setOrderId(orderId);
        tracking.setDate(new Date());
        repository.save(tracking);
    }
}
