package items;

import textadventure.World;

public class Potion extends Item{
	
	World worlds;

	public Potion(World world, String name, boolean takeable, String description) {
		super(world, name, takeable, description);
		worlds = world;
	}

	@Override
	public void doUse() {
		worlds.getPlayer().removeItem(this);
		World.print("You've drank the potion.\n");
		World.print("CONGRATULATIONS!!!\n");
		World.print("You've SUCCESSFULLY DRANK THE POTION. YOU WIN THE GAME!\n");
		World.print("Years and years later...\n");
		World.print("You become a legend in Cupertino High. They say that there was once a student who managed to get their hands on the most powerful potion of all time...");
		World.print(" But no one TRULY knows what happened the morning of March 9th. The school covered up any evidence of robbery, conducted thousands of investigations,");
		World.print(" but it was all futile! 20 years later, you're a world renowned entrepreneur of a tech company.\n");
		//insert custom date
		World.print("\n\nThanks for playing :) \n");
		System.exit(0);

	}
	


}
