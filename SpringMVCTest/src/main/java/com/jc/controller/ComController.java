package com.jc.controller;

import com.jc.dao.CommodityMapper;
import com.jc.entity.Commodity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class ComController {
    @RequestMapping("FindCom")
    public String FindCom(Model model) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        CommodityMapper mapper = sqlSession.getMapper(CommodityMapper.class);
        List<Commodity> list = mapper.FindAll();
        model.addAttribute("list",list);
        sqlSession.close();
        return "allcom";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "addcom";
    }
    @RequestMapping("AddCom")
    public String AddCom(Commodity com, MultipartFile img) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        CommodityMapper mapper = sqlSession.getMapper(CommodityMapper.class);
        if(img!=null){
            String oldName="fileupload\\"+img.getOriginalFilename();
            String filepath="C:\\JavaWorkPlace\\Day1\\"+oldName;
            img.transferTo(new File(filepath));
            com.setImgs(oldName);
            mapper.AddCom(com);
        }
        sqlSession.commit();
        sqlSession.close();
        return "redirect:/FindCom.do";
    }
    @RequestMapping("Delete")
    public String Delete(int cid) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        CommodityMapper mapper = sqlSession.getMapper(CommodityMapper.class);
        mapper.Delete(cid);
        sqlSession.commit();
        sqlSession.close();
        return "redirect:/FindCom.do";
    }
    @RequestMapping("FindById")
    public String FindById(int cid,Model model) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        CommodityMapper mapper = sqlSession.getMapper(CommodityMapper.class);
        Commodity commodity = mapper.FindById(cid);
        model.addAttribute("com",commodity);
        sqlSession.close();
        return "findid";
    }
    @RequestMapping("Update")
    public String Update(Commodity com, MultipartFile img) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        CommodityMapper mapper = sqlSession.getMapper(CommodityMapper.class);
        if(img!=null){
            String oldName="fileupload\\"+UUID.randomUUID()+"-"+img.getOriginalFilename();
            String filepath="C:\\JavaWorkPlace\\Day1\\"+oldName;
            img.transferTo(new File(filepath));
            com.setImgs(oldName);
            mapper.Update(com);
        }
        sqlSession.commit();
        sqlSession.close();
        return "redirect:/FindCom.do";
    }
}
