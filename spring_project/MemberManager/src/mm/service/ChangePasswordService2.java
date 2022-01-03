package mm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.dao.Dao;
import mm.domain.Member;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;

@Component("changeService")
public class ChangePasswordService2 {

	@Autowired
	@Qualifier("md")
	private Dao dao;

	public ChangePasswordService2() {}
	
	public ChangePasswordService2(Dao dao) {
		this.dao = dao;
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void changePassword(String email, String oldPw, String newPw) throws NotFoundMemberException, IdPasswordNotMatchingException {
		
		// 회원이 존재하는지 여부 -> 예외 발생!
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new NotFoundMemberException("해당 정보로 등록된 회원이 없습니다.");
		}
		
		member.changePassword(oldPw, newPw);
		
		dao.update(member);
		
		System.out.println("비밀번호가 변경되었습니다.");
		
	}
	
}
