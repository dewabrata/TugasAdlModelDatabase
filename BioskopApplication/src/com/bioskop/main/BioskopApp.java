package com.bioskop.main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bioskop.main.dao.FilmDaoImplementation;
import com.bioskop.main.model.FilmModel;
import com.bioskop.main.utility.DatabaseConnection;
import com.bioskop.main.view.FilmForm;


public class BioskopApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilmForm frame = new FilmForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
