package utility;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile
{
    public static Properties properties;
    public static FileInputStream fileInputStream;
    public static String path= System.getProperty("user.dir")+"/src/main/resources/config.properties";

    public static String ReadFile(String key)
    {
        try
        {
            fileInputStream= new FileInputStream(path);
            properties= new Properties();
            properties.load(fileInputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String value= properties.getProperty(key);

        if(StringUtils.isEmpty(value))
        {
            try
            {
                throw new Exception("Value is not specified for key: "+key+ " in properties file.");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return value;
    }
}
