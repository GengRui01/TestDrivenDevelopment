package serviceTest;

import TestDrivenDevelopment.Application;
import domain.vo.MemberVo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import service.MemberService;

import java.util.List;

/**
 * Description: Member 业务层测试
 *
 * @ClassName: MemberServiceTest
 * @Author: GengRui
 * @Date: 2019/10/17 10:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MemberServiceTest extends TestCase {
    @Autowired
    private MemberService memberService;

    /**
     * Description: Member 新增数据测试
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void testInsertMember() throws Exception {
        MemberVo memberVo = new MemberVo();
        memberVo.setUsername("Peter");
        memberVo.setGenderName("男");
        memberVo.setBirthday("2005-06-18");
        memberVo.setMemberId("9");
        int count = memberService.insertMember(memberVo);
        assertEquals(count, 1);
        MemberVo testMemberVo = memberService.selectMemberById("9");
        assertEquals(memberVo.getUsername(), testMemberVo.getUsername());
        assertEquals(memberVo.getGenderName(), testMemberVo.getGenderName());
        assertEquals(memberVo.getBirthday(), testMemberVo.getBirthday());
    }

    /**
     * Description: Member 修改数据测试
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void testUpdateMember() throws Exception {
        MemberVo memberVo = new MemberVo();
        memberVo.setMemberId("6");
        memberVo.setBirthday("1988-01-10");
        int count = memberService.updateMember(memberVo);
        assertEquals(count, 1);
        MemberVo testMemberVo = memberService.selectMemberById("6");
        assertEquals(memberVo.getBirthday(), testMemberVo.getBirthday());
    }

    /**
     * Description: Member 列表查询测试
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void testMemberList() throws Exception {
        List<MemberVo> list = memberService.selectAllMember();
        assertEquals(list.size(), 8);
        assertEquals(list.get(2).getUsername(), "Tom");
        assertEquals(list.get(6).getGenderName(), "女");
    }
}
