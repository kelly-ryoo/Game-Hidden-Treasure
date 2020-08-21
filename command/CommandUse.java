package command;

import items.VendingMachine;
import items.Item;
import items.Keys;
import items.Lockpick;
import textadventure.World;
import interfaces.isVault;

public class CommandUse extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] { "use" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {

		if (params.length >= 1) {

			String itemName = params[0];
			boolean playerHasItem = world.getPlayer().hasItem(itemName);
			boolean roomHasItem = world.getPlayer().getCurrentRoom().hasItem(itemName);
			Item item = world.getPlayer().getItem(itemName);

			if (playerHasItem && item instanceof Lockpick) {
				if (world.getPlayer().getCurrentRoom().equals(world.getRoom(World.QUAD))) {
					((VendingMachine) world.getPlayer().getCurrentRoom().getItem("vending_machine")).doUnlock(itemName);
					return;
				} else if (world.getPlayer().getCurrentRoom().equals(world.getRoom(World.MATH_CLASS))) {
					((isVault) world.getPlayer().getCurrentRoom().getItem("closet")).doUnlock(itemName);
					return;
				}
			} else if (playerHasItem && item instanceof Keys) {
				((Keys) item).doUse(itemName);
				return;
			}

			if (playerHasItem && roomHasItem) {
				Item item1 = world.getPlayer().getItem(itemName);
				item1.doUse();
			} else if (playerHasItem) {
				Item item1 = world.getPlayer().getItem(itemName);
				item1.doUse();
			} else if (roomHasItem) {
				Item item1 = world.getPlayer().getCurrentRoom().getItem(itemName);
				item1.doUse();
			} else
				World.print("You don't have a " + itemName + ".\n\n");
		} else
			World.print("What do you want to use?\n\n");
	}

	@Override
	public String getHelpDescription() {
		return "[item]";
	}
}
