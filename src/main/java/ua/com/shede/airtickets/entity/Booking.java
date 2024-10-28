package ua.com.shede.airtickets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private Long id;
    private LocalDate bookingDate;
    private String paymentStatus;
    private Long flightsId;
    private Long passengersId;
}
