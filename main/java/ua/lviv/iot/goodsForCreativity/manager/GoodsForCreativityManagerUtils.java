package ua.lviv.iot.goodsForCreativity.manager;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.goodsForCreativity.model.AbstractGoodsForCreativity;
import ua.lviv.iot.goodsForCreativity.model.SortType;

public class GoodsForCreativityManagerUtils {

	private static final MinimumAgeForUsingComparator MINIMUM_AGE_FOR_USING_COMPARATOR = new MinimumAgeForUsingComparator();

	public static void sortGoodsByMinimumAgeForUsing (List<AbstractGoodsForCreativity> goods , SortType sortType) {
		goods.sort(sortType == SortType.ASC ? MINIMUM_AGE_FOR_USING_COMPARATOR : MINIMUM_AGE_FOR_USING_COMPARATOR.reversed());
	}

	// sorting by static inner class
	public static class MinimumAgeForUsingComparator implements Comparator<AbstractGoodsForCreativity> {

		@Override
		public int compare(AbstractGoodsForCreativity firstGood, AbstractGoodsForCreativity secondGood) {
			if (firstGood.getMinimumAgeForUsing() > secondGood.getMinimumAgeForUsing()) {
				return 1;
			} else if (firstGood.getMinimumAgeForUsing() < secondGood.getMinimumAgeForUsing()) {
				return -1;
			}
			return 0;
		}
	}

	public static void sortGoodsByPriceInUAH( List<AbstractGoodsForCreativity> goods, SortType sortType,
			Comparator<AbstractGoodsForCreativity> priceInUAHComparator) {

		goods.sort(sortType == SortType.ASC ? priceInUAHComparator : priceInUAHComparator.reversed());
	}

	// sorting by inner class
	public class PriceInUAHComparator implements Comparator<AbstractGoodsForCreativity> {

		@Override
		public int compare( AbstractGoodsForCreativity firstGood, AbstractGoodsForCreativity secondGood) {
			if (firstGood.getPriceInUAH() > secondGood.getPriceInUAH()) {
				return 1;
			} else if (firstGood.getPriceInUAH() < secondGood.getPriceInUAH()) {
				return -1;
			}
			return 0;
		}
	}

	// sort using anonymous class

	public static void sortGoodsByName(List<AbstractGoodsForCreativity> goods, SortType sortType) {
		Comparator<AbstractGoodsForCreativity> comparator = new Comparator<AbstractGoodsForCreativity>() {

			@Override
			public int compare(AbstractGoodsForCreativity firstGood, AbstractGoodsForCreativity secondGood) {
				return firstGood.getName().compareTo(secondGood.getName());
			}
		};
		goods.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
	}

}