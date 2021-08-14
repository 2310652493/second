package com.jc.dao;

import com.jc.entity.Commodity;

import java.util.List;

public interface CommodityMapper {
    public void AddCom(Commodity com);
    public List<Commodity> FindAll();
    public void Delete(int cid);
    public void Update(Commodity com);
    public Commodity FindById(int cid);
    public String FindPass(String a);
}
