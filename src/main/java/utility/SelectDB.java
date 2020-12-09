package utility;

public enum SelectDB
{
    CLASSNAME
            {
                @Override
                public String toString() {
                    return "com.mysql.cj.jdbc.Driver";
                }
            },
    URL
            {
                @Override
                public String toString() {
                    return "jdbc:mysql://localhost:3306/qdpm_qa?serverTimezone=UTC";
                }
            },
    USERNAME
            {
                @Override
                public String toString() {
                    return "root";
                }
            }
}
