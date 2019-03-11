package cn.itcast.ssm.service.imple;

import cn.itcast.ssm.mapper.PCaseMapper;
import cn.itcast.ssm.po.PCase;
import cn.itcast.ssm.po.PCaseExample;
import cn.itcast.ssm.po.PCaseWithBLOBs;
import cn.itcast.ssm.service.IPCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IPCaseImple implements IPCase {
    @Autowired
    protected PCaseMapper pCaseMapper;
    @Override
    public PCaseWithBLOBs selectByPrimaryKey(Integer id) {
        return pCaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PCase> getAllCase() {
        return pCaseMapper.getAllCase();
    }

}
