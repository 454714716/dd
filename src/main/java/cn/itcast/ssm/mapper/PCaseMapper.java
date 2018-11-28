package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.PCase;
import cn.itcast.ssm.po.PCaseExample;
import cn.itcast.ssm.po.PCaseWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}