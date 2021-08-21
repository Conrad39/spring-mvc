package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.DaoCar;
import web.model.Car;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private final DaoCar daoCar;

    public CarServiceImpl(DaoCar daoCar) {
        this.daoCar = daoCar;
    }

    @Override
    public List<Car> readCars(Integer count) {
        return daoCar.readCars(count);
    }
}