import java.util.Scanner;
import java.util.Random; 

public class DungeonText{
	public static void main (String args[]){
		
		// System Objects
		Scanner in = new Scanner (System.in);
		Random rand = new Random ();
	    
		
		//Game Variables
		String [] enemies = {"Skeleton", "Zombie", "Troll", "Elephant" };
		int maxEnemyHealth = 75; 
		int enemyAttackDamage = 25; 
		
		// Player Variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3; 
		int healthPotionHealAmmount = 30; 
		int healthPotionDropChance = 50; //percentage
		
		boolean running = true; 
		
		System.out.println("Welcome to the Dungeon!");
		
		GAME:
		while (running){
			System.out.println("----------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth); 
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " appeared! #\n" );
			
		while (enemyHealth > 0){
			System.out.println("\t Your HP:" + health );
			System.out.println("\t" + enemy + "'s Health: " + enemyHealth);
			System.out.println("\n\tWhat would you like to do?");
			System.out.println("\t1. Attack");
			System.out.println("\t2. Drink Health Potion");
			System.out.println("\t3. Run!");
			
			String input = in.nextLine();
			if(input.equals("1")){
				int damageDealt = rand.nextInt(attackDamage);
				int damageTaken = rand.nextInt(enemyAttackDamage);
				
				enemyHealth -= damageDealt;
				health -= damageTaken; 
				
				System.out.println("\t You strike the enemy "+enemy+ " for "+damageDealt +" damage" );
				System.out.println("\t you receive " + damageTaken + " in retaliation"); 
				
				if(health < 1){
					System.out.println ("\t You have taken too much damage, you are too weak to go on");
					break;
				}
			}
			else if(input.equals("2")){
				if(numHealthPotions > 0){
					health +=healthPotionHealAmmount; 
					numHealthPotions --; 
					System.out.println("\t You drink a health potion, healing your self for"+healthPotionHealAmmount+ "."
							+"\n\t> You now have" + health + "HP"
							+ "\n\t> You have" +numHealthPotions + "health potions");
				}
				else {
					System.out.println("\t> You have no health potions left!");
				}
			}
			else if(input.equals("3")){
				System.out.println("\t You have run away from the "+enemy+"!");
				continue GAME; 
	}
			else { 
				System.out.println("\t Invalid Command.");
			}
}
		if (health < 1){
			System.out.println(" You limp out of the dungeon, weak from battle.");
			break; 
		}
		System.out.println("----------------------------");
		System.out.println("#"+enemy +" was defeated! #");
		System.out.println("# You have "+health+" HP left");
		if (rand.nextInt(100) < healthPotionDropChance){
			numHealthPotions++;
			System.out.println("# The" + enemy + " Drooped a health potion # ");
			System.out.println("# You now have " +numHealthPotions + " health potion(s). #");
		}
		System.out.println("----------------------------");
		System.out.println("What would you like to do?");
		System.out.println("1. Continue Fighting");
		System.out.println("2. Exit");
		
		String input = in.nextLine();
		
		while(!input.equals("1") && !input.equals("2")){
			System.out.println(" Invalid Command");
			input =in.nextLine();
		}
		if(input.equals("1")){
			System.out.println("You continue on your adventure!");
		}
		else if (input.equals("2")){
			System.out.println("You Exit the Dungeon");
			
		}
}
		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("");
}
}