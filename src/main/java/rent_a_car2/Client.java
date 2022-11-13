package rent_a_car2;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column
    private long licenseId;
    @Column
    private String name;
    @Column
    private long phoneNumber;
    @Column
    private String email;

    public Client(String name, long licenseId, long phoneNumber, String email) {
        this.name = name;
        this.licenseId = licenseId;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Client(){}
}
