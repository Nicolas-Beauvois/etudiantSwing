package fr.formation.afpa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

/**
 * Hello world!
 *
 */
public class FrameDemo extends JFrame implements WindowListener {
	public static void main(String[] args) {
		FrameDemo fd = new FrameDemo();

	}

	public FrameDemo() {
		super("Frame Demo");
		// Initialisation des components
		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.setTitle("Liste des étudiants");

		JFrame fAj = new JFrame();
		fAj.setSize(500, 400);
		fAj.setTitle("Ajouter un étudiant");

		JFrame fMo = new JFrame();
		fMo.setSize(500, 400);
		fMo.setTitle("Modifier étudiant");

		JPanel pBouton = new JPanel();
		JPanel pAcc = new JPanel();
		JPanel pPhoto = new JPanel();
		JPanel pNom = new JPanel();
		JPanel pPrenom = new JPanel();
		JPanel pDateNaissance = new JPanel();

		JPanel pPhotoMo = new JPanel();
		JPanel pNomMo = new JPanel();
		JPanel pPrenomMo = new JPanel();
		JPanel pDateNaissanceMo = new JPanel();

		JMenuBar menu = new JMenuBar();

		JMenu etudiant = new JMenu("Etudiant");

		JMenuItem ajoutEtudiant = new JMenuItem("Ajouter étudiant");
		JMenuItem listEtudiant = new JMenuItem("Liste étudiant");
		JMenuItem modifierEtudiant = new JMenuItem("Modifier étudiant");

		JLabel photo = new JLabel("Photo : ");
		JLabel nom = new JLabel("Nom: ");
		JLabel prenom = new JLabel("Prenom : ");
		JLabel dateNaissance = new JLabel("Date de naissance : ");
		

		JLabel photoMo = new JLabel("Photo : ");
		JLabel nomMo = new JLabel("Nom: ");
		JLabel prenomMo = new JLabel("Prenom : ");
		JLabel dateNaissanceMo = new JLabel("Date de naissance : ");

		JTextField photoT = new JTextField(10);
		photoT.setSize(20, 20);
		JTextField nomT = new JTextField(10);
		nomT.setSize(20, 20);
		JTextField prenomT = new JTextField(10);
		prenomT.setSize(20, 20);
		JTextField dateNaissanceT = new JTextField(10);
		dateNaissanceT.setSize(10, 20);

		JTextField photoTmo = new JTextField(10);
		photoT.setSize(20, 20);
		JTextField nomTmo = new JTextField(10);
		nomT.setSize(20, 20);
		JTextField prenomTmo = new JTextField(10);
		prenomT.setSize(20, 20);
		JTextField dateNaissanceTmo = new JTextField(10);
		dateNaissanceT.setSize(10, 20);

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
		JButton parcourirAj = new JButton("Parcourir");
		parcourirAj.setVisible(false);
		JButton parcourirMo = new JButton("Parcourir");
		parcourirMo.setVisible(false);
		JFileChooser parcourPhoto = new JFileChooser();

		ajouterAj.setSize(20, 20);
		annulerAj.setSize(20, 20);
		parcourirAj.setSize(20, 20);
		enregistrerMo.setSize(20, 20);
		modifierMo.setSize(20, 20);
		annulerMo.setSize(20, 20);
		parcourirMo.setSize(20, 20);

		// Initialisation de la liste des étudiants
		String[] donnees = { "Nom", "Prenom", "Date de naissance", "ID" };

		Object[][] arrEtu = { { "Petit", "Nicolas", new Integer(1997), new Integer(1) },
				{ "Paddle", "Kid", new Integer(1999), new Integer(2) },
				{ "Zep", "Titeuf", new Integer(2001), new Integer(3) }, };

		JTable tab = new JTable(arrEtu, donnees);
		tab.setVisible(false);

		// Agencement page d'accueil avec liste

		menu.add(etudiant);
		etudiant.add(ajoutEtudiant);
		etudiant.add(listEtudiant);
		etudiant.add(modifierEtudiant);

		BoxLayout boxlayoutAcc = new BoxLayout(pAcc, BoxLayout.Y_AXIS);
		pAcc.setLayout(boxlayoutAcc);
		f.add(menu, BorderLayout.NORTH);
		pAcc.add(tab);

		pAcc.add(tab.getTableHeader());
		pAcc.add(tab);
		f.add(pAcc);

		pBouton.add(ajouterAj);
		pBouton.add(annulerAj);
		pBouton.add(enregistrerMo);
		pBouton.add(modifierMo);
		pBouton.add(annulerMo);

		pPhoto.add(photo);
		pPhoto.add(photoT);
		pPhoto.add(parcourirAj);
		pNom.add(nom);
		pNom.add(nomT);
		pPrenom.add(prenom);
		pPrenom.add(prenomT);
		pDateNaissance.add(dateNaissance);
		pDateNaissance.add(dateNaissanceT);

		pPhotoMo.add(photoMo);
		pPhotoMo.add(photoTmo);
		pPhotoMo.add(parcourirMo);
		pNomMo.add(nomMo);
		pNomMo.add(nomTmo);
		pPrenomMo.add(prenomMo);
		pPrenomMo.add(prenomTmo);
		pDateNaissanceMo.add(dateNaissanceMo);
		pDateNaissanceMo.add(dateNaissanceTmo);

		// Initialistion de la fenêtre accueillant le formulaire d'ajout d'étudiant
		ajoutEtudiant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fAj.setVisible(true);
				JPanel boxAj = new JPanel();
				BoxLayout boxlayoutAj = new BoxLayout(boxAj, BoxLayout.Y_AXIS);

				boxAj.setLayout(boxlayoutAj);

				boxAj.add(pPhoto);
				boxAj.add(pPrenom);
				boxAj.add(pNom);
				boxAj.add(pDateNaissance);

				
				fAj.add(boxAj);
				
				fAj.add(pBouton, BorderLayout.SOUTH);
				ajouterAj.setVisible(true);
				annulerAj.setVisible(true);
				parcourirAj.setVisible(true);

			}
		});

		parcourirAj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parcourPhoto.showOpenDialog(photoT);

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
				parcourirAj.setVisible(false);

			fAj.setVisible(false);
				
				

			}
		});

		listEtudiant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tab.setVisible(true);

			}
		});

		modifierEtudiant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fMo.setVisible(true);
				JPanel boxMo = new JPanel();
				BoxLayout boxlayoutMo = new BoxLayout(boxMo, BoxLayout.Y_AXIS);

				String imgUrl="C:\\Users\\afpa\\Documents\\Fichier IO\\test\\iconEtudiant.png";
			     ImageIcon icone = new ImageIcon(imgUrl);
			     
			     JLabel affPhoto = new JLabel(icone);
			     
				boxMo.setLayout(boxlayoutMo);

				boxMo.add(pPhotoMo);
				boxMo.add(pNomMo);
				boxMo.add(pPrenomMo);
				boxMo.add(pDateNaissanceMo);

				photoTmo.setEditable(false);
				nomTmo.setEditable(false);
				prenomTmo.setEditable(false);
				dateNaissanceTmo.setEditable(false);

				fMo.add(affPhoto, BorderLayout.EAST);
				fMo.add(boxMo);
				fMo.add(pBouton, BorderLayout.SOUTH);
				modifierMo.setVisible(true);

			}
		});

		modifierMo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				photoTmo.setEditable(true);
				prenomTmo.setEditable(true);
				dateNaissanceTmo.setEditable(true);

				parcourirMo.setVisible(true);
				modifierMo.setVisible(false);
				enregistrerMo.setVisible(true);
				annulerMo.setVisible(true);

			}

		});

		enregistrerMo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				photoTmo.setEditable(false);
				prenomTmo.setEditable(false);
				dateNaissanceTmo.setEditable(false);
				
				modifierMo.setVisible(true);
				enregistrerMo.setVisible(false);
				parcourirMo.setVisible(false);
				annulerMo.setVisible(false);

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

		addWindowListener(this);

		f.setVisible(true);

		fAj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
