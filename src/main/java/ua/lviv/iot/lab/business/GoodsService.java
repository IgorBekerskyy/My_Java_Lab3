package ua.lviv.iot.lab.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab.dataaccess.GoodsRepository;
import ua.lviv.iot.lab.model.Pen;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Pen createGood(Pen pen) {
        return goodsRepository.save(pen);
    }

    public void deleteGood(Integer goodId) {
        goodsRepository.deleteById(goodId);
    }

    public Pen updateGood(Integer goodId, Pen pen) {
        pen.setId(goodId);
        return goodsRepository.save(pen);
    }

    public boolean goodExists(Integer goodId) {
        return goodsRepository.existsById(goodId);
    }

    public Pen findGoodById(Integer goodId) {
        return goodsRepository.findById(goodId).get();
    }

    public List<Pen> findAll() {
        return goodsRepository.findAll();
    }
}