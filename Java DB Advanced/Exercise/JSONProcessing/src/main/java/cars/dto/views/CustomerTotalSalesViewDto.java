package cars.dto.views;

import cars.dto.utilities.PartPriceUtilityDto;
import cars.dto.utilities.SaleCarPartsUtilityDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class CustomerTotalSalesViewDto {

    @Expose
    @SerializedName("fullName")
    private String name;

    @Expose
    private int boughtCars;

    private Set<SaleCarPartsUtilityDto> sales;

    @Expose
    private double spentMoney;

    public CustomerTotalSalesViewDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SaleCarPartsUtilityDto> getSales() {
        return this.sales;
    }

    public void setSales(Set<SaleCarPartsUtilityDto> sales) {
        this.sales = sales;
        this.setBoughtCars(sales.size());

        double spentMoney = sales.stream().mapToDouble(x -> x.getCarParts().stream().mapToDouble(PartPriceUtilityDto::getPrice).sum()).sum();
        this.setSpentMoney(spentMoney);
    }

    public int getBoughtCars() {
        return this.boughtCars;
    }

    public void setBoughtCars(int boughtCars) {
        this.boughtCars = boughtCars;
    }

    public double getSpentMoney() {
        return this.spentMoney;
    }

    public void setSpentMoney(double spentMoney) {
        this.spentMoney = spentMoney;
    }
}
