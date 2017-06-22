package kr.co.hyeonyoung.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Wrapper;

import javax.sql.CommonDataSource;

import org.springframework.context.annotation.Bean;

public interface DataSource extends CommonDataSource, Wrapper{
	Connection getConnection() throws SQLException;
}
