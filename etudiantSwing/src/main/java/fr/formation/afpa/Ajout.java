package fr.formation.afpa;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ajout {

	Ajout() {
		JFrame fAj = new JFrame();
		fAj.setSize(500, 400);
		fAj.setTitle("Ajouter un étudiant");
		JPanel pDateNaissance = new JPanel();
		JLabel dateNaissance = new JLabel("Date de naissance : ");
		dateNaissance.setBounds(11, 259, 117, 16);
		JLabel affPhotoAj = new JLabel();
		affPhotoAj.setSize(200, 100);
		JTextField dateNaissanceT = new JTextField(10);
		dateNaissanceT.setLocation(11, 288);
		dateNaissanceT.setSize(116, 20);
		pDateNaissance.setLayout(null);
		pDateNaissance.add(dateNaissance);
		pDateNaissance.add(dateNaissanceT);
		fAj.getContentPane().add(pDateNaissance);
		
			JLabel photo = new JLabel("Photo : ");
			photo.setBounds(12, 29, 45, 16);
			pDateNaissance.add(photo);
			
				JTextField photoT = new JTextField(10);
				photoT.setLocation(12, 48);
				pDateNaissance.add(photoT);
				photoT.setSize(116, 22);
				JLabel prenom = new JLabel("Prenom : ");
				prenom.setBounds(11, 184, 57, 16);
				pDateNaissance.add(prenom);
				JTextField prenomT = new JTextField(10);
				prenomT.setLocation(11, 213);
				pDateNaissance.add(prenomT);
				prenomT.setSize(116, 22);
				JLabel nom = new JLabel("Nom: ");
				nom.setBounds(11, 97, 35, 16);
				pDateNaissance.add(nom);
				JTextField nomT = new JTextField(10);
				nomT.setLocation(11, 126);
				pDateNaissance.add(nomT);
				nomT.setSize(116, 22);
				
				JButton parcourirAj = new JButton("Parcourir");
				parcourirAj.setSize(20, 20);
				parcourirAj.setBounds(157, 47, 97, 25);
				pDateNaissance.add(parcourirAj);
				
				JButton ajouterAj = new JButton("Ajouter");
				ajouterAj.setBounds(145, 315, 97, 25);
				pDateNaissance.add(ajouterAj);
				ajouterAj.setVisible(true);
				
				JButton annulerAj = new JButton("Annuler");
				annulerAj.setBounds(275, 315, 97, 25);
				pDateNaissance.add(annulerAj);
				annulerAj.setVisible(true);
				
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(306, 33, 170, 189);
				pDateNaissance.add(panel);
				panel.setLayout(null);
				
				JLabel lblPhoto = new JLabel(" ");
				lblPhoto.setBounds(6, 18, 158, 164);
				panel.add(lblPhoto);
				
				ajouterAj.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						/*
						model.addRow(new Object[] { nomT.getText(), prenomT.getText(), dateNaissanceT.getText(),
								(tab.getRowCount() + 1) });
								*/
						photoT.setText(null);
						prenomT.setText(null);
						nomT.setText(null);
						dateNaissanceT.setText(null);
						fAj.setVisible(false);
					}
				});

				annulerAj.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						photoT.setText(null);
						prenomT.setText(null);
						nomT.setText(null);
						dateNaissanceT.setText(null);

						ajouterAj.setVisible(false);
						annulerAj.setVisible(false);
						pDateNaissance.setVisible(false);

						fAj.setVisible(false);

					}
				});

				parcourirAj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser file = new JFileChooser();
						file.setCurrentDirectory(new File(System.getProperty("user.home")));
						// filtrer les fichiers
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", ".jpg", ".png");
						file.addChoosableFileFilter(filter);
						int res = file.showSaveDialog(null);
						// si l'utilisateur clique sur enregistrer dans Jfilechooser
						if (res == JFileChooser.APPROVE_OPTION) {
							File selFile = file.getSelectedFile();
							String path = selFile.getAbsolutePath();
							ImageIcon icon = new ImageIcon(path);
							 Image img = icon.getImage();
							  Image newImg = img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
							  icon = new ImageIcon(newImg);
							  lblPhoto.setIcon(icon);

							photoT.setText(path);
						}
					}
				});
			

	}

}
