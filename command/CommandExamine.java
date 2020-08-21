package command;

import items.Item;
import textadventure.World;

public class CommandExamine extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] { "examine", "x", "inspect" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {

		if (params.length >= 1) {

			String secondWord = params[0];
			boolean playerHasItem = world.getPlayer().hasItem(secondWord);
			boolean roomHasItem = world.getPlayer().getCurrentRoom().hasItem(secondWord);

			/*
			if (roomHasItem && world.getPlayer().getCurrentRoom().getItem(secondWord) instanceof Vault) {
				Vault vault = (Vault) world.getPlayer().getCurrentRoom().getItem(secondWord);
				if (vault.isLocked()) {

					if (world.getPlayer().getCurrentRoomName().equals("QUAD")) {
						World.print("The vending machine is full of lots of snacks, including chips and candy. On one of rows is a brass-colored shiny key.");
						return;
					}else if(world.getPlayer().getCurrentRoomName().equals("SCIENCE_CLASS")) {
						if(world.getPlayer().getCurrentRoom().getItem(secondWord).equals("potion_vault")) {
							World.print("It's a shiny, metal vault. There's a screen that displays numbered keypad on it. The screen displays the following message: Enter the 4 digit password. If input incorrectly, the alarm bells will ring!");
							return;
						}else {
							World.print("It resembles an antique treasure chest, but it's made out of iron. There are three keyholes in the order of: gold, silver, and brass (left to right).");
							return;
						}
					}
				}
			}
			*/

			if (playerHasItem) {
				Item item = world.getPlayer().getItem(secondWord);
				item.doExamine();
			} else if (roomHasItem) {
				Item item = world.getPlayer().getCurrentRoom().getItem(secondWord);
				item.doExamine();
			} else
				World.print("You can't see any " + params[0] + "(s) here!\n\n");
		} else
			World.print("What do you want to examine?\n\n");
	}

	@Override
	public String getHelpDescription() {
		return "[item]";
	}

}
