package com.ghub.boiko.sergiy.configuration;

import com.ghub.boiko.sergiy.model.Car;
import com.ghub.boiko.sergiy.model.Engine;
import com.ghub.boiko.sergiy.model.Tyres;
import com.ghub.boiko.sergiy.model.Wheel;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;

@Configuration
@ComponentScan(basePackages = {"model"})
@PropertySource("classpath:car.properties")
public class CarConfiguration {

        @Value("${car.tyresSize}")
        private String size;
        @Value("${car.tyresName}")
        private String name;
        @Value("${car.engineCapacity}")
        private BigDecimal engineCapacity;


        @Bean(autowire = Autowire.BY_NAME)
        public Tyres tyres() {
            return new Tyres(size, name);
        }

        @Bean
        public Wheel wheel(Tyres tyres) {
            return new Wheel(tyres);
        }

        @Bean(autowire = Autowire.BY_NAME)
        public Engine engine() {
            return new Engine(engineCapacity);
        }

        @Bean(autowire = Autowire.BY_NAME)
        public Car car() {
            return new Car();
        }

}
