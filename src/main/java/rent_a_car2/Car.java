package rent_a_car2;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String model;
    @Column
    private String engineType;
    @Column
    private String gearbox;
    @Column
    private double price;

    @Enumerated(EnumType.STRING)
    private ClientService clientService;

    public Car(String name, String type, String model, String engineType, String gearbox, double price, ClientService clientService) {
        this.name = name;
        this.type = type;
        this.model = model;
        this.engineType = engineType;
        this.gearbox = gearbox;
        this.price = price;
        this.clientService = clientService;
    }
    public Car(){

    }
}
