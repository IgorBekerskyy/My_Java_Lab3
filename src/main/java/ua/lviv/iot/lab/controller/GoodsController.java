package ua.lviv.iot.lab.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import ua.lviv.iot.lab.business.GoodsService;
import ua.lviv.iot.lab.model.Pen;

@RequestMapping("/lamps")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public List<Pen> getGoods() {
        return goodsService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Pen getGood(final @PathVariable("id") Integer goodId) {
        return goodsService.findGoodById(goodId);
    }

    @PostMapping
    public Pen createGood(final @RequestBody Pen good) {
        System.out.println(goodsService.createGood(good));
        return good;
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Pen> updateGood(final @PathVariable("id") Integer goodId,
            final @RequestBody Pen good) {
        if (goodsService.goodExists(goodId)) {
            goodsService.updateGood(goodId, good);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Pen> deleteGood(final @PathVariable("id") Integer goodId) {
        if (goodsService.goodExists(goodId)) {
            goodsService.deleteGood(goodId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}