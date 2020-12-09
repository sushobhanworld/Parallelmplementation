package utility;

import java.sql.*;
import java.util.HashMap;

public class DataBaseOperations
{
    public synchronized HashMap<String, String> GetSQLResult(String sql)
    {
        HashMap<String, String> DB_map= new HashMap<>();
        try
        {
            Class.forName(SelectDB.CLASSNAME.toString());
            Connection connection= DriverManager.getConnection(SelectDB.URL.toString(), SelectDB.USERNAME.toString(), "");
            Statement statement= connection.createStatement();

            //Column value
            ResultSet resultSet= statement.executeQuery(sql);
            //Column name
            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

            //put the result in hashmap
            while(resultSet.next())
            {
                for (int i=0; i<resultSetMetaData.getColumnCount();i++)
                {
                    DB_map.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
                }
                System.out.println(DB_map);
                connection.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return DB_map;
    }
}
