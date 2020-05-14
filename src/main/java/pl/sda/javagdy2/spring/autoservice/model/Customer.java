package pl.sda.javagdy2.spring.autoservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Customer")

public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Integer cars_qty;
    private boolean tips;
    private Integer rate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private Set<CustomerOrder> customerOrderList;
}
