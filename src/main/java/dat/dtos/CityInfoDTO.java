package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//JsonIgnoreP ignorer alle de "properties" den ikke kender og derved kan man "vælge" hva man vil ha.


// bruger "https://api.dataforsyningen.dk/kommuner/0265" til city

public class CityInfoDTO {

    @JsonSetter("navn") // kig i Jason og se va navnet er sat til
    private String name;

    @JsonSetter("code")
    private int code;

    @Override
    public String toString() {
        return String.format(
                "City Info:\n" +
                        " - Name: %s\n" +
                        " - Code: %d",
                name, code
        );
    }
}
