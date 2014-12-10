package com.handq.business.service.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.handq.business.service.UserService;
import com.handq.business.vo.Person;
@Transactional
@Service(value = "userService")//服务层配置
public class UserServiceImpl implements UserService
{
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;
    
//     @Resource(name = "sqlMapClient")
//     public void setSqlMap(SqlMapClient sqlMapClient) {
//     this.sqlMapClient = sqlMapClient;
//     }
    
    public boolean queryPerson()
    {
        Person person = new Person();
        try
        {
            person = (Person)sqlMapClient.queryForObject("person.getPerson", "zhangsan");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(person.getPersonName());
        System.out.println(person.getPwd());
        return true;
    }

    /**
     * @return
     */
    public boolean updatePerson()
    {
        logger.info("updatePerson() start:");
        Person person = new Person("lisi","1111111");
        int f = 0;
        try
        {
            f = sqlMapClient.update("person.updatePerson", person);
        }
        catch (SQLException e)
        {
            logger.debug(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info(f);
        logger.debug(f);
        System.out.println(f);
        return true;
    }
    
}
