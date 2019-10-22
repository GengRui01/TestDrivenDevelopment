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

import java.util.List;

/**
 * Description: Member 持久层测试
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

    /**
     * Description: Member 新增数据测试
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void testInsertMember() throws Exception {
        Member member = new Member();
        member.setUsername("Peter");
        member.setGender(Boolean.FALSE);
        member.setBirthday("2005-06-18");
        member.setMemberId("9");
        int count = memberDao.insertMember(member);
        assertEquals(count, 1);
        Member testMember = memberDao.selectMemberById("9");
        assertEquals(member.getUsername(), testMember.getUsername());
        assertEquals(member.getGender(), testMember.getGender());
        assertEquals(member.getBirthday(), testMember.getBirthday());
    }

    /**
     * Description: Member 修改数据测试
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void testUpdateMember() throws Exception {
        Member member = new Member();
        member.setMemberId("6");
        member.setBirthday("1995-01-10");
        int count = memberDao.updateMember(member);
        assertEquals(count, 1);
    }

    /**
     * Description: Member 删除数据测试
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void testDeleteMember() throws Exception {
        List<Member> beforeList = memberDao.selectAllMember();
        int count = memberDao.deleteMember("8");
        List<Member> afterList = memberDao.selectAllMember();
        assertEquals(beforeList.size() - afterList.size(), count);
    }

    /**
     * Description: Member 列表查询测试
     *
     * @throws Exception
     */
    @Test
    public void testMemberList() throws Exception {
        List<Member> list = memberDao.selectAllMember();
        assertEquals(list.size(), 8);
        assertEquals(list.get(2).getUsername(), "Tom");
        assertEquals(list.get(6).getGender(), Boolean.TRUE);
    }
}
