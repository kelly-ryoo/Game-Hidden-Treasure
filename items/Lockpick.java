package items;

import textadventure.World;

public class Lockpick extends Item {

	World world;

	public Lockpick(World worlds, String name, boolean takeable, String description) {
		super(worlds, name, takeable, description);
		world = worlds;
	}

	@Override
	public void doUse() {
		
	}

}
