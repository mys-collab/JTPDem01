package com.jtp7.demo;

import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.ReimbursementApprovalInfo;
import com.jtp7.demo.entity.ReimbursementInfo;
import com.jtp7.demo.service.impl.LorryInfoServiceImpl;
import com.jtp7.demo.service.impl.ReimbursementInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@SpringBootTest
class OrderManageApplicationTests {
    @Autowired
    ReimbursementInfoServiceImpl infoService;
    @Autowired
    LorryInfoServiceImpl lorryInfoService;

    @Test
    void contextLoads() {

        ReimbursementInfo info = new ReimbursementInfo();
//        info.setApplicant("lsx");
//        info.setType("汽油费");
//        info.setMoney(2222);
//        info.setMonth(8);
//        info.setState("已提交");

        List<ReimbursementInfo> infoList = infoService.getReimbursementInfoByLike(info);

        infoList.forEach(a->{
            System.out.println(a);
        });
    }

    @Test
    void test01() {

        ReimbursementInfo info = new ReimbursementInfo();
        info.setApplicant("lsx");
        info.setType("汽油费");
        info.setMoney(2222);
        info.setMonth(8);
        info.setState("已提交");
        info.setDriving_code("123456789");

        Integer integer = infoService.claimForReimbursement(info);
        System.out.println(integer);
    }

    @Test
    void test02() {

        ReimbursementApprovalInfo reimbursementApprovalInfo = new ReimbursementApprovalInfo(3,"驳回");

        Integer integer = infoService.reimbursementApproval(reimbursementApprovalInfo);
        System.out.println(integer);
    }

    @Test
    void test03() {

        LorryInfo lorryInfo = new LorryInfo(1, "aaa", "1");

        List<LorryInfo> integer = lorryInfoService.getLorryInfoByLike(lorryInfo);
        integer.forEach(a->{
            System.out.println(a);
        });
    }

    @Test
    void test04() {

        LorryInfo lorryInfo = new LorryInfo(1, "aaa", "1");

        Integer add = lorryInfoService.add(lorryInfo);
        System.out.println(add);

    }

    @Test
    void test05() {

        LorryInfo lorryInfo = new LorryInfo(1, "aaaa", "1");

        Integer update = lorryInfoService.updateById(lorryInfo);
        System.out.println(update);

    }

    @Test
    void test06() {

        Integer delete = lorryInfoService.deleteById(1);
        System.out.println(delete);

    }
}
