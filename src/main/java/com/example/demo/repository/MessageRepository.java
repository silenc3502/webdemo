package com.example.demo.repository;

import com.example.demo.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.ZonedDateTime.now;

@Repository
public class MessageRepository {
    private final static Logger log = LoggerFactory.getLogger(MessageRepository.class);

    private SessionFactory sessionFactory;

    // private DataSource dataSource;

    public MessageRepository(DataSource dataSource, SessionFactory sessionFactory) {
        // this.dataSource = dataSource;
        this.sessionFactory = sessionFactory;
    }

    public Message saveMessage(Message message) {
        Session session = sessionFactory.openSession();
        session.save(message);
        return message;
    }

    public List<Message> getMessage() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Message";
        Query<Message> query = session.createQuery(hql, Message.class);
        System.out.println(query.list());
        return query.list();
    }

    /*
    public Message saveMessage(Message message) {
        Connection c = DataSourceUtils.getConnection(dataSource);

        try {
            boolean doNot = true;
            String insertSql;
            PreparedStatement ps;

            log.info("time: " + message.getCreatedDate());
            Date curTime = message.getCreatedDate();

            if(curTime == null) {
                insertSql = "insert into messages (id, text) values (null, ?)";
                log.info("Don't do it - null!");
                doNot = false;

                ps = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, message.getText());
            } else {
                insertSql = "insert into messages (id, text, created_date) values (null, ?, ?)";
                log.info("Do it!");

                ps = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, message.getText());
                ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));
            }

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();

                if(rs.next()) {
                    int id = rs.getInt(1);

                    if(doNot == false) {
                        Date date = new Date();
                        return new Message(id, message.getText(), date);
                    } else {
                        return new Message(id, message.getText(), message.getCreatedDate());
                    }
                } else {
                    log.error("Failed to retrieve id. No row in result set");
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            log.error("Failed to save message", ex);
            try {
                c.close();
            } catch (SQLException e) {
                log.error("Failed to close connection", e);
            }
        } finally {
            DataSourceUtils.releaseConnection(c, dataSource);
        }
        return null;
    }
     */
}
