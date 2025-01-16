# UpdateUserTReKiEStatus
A scala project.  Modifies a MySQL database to unsuspend a user named TReKiE.

## Getting started
### Install requirements
1.  If a MySQL server is not available, install a [MySQL server on the local machine](https://dev.mysql.com/downloads/mysql/).
2.  If not installed, install the [Java JDK](https://www.oracle.com/java/technologies/downloads/)[^1].
3.  If not installed, install [Scala](https://www.scala-lang.org/download/)[^2].
4.  If not installed, install [sbt](https://www.scala-sbt.org/download)[^3].
5.  If intending to clone the repo and not already installed, install [Git](https://git-scm.com/downloads)[^4].

### Set up the environment
1.  Close and reopen your terminal if anything had to be installed.
2.  Clone the repo (`git clone https://github.com/TReKiE/UpdateUserTReKiEStatus`) or extract a zipped release to a directory/folder.
3.  In a terminal, navigate to the UpdateUserTReKiEStatus directory/folder.
4.  Initialize the database by running the included InitUsersDB.sql as SQL root user (`mysql -u root -p < InitUsersDB.sql`)[^5].
5.  If your MySQL server/instance needs to be configured, copy `src\main\resources\reference.conf` to `src\main\resources\application.conf` and edit application.conf in your preferred editor.

### Run the project!
1.  Run `sbt run` from the project directory/folder.

[^1]: On Windows, run `winget install Oracle.JDK.23` from the Terminal
[^2]: On Windows, run `winget install scala` from the Terminal
[^3]: On Windows, run `winget install sbt.sbt` from the Terminal
[^4]: On Windows, run `winget install git.git` from the Terminal
[^5]: You may need to add the MySQL binary/executable to PATH or adjust command accordingly
