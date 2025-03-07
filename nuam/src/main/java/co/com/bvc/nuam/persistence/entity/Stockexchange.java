package co.com.bvc.nuam.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@Table(name = "stockexchange",schema = "nuam")
@AllArgsConstructor
@NoArgsConstructor
public class Stockexchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "idcompany")
    public Company company;

    @Column(name = "stock")
    public Long stock;

    @Column(name = "prices")
    public String prices;

    @Column(name = "available")
    public Long available;

    @Column(name = "currency")
    public String currency;

}
