package cars.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class PartViewDto {

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("Price")
    private BigDecimal price;

    public PartViewDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
