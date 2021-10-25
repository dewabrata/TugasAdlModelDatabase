package com.bioskop.main.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.bioskop.main.dao.FilmDaoImplementation;
import com.bioskop.main.model.FilmModel;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FilmForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;

	private JTextField txtFilmName;
	private JTextField txtFilmCategory;
	private JTextField txtFilmSubtitle;
	private JPanel panel_1;
	private JButton btnSave;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private FilmDaoImplementation fd ;


	public void setUpForm() {
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JLabel lblNewLabel = new JLabel("Film Name");
		panel_2.add(lblNewLabel);
		
		panel_5 = new JPanel();
		panel_2.add(panel_5);
		txtFilmName = new JTextField();
		panel_2.add(txtFilmName);
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		panel_9 = new JPanel();
		panel_3.add(panel_9);
		
		
		JLabel lbl2 = new JLabel("Film Category");
		panel_3.add(lbl2);
		
		panel_6 = new JPanel();
		panel_3.add(panel_6);
		txtFilmCategory = new JTextField();
		panel_3.add(txtFilmCategory);
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		panel_10 = new JPanel();
		panel_4.add(panel_10);
		
		JLabel lbl3 = new JLabel("Film Subtitle");
		panel_4.add(lbl3);
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		
		panel_7 = new JPanel();
		panel_4.add(panel_7);
		txtFilmSubtitle = new JTextField();
		panel_4.add(txtFilmSubtitle);
		lbl3.setLabelFor(txtFilmSubtitle);
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				saveData();
				
				
			}
		});
		panel_1.add(btnSave, BorderLayout.EAST);
	}
	
	public void setupData() {
		Vector lstLabel = new Vector();
		lstLabel.add("Film Id");
		lstLabel.add( "Film Name");
		lstLabel.add("Category");
		lstLabel.add("Subtitle");
		
		
		 fd = new FilmDaoImplementation();
		try {
		Vector lstData = new Vector();
		for (FilmModel model : fd.getAll()) {
			
			Vector tempData = new Vector();
			
			tempData.add(model.getFilmId());
			tempData.add(model.getFilmName());
			tempData.add(model.getCategory());
			tempData.add(model.getSubTitle());
			lstData.add(tempData);
			
		}
		
		table = new JTable(lstData,lstLabel);
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		JScrollPane scroll = new JScrollPane(table);
		
		
		 
		
		contentPane.add(scroll, BorderLayout.SOUTH);
	}
	
	
	public void resetTable() {
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		 fd = new FilmDaoImplementation();
			try {
			
			for (FilmModel model : fd.getAll()) {
				
				Vector tempData = new Vector();
				
				tempData.add(model.getFilmId());
				tempData.add(model.getFilmName());
				tempData.add(model.getCategory());
				tempData.add(model.getSubTitle());
				
				tableModel.addRow(tempData);
				
			}
		
			}catch (Exception e) {
				// TODO: handle exception
			}
		table.setModel(tableModel);
		
	}
	
	
	public void saveData() {
		
		FilmModel fm = new FilmModel();
		fm.setFilmName(txtFilmName.getText());
		fm.setCategory(txtFilmCategory.getText());
		fm.setSubTitle(txtFilmSubtitle.getText());
		try {
			fd.save(fm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resetTable();
		
	}
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public FilmForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 752);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		setUpForm();
		setupData();
		
		
		
		
	}

}
