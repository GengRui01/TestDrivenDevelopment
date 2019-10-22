package service.impl;

import dao.MemberDao;
import domain.entity.Member;
import domain.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MemberService;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @ClassName: MemberServiceImpl
 * @Author: GengRui
 * @Date: 2019/10/17 15:07
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    /**
     * Description: Member 新增数据
     *
     * @param memberVo
     * @return
     */
    @Override
    public int insertMember(MemberVo memberVo) {
        return memberDao.insertMember(voToEntity(memberVo));
    }

    /**
     * Description: Member 修改数据
     *
     * @param memberVo
     */
    @Override
    public int updateMember(MemberVo memberVo) {
        return memberDao.updateMember(voToEntity(memberVo));
    }

    /**
     * Description: 封装为数据库可insert或update的对象
     *
     * @param memberVo
     * @return
     */
    private Member voToEntity(MemberVo memberVo) {
        Member member = new Member(memberVo);
        member.setGender("女".equals(memberVo.getGenderName()));
        return member;
    }

    /**
     * Description: 根据 ID 获取 Member 对象
     *
     * @param memberId
     * @return
     */
    @Override
    public MemberVo selectMemberById(String memberId) {
        Member member = memberDao.selectMemberById(memberId);
        return entityToVo(member);
    }

    /**
     * Description: Member 列表查询
     *
     * @throws Exception
     */
    @Override
    public List<MemberVo> selectAllMember() {
        List<MemberVo> returnList = new ArrayList<>();
        List<Member> list = memberDao.selectAllMember();
        list.forEach(member -> returnList.add(entityToVo(member)));
        return returnList;
    }

    /**
     * Description: 封装为可展示的对象
     *
     * @param member
     * @return
     */
    private MemberVo entityToVo(Member member) {
        MemberVo memberVo = new MemberVo(member);
        memberVo.setGenderName(memberVo.getGender() ? "女" : "男");
        return memberVo;
    }
}


