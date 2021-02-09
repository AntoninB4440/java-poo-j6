package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.exceptions.MaxNegatifException;
import fr.diginamic.recensement.exceptions.MaxStringException;
import fr.diginamic.recensement.exceptions.MinNegatifException;
import fr.diginamic.recensement.exceptions.MinStringException;
import fr.diginamic.recensement.exceptions.MinSuperiorMaxException;
import fr.diginamic.recensement.exceptions.NoDepartementFoundException;
import fr.diginamic.recensement.exceptions.RecensementExceptions;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws MinStringException
	 * @throws MaxStringException
	 * @throws MinNegatifException
	 * @throws MaxNegatifException
	 * @throws MinSuperiorMaxException
	 * @throws NoDepartementFoundException
	 * @throws RecensementExceptions
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws RecensementExceptions;
}
