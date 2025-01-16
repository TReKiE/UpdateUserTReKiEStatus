import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet, SQLException}
import com.typesafe.config.ConfigFactory

object UpdateUserTReKiEStatus {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()
    val jdbcUrl = config.getString("db.url")
    val username = config.getString("db.username")
    val password = config.getString("db.password")

    var connection: Connection = null

    try {
      connection = DriverManager.getConnection(jdbcUrl, username, password)

      // Update suspended column to false for poor TReKiE
      val updateQuery = "UPDATE users SET suspended = ? WHERE username = ?"
      val updateStmt: PreparedStatement = connection.prepareStatement(updateQuery)
      updateStmt.setBoolean(1, false)
      updateStmt.setString(2, "TReKiE")

      val rowsAffected = updateStmt.executeUpdate()
      if (rowsAffected > 0) {
        println(s"${Colors.greenChar}User 'TReKiE' has been unsuspended!${Colors.resetChar}")
      } else {
        println(s"${Colors.yellowChar}User 'TReKiE' was not found.${Colors.resetChar}") // ?!
      }
    } catch {
      case e: SQLException if e.getErrorCode == 1045 => // 1045=access denied
        println(s"${Colors.redChar}Access denied. Please check your database credentials and permissions.${Colors.resetChar}")
        checkDefaults(jdbcUrl, username, password)
      case e: SQLException =>
        println(s"${Colors.redChar}SQL Error: ${e.getMessage}, Code: ${e.getErrorCode}${Colors.resetChar}")
        checkDefaults(jdbcUrl, username, password)
      case e: Exception =>
        println(s"${Colors.redChar}An unexpected error occurred: ${e.getMessage}${Colors.resetChar}")
        checkDefaults(jdbcUrl, username, password)
    } finally {
      if (connection != null) {
        try {
          connection.close()
        } catch {
          case e: Exception => e.printStackTrace()
        }
      }
    }
  }

  def checkDefaults(jdbcUrl: String, username: String, password: String): Unit = {
    if (jdbcUrl == "jdbc:mysql://localhost:3306/X_database_name" || username == "X_db_user" || password == "X_db_password") {
      println(s"${Colors.magentaChar}Some of the database connection values appear to be same as the reference conf, is this right?")
      println(s"Please make an application.conf with the correct values.${Colors.resetChar}")
    }
  }
}

object Colors {
  val redChar = "\u001b[31m"
  val greenChar = "\u001b[32m"
  val yellowChar = "\u001b[33m"
  val magentaChar = "\u001b[95m"
  val resetChar = "\u001b[0m"
}
