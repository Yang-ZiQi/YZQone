package com.yzq.dao;

import com.yzq.po.Dept;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-11-21=11:22
 */
public interface DeptDao {
    List<Dept> selectAll();
}
