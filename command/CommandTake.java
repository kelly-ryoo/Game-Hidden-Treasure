package command;

import items.Item;
import items.Container;
import textadventure.World;

public class CommandTake extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] { "take", "get", "grab", "hold" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if (params.length == 1) {
			String itemName = params[0];
			if (world.getPlayer().getCurrentRoom().hasItem(itemName)) {
				Item item = world.getPlayer().getCurrentRoom().getItem(itemName);
				item.doTake(world.getPlayer().getCurrentRoom());
				return;
			} else if (world.getPlayer().hasItem(itemName)) {
				World.print("You already have that!\n\n");
				return;
			} else {
				World.print("You can't see any " + itemName + " here.\n\n");
				return;
			}
		} else if (params.length == 3) {

			String itemName = params[0];
			String containerName = params[2];

			if (itemName.equals("computer") && containerName.contentEquals("small_cabinet")) {
				World.print("You can't take that! Mr. Ferrante needs that computer for schoolwork.\n\n");
				return;
			}

			if (!params[1].equals("from")) {
				World.print("I don't understand.\n\n");
				return;
			}
			if (!world.getPlayer().getCurrentRoom().hasItem(containerName)) {
				World.print("You can't see any " + containerName + " here.\n\n");
				return;
			}

			Container contain = (Container) world.getPlayer().getCurrentRoom().getItem(containerName);

			if (!world.getPlayer().getCurrentRoom().hasItem(itemName) && !contain.hasItem(itemName)) {
				World.print("You can't see any " + itemName + " here.\n\n");
				return;
			}
			if (!(world.getPlayer().getCurrentRoom().getItem(containerName) instanceof Container)) {
				World.print("The " + containerName + " can't hold things!" + containerName + " here.\n\n");
				return;
			}

			if (!contain.hasItem(itemName)) {
				World.print("The " + containerName + " doens't have a " + containerName + " here.\n\n");
				return;
			}

			contain.doTake(contain.getItem(itemName));

		} else {
			World.print("I don't understand.\n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "[item] or [item] from [container]";
	}

}
