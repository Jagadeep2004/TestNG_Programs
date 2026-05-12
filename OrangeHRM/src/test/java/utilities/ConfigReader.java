package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        prop = new Properties();

        try {

            FileInputStream fis =
            new FileInputStream(
            System.getProperty("user.dir")
            + "/src/test/resources/config.properties");

            prop.load(fis);

        }

        catch (IOException e) {

            e.printStackTrace();
        }
    }

    public String getBrowser() {

        return prop.getProperty("browser");
    }

    public String getURL() {

        return prop.getProperty("url");
    }

    public String getUsername() {

        return prop.getProperty("username");
    }

    public String getPassword() {

        return prop.getProperty("password");
    }
    
    public String getInvalidUsername() {

        return prop.getProperty("invalidUsername");
    }

    public String getInvalidPassword() {

        return prop.getProperty("invalidPassword");
    }

    public String getEmployeeFirstName() {

        return prop.getProperty("employeeFirstName");
    }

    public String getEmployeeLastName() {

        return prop.getProperty("employeeLastName");
    }

    public String getEmployeeSearchName() {

        return prop.getProperty("employeeSearchName");
    }
    
    public String getInvalidEmployeeName() {

        return prop.getProperty("invalidEmployeeName");
    }
}