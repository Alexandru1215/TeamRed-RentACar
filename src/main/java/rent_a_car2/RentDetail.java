package rent_a_car2;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="rent_detail")
public class RentDetail {
    @Id
    private int id;

    @Column
    private String startDate;
    @Column
    private String endDate;
    @Column
    private String pickUpLocation;

    public RentDetail(String startDate, String endDate, String pickUpLocation, double price)  {
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickUpLocation=pickUpLocation;

    }

    public RentDetail(String startDate, String endDate, String pickUpLocation) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickUpLocation = pickUpLocation;
    }
    public RentDetail(){}
}
