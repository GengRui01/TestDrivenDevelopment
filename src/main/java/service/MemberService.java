package service;

import domain.vo.MemberVo;

import java.util.List;

/**
 * Description:
 *
 * @InterfaceName: MemberService
 * @Author: GengRui
 * @Date: 2019/10/17 15:06
 */
public interface MemberService {
    /**
     * Description: Member 新增数据
     *
     * @param memberVo
     * @return
     */
    int insertMember(MemberVo memberVo);

    /**
     * Description: Member 修改数据
     *
     * @param memberVo
     */
    int updateMember(MemberVo memberVo);

    /**
     * Description: 根据 ID 获取 Member 对象
     *
     * @param memberId
     * @return
     */
    MemberVo selectMemberById(String memberId);

    /**
     * Description: Member 列表查询
     *
     * @throws Exception
     */
    List<MemberVo> selectAllMember();
}
