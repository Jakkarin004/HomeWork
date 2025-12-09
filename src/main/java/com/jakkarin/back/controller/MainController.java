package com.jakkarin.back.controller;

import com.jakkarin.back.model.MainModel;
import com.jakkarin.back.repository.MainJPARepository;
import com.jakkarin.back.respon.UserResponses;
import com.jakkarin.back.service.MainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Main-controller")
public class MainController {

    @Autowired
    private MainService mainService;

    //http://localhost:8080/swagger-ui/index.html#/
    @GetMapping("/check-connect-swagger")
    public String checkSwagger(){
        return "swagger check point";
    }

    //ตรวจสอบข้อมูล
    @GetMapping("/get-data-user")
    public List<MainModel> getData(){
        return mainService.getData();
    }

    //POST เพิ่ม
    //RequestBody เอามาทั้งหมด เช่น mainModel
    //เส้น api เพิ่ม ใส่ void ไม่ส่งค่าอะไรกลับ
    @PostMapping("gentoken")
    public UserResponses saveData( @RequestBody MainModel mainModel) {
        return mainService.saveData(mainModel);
    }


}
