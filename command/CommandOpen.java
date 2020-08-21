package command;

import interfaces.Closeable;
import interfaces.Lockable;
import interfaces.isVault;
import items.CloseableContainer;
import items.Container;
import items.Item;
import textadventure.Room;
import textadventure.World;

public class CommandOpen extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] { "open" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {

		if (params.length >= 1) {

			if (!((world.getPlayer().getCurrentRoom().getItem(params[0]) instanceof Closeable) || world.getPlayer().getCurrentRoom().getItem(params[0]) instanceof isVault)) {
				World.print("You can't open that.\n\n");
				return;
			}

			String secondWord = params[0];
			boolean playerHasItem = world.getPlayer().hasItem(params[0]);
			boolean roomHasItem = world.getPlayer().getCurrentRoom().hasItem(params[0]);
			Container vault = (Container) world.getPlayer().getCurrentRoom().getItem(params[0]);

			if (playerHasItem || roomHasItem) {

				// We know the player or room has the item so grab it from whichever has the
				// item
				Item item = playerHasItem ? world.getPlayer().getItem(secondWord)
						: world.getPlayer().getCurrentRoom().getItem(secondWord);

				if (item instanceof Closeable) {
					Closeable obj = (Closeable) item; // Casting is safe because we already checked that it's
														// Openable
					obj.doOpen();
				} else if (item instanceof isVault) {
					((isVault) item).doOpen();
					return;

				} else {
					World.print("You can't open that!\n");
					return;
				}
			} else {
				World.print("You can't open that!\n\n");
			}

		} else {
			World.print("What do you want to open?\n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "[item]";
	}
}
