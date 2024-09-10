package ru.netology.dataaccessobject.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String sqlFileName = "findScript.sql";
    private String sqlScript;

    public CustomerOrderRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Product> getProducts(String customerName) {
        sqlScript = read(sqlFileName);
        return namedParameterJdbcTemplate.query(sqlScript,
                Collections.singletonMap("customer_name", customerName),
                (rs, rowNum) -> new Product(
                        rs.getString("product_name"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("date"),
                        rs.getInt("amount")));
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream(); BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
