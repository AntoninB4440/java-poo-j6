package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.MaxNegatifException;
import fr.diginamic.recensement.exceptions.MaxStringException;
import fr.diginamic.recensement.exceptions.MinNegatifException;
import fr.diginamic.recensement.exceptions.MinStringException;
import fr.diginamic.recensement.exceptions.MinSuperiorMaxException;
import fr.diginamic.recensement.exceptions.NoDepartementFoundException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws MinStringException, MaxStringException,
			MinNegatifException, MaxNegatifException, MinSuperiorMaxException, NoDepartementFoundException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
//		if (!scanner.hasNextInt()) {
//			throw new MaxStringException("PLease enter a number for max population value");
//		}

		String saisieMin = scanner.nextLine();
		if (!NumberUtils.isCreatable(saisieMin)) {
			throw new MinStringException("PLease enter a number for min population value");
		}
		int min = Integer.parseInt(saisieMin) * 1000;

		if (min < 0) {
			throw new MinNegatifException("Please enter a positive minimum value");
		}

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		if (!scanner.hasNextInt()) {
			throw new MaxStringException("PLease enter a number for max population value");
		}

		String saisieMax = scanner.nextLine();

		int max = Integer.parseInt(saisieMax) * 1000;

		if (max < 0) {
			throw new MaxNegatifException("Please enter a positive maximum value");
		}

		if (min > max) {
			throw new MinSuperiorMaxException("Your min value is superior to your max value");
		}

		boolean depFound = false;

		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				depFound = true;
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}

		if (!depFound) {
			throw new NoDepartementFoundException("No departement found with this code");
		}
	}

}
