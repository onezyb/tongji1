package com.zyb.tjpkg.mapper;

import com.zyb.tjpkg.model.TongjiOutlog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;


@Repository
public interface TongjiOutlogMapper extends MyMapper<TongjiOutlog> {

//    TongjiOutlog limitGetOne(@Param("offset") Integer offset);
//    List<Integer> ids();
    List<Integer> getTableIds(@Param("tableName") String tableName);
}