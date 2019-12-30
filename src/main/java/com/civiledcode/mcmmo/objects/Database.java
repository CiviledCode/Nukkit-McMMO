package com.civiledcode.mcmmo.objects;

import com.civiledcode.mcmmo.Main;

import java.io.File;
import java.sql.*;

public class Database {

    private String url;
    private Connection connection;

    public Database(String name) {
        url = Main.getInstance().getDataFolder().getAbsolutePath() + File.separator + name + ".db";
        try {
            Class.forName("org.sqlite.JDBC");
            new File(url).createNewFile();
            connection = DriverManager.getConnection("jdbc:sqlite:" + url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeSelect(String query) {
        ResultSet set = null;
        try {
            Statement stmt = connection.createStatement();
            set = stmt.executeQuery(query);
            stmt.close();
        } catch(SQLException e) {
            return null;
        }
        return set;
    }

    public int getInt(String query, String name) {
        try {
            if (!connection.isClosed()) {
                Statement stmt = connection.createStatement();
                ResultSet set = stmt.executeQuery(query);
                if(set.isClosed()) {
                    Main.getInstance().getLogger().info("Unexpected dropped query. This is not an error");
                    return -1;
                }
                int p = set.getInt(name);
                stmt.close();
                return p;
            }
        } catch(SQLException e) {
            return -1;
        }
        return -1;
    }

}
