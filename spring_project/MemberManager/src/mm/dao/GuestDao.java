package mm.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.domain.Member;

@Component("guestDao")
@Qualifier("gdao")
public class GuestDao implements Dao {

	@Override
	public void insert(Member member) {
		System.out.println("GuestDao insert()");
		
	}

	@Override
	public void update(Member member) {
		System.out.println("GuestDao update()");
		
	}

	@Override
	public Member selectByEmail(String email) {
		System.out.println("GuestDao selectByEmail()");
		return null;
	}

	@Override
	public Collection<Member> selectAll() {
		System.out.println("GuestDao selectAll()");
		return null;
	}

}
