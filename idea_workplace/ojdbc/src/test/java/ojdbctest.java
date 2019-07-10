import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ojdbctest {
    @Test
    public void  testJdbc(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.10:1521:orcl", "scott", "tiger");
            CallableStatement cstm = conn.prepareCall("{call proc_countyearsal(?,?)}");
            cstm.setInt(1,7839);
            cstm.registerOutParameter(2, OracleTypes.NUMBER);
            cstm.execute();
            System.out.println(cstm.getObject(2));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
