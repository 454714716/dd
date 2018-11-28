package cn.itcast.ssm.service;

import cn.itcast.ssm.po.PCase;
import cn.itcast.ssm.po.PCaseExample;
import cn.itcast.ssm.po.PCaseWithBLOBs;

import java.util.List;

public interface IPCase {
    PCaseWithBLOBs selectByPrimaryKey(Integer id);
}
