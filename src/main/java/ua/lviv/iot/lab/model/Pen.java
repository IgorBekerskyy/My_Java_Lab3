package ua.lviv.iot.lab.model;

import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;
import ua.lviv.iot.lab.model.KindOfProduct;
import javax.persistence.Entity;

@Entity
public class Pen extends AbstractGoodsForCreativity {
  public Pen(String name, KindOfProduct kind, double priceInUAH, String countryOfProducing, int minimumAgeForUsing) {
    super(name, kind, priceInUAH, countryOfProducing, minimumAgeForUsing);
  }

  public Pen() {

  }
}