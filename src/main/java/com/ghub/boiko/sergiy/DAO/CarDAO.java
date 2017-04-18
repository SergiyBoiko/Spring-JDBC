package com.ghub.boiko.sergiy.DAO;

import com.ghub.boiko.sergiy.model.Car;
import com.ghub.boiko.sergiy.model.Engine;
import com.ghub.boiko.sergiy.model.Wheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CarDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertCar;
    private EngineDAO engineDao;
    private WheelDAO wheelDao;
    Map<String, Object> parameters = new HashMap<String, Object>(2);

    public void setEngineDAO(EngineDAO engineDao){
        this.engineDao = engineDao;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.wheelDao = new WheelDAO(dataSource);
        this.engineDao = new EngineDAO(dataSource);
        this.insertCar = new SimpleJdbcInsert(dataSource).withTableName("CAR").usingGeneratedKeyColumns("ID");
    }

    public void addCar(Car car){
        Engine engine = car.getEngine();
        Wheel wheel = car.getWheels();
        parameters.put("ID_ENGINE", engineDao.addEngine(engine));
        parameters.put("ID_WHEEL", wheelDao.addWheel(wheel));
        insertCar.execute(parameters);
    }

    public Car getCarByID(int id){
        String SQL = "select ID_WHEEL from Car where id = ?";
        int id_wheel = jdbcTemplate.queryForObject(SQL, new Object[]{id}, Integer.class);
        SQL = "select ID_ENGINE from Car where id = ?";
        int id_engine = jdbcTemplate.queryForObject(SQL, new Object[]{id}, Integer.class);
        return new Car(wheelDao.getWheelByID(id_wheel), engineDao.getEngineByID(id_engine));
    }
}

