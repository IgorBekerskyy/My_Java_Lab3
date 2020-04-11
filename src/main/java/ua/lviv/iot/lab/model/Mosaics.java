package ua.lviv.iot.lab.model;

import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;
import ua.lviv.iot.lab.model.KindOfProduct;

public class Mosaics extends AbstractGoodsForCreativity {
  public Mosaics(String name, KindOfProduct kind, double priceInUAH, String countryOfProducing,
      int minimumAgeForUsing) {
    super(name, kind, priceInUAH, countryOfProducing, minimumAgeForUsing);
  }
}
