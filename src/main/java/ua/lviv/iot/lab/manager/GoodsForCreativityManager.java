package ua.lviv.iot.lab.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;

public class GoodsForCreativityManager {
  private List<AbstractGoodsForCreativity> goods = new LinkedList<>();

  public void addGoods(List<AbstractGoodsForCreativity> goods) {
    this.goods.addAll(goods);
  }

  public void addGood(AbstractGoodsForCreativity good) {
    this.goods.add(good);
  }

  public List<AbstractGoodsForCreativity> findByName(String name) {

    List<AbstractGoodsForCreativity> result = new LinkedList<>();

    for (AbstractGoodsForCreativity good : goods) {

      if (good.getName() == name) {

        result.add(good);
      }
    }
    return result;
  }

  public List<AbstractGoodsForCreativity> findByMinimumAgeForUsing(int minimumAgeForUsing) {

    List<AbstractGoodsForCreativity> result = new LinkedList<>();

    for (AbstractGoodsForCreativity good : goods) {

      if (good.getMinimumAgeForUsing() == minimumAgeForUsing) {

        result.add(good);
      }
    }
    return result;
  }

  public List<AbstractGoodsForCreativity> findByPriceInUAH(double priceInUAH) {

    List<AbstractGoodsForCreativity> result = new LinkedList<>();

    for (AbstractGoodsForCreativity good : goods) {

      if (good.getPriceInUAH() == priceInUAH) {

        result.add(good);
      }
    }
    return result;

  }
}
