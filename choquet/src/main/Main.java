package main;

import model.Treilli;
import controleur.TreilliController;

public class Main {

	public static void main(String[] args) {
		TreilliController treilliController = new TreilliController();
		Treilli treilli = treilliController.createTreilli(3);
		treilliController.showTreilli(treilli);
	}

}
