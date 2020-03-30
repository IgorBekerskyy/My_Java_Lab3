package ua.lviv.iot.goodsForCreativity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.goodsForCreativity.manager.GoodsForCreativityManagerUtils;
import ua.lviv.iot.goodsForCreativity.model.SortType;


class GoodsForCreativityManagerUtilsTest extends BaseGoodsForCreativityTest {

	@Test
	public void testSortGoodsByNameDescending() {
		GoodsForCreativityManagerUtils.sortGoodsByName(goods, SortType.DESC);
		assertEquals("Parker", goods.get(0).getName());
		assertEquals("Oliver", goods.get(1).getName());
		assertEquals("Kilimok", goods.get(2).getName());
		assertEquals("Applique", goods.get(3).getName());
	}

	@Test
	public void testSortGoodsByNameAscending() {
		GoodsForCreativityManagerUtils.sortGoodsByName(goods, SortType.ASC);
		assertEquals("Applique", goods.get(0).getName());
		assertEquals("Kilimok", goods.get(1).getName());
		assertEquals("Oliver", goods.get(2).getName());
		assertEquals("Parker", goods.get(3).getName());
	}

	@Test
	public void testSortByMinimumAgeForUsingDescending() {
		GoodsForCreativityManagerUtils.sortGoodsByMinimumAgeForUsing(goods, SortType.DESC);
		assertEquals(6, goods.get(0).getMinimumAgeForUsing());
		assertEquals(5, goods.get(1).getMinimumAgeForUsing());
		assertEquals(3, goods.get(2).getMinimumAgeForUsing());
		assertEquals(1, goods.get(3).getMinimumAgeForUsing());
	}

	@Test
	public void testSortByMinimumAgeForUsingAscending() {
		GoodsForCreativityManagerUtils.sortGoodsByMinimumAgeForUsing(goods, SortType.ASC);
		assertEquals(1, goods.get(0).getMinimumAgeForUsing());
		assertEquals(3, goods.get(1).getMinimumAgeForUsing());
		assertEquals(5, goods.get(2).getMinimumAgeForUsing());
		assertEquals(6, goods.get(3).getMinimumAgeForUsing());
	}

	@Test
	public void testSortByPriceInUAHAscending() {
		GoodsForCreativityManagerUtils.sortGoodsByPriceInUAH(goods, SortType.ASC);
		assertEquals(100.60, goods.get(0).getPriceInUAH());
		assertEquals(130.7, goods.get(1).getPriceInUAH());
		assertEquals(145.50, goods.get(2).getPriceInUAH());
		assertEquals(160.50, goods.get(3).getPriceInUAH());
	}

	@Test
	public void testSortByPriceInUAHDescending() {
		GoodsForCreativityManagerUtils.sortGoodsByPriceInUAH(goods, SortType.DESC);
		assertEquals(160.50, goods.get(0).getPriceInUAH());
		assertEquals(145.50, goods.get(1).getPriceInUAH());
		assertEquals(130.7, goods.get(2).getPriceInUAH());
		assertEquals(100.60, goods.get(3).getPriceInUAH());
	}
}
