package JavaClass;

import org.junit.Test;

import java.util.StringJoiner;

public class Main {
    @Test
    public void test1(){
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }
    static String buildInsertSql(String table, String[] fields) {
       StringBuilder insert = new StringBuilder();
        String field = String.join(", ", fields);
        insert.append("INSERT ");
        insert.append("INTO ");
        insert.append(table);
        insert.append(" (");
        insert.append(field);
        insert.append(") ");
        insert.append("VALUES (?, ?, ?)");
        return insert.toString();
    }

    @Test
    public void test2(){
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    static String buildSelectSql(String table, String[] fields) {
        var sql =new StringJoiner(", ","SELECT "," FROM "+table);
        for(String field:fields){
            sql.add(field);
        }
        return sql.toString();
    }
}
