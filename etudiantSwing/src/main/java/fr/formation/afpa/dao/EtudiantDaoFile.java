package fr.formation.afpa.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.formation.afpa.model.Etudiant;

public class EtudiantDaoFile implements IEtudiantDao {
	private String pathName = "liste.txt";

	public List<Etudiant> getAll() {
		List<Etudiant> list = new ArrayList<Etudiant>();
		try {

			File fich = new File(pathName);
			if (!fich.exists()) {
				fich.createNewFile();
			} else {
				if (!(fich.length() == 0)) {
					InputStream os = new FileInputStream(pathName);
					ObjectInputStream oos = new ObjectInputStream(os);

					list = (List<Etudiant>) oos.readObject();

					oos.close();
				}
				return list;

			}
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;

	}

	public void add(Etudiant e) {
		List<Etudiant> list = getAll();
		try {
			OutputStream os = new FileOutputStream(pathName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			list.add(e);
			System.out.println("Le fichier a bien été créé" + list);
			oos.writeObject(list);

			oos.close();

		} catch (FileNotFoundException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		} catch (IOException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		}

	}

	public Etudiant update(Etudiant e) {

		List<Etudiant> list = getAll();
		int emplacement = e.getUID() - 1;
		list.remove(emplacement);
		list.add(emplacement, e);
		

		try {
			OutputStream os = new FileOutputStream(pathName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.close();
			System.out.println("La liste a bien été mise à  jour " + list);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return e;

	}

}
