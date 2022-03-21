package dao;

import java.util.List;

import model.Profissional;

public interface CRUDPRO {
	
	public static void create(Profissional profissional) {};
	public static void delete(int profissionalId) {};
	
	public static List<Profissional>	find(String pesquisa){return null;}
	public static Profissional findByPk(int profissionalId) {return null;}
	public static void update(Profissional profissional) {}
	}


