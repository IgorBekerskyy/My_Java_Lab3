package ua.lviv.iot.goodsForCreativity.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.goodsForCreativity.model.AbstractGoodsForCreativity;

public class AbstractGoodsForCreativityWriter {

  private Writer textWriter;

  public void setTextWriter(Writer textWriter) {
    this.textWriter = textWriter;
  }

  public void writeToFile(List<AbstractGoodsForCreativity> goods) throws IOException {

    for (AbstractGoodsForCreativity good : goods) {
      textWriter.write(good.getHeaders());
      textWriter.write("\r\n");
      textWriter.write(good.toCSV());
      textWriter.write("\r\n");

    }
    textWriter.flush();
    textWriter.close();
  }

  @Override
  public String toString() {
    return textWriter.toString();
  }
}
