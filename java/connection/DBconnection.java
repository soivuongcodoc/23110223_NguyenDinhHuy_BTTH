package connection;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBconnection {
	private final String serverName = "DESKTOP-SR8T0FK\\SQLEXPRESS";
	private final String dbName = "";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "23110223";
	public Connection getConnection() throws Exception {
		String url =
		"jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber +
		";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
		if (instance == null || instance.trim().isEmpty())
		url =
		"jdbc:sqlserver://"+serverName+":"+portNumber
		+";databaseName="+dbName+ ";encrypt=true;trustServerCertificate=true;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
		}
	public static void main(String[] args) {
		try {
		System.out.println(new DBconnection().getConnection());
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
