package com.ghub.boiko.sergiy.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class InitDataBase {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void initDataBase() {

        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CAR (" +
                "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                " ID_ENGINE INT," +
                " ID_WHEEL INT);");
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ENGINE (" +
                "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                " ENGINE_CAR VARCHAR (25);");
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS TYRES (" +
                "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                " SIZE VARCHAR (25)," +
                " NAME VARCHAR (25));");
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS WHEEL (" +
                "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "ID_TYRES INT);");
    }

    public int countRowInTableWheel() {
        int countRow = this.jdbcTemplate.queryForObject(
                "select count(*) from Wheel", Integer.class);
        return countRow;
    }

}
