package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO{
	 public List<Player> getAllPlayers() throws ClassNotFoundException, IOException, SQLException{
		 List<Player>list = new ArrayList<Player>();
		 Connection con = ConnectionManager.getConnection();
		 SkillDAO skilldao = new SkillDAO();
		 Skill skill;
		 String sql="SELECT * FROM PLAYER";
		 PreparedStatement st = con.prepareStatement(sql);
		 ResultSet rs = st.executeQuery(sql);
		 while(rs.next()) {
			 skill=skilldao.getSkillByID(rs.getLong(4));
			 Player player=new Player(rs.getLong(1),rs.getString(2),rs.getString(3),skill);
			 list.add(player);
		 }
		 con.close();
		 return list;
	 }
}















