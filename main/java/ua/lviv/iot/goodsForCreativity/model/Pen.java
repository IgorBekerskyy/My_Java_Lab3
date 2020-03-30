package ua.lviv.iot.goodsForCreativity.model;

public class Pen extends AbstractGoodsForCreativity {
  public Pen(String name, KindOfProduct kind, double priceInUAH, String countryOfProducing, int minimumAgeForUsing) {
    super(name, kind, priceInUAH, countryOfProducing, minimumAgeForUsing);
  }
}