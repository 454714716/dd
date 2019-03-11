package com.dachen.st;

import com.dachen.st.commons.JSONMessage;
import com.dachen.st.po.PCase;
import com.dachen.st.service.ILightAppService;
import com.dachen.st.service.IPCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class control {
    @Autowired
    IPCase ipCase;
    @Autowired
    ILightAppService serviceImp;
    private final static String redis_key_prefix = "light_app:";
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @RequestMapping("/nologin/dds")
    public JSONMessage getUserPageNoAdmin(@RequestParam  Integer idd ) {
        System.out.print("iddd=="+idd);
        System.out.print("iddd=="+ipCase);
        List<PCase>   appVO;
        if (redisTemplate.hasKey(redis_key_prefix + idd)) {
               appVO = (List<PCase>) redisTemplate.opsForValue().get(redis_key_prefix + idd);
               System.out.println("===redisTemplate===="+redisTemplate);
        } else {
               appVO =  ipCase.getAllCase();
               redisTemplate.opsForValue().set(redis_key_prefix +idd, appVO);
        }
        return JSONMessage.success(appVO);

    }
    @RequestMapping("/nologin/ddall")
    public JSONMessage getUserPageNoAdmins(@RequestParam  Integer status ) {
        System.out.print("iddd=="+status);
        System.out.print("===iddd=="+serviceImp);
        return JSONMessage.success(serviceImp.appCenter(status).toString());

    }
}
