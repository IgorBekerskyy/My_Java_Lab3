package ua.lviv.iot.goodsForCreativity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.goodsForCreativity.model.AbstractGoodsForCreativity;
import ua.lviv.iot.goodsForCreativity.writer.AbstractGoodsForCreativityWriter;

public class GoodsForCreativityWriterTest extends BaseGoodsForCreativityTest {

  File file = new File("goodsFile.csv");
  AbstractGoodsForCreativityWriter abstractGoodsForCreativityWriter = new AbstractGoodsForCreativityWriter();

  @Test
  void WriteToFileTest() throws IOException {
    abstractGoodsForCreativityWriter.setTextWriter(new FileWriter("goodFile.csv"));
    abstractGoodsForCreativityWriter.writeToFile(goods);
  }

  @Test
  void StringWriterTest() throws IOException {
    String expectedResult = "";

    abstractGoodsForCreativityWriter.setTextWriter(new StringWriter());
    abstractGoodsForCreativityWriter.writeToFile(goods);

    for (AbstractGoodsForCreativity good : goods) {
      expectedResult += good.getHeaders() + "\r\n" + good.toCSV() + "\r\n";
    }
    assertEquals(expectedResult, abstractGoodsForCreativityWriter.toString());
  }

}