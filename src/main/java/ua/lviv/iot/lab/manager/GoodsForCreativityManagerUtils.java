package ua.lviv.iot.lab.manager;

import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;
import ua.lviv.iot.lab.model.SortType;

public class GoodsForCreativityManagerUtils {

  class GoodsSorterByPriceInUAH implements Comparator<AbstractGoodsForCreativity> {

    @Override
    public int compare(AbstractGoodsForCreativity firstGood, AbstractGoodsForCreativity secondGood) {
      return Double.compare(firstGood.getPriceInUAH(), secondGood.getPriceInUAH());
    }
  }

  static class GoodsSorterByMinimumAgeForUsing implements Comparator<AbstractGoodsForCreativity> {

    @Override
    public int compare(AbstractGoodsForCreativity firstGood, AbstractGoodsForCreativity secondGood) {

      return firstGood.getMinimumAgeForUsing() - secondGood.getMinimumAgeForUsing();
    }

  }

  private static final GoodsSorterByMinimumAgeForUsing GOODS_SORTER_BY_MINIMUM_AGE_FOR_USING = new GoodsSorterByMinimumAgeForUsing();

  // sort using inner class

  public static void sortGoodsByPriceInUAH(List<AbstractGoodsForCreativity> goods, SortType sortType) {
    GoodsSorterByPriceInUAH comparator = new GoodsForCreativityManagerUtils().new GoodsSorterByPriceInUAH();
    goods.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
  }

  // sort using static inner class

  public static void sortGoodsByMinimumAgeForUsing(List<AbstractGoodsForCreativity> goods, SortType sortType) {
    goods.sort(sortType == SortType.ASC ? GOODS_SORTER_BY_MINIMUM_AGE_FOR_USING
        : GOODS_SORTER_BY_MINIMUM_AGE_FOR_USING.reversed());
  }

  // sort using anonymous class

  public static void sortGoodsByName(List<AbstractGoodsForCreativity> goods, SortType sortType) {
    Comparator<AbstractGoodsForCreativity> comparator = new Comparator<AbstractGoodsForCreativity>() {

      @Override
      public int compare(AbstractGoodsForCreativity firstGood, AbstractGoodsForCreativity secondGood) {
        return firstGood.getName().compareTo(secondGood.getName());
      }
    };
    goods.sort(sortType.equals(SortType.ASC) ? comparator : comparator.reversed());
  }

}
