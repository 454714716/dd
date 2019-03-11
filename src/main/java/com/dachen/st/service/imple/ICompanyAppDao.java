package com.dachen.st.service.imple;

import com.dachen.st.Entity.CompanyApp;

import java.util.List;

public interface ICompanyAppDao {
    List<CompanyApp> getALL(Integer status);
}
