package com.jtp7.demo;

import com.jtp7.demo.entity.ReimbursementApprovalInfo;
import com.jtp7.demo.entity.ReimbursementInfo;
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
}
