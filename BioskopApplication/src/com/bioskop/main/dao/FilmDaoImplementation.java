package com.bioskop.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bioskop.main.model.FilmModel;
import com.bioskop.main.model.Model;
import com.bioskop.main.utility.DatabaseConnection;

public class FilmDaoImplementation implements DaoInterfaces<FilmModel> {
	
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int save(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into film(film_name,category,sub_title) values (?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, model.getFilmName());
		ps.setString(2, model.getCategory());
		ps.setString(3, model.getSubTitle());
		int result = ps.executeUpdate();
		
		return result;
	}

	@Override
	public void delete(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from film where film_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
	
		ps.setInt(1, model.getFilmId());
	
		ps.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from film where film_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.executeUpdate();
	}

	@Override
	public void update(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update film set film_name = ? ,  category = ?,  sub_title = ?  where film_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, model.getFilmName());
		ps.setString(2, model.getCategory());
		ps.setString(3, model.getSubTitle());
		ps.setInt(4, model.getFilmId());
		
		ps.executeUpdate();
	}

	@Override
	public FilmModel getById(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = " select * from film where film_id =?";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, model.getFilmId());
		ResultSet rs = ps.executeQuery();
		
		FilmModel filmModel = new FilmModel();
		
		while(rs.next()) {
			filmModel.setFilmId(rs.getInt("film_id"));
			filmModel.setFilmName(rs.getString("film_name"));
			filmModel.setCategory(rs.getString("category"));
			filmModel.setSubTitle(rs.getString("sub_title"));
			
			
		}
		
		
		return filmModel;
	}

	@Override
	public FilmModel getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = " select * from film where film_id =?";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		FilmModel filmModel = new FilmModel();
		
		while(rs.next()) {
			filmModel.setFilmId(rs.getInt("film_id"));
			filmModel.setFilmName(rs.getString("film_name"));
			filmModel.setCategory(rs.getString("category"));
			filmModel.setSubTitle(rs.getString("sub_title"));
			
			
		}
		
		
		return filmModel;
	}

	@Override
	public List<FilmModel> getAll() throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String query = " select * from film";
		PreparedStatement ps = con.prepareStatement(query);
		
		
		ResultSet rs = ps.executeQuery();
		
		List<FilmModel> lstFilm = new ArrayList<FilmModel>();
		
		while(rs.next()) {
			FilmModel filmModel = new FilmModel();
			filmModel.setFilmId(rs.getInt("film_id"));
			filmModel.setFilmName(rs.getString("film_name"));
			filmModel.setCategory(rs.getString("category"));
			filmModel.setSubTitle(rs.getString("sub_title"));
			lstFilm.add(filmModel);
			
		}
		
		
		return (lstFilm);
	}

}
