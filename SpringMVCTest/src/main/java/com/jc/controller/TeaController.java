package com.jc.controller;

import com.jc.dao.TeacherMapper;
import com.jc.entity.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class TeaController {
    @RequestMapping("AllTea")
    public String AllTea(Model model) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> list=mapper.FindAll();
        model.addAttribute("list",list);
        return "alltea";
    }
    @RequestMapping("AddTea")
    public String AddTea(@RequestBody Teacher tea) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.AddTea(tea);
        sqlSession.commit();
        sqlSession.close();
        return "redirect:/alltea";
    }
}
