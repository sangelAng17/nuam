package co.com.bvc.nuam.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Data
@Table(name = "userN",schema = "nuam")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;

    @Column(name = "firstName")
    public String firstName;

    @Column(name = "secondName")
    public String secondName;

    @Column(name = "typeDocument")
    public String typeDocument;

    @Column(name = "document")
    public String document;

    public User() {

    }
}
