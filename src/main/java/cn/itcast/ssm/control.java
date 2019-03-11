package cn.itcast.ssm;

import cn.itcast.ssm.commons.JSONMessage;
import cn.itcast.ssm.service.ILightAppService;
import cn.itcast.ssm.service.IPCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {
    @Autowired
    IPCase ipCase;
    @Autowired
    ILightAppService serviceImp;
    @RequestMapping("/nologin/dds")
    public JSONMessage getUserPageNoAdmin(@RequestParam  Integer idd ) {
        System.out.print("iddd=="+idd);
        System.out.print("iddd=="+ipCase);
        return JSONMessage.success(ipCase.getAllCase());

    }
    @RequestMapping("/nologin/ddall")
    public JSONMessage getUserPageNoAdmins(@RequestParam  Integer status ) {
        System.out.print("iddd=="+status);
        System.out.print("iddd=="+serviceImp);
        return JSONMessage.success(serviceImp.appCenter(status).toString());

    }
}
