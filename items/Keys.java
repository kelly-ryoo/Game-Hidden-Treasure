package items;

import items.PotionVault;
import interfaces.isVault;
import textadventure.Room;
import textadventure.World;

public class Keys extends Item {

	String names;
	World world;

	public Keys(World worlds, String name, boolean takeable, String description) {
		super(worlds, name, takeable, description);
		names = name;
		world = worlds;
	}

	public void doUse(String name) {
		if (world.getPlayer().getCurrentRoom().equals(world.getRoom(World.SCIENCE_CLASS))) {
			if (name.equals("gold_key")) {
				((PotionVault) world.getPlayer().getCurrentRoom().getItem("potion_vault")).setFirstKey(true);
				return;
			} else if (name.equals("silver_key")) {
				((PotionVault) world.getPlayer().getCurrentRoom().getItem("potion_vault")).setSecKey(true);
				return;
			} else if (name.equals("brass_key")) {
				((PotionVault) world.getPlayer().getCurrentRoom().getItem("potion_vault")).setThirdKey(true);
				return;
			} else {
				World.print("Sorry. I'm not sure what you mean.\n");
				return;
			}

		}else {
			World.print("Sorry. You can't use that here.\n");
			return;
		}
	}

	@Override
	public void doUse() {

	}

}
