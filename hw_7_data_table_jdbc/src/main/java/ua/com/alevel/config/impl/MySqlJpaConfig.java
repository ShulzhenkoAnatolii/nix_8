package ua.com.alevel.config.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.DataSourceProperty;
import ua.com.alevel.config.JpaConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class MySqlJpaConfig implements JpaConfig {

    private Statement statement;
    private Connection connection;

    private final DataSourceProperty dataSourceProperty;

    public MySqlJpaConfig(DataSourceProperty dataSourceProperty) {
        this.dataSourceProperty = dataSourceProperty;
    }

    @Override
    public void connect() {
        try {
            Class.forName(dataSourceProperty.getDriverClassName());
            connection = DriverManager.getConnection(
                    dataSourceProperty.getUrl(),
                    dataSourceProperty.getUsername(),
                    dataSourceProperty.getPassword()
            );
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Statement getStatement() {
        return statement;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
