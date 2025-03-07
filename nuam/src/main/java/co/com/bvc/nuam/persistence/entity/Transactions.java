package co.com.bvc.nuam.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@Table(name = "transactions",schema = "nuam")
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_user")
    public User userN;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_stockexchange")
    private Stockexchange stockexchange;

    @Column(name = "amount")
    public Long amount;

    @Column(name = "dateTransaction")
    public Date dateTransaction;
    @Column(name = "typeTransaction")
    public String typeTransaction;

}
