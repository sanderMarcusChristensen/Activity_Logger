package dat.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder

public class CityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private int code;


    public CityInfo(Long id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }


    public CityInfo() {

    }
}
