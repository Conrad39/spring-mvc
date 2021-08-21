package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoCarImpl implements DaoCar {

    private final List<Car> list;
    {
        list = new ArrayList<>();
        list.add(new Car("VW", 111, "yellow"));
        list.add(new Car("KIA", 222, "green"));
        list.add(new Car("Chevrolet", 333, "red"));
        list.add(new Car("Opel", 444, "white"));
        list.add(new Car("Mercedes", 555, "black"));
    };

    public List<Car> getList() {
        return list;
    }

    @Override
    public List<Car> readCars(Integer count) {
        List<Car> cars = new ArrayList<>();
        if (count == 0 || count >= list.size()) {
            return list;
        } else {
            for(int i = 0; i < count; i ++) {
                cars.add(list.get(i));
            }
        }
        return cars;
    }
}