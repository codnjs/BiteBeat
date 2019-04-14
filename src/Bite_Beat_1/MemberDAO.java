package Bite_Beat_1;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


// DB 처리
public class MemberDAO {
	private static final String DRIVER
		= "oracle.jdbc.driver.OracleDriver";
	private static final String URL
		= "jdbc:oracle:thin:@192.168.0.3:1521:ORCL";
	
	private static final String USER = "SCOTT";
	private static final String PASS = "SCOTT";
	// Memebr_List mList;
	
	public MemberDAO () {
		
	}
	
//	public MemberDAO(Member_List mList) {
//		this.mList = mList;
//		System.out.println("DAO => " + mList);
//	}
	
	public static Connection connectDB() // DB 연결 메소드
	  {
	      Connection c = null;
	        try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:BiteBeat.sqlite");
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }
	        System.out.println("Opened database successfully_connect");
			return c;
	  }
	
	// 한 사람의 회원 정보를 얻는 부분 
	public MemberDTO getMemberDTO(String id) {
		MemberDTO dto = new MemberDTO();
		
		Connection c = null; // DB연결
		PreparedStatement stmt = null; // 명령어
		ResultSet rs = null; // 결과
		
		try {
	           
            c = connectDB();
            String sql = "select * from testdb where id=?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, id);
           
            rs = stmt.executeQuery(sql);
           
            if(rs.next()){
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("Pwd"));               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    		
	}
	
	public boolean insertMember(MemberDTO dto) {
		boolean ok = false;
		
		Connection c = null;
		PreparedStatement stmt = null;
		
		try {
			  c = connectDB();
			  
	          String sql = "INSERT INTO testdb (ID,PASSWD,SCORE) " +
	                       "VALUES ('tjdus', '123', 78014)," +
	                       " ('zzeon', '456',68192);"; 
	          stmt = c.prepareStatement(sql);
	          int r = stmt.executeUpdate(sql);
	          
	          if(r>0) {
	        	  System.out.println("가입 성공");
	        	  ok = true;
	          } else {
	        	  System.out.println("가입 실패");
	          }
//	          stmt.close();
//	          c.commit();
//	          c.close();
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }	
		return ok;
	} // insertMember
 	
}
