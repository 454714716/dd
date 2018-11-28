package cn.itcast.ssm.service.imple;

import cn.itcast.ssm.Entity.CompanyApp;

import java.util.List;

public interface ICompanyAppDao {
    List<CompanyApp> getALL(Integer status);
}
