package ua.lviv.iot.lab.manager;

import java.util.LinkedList;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;
import ua.lviv.iot.lab.model.KindOfProduct;
import ua.lviv.iot.lab.model.Mosaics;
import ua.lviv.iot.lab.model.PaperForApplique;
import ua.lviv.iot.lab.model.Pen;
import ua.lviv.iot.lab.model.Pencil;

public abstract class BaseGoodsForCreativityTest {

  protected List<AbstractGoodsForCreativity> goods;

  @BeforeEach
  public void createGoods() {

    goods = new LinkedList<AbstractGoodsForCreativity>();

    goods.add(new Pencil("Oliver", KindOfProduct.GOODS_FOR_DRAWING, 100.60, "Germany", 3));
    goods.add(new Mosaics("Kilimok", KindOfProduct.GOODS_FOR_MOSAICS, 130.7, "Japan", 6));
    goods.add(new PaperForApplique("Applique", KindOfProduct.GOODS_FOR_APPLIQUE, 145.50, "France", 1));
    goods.add(new Pen("Parker", KindOfProduct.GOODS_FOR_DRAWING, 160.50, "Columbia", 5));
  }
}
