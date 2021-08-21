package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.DaoCarImpl;
import web.service.CarService;

@Controller
public class CarsController {

    private final CarService carService;
    private final DaoCarImpl daoCar;


    public CarsController(CarService carService) {
        this.carService = carService;
        daoCar = new DaoCarImpl();
    }

    @GetMapping(value = "/cars")
    public String listOfCars(@RequestParam(value = "count", required = false) Integer count, Model model) {

        if (count != null) {
            model.addAttribute("cars", carService.readCars(count));
        } else {
            model.addAttribute("cars", daoCar.getList());
        }
        return "cars";
    }

}