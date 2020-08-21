package command;

import items.Container;
import items.Item;
import textadventure.World;

public class CommandPut extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] { "put" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {

		if(params.length < 3) {
			World.print("I'm not sure what you mean.\n\n");
			return;
		}
		String itemName = params[0];
		String containerName = params[2];
		boolean roomHasItem = world.getPlayer().getCurrentRoom().hasItem(itemName);
		boolean playerHasItem = world.getPlayer().hasItem(itemName);

		if (!cmd.equals("put") || !(params[1].equals("in") || params[1].equals("into"))) {
			World.print("Invalid syntax\\n\\n");
			return;
		}
		
		if (!world.getPlayer().getCurrentRoom().hasItem(itemName) && !world.getPlayer().hasItem(itemName)) {
			World.print("You can't see any " + itemName + " here!");
			return;
		}
		if (!world.getPlayer().getCurrentRoom().hasItem(containerName)) {
			World.print("You can't see any " + containerName + " here!\\n\\n");
			return;
		}

		Item contain = world.getPlayer().hasItem(containerName) ? world.getPlayer().getItem(containerName)
				: world.getPlayer().getCurrentRoom().getItem(containerName);
		;
		if (!(contain instanceof Container)) {
			World.print("The " + containerName + " can't hold things.\n\n");
			return;
		}
		if (containerName.equals(itemName)) {
			World.print("You can't put the " + containerName + " into itself!\\n\\n");
			return;
		}
		

		Item item = world.getPlayer().getItem(itemName);
		if (world.getPlayer().hasItem(itemName)) {
			((Container) contain).doPut(item, world.getPlayer());
		} else {
			((Container) contain).doPut(item, world.getPlayer());
		}

	}

	@Override
	public String getHelpDescription() {
		// TODO Auto-generated method stub
		return "[item] in [container]";
	}

}
