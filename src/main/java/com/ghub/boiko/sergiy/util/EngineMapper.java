package com.ghub.boiko.sergiy.util;


import com.ghub.boiko.sergiy.model.Engine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EngineMapper implements RowMapper<Engine> {
    @Override
    public Engine mapRow(ResultSet resultSet, int i) throws SQLException {
        Engine engine = new Engine(resultSet.getBigDecimal("ENGINE_CAR"));
        return null;
    }
}
