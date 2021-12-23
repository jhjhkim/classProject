package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guestbook.dao.GuestbookDao;
import guestbook.domain.Guestbook;
import guestbook.domain.GuestbookListView;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestbookListService {
	
	private GuestbookListService() {}
	private static GuestbookListService service = new GuestbookListService();
	public static GuestbookListService getInstance() {
		return service;
	}
	public GuestbookListView getPage(int pageNum) {
		GuestbookListView listView = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			int currentPage = pageNum;
			final int COUNT_PER_PAGE = 5;
			int index = (currentPage - 1)*COUNT_PER_PAGE;
			
			List<Guestbook> list = GuestbookDao.getInstance().selectList(conn, index, COUNT_PER_PAGE);
			
			int totalCount = GuestbookDao.getInstance().selectTotalCount(conn);
			
			listView = new GuestbookListView(totalCount, COUNT_PER_PAGE, currentPage, list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}		
		
		return listView;
	}
	
	

}
