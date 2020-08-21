package items;

import textadventure.World;

public class Books extends Item{


	public Books(World world, String name, boolean takeable, String description) {
		super(world, name, takeable, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doUse() {
		World.print("You can't use that,..");
	}

}
