package org.jpm.deco.app;


import org.jpm.deco.modal.Cognos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private CognosRepo cognosRepo;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setCognosRepo(CognosRepo cognosRepo){
        this.cognosRepo = cognosRepo;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/all")
    public List<Cognos> getAll(){
        String SQL = "select * from employees";
        return jdbcTemplate.query(SQL,new EmpMapper());
    }
}
