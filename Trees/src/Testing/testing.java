package Testing;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;

import Database.BinaryTree;
import Database.Game;
import Database.GameList;
import Database.Trophy;
import Database.User;

public class testing {

	public static void main(String[] args) {
		
			BinaryTree bt = new BinaryTree();
			User root = bt.root;
		  
		  Game massEffect, persona, yooka, yooka2, prey, prey2, prey3, crash, crash2;
			GameList gl1, gl2, gl3, gl4;

			Calendar c;
			Trophy massEffectT1, massEffectT2, personaT1, personaT2, personaT3, yookaT1, preyT1, preyT2, preyT3, preyT4, preyT5,
					crashT1, crashT2;

			ArrayList<Trophy> tl1, tl2, tl3, tl4, tl5;

			Calendar dob;
			
			User oberon, pippin, medraut, astaroth, lunete, guiomar, faust, sophronia, haidee, dulcinea, cosette, nelida;

		
				massEffect = new Game("Mass Effect Andromeda", new GregorianCalendar(2017, 3, 21), 56);
				persona = new Game("Persona 5", new GregorianCalendar(2017, 4, 4), 49);
				yooka = new Game("Yooka-Laylee", new GregorianCalendar(2017, 4, 11), 36);
				yooka2 = new Game("Yooka-Laylee", new GregorianCalendar(2017, 4, 11), 36);
				prey = new Game("Prey", new GregorianCalendar(2017, 5, 5), 50);
				prey2 = new Game("Prey", new GregorianCalendar(2017, 5, 5), 50);
				prey3 = new Game("Prey", new GregorianCalendar(2017, 5, 5), 50);
				crash = new Game("Crash Bandicoot N. Sane Trilogy", new GregorianCalendar(2017, 6, 30), 88);
				crash2 = new Game("Crash Bandicoot N. Sane Trilogy", new GregorianCalendar(2017, 6, 30), 88);

				gl1 = new GameList(yooka); {
					gl1.addGame(massEffect);
					gl1.addGame(persona);
				}
				gl2 = new GameList(prey); {
					gl2.addGame(crash);
				}
				gl3 = new GameList(prey2);
				gl4 = new GameList(prey3); {
					gl4.addGame(crash2);
					gl4.addGame(yooka2);
				}

				c = new GregorianCalendar(2017, 2, 26); // Trophies can have the same date - we don't care for these tests

				massEffectT1 = new Trophy("Shady Trees", Trophy.Rank.GOLD, Trophy.Rarity.ULTRA_RARE, c, massEffect);
				massEffectT2 = new Trophy("Keep", Trophy.Rank.SILVER, Trophy.Rarity.RARE, c, massEffect);
				personaT1 = new Trophy("War Never Changes", Trophy.Rank.BRONZE, Trophy.Rarity.COMMON, c, persona);
				personaT2 = new Trophy("The Nuclear Option", Trophy.Rank.SILVER, Trophy.Rarity.UNCOMMON, c, persona);
				personaT3 = new Trophy("Prepared for the Future", Trophy.Rank.GOLD, Trophy.Rarity.UNCOMMON, c, persona);
				yookaT1 = new Trophy("Platinum", Trophy.Rank.PLATINUM, Trophy.Rarity.ULTRA_RARE, c, yooka);
				preyT1 = new Trophy("Xenonaut", Trophy.Rank.BRONZE, Trophy.Rarity.RARE, c, prey);
				preyT2 = new Trophy("Walked the Path", Trophy.Rank.GOLD, Trophy.Rarity.VERY_RARE, c, prey);
				preyT3 = new Trophy("Humpty Dumpty", Trophy.Rank.BRONZE, Trophy.Rarity.VERY_RARE, c, prey);
				preyT4 = new Trophy("Can't Touch This!", Trophy.Rank.BRONZE, Trophy.Rarity.RARE, c, prey);
				preyT5 = new Trophy("Overkill", Trophy.Rank.SILVER, Trophy.Rarity.RARE, c, prey);
				crashT1 = new Trophy("Expert Fortune Hunter", Trophy.Rank.BRONZE, Trophy.Rarity.UNCOMMON, c, crash);
				crashT2 = new Trophy("Platinum", Trophy.Rank.PLATINUM, Trophy.Rarity.ULTRA_RARE, c, crash);

				tl1 = new ArrayList<Trophy>(); {
					tl1.add(yookaT1);
					tl1.add(personaT1);
					tl1.add(massEffectT2);
				}
				tl2 = new ArrayList<Trophy>(); {
					tl2.add(personaT1);
					tl2.add(personaT2);
					tl2.add(personaT3);
					tl2.add(massEffectT2);
				}
				tl3 = new ArrayList<Trophy>(); {
					tl3.add(crashT1);
					tl3.add(crashT2);
					tl3.add(preyT4);
					tl3.add(preyT3);
					tl3.add(preyT1);
				}
				tl4 = new ArrayList<Trophy>(); {
					tl4.add(preyT1);
					tl4.add(preyT2);
					tl4.add(preyT5);
				}
				tl5 = new ArrayList<Trophy>(); {
					tl5.add(crashT2);
					tl5.add(yookaT1);
				}

				dob = new GregorianCalendar(1980, 4, 23); // Users can have the same dob - we don't care for these tests
				
				oberon = new User("Oberon", dob, 7);
				pippin = new User("Pippin", dob, 10);
				medraut = new User("Medraut", dob, 8);
				astaroth = new User("Astaroth", dob, 9);
				lunete = new User("Lunete", dob, 12);
				guiomar = new User("Guiomar", dob, 14);
				faust = new User("Faust", dob, 4);
				sophronia = new User("Sophronia", dob, 6);
				haidee = new User("Haidee", dob, 5);
				cosette = new User("Cosette", dob, 3);
				dulcinea = new User("Dulcinea", dob, 3);
				nelida = new User("Nelida", dob, 1);

				oberon.setGames(gl1);
				oberon.setTrophies(tl1);
				oberon.setLeft(faust);
				oberon.setRight(pippin);

				
				faust.setGames(gl2);
				faust.setTrophies(tl3);
				faust.setLeft(cosette);
				faust.setRight(sophronia);


				cosette.setGames(gl3);
				cosette.setTrophies(tl4);
				cosette.setLeft(nelida);
				cosette.setRight(dulcinea);


				nelida.setGames(gl3);
				nelida.setTrophies(tl4);
				
				
				dulcinea.setGames(gl1);
				dulcinea.setTrophies(tl1);
				

				sophronia.setGames(gl2);
				sophronia.setTrophies(tl3);
				sophronia.setLeft(haidee);
				
				
				haidee.setGames(gl3);
				haidee.setTrophies(tl4);
				
				
				pippin.setGames(gl1);
				pippin.setTrophies(tl2);
				pippin.setLeft(medraut);
				pippin.setRight(lunete);


				medraut.setGames(gl4);
				medraut.setTrophies(tl5);
				medraut.setRight(astaroth);


				astaroth.setGames(gl2);
				astaroth.setTrophies(tl3);


				lunete.setGames(gl1);
				lunete.setTrophies(tl1);
				lunete.setRight(guiomar);


				guiomar.setGames(gl2);
				guiomar.setTrophies(tl4);
			
				bt.root = oberon;

				bt.levelUp("Oberon");
		  
	}
}
