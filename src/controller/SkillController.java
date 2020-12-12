package controller;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import dao.ISkillDao;
import daoImpl.SkillDaoImpl;
import model.Skill;

public class SkillController {

	ISkillDao skDao=null;
	public SkillController() throws ClassNotFoundException,SQLException
	{
		skDao=new SkillDaoImpl();
	}
	
	public Skill addSkill()  
	{
		Skill sk=new Skill();
		try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Skill Name:");
		String skill=reader.readLine();
		sk.setSkillName(skill);
		System.out.println("Enter Skill Description:");
		sk.setSkillDescription(reader.readLine());
		
		if(skill.equals("Presentation"))
		{
			sk.setActive("Active");
		}
		else
		{
			sk.setActive("Deactive");
		
		}
		skDao.addSkill(sk);
		
	}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		return sk;
		
}
	public void getAllSkills()
	{
		List<Skill> allSkillList=skDao.getAllSkills();
		for(Skill sk:allSkillList)
		{
			System.out.println(sk);
		}
		
	}
		public void getSkillById()
		{
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter the SkillId whose record you want to access:");
				id=Integer.parseInt(reader.readLine());
				Skill sk=skDao.getSkillById(id);
				System.out.println(sk);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void updateSkill() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter the SkillId whose record you want to update:");
				id=Integer.parseInt(reader.readLine());
				Skill sk=skDao.getSkillById(id);
				skDao.updateSkill(sk);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void deactivateSkill() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter the SkillId whose record you want to deactivate:");
				id=Integer.parseInt(reader.readLine());
				Skill sk=skDao.getSkillById(id);
				skDao.deactivateSkill(sk);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		public void deleteSkill() {
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				int id;
				System.out.println("Enter the SkillId whose record you want to delete:");
				id=Integer.parseInt(reader.readLine());
				skDao.deleteSkill(id);
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}

		
		
}