package com.hui.mapper;


import com.hui.entity.examine.Cadre;
import com.hui.mapper.examine.CadreMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
/**
 * @author huang jiehui
 * @date 2020/12/7 14:41
 */
public class MapperTest {
    @Autowired
    CadreMapper cadreMapper;
    @Test
    public void queryAllTest() {
        List<Cadre> cadres = cadreMapper.selectSelective(new Cadre());
        for (Cadre s:cadres
             ) {
            System.out.println(s);
        }
    }

}
