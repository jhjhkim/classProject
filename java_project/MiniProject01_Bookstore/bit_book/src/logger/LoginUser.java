package logger;

public class LoginUser {
	static public int loginId;
	static public boolean loginStatus;
	static public int who;
	
	int manager  = 0;
	int customer = 1;
	
	
	static public void printLoginUser() {
		System.out.println("loginId     : " +loginId);
		System.out.println("loginStatus : " +loginStatus);
	}
	
	static public void logOut() {
		loginId = -1;
		loginStatus = false;
		who = -1;
		System.out.println("로그아웃되었습니다.");
	}

}
