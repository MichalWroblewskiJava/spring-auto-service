package pl.sda.javagdy2.spring.autoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Fault fault;

    private String car_plate;

    private boolean paid;

    @CreationTimestamp
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public CustomerOrder(Fault fault, String car_plate, boolean paid) {
        this.fault = fault;
        this.car_plate = car_plate;
        this.paid = paid;
    }
}
