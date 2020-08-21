package command;

import interfaces.isVault;
import items.Container;
import items.Item;
import items.PotionVault;
import items.Riddle;
import textadventure.Room;
import textadventure.World;

public class CommandEnter extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] { "enter" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {

		if (params.length == 3) {
			String pass = params[0];
			String in = params[1];
			String vaultName = params[2];
			Item vault = world.getPlayer().getCurrentRoom().getItem(vaultName);

			if (!(in.equals("in") || in.equals("into"))) {
				World.print("Invalid command. I'm not quite sure what you mean.\n\n");
				return;
			}

			if (!world.getPlayer().getCurrentRoom().hasItem(vaultName)) {
				World.print("There is no " + vaultName + " to enter the password into!\n\n");
				return;
			}

			if (!(vault instanceof isVault)) {
				World.print("The " + vaultName + " is not something that can be locked and unlocked !\n\n");
				return;
			}
			
			((isVault) vault).doUnlock(pass);
			
		} else {
			World.print("I don't understand what you mean.\n");
		}

	}

	@Override
	public String getHelpDescription() {
		return "enter [int] into [riddle or vaultName]";
	}

}
