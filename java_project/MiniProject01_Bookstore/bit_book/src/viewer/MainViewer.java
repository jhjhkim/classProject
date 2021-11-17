package viewer;

import controller.UserController;
import util.PatternChk;
import util.ScannerUtil;

public class MainViewer {

	PatternChk patternChk;
	UserController userController;
	UserViewer userViewer;
	AdminViewer adminViewer;
	
	public MainViewer() {
		patternChk = new PatternChk();
		userController = new UserController();
		userViewer = new UserViewer();
		adminViewer = new AdminViewer();
	}
	
	public void showLogin() {
		while (true) {
			System.out.println("아이디를 입력해주세요.");
			System.out.print("> ");
			String userName = ScannerUtil.getString();

			while (!patternChk.userNameForm(userName)) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println("아이디를 입력해주세요. (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
				System.out.print(">	");
				userName = ScannerUtil.getString();
			}

			System.out.println("비밀번호를 입력해주세요.");
			System.out.print("> ");
			String password = ScannerUtil.getString();

			while (!patternChk.pwForm(password)) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println("비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
				System.out.print("> ");
				password = ScannerUtil.getString();
			}
			
			// 로그인 
			if (userController.auth(userName, password)) {
				System.out.println("로그인 성공!");

				if (logger.LoginUser.loginId > 9) {   		// 일반.
					userViewer.userMenu();
				} else {
					adminViewer.adminMenu();
				}
				break;
			} else {
				System.out.println("로그인에 실패했습니다. 다시 한 번 확인해주세요.");
			}
		}
	}
	
	
	public void showJoinForm() {
		System.out.println("==============		회 원 가 입		 ==============\n");
		System.out.println(" 아래 양식에 따라 입력해주세요.");

		System.out.println("로그인 아이디  (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
		System.out.print("> ");
		String userName = ScannerUtil.getString();

		while (!patternChk.userNameForm(userName)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("로그인 아이디를 입력해주세요.  (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
			System.out.print("> ");
			userName = ScannerUtil.getString();
		}

		System.out.println("\n로그인 비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
		System.out.print("> ");
		String password = ScannerUtil.getString();

		while (!patternChk.pwForm(password)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("로그인 비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
			System.out.print("> ");
			password = ScannerUtil.getString();
		}

		System.out.print("\n이름을 입력해주세요. (영문 최대20글자, 한글 최대10글자)\n> ");
		String name = ScannerUtil.getString();

		while (!patternChk.nameForm(name)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("이름은 영문20글자, 한글10글자를 넘을 수 없습니다.");
			System.out.print("이름을 입력해주세요.\n> ");
			name = ScannerUtil.getString();
		}

		System.out.print("\n이메일을 입력해주세요. (예: mail@email.com)\n> ");
		String email = ScannerUtil.getString();

		while (!patternChk.emailForm(email)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.print("이메일을 입력해주세요. (예: mail@email.com)\n> ");
			email = ScannerUtil.getString();
		}

		System.out.print("\n전화번호를 입력해주세요. (-를 포함해주세요.) (예: 010-1111-2222)\n> ");
		String phnum = ScannerUtil.getString();

		while (!patternChk.phnumForm(phnum)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.print("전화번호를 입력해주세요. (-를 포함해주세요.) (예: 010-1111-2222)\n> ");
			phnum = ScannerUtil.getString();
		}

		System.out.print("\n주소를 입력해주세요.\n> ");
		String address = ScannerUtil.getString();

		userController.joinUser(userName, password, name, email, phnum, address);
	}
	
}
