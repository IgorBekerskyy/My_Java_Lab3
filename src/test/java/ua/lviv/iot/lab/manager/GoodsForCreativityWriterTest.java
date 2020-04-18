package ua.lviv.iot.lab.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;
import ua.lviv.iot.lab.writer.AbstractGoodsForCreativityWriter;

public class GoodsForCreativityWriterTest extends BaseGoodsForCreativityTest {

  AbstractGoodsForCreativityWriter abstractGoodsForCreativityWriter = new AbstractGoodsForCreativityWriter();

  @Test
  void writeToFileTest() throws IOException {
    Writer csvWriter = new FileWriter("Goods.csv");
    abstractGoodsForCreativityWriter.setCsvWriter(csvWriter);
    abstractGoodsForCreativityWriter.writeToFile(goods);
  }

  @Test
  void stringWriterTest() throws IOException {
    StringBuilder expected = new StringBuilder();
    abstractGoodsForCreativityWriter.setCsvWriter(new StringWriter());
    abstractGoodsForCreativityWriter.writeToFile(goods);
    expected.append(goods.get(0).getHeaders());
    expected.append("\n");
    for (AbstractGoodsForCreativity good : goods) {
      expected.append(good.toCSV());
      expected.append("\n");
    }
    assertEquals(expected.toString(), abstractGoodsForCreativityWriter.toString());

  }
}