package cn.corp.web.memberService.memberServiceImpl;

import cn.corp.web.dao.Dao;
import cn.corp.web.dao.DaoImpl.DaoImpl;
import cn.corp.web.domain.Member;
import cn.corp.web.memberService.memberService;

import java.util.List;

public class memberServiceImpl implements memberService {
    @Override
    public List<Member> findall() {
        Dao dao = new DaoImpl();
        List<Member> list = dao.findall();
        return list;
    }
}
