package controller;
import model.Player;
import java.io.BufferedReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.PlayerDAO;
import dao.SkillDAO;
import jdk.internal.org.jline.utils.InputStreamReader;
import model.Skill;
import utility.ConnectionManager;
class Main{
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner in = new Scanner(System.in);
		SkillDAO skilldao= new SkillDAO();
		PlayerDAO playerdao = new PlayerDAO();
		List<Player>list=new ArrayList<Player>();
		System.out.println("Enter the Skill ID");
		long id = Long.parseLong(in.nextLine());
		Skill skill=skilldao.getSkillByID(id);
		System.out.println("Skill_Id:"+skill.getSkillId()+" "+"Skill_Name:"+skill.getSkillName());
		
		list=playerdao.getAllPlayers();
		for (Player p : list) {
			System.out.println(p.getPlayerId()+" "+p.getName()+" "+p.getCountry()+" "+p.getSkill().getSkillName());
		}
	}
}
