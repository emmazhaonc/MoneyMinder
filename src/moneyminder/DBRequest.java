package moneyminder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Igor Klekotnev on 19.09.15.
 */
public class DBRequest {
    static Connection c = null;
    static Statement stmt = null;
    static String request = "";
    static Object[] result;
    static Integer count = 0;

    DBRequest(String request) {
        this.request = request;
    }
    public static void setValue() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:moneyMinder.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = request;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.exit(0);
        }
    }

    public static Object[] getRowValues() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:moneyMinder.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(request);
            while (rs.next()) {
                result = new Object[] {
                         rs.getString("HEADER"), rs.getInt("PERCENTAGE"), rs.getInt("CUTTING"),
                         rs.getInt("GATHERING"), rs.getFloat("CUT_PRICE"), rs.getFloat("GAT_PRICE"), rs.getFloat("PAID"),
                         rs.getDate("PAID_DATE"), rs.getString("CUSTOMER"), rs.getString("PERFORMER"), rs.getDate("START"),
                         rs.getDate("DEADLINE"), rs.getDate("SOFTLINE"), rs.getString("NOTES")
                };
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return result;
    }
    public static Integer getRowsCount() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:moneyMinder.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(request);

            rs.next();
            count = rs.getInt("rowcount") ;
            rs.close() ;

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return count;
    }
}
