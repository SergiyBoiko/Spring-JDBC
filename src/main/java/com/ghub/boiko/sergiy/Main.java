package com.ghub.boiko.sergiy;

import com.ghub.boiko.sergiy.DAO.CarDAO;
import com.ghub.boiko.sergiy.configuration.CarConfiguration;
import com.ghub.boiko.sergiy.configuration.JDBCConfiguration;
import com.ghub.boiko.sergiy.model.Car;
import com.ghub.boiko.sergiy.util.InitDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CarConfiguration.class, JDBCConfiguration.class);
    Car car = applicationContext.getBean(Car.class);
    CarDAO carDAO = applicationContext.getBean(CarDAO.class);
    InitDataBase initial = applicationContext.getBean(InitDataBase.class);
    initial.initDataBase();
    carDAO.addCar(car);
}
