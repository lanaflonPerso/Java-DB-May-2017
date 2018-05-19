package hiberspring.dtos.views.town;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownViewDto {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private Integer population;

    @XmlAttribute(name = "town_clients")
    private BigDecimal count;

    public TownViewDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return this.population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getCount() {
        return this.count;
    }

    public void setCount(BigDecimal count) {
        if (count == null) {
            this.count = BigDecimal.ZERO;
        } else {
            this.count = count;
        }
    }
}
