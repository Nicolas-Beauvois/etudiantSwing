package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import fr.formation.afpa.model.Etudiant;
import fr.formation.afpa.service.EtudiantService;
import fr.formation.afpa.service.IEtudiantService;

/**
 * Hello world!
 *
 */
public class FrameDemo extends JFrame implements WindowListener {
	private IEtudiantService service = new EtudiantService();

	public static void main(String[] args) {
		FrameDemo fd = new FrameDemo();

	}

	public FrameDemo() {// Initialisation première fenêtre

		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.setTitle("Liste des étudiants");

		JPanel pBouton = new JPanel();
		JPanel pAcc = new JPanel();

		JMenuBar menu = new JMenuBar();

		JMenu etudiant = new JMenu("Etudiant");

		JMenuItem ajoutEtudiant = new JMenuItem("Ajouter étudiant");

		JMenuItem modifierEtudiant = new JMenuItem("Modifier étudiant");

		JMenuItem importerListe = new JMenuItem("Importer liste");

		// Initialisation de la liste des étudiants sur la page d'accueil

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nom");
		model.addColumn("Prenom");
		model.addColumn("Date de naissance");
		model.addColumn("ID");

		JTable tab = new JTable(model);

		menu.add(etudiant);
		etudiant.add(ajoutEtudiant);
		etudiant.add(modifierEtudiant);
		etudiant.add(importerListe);

		BoxLayout boxlayoutAcc = new BoxLayout(pAcc, BoxLayout.Y_AXIS);
		pAcc.setLayout(boxlayoutAcc);
		f.getContentPane().add(menu, BorderLayout.NORTH);
		pAcc.add(tab);

		pAcc.add(tab.getTableHeader());
		pAcc.add(tab);
		f.getContentPane().add(pAcc);

		// Initialisation fenêtre ajout
		JFrame fAj = new JFrame();
		fAj.setSize(500, 400);
		fAj.setTitle("Ajouter un étudiant");

		JPanel pPhoto = new JPanel();
		JPanel pNom = new JPanel();
		JPanel pPrenom = new JPanel();
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

		fAj.getContentPane().add(pNom);
		fAj.getContentPane().add(pPrenom);
		fAj.getContentPane().add(pPhoto);
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

		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBackground(Color.DARK_GRAY);
		lblPhoto.setBounds(312, 51, 158, 149);
		pDateNaissance.add(lblPhoto);

		// Initialisation fenêtre modification

		JFrame fMo = new JFrame();
		fMo.setSize(521, 446);
		fMo.setTitle("Modifier étudiant");

		JPanel pPhotoMo = new JPanel();
		JPanel pNomMo = new JPanel();
		JPanel pPrenomMo = new JPanel();
		JPanel pdateNaissanceMo = new JPanel();

		JLabel photoMo = new JLabel("Photo : ");
		photoMo.setBounds(12, 8, 45, 16);
		JLabel affPhotoMo = new JLabel();
		affPhotoMo.setSize(200, 100);

		JTextField photoTmo = new JTextField(10);
		photoTmo.setLocation(12, 33);
		photoTmo.setSize(116, 22);
		pPhotoMo.setLayout(null);

		JLabel nomMo = new JLabel("Nom: ");
		nomMo.setBounds(12, 97, 35, 16);
		pPhotoMo.add(nomMo);
		JTextField nomTmo = new JTextField(10);
		nomTmo.setLocation(12, 123);
		pPhotoMo.add(nomTmo);
		nomTmo.setSize(116, 22);
		JLabel dateNaissanceMo = new JLabel("Date de naissance : ");
		dateNaissanceMo.setBounds(11, 266, 117, 16);
		pPhotoMo.add(dateNaissanceMo);
		JTextField dateNaissanceTmo = new JTextField(10);
		dateNaissanceTmo.setLocation(12, 290);
		pPhotoMo.add(dateNaissanceTmo);
		dateNaissanceTmo.setSize(116, 22);
		JLabel prenomMo = new JLabel("Prenom : ");
		prenomMo.setBounds(12, 170, 57, 16);
		pPhotoMo.add(prenomMo);
		JTextField prenomTmo = new JTextField(10);
		prenomTmo.setLocation(12, 199);
		pPhotoMo.add(prenomTmo);
		prenomTmo.setSize(116, 22);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(248, 8, 243, 213);
		pPhotoMo.add(lblNewLabel);

		pPhotoMo.add(photoMo);
		pPhotoMo.add(photoTmo);

		fMo.getContentPane().add(pPrenomMo);
		fMo.getContentPane().add(pdateNaissanceMo);
		fMo.getContentPane().add(pNomMo);
		fMo.getContentPane().add(pPhotoMo);

		// Initialisation des boutons et de leurs actions

		JButton ajouterAj = new JButton("Ajouter");
		ajouterAj.setVisible(false);
		JButton annulerAj = new JButton("Annuler");
		annulerAj.setVisible(false);
		JButton enregistrerMo = new JButton("Enregistrer");
		enregistrerMo.setVisible(false);
		JButton modifierMo = new JButton("Modifier");
		modifierMo.setVisible(false);
		JButton annulerMo = new JButton("Annuler");
		annulerMo.setVisible(false);

		JButton parcourirMo = new JButton("Parcourir");
		parcourirMo.setSize(20, 20);
		parcourirMo.setBounds(157, 47, 97, 25);

		ajouterAj.setSize(20, 20);
		annulerAj.setSize(20, 20);
		enregistrerMo.setSize(20, 20);
		modifierMo.setSize(20, 20);
		annulerMo.setSize(20, 20);

		pBouton.add(ajouterAj);
		pBouton.add(annulerAj);
		pBouton.add(enregistrerMo);
		pBouton.add(modifierMo);
		pBouton.add(annulerMo);

		pDateNaissance.setLayout(null);
		/*
		 * JButton btnModifierProfil = new JButton("Modifier le profil");
		 * btnModifierProfil .addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { Ajout f = new Ajout(); } });
		 * 
		 * btnModifierProfil .setBounds(168, 9, 97, 25);
		 * pDateNaissance.add(btnModifierProfil );
		 */

		pPhotoMo.add(photoMo);
		pPhotoMo.add(photoTmo);
		pPhotoMo.add(parcourirMo);

		// Initialistion de la fenêtre accueillant le formulaire d'ajout d'étudiant
		ajoutEtudiant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fAj.setVisible(true);

				parcourirAj.setVisible(true);

				fAj.getContentPane().add(affPhotoAj, BorderLayout.EAST);
				fAj.getContentPane().add(pBouton, BorderLayout.SOUTH);
				ajouterAj.setVisible(true);
				annulerAj.setVisible(true);
				pDateNaissance.setVisible(true);

			}
		});

		// Initialisation des boutons de la page ajouter
		ajouterAj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ID;
				model.addRow(new Object[] { nomT.getText(), prenomT.getText(), dateNaissanceT.getText(),
						(tab.getRowCount() + 1) });
				List<Etudiant> promo = new ArrayList();
				promo = service.listEtudiant();

				if (promo.size() == 0) {
					ID = 1;
				} else {
					Etudiant IDetudiant = promo.get(promo.size() - 1);
					ID = ((Etudiant) IDetudiant).getID() + 1;
				}
				Etudiant etu = new Etudiant(nomT.getText(), prenomT.getText(), dateNaissanceT.getText(), ID);
				service.ajouterEtudiant(etu);
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

		// Initialisation de la fenêtre accueillant le formulaire de modification
		tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (tab.getSelectedColumn() == 3) {
					int ID = tab.getSelectedRow();
					String nomV = (String) tab.getValueAt(ID, 0);
					String prenomV = (String) tab.getValueAt(ID, 1);
					String naissanceV = (String) tab.getValueAt(ID, 2);

					nomTmo.setText(nomV);
					prenomTmo.setText(prenomV);
					dateNaissanceTmo.setText(naissanceV);

					fMo.setVisible(true);

					photoTmo.setEditable(false);
					nomTmo.setEditable(false);
					prenomTmo.setEditable(false);
					dateNaissanceTmo.setEditable(false);

					fMo.getContentPane().add(affPhotoAj, BorderLayout.EAST);

					fMo.getContentPane().add(pBouton, BorderLayout.SOUTH);
					modifierMo.setVisible(true);
					fMo.setVisible(true);

					photoTmo.setEditable(false);
					nomTmo.setEditable(false);
					prenomTmo.setEditable(false);
					dateNaissanceTmo.setEditable(false);

					modifierMo.setVisible(true);
					ajouterAj.setVisible(false);
					annulerAj.setVisible(false);
					fMo.getContentPane().add(pBouton, BorderLayout.SOUTH);
				}

			}

		});

		modifierEtudiant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fMo.setVisible(true);

				photoTmo.setEditable(false);
				nomTmo.setEditable(false);
				prenomTmo.setEditable(false);
				dateNaissanceTmo.setEditable(false);

				fMo.getContentPane().add(affPhotoAj, BorderLayout.EAST);

				fMo.getContentPane().add(pBouton, BorderLayout.SOUTH);
				modifierMo.setVisible(true);

			}
		});

		enregistrerMo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ID = tab.getSelectedRow();
				tab.setValueAt(nomTmo.getText(), ID, 0);
				tab.setValueAt(prenomTmo.getText(), ID, 1);
				tab.setValueAt(dateNaissanceTmo.getText(), ID, 2);

				Etudiant upEtu = new Etudiant(nomTmo.getText(), prenomTmo.getText(), dateNaissanceTmo.getText(), ID);
				service.modifierEtudiant(upEtu);
				photoTmo.setEditable(false);
				prenomTmo.setEditable(false);
				dateNaissanceTmo.setEditable(false);
				nomTmo.setEditable(false);

				modifierMo.setVisible(true);
				enregistrerMo.setVisible(false);
				parcourirMo.setVisible(false);
				annulerMo.setVisible(false);

			}

		});

		modifierMo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				photoTmo.setEditable(true);
				nomTmo.setEditable(true);
				prenomTmo.setEditable(true);
				dateNaissanceTmo.setEditable(true);

				parcourirMo.setVisible(true);
				modifierMo.setVisible(false);
				enregistrerMo.setVisible(true);
				annulerMo.setVisible(true);

			}

		});

		annulerMo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				photoTmo.setText(null);
				prenomTmo.setText(null);
				nomTmo.setText(null);
				dateNaissanceTmo.setText(null);

				enregistrerMo.setVisible(false);
				parcourirMo.setVisible(false);
				annulerMo.setVisible(false);

				fMo.setVisible(false);

			}
		});

		parcourirMo.addActionListener(new ActionListener() {
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
					Image newImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
							Image.SCALE_SMOOTH);
					icon = new ImageIcon(newImg);
					lblNewLabel.setIcon(icon);
					photoTmo.setText(path);
				}
			}
		});

		importerListe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Etudiant> etudiants = service.listEtudiant();
				Object[] col = { "Nom", "Prenom", "Date de naissance", "ID" };
				
				model.fireTableRowsUpdated(0, etudiants.size());
				model.setColumnIdentifiers(col);
				Object rowData[] = new Object[4];
				for (int i = 0; i < etudiants.size(); i++) {
					Object etudiant = etudiants.get(i);
					rowData[0] = ((Etudiant) etudiant).getNom();
					rowData[1] = ((Etudiant) etudiant).getPrenom();
					rowData[2] = ((Etudiant) etudiant).getDateNaissance();
					rowData[3] = ((Etudiant) etudiant).getID();
					model.addRow(rowData);
				}
				model.fireTableDataChanged();
				tab.setModel(model);
				tab.getColumnModel().getColumn(0).setPreferredWidth(36);
				//Finalisationaa
			}

		});

		addWindowListener(this);

		f.setVisible(true);

		fAj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void decodeListe(String pathName, JTable tab) {
	}

	public void windowActivated(WindowEvent event) {
		System.out.println("The window has been activated");
	}

	public void windowClosed(WindowEvent event) {
		System.out.println("The window has been closed");
	}

	public void windowClosing(WindowEvent event) {
		System.out.println("About to close the window");
	}

	public void windowDeactivated(WindowEvent event) {
		System.out.println("The window has been deactivated");
	}

	public void windowDeiconified(WindowEvent event) {
		System.out.println("The window has been restored");
	}

	public void windowIconified(WindowEvent event) {
		System.out.println("The window has been minimized");
	}

	public void windowOpened(WindowEvent event) {
		System.out.println("The window has been opened");
	}
}
