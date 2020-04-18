package ua.lviv.iot.lab.writer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.lab.model.AbstractGoodsForCreativity;

public class AbstractGoodsForCreativityWriter {
  public Writer csvWriter = new StringWriter();

  public Writer getCsvWriter() {
    return csvWriter;
  }

  public void setCsvWriter(Writer csvWriter) {
    this.csvWriter = csvWriter;
  }

  public void writeToFile(List<AbstractGoodsForCreativity> goods) throws IOException {
    csvWriter.write(goods.get(0).getHeaders());
    csvWriter.write("\n");
    for (AbstractGoodsForCreativity good : goods) {
      csvWriter.write(good.toCSV());
      csvWriter.write("\n");
    }
    csvWriter.flush();
  }

  @Override
  public String toString() {
    return csvWriter.toString();
  }
}
