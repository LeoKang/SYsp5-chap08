package com.example.sp5_chap08.spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);

        return count;
    }

    public Member selectByEmail(String email) {
        return null;
    }

    public void insert(Member member) {

    }

    public void update(Member member) {

    }

    public List<Member> selectAll() {
        List<Member> result = jdbcTemplate.query("select * from MEMBER", new RowMapper<Member>() {

            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member(
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("NAME"),
                        rs.getTimestamp("REGDATE").toLocalDateTime());
                member.setId(rs.getLong("ID"));
                return member;
            }
        });

        return result;
    }
}
