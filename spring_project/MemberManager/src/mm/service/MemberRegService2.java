package mm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.dao.Dao;
import mm.dao.MemberDao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

@Component("regService")
public class MemberRegService2 {

	//@Autowired
	//@Qualifier("kkd")
	@Resource(name="guestDao")
	private Dao dao;	
	
	// Dao 타입의 객체를 주입 받는 방법 : 생성자, setter 메소드
	public MemberRegService2() {}
	
	public MemberRegService2(Dao dao) {
		this.dao = dao;
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void regMember(RegRequest request) throws DuplicateMemberException {
		
		// 이메일 중복 체크
		Member member = dao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException("이미 존재하는 이메일입니다.");
		}
		
		dao.insert(request.toMember());
		System.out.println("[msg : 등록되었습니다.]");
	}
	
}
