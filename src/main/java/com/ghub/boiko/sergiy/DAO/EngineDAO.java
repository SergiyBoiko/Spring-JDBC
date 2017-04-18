package com.ghub.boiko.sergiy.DAO;

import com.ghub.boiko.sergiy.model.Engine;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EngineDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsertEngine;
    private Map<String, Object> parameter = new HashMap<String, Object>(2);

    public EngineDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsertEngine = new SimpleJdbcInsert(dataSource).withTableName("ENGINE").usingGeneratedKeyColumns("ID");
    }

    public void addEngine(Engine engine){
        parameter.put("ENGINE_CAR", engine.getEngineСapacity());
    }

    public int getID(){
        Number id = simpleJdbcInsertEngine.executeAndReturnKey(parameter);
        return id.intValue();
    }

    public Engine getEngineByID(int id){
        String SQL = "select * from Engine where id = ?";
        Engine engine = jdbcTemplate.queryForObject(SQL, new Object[]{id},new EngineMapper());
        return engine;
    }
}
