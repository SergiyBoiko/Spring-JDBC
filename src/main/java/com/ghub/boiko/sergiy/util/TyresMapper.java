package com.ghub.boiko.sergiy.util;


import com.ghub.boiko.sergiy.model.Tyres;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TyresMapper implements RowMapper<Tyres> {
    @Override
    public Tyres mapRow(ResultSet resultSet, int i) throws SQLException {
        Tyres tyres = new Tyres(resultSet.getString("SIZE"), resultSet.getString("NAME"));
        return null;
    }
}
