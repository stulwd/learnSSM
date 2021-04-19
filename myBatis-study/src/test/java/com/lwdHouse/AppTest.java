package com.lwdHouse;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lwdHouse.domain.Student;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * 传统JDBC操作数据库
     * @throws SQLException
     */
    @Test
    public void test01() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> stuList = new ArrayList<Student>();
        try {
            String url = "jdbc:mysql://localhost:3306/mysql";
            String userName = "root";
            String password = "1800435836lwd";
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("Select * from study");
            while (rs.next()) {
                Student stu = new Student();
                stu.setName(rs.getString("name"));
                stu.setId(rs.getInt("id"));
                stu.setAge(rs.getInt("age"));
                stu.setSex(rs.getString("sex"));
                stuList.add(stu);
            }

            String sql = "INSERT INTO study (name, id, age, sex) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "lwd5");
            ps.setObject(2, 14024299);
            ps.setObject(3, 22);
            ps.setObject(4, "male");
            ps.executeUpdate();

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        for (Student student : stuList) {
            System.out.println(student);
        }
    }
}
