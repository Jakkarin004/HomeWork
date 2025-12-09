package com.jakkarin.back.service;


import com.jakkarin.back.entity.MainEntity;
import com.jakkarin.back.model.MainModel;
import com.jakkarin.back.repository.MainJPARepository;
import com.jakkarin.back.respon.UserResponData;
import com.jakkarin.back.respon.UserResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainJPARepository mainJPARepository;

    //
    public List<MainModel> getData() {
        List<MainEntity> mainEntityList =  mainJPARepository.findAll();
        List<MainModel> mainModelList = new ArrayList<>();

        for (MainEntity mainEntity : mainEntityList) {
            MainModel mainModel = new MainModel();

            mainModel.setSsoType(mainEntity.getSsoType());
            mainModel.setSystemId(mainEntity.getSystemId());
            mainModel.setSystemName(mainEntity.getSystemName());
            mainModel.setSystemTransactions(mainEntity.getSystemTransactions());
            mainModel.setSystemPrivileges(mainEntity.getSystemPrivileges());
            mainModel.setSystemUserGroup(mainEntity.getSystemUserGroup());
            mainModel.setSystemLocationGroup(mainEntity.getSystemLocationGroup());
            mainModel.setUserId(mainEntity.getUserId());
            mainModel.setUserFullName(mainEntity.getUserFullName());
            mainModel.setUserRdOfficeCode(mainEntity.getUserRdOfficeCode());
            mainModel.setUserOfficeCode(mainEntity.getUserOfficeCode());
            mainModel.setClientLocation(mainEntity.getClientLocation());
            mainModel.setLocationMachineNumber(mainEntity.getLocationMachineNumber());
            mainModel.setTokenId(mainEntity.getTokenId());
            mainModel.setRequestDate(mainEntity.getRequestDate());

            mainModelList.add(mainModel);
        }
        return mainModelList;
    }

    public UserResponses saveData(MainModel mainModel) {
        try{
            if( mainModel == null
                    || mainModel.getTokenId() == null
                    || mainModel.getSsoType() == null
                    || mainModel.getSystemId() == null
                    || mainModel.getSystemName() == null
                    || mainModel.getSystemTransactions() == null
                    || mainModel.getSystemPrivileges() == null
                    || mainModel.getSystemUserGroup() == null
                    || mainModel.getSystemLocationGroup() == null
                    || mainModel.getUserId() == null
                    || mainModel.getUserFullName() == null
                    || mainModel.getUserRdOfficeCode() == null
                    || mainModel.getUserOfficeCode() == null
                    || mainModel.getClientLocation() == null
                    || mainModel.getLocationMachineNumber() == null
                    || mainModel.getTokenId() == null
                    || mainModel.getRequestDate() == null)
            {
                UserResponData userResponData = new UserResponData(null,"");
                UserResponses errorr = new UserResponses(userResponData);
                errorr.setResponseCode("E000400");
                errorr.setResponseMessage("ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้ เนื่องจากข้อมูลไม่ครบ");
                return errorr;
            }

            MainEntity mainEntity = new MainEntity();

            mainEntity.setSsoType(mainModel.getSsoType());
            mainEntity.setSystemId(mainModel.getSystemId());
            mainEntity.setSystemName(mainModel.getSystemName());
            mainEntity.setSystemTransactions(mainModel.getSystemTransactions());
            mainEntity.setSystemPrivileges(mainModel.getSystemPrivileges());
            mainEntity.setSystemUserGroup(mainModel.getSystemUserGroup());
            mainEntity.setSystemLocationGroup(mainModel.getSystemLocationGroup());
            mainEntity.setUserId(mainModel.getUserId());
            mainEntity.setUserFullName(mainModel.getUserFullName());
            mainEntity.setUserRdOfficeCode(mainModel.getUserRdOfficeCode());
            mainEntity.setUserOfficeCode(mainModel.getUserOfficeCode());
            mainEntity.setClientLocation(mainModel.getClientLocation());
            mainEntity.setLocationMachineNumber(mainModel.getLocationMachineNumber());
            mainEntity.setTokenId(mainModel.getTokenId());
            mainEntity.setRequestDate(mainModel.getRequestDate());

            mainJPARepository.save(mainEntity);

            UserResponData userResponData = new UserResponData(mainModel.getUserId(),mainModel.getTokenId());
            UserResponses userResponses = new UserResponses(userResponData);
            userResponses.setResponseCode("I07000");
            userResponses.setResponseMessage("ทำรายการเรียบร้อย");

            return userResponses;

        }catch (DataAccessException e){
            UserResponData userResponData = new UserResponData(mainModel != null && mainModel.getUserId() != null ? mainModel.getUserId() : "เกิดข้อผิดพลาด","");
            UserResponses errorr = new UserResponses(userResponData);
            errorr.setResponseCode("E000500");
            errorr.setResponseMessage("ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้  เนื่องจากไม่พบฐานข้อมูล");
            return errorr;
        }
    }


}
