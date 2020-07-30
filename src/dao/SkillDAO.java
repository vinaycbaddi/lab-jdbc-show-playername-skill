package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
	public Skill getSkillByID(Long id) throws ClassNotFoundException, IOException, SQLException {
		Connection con = ConnectionManager.getConnection();
		Skill skill = null;
		String sql ="SELECT * FROM SKILL";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			if(id.equals(rs.getLong(1))) {
				skill= new Skill(rs.getLong(1),rs.getString(2));
			}
		}
		return skill;
	}
}
