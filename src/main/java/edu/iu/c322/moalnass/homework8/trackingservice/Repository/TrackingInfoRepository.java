package edu.iu.c322.moalnass.homework8.trackingservice.Repository;

import edu.iu.c322.moalnass.homework8.trackingservice.Model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingInfoRepository extends JpaRepository<Tracking, Long> {
    List<Tracking> findByOrderId(String orderId);
}