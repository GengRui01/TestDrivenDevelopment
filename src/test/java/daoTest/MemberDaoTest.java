package daoTest;

import TestDrivenDevelopment.Application;
import dao.MemberDao;
import domain.entity.Member;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description: Member持久层测试
 *
 * @ClassName: MemberDaoTest
 * @Author: GengRui
 * @Date: 2019/10/8 15:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MemberDaoTest extends TestCase {
    @Autowired
    private MemberDao memberDao;

    @Test
    @Transactional
    public void testInsertMember() throws Exception {
        Member member = new Member();
        member.setUsername("Peter");
        member.setGender(Boolean.FALSE);
        member.setBirthday("2005-06-18");
        member.setMemberId("9");
        memberDao.insertMember(member);
        Member testMember = memberDao.selectMemberById("9");
        assertEquals(member.getUsername(), testMember.getUsername());
        assertEquals(member.getGender(), testMember.getGender());
        assertEquals(member.getBirthday(), testMember.getBirthday());
    }
}
