package database;
import java.sql.*;
 
public class SQLiteJDBC
{
  public static void main( String args[] )
  {
	  deleteDB();
      connectDB();
 //     createDB();
      insertDB();
      selectDB();
      //updateDB();
      
  }
   
  public static void connectDB()
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
  }
  public static void createDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:BiteBeat.sqlite");
          System.out.println("Opened database successfully");
 
          stmt = c.createStatement();
          String sql = "CREATE TABLE testdb " +
                       "(ID VARCHAR(20) PRIMARY KEY UNIQUE," +
                       " PASSWD        VARCHAR(20)     NOT NULL, " + 
                       " SCORE     INTEGER NOT NULL)";
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Table created successfully");
  }
   
  public static void insertDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:BIteBeat.sqlite");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully_insert");
 
          stmt = c.createStatement();
          String sql = "INSERT INTO testdb (ID,PASSWD,SCORE) " +
                       "VALUES ('tjdus', '123', 78014)," +
                       " ('zzeon', '456',68192);"; 
          stmt.executeUpdate(sql);
          stmt.close();
          c.commit();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Records created successfully");
  }
   
  public static void selectDB()
  {
        Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:BiteBeat.sqlite");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully_select");
 
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM testdb;" );
          while ( rs.next() ) {
             String id = rs.getString("id");
             String passwd=rs.getString("passwd");
             int score = rs.getInt("score");
             System.out.println( "ID : " + id );
             System.out.println( "PASSWD : " + passwd );
             System.out.println( "SCORE : " + score );
             System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");  
  }
   
  public static void updateDB()
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:BiteBeat.sqlite");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully_update");
 
      stmt = c.createStatement();
      String sql = "UPDATE user_info set message = 'This is updated by updateDB()' where ID=zzeon;";
      stmt.executeUpdate(sql);
      c.commit();
 
      ResultSet rs = stmt.executeQuery( "SELECT * FROM testdb;" );
      while ( rs.next() ) {
          String id = rs.getString("id");
          String passwd=rs.getString("passwd");
          int score = rs.getInt("score");
          System.out.println( "ID : " + id );
          System.out.println( "PASSWD : " + passwd );
          System.out.println( "SCORE : " + score );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
   
  public static void deleteDB()
  {
      Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:BiteBeat.sqlite");
          c.setAutoCommit(false);
          System.out.println("Opened database successfully_delect");
 
          stmt = c.createStatement();
          String sql = "DELETE from testdb where ID=1 or ID=2;";
          stmt.executeUpdate(sql);
          c.commit();
 
          ResultSet rs = stmt.executeQuery( "SELECT * FROM testdb;" );
          while ( rs.next() ) {
              String id = rs.getString("id");
              String passwd=rs.getString("passwd");
              int score = rs.getInt("score");
              System.out.println( "ID : " + id );
              System.out.println( "PASSWD : " + passwd );
              System.out.println( "SCORE : " + score );
             System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");
  }
}