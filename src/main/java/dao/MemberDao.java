package dao;

import domain.entity.Member;
import org.apache.ibatis.annotations.Mapper;

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

    Member selectMemberById(String memberId);
}
