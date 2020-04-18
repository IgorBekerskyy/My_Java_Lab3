package ua.lviv.iot.lab.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.lab.model.Pen;

@Repository
public interface GoodsRepository extends JpaRepository<Pen, Integer> {

}