package items;

import textadventure.World;

public class GasMask extends Item{
	
	World world;

	public GasMask(World worlds, String name, boolean takeable, String description) {
		super(worlds, name, takeable, description);
		world = worlds;
	}

	public void doUse(Container closet) {
		world.getPlayer().addItem(this);
	}

	@Override
	public void doUse() {
	}

}
