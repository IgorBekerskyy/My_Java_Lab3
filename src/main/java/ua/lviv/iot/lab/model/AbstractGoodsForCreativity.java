package ua.lviv.iot.lab.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import ua.lviv.iot.lab.model.KindOfProduct;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractGoodsForCreativity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private KindOfProduct kind;
  private double priceInUAH;
  private String countryOfProducing;
  private int minimumAgeForUsing;

  public AbstractGoodsForCreativity(String name, KindOfProduct kind, double priceInUAH, String countryOfProducing,
      int minimumAgeForUsing) {
    super();
    this.name = name;
    this.kind = kind;
    this.priceInUAH = priceInUAH;
    this.countryOfProducing = countryOfProducing;
    this.minimumAgeForUsing = minimumAgeForUsing;
  }

  public String getHeaders() {
    return "name," + "kind," + "priceInUAH," + "countryOfProducing," + "minimumAgeForUsing";

  }

  public String toCSV() {
    return getName() + "," + getKind() + "," + getPriceInUAH() + "," + getCountryOfProducing() + ","
        + getMinimumAgeForUsing();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public KindOfProduct getKind() {
    return kind;
  }

  public void setKind(KindOfProduct kind) {
    this.kind = kind;
  }

  public double getPriceInUAH() {
    return priceInUAH;
  }

  public void setPriceInUAH(double priceInUAH) {
    this.priceInUAH = priceInUAH;
  }

  public String getCountryOfProducing() {
    return countryOfProducing;
  }

  public void setCountryOfProducing(String countryOfProducing) {
    this.countryOfProducing = countryOfProducing;
  }

  public int getMinimumAgeForUsing() {
    return minimumAgeForUsing;
  }

  public void setMinimumAgeForUsing(int minimumAgeForUsing) {
    this.minimumAgeForUsing = minimumAgeForUsing;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AbstractGoodsForCreativity() {
    super();
  }

}
