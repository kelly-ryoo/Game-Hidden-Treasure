package command;

import java.util.Arrays;

import items.Item;
import items.Note;
import items.Riddle;
import textadventure.World;

public class CommandRead extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] { "read" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {

		if (params.length == 1) {
			boolean playerHasNote = world.getPlayer().hasItem(params[0]);
			Item item = world.getPlayer().getItem(params[0]);
			boolean itemIsNote = item instanceof Note;
			boolean worldHasNote = world.getPlayer().getCurrentRoom().hasItem(params[0]);
			boolean itemIsRiddle = item instanceof Riddle;

			if (!cmd.equals("read")) {
				World.print("I don't understand.\n\n");
				return;
			}

			if (!worldHasNote && !playerHasNote) {
				World.print("There doesn't seem to be a " + params[0] + " here.\n\n");
				return;
			}

			if (world.getPlayer().getCurrentRoom().equals(world.getRoom(World.QUAD)) && params[0].equals("riddle")) {
				String str = "After the last statement has been executed, how many objects are now accessible?\n" + "String straA = new String(\"Cheese\")\n"
						+ "String strB = strA;\n"
						+ "String strC = strA;\n"
						+ "String strD = strA;\n"
						+ "String strE = strA;\n"
						+ "Options:\n"
						+ "one, two, three, four, five\n\n"
						+ "Think carefully! You have two chances!\n\n"
						+ "Make Mr. Ferrante proud. :)\n"
						+ "HINT: Once you decide on an answer you should: enter [the answer] into riddle.\n";
				World.print(str);
				return;
			} else if (!itemIsNote) {
			World.print("You can't read that!\n");
			return;
		}

		if (worldHasNote && !playerHasNote) {
			World.print("You need to pick up the " + params[0] + " to actually read it...\n");
			return;
		}

		if (world.getPlayer().getCurrentRoom().equals(world.getRoom(World.QUAD))) {
			World.print("The " + params[0] + " reads:\n");
			World.print("The first place you must go, is a place of many woes."
					+ " It is full of frustrations, mainly because of calculations. "
					+ "But no matter! Because if you can integrate, you will not be irate.\n");
		} else if (world.getPlayer().getCurrentRoom().equals(world.getRoom(World.LIT_CLASS))) {
			World.print("The " + params[0] + " reads:\n");
			World.print(
					"System.out.println('you extend, you comprehend. You loop, you whoop. you download, you code.') \n");
		} else {
			World.print("food is good.\n\n");
		}
	}else

	{
		World.print("I don't understand.");
	}

	}

	@Override
	public String getHelpDescription() {
		return "read [item]";
	}

}
