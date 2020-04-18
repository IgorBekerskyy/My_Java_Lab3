package ua.lviv.iot.lab.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.lab.manager.GoodsForCreativityManager;
import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;

class GoodsForCreativityManagerTest extends BaseGoodsForCreativityTest {

  public GoodsForCreativityManager goodsForCreativityManager;

  @BeforeEach
  public void setUp() {
    goodsForCreativityManager = new GoodsForCreativityManager();
    goodsForCreativityManager.addGoods(goods);
  }

  @Test
  public void testFindByMinimumAgeForUsing() {
    List<AbstractGoodsForCreativity> result = goodsForCreativityManager.findByMinimumAgeForUsing(3);
    assertEquals(1, result.size());

    assertEquals(3, goods.get(0).getMinimumAgeForUsing());

  }

  @Test
  public void testFindByPriceInUAH() {
    List<AbstractGoodsForCreativity> result = goodsForCreativityManager.findByPriceInUAH(100.60);
    assertEquals(1, result.size());

    assertEquals(100.60, goods.get(0).getPriceInUAH());
  }

}
