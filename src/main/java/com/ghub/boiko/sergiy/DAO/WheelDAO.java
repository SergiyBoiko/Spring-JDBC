package com.ghub.boiko.sergiy.DAO;

import com.ghub.boiko.sergiy.model.Engine;
import com.ghub.boiko.sergiy.model.Tyres;
import com.ghub.boiko.sergiy.model.Wheel;
import com.ghub.boiko.sergiy.util.EngineMapper;
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
public class WheelDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsertWheel;
    private TyresDAO tyresDAO;
    private Map<String, Object> parameter = new HashMap<String, Object>(2);

    @Autowired
    public WheelDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsertWheel = new SimpleJdbcInsert(dataSource).withTableName("WHEEL").usingGeneratedKeyColumns("ID");
    }

    public void addWheel(Wheel wheel){
        Tyres tyres = wheel.getTyres();
        parameter.put("id_tyres", tyresDAO.addTyres(tyres));
    }

    public int getID(){
        Number id = simpleJdbcInsertWheel.executeAndReturnKey(parameter);
        return id.intValue();
    }

    public Wheel getWheelByID(int id){
        String SQL = "select * from Wheel where id = ?";
        int id_tyres = jdbcTemplate.queryForObject(SQL, new Object[]{id}, Integer.class);
        return new Wheel(tyresDAO.getTyresByID(id_tyres));
    }
}

}
