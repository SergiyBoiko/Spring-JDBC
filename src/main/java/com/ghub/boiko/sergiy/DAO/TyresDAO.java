package com.ghub.boiko.sergiy.DAO;

import com.ghub.boiko.sergiy.model.Engine;
import com.ghub.boiko.sergiy.model.Tyres;
import com.ghub.boiko.sergiy.util.EngineMapper;
import com.ghub.boiko.sergiy.util.TyresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TyresDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsertTyres;
    private Map<String, Object> parameter = new HashMap<String, Object>(2);

    @Autowired
    public TyresDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsertTyres = new SimpleJdbcInsert(dataSource).withTableName("TYRES").usingGeneratedKeyColumns("ID");
    }

    public void addTyres(Tyres tyres){
        parameter.put("SIZE", tyres.getSize());
        parameter.put("NAME", tyres.getName());
    }

    public int getID(){
        Number id = simpleJdbcInsertTyres.executeAndReturnKey(parameter);
        return id.intValue();
    }

    public Tyres getTyresByID(int id){
        String SQL = "select * from Tyres where id = ?";
        Tyres tyres = jdbcTemplate.queryForObject(SQL, new Object[]{id},new TyresMapper());
        return tyres;
    }
}
