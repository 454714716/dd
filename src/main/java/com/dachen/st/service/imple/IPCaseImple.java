package com.dachen.st.service.imple;

import com.dachen.st.mapper.PCaseMapper;
import com.dachen.st.po.PCase;
import com.dachen.st.po.PCaseWithBLOBs;
import com.dachen.st.service.IPCase;
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
        return  pCaseMapper.getAllCase()  ;
    }

}
