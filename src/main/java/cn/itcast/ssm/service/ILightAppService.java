package cn.itcast.ssm.service;

import cn.itcast.ssm.Entity.CompanyApp;
import cn.itcast.ssm.Entity.LightAppParam;

import java.util.List;

public interface ILightAppService {
      public List<CompanyApp> appCenter(Integer param);

}
