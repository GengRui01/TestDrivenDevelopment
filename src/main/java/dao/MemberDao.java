package dao;

import domain.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:
 *
 * @InterfaceName: MemberDao
 * @Author: GengRui
 * @Date: 2019/10/8 16:31
 */
@Mapper
public interface MemberDao {
    int insertMember(Member member);

    int updateMember(Member member);

    int deleteMember(String memberId);

    Member selectMemberById(String memberId);

    List<Member> selectAllMember();
}
