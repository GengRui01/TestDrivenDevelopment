package daoTest;

import dao.MemberDao;
import domain.entity.Member;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description: Member持久层测试
 *
 * @ClassName: MemberDaoTest
 * @Author: GengRui
 * @Date: 2019/10/8 15:23
 */
public class MemberDaoTest extends TestCase {
    @Autowired
    private MemberDao memberDao;

    public void testInsertMember() throws Exception {
        Member member = new Member();
        member.setUsername("Tony");
        member.setGender(Boolean.FALSE);
        member.setBirthday("1996-04-02");
        member.setMemberId("6");
        memberDao.insertMember(member);
        Member testMember = memberDao.selectMemberById("6");
        assertEquals(member.getUsername(), testMember.getUsername());
        assertEquals(member.getGender(), testMember.getGender());
        assertEquals(member.getBirthday(), testMember.getBirthday());
    }
}
