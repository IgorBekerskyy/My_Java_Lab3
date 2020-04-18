package ua.lviv.iot.lab.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.lab.model.Pen;

@RequestMapping("/goods")
@RestController
public class GoodsController {
  private Map<Integer, Pen> goods = new HashMap<Integer, Pen>();

  private AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<Pen> getGoods() {
    return new LinkedList<Pen>(goods.values());
  }

  @GetMapping(path = "/{id}")
  public Pen getGood(final @PathVariable("id") Integer goodId) {
    return goods.get(goodId);
  }

  @PostMapping
  public Pen createGood(final @RequestBody Pen good) {
    good.setId(idCounter.incrementAndGet());
    goods.put(good.getId(), good);
    return good;
  }

  @PutMapping(path = "{id}")
  public ResponseEntity<Pen> updateGood(final @PathVariable("id") Integer goodId, final @RequestBody Pen good) {
    if (goods.containsKey(goodId)) {
      good.setId(goodId);
      goods.put(goodId, good);
      return ResponseEntity.status(HttpStatus.OK).build();
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Pen> deleteLamp(final @PathVariable("id") Integer goodId) {
    if (goods.containsKey(goodId)) {
      goods.remove(goodId);
      return ResponseEntity.status(HttpStatus.OK).build();
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
