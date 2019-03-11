package com.dachen.st.service;


import com.dachen.st.po.PCase;
import com.dachen.st.po.PCaseWithBLOBs;

import java.util.List;

public interface IPCase {
    PCaseWithBLOBs selectByPrimaryKey(Integer id);
    List<PCase> getAllCase();
}
