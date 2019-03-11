package com.dachen.st.mapper;

import com.dachen.st.po.PCase;
import com.dachen.st.po.PCaseExample;
import com.dachen.st.po.PCaseWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface PCaseMapper {
    int countByExample(PCaseExample example);

    int deleteByExample(PCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PCaseWithBLOBs record);

    int insertSelective(PCaseWithBLOBs record);

    List<PCaseWithBLOBs> selectByExampleWithBLOBs(PCaseExample example);

    List<PCase> selectByExample(PCaseExample example);

    PCaseWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PCaseWithBLOBs record, @Param("example") PCaseExample example);

    int updateByExampleWithBLOBs(@Param("record") PCaseWithBLOBs record, @Param("example") PCaseExample example);

    int updateByExample(@Param("record") PCase record, @Param("example") PCaseExample example);

    int updateByPrimaryKeySelective(PCaseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PCaseWithBLOBs record);

    int updateByPrimaryKey(PCase record);
    List<PCase>  getAllCase();
}