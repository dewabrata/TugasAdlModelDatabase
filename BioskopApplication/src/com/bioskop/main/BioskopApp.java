package com.bioskop.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bioskop.main.dao.FilmDaoImplementation;
import com.bioskop.main.model.FilmModel;
import com.bioskop.main.utility.DatabaseConnection;


public class BioskopApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
		     FilmModel film = new FilmModel();
		     film.setFilmName("Beranak dalam Kardus");
		     film.setCategory("Horror");
		     film.setSubTitle("Sunda");
		     
		     FilmDaoImplementation filmDao = new FilmDaoImplementation();
		     filmDao.save(film);
		     
		     
		     List <FilmModel> lstFilm = filmDao.getAll();
		     
		     
		     for (FilmModel filmModel : lstFilm) {
				System.out.print(filmModel.getFilmId() +" | " +  filmModel.getFilmName()+" | " +  filmModel.getCategory()+" | " +  filmModel.getSubTitle());
				System.out.println();
			}
		     
		    FilmModel updateFilm = new FilmModel();
		    updateFilm.setFilmId(6);
		    updateFilm.setFilmName("Suzanna");
		    updateFilm.setCategory("Horror");
		    updateFilm.setSubTitle("Indonesia");
		    filmDao.update(updateFilm); 
		    
		    
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//st.execute("drop database dewa" );
	}

}
