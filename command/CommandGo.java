package command;

import items.Riddle;
import textadventure.Player;
import textadventure.Room;
import textadventure.World;

public class CommandGo extends Command {

	boolean once;

	@Override
	public String[] getCommandWords() {
		once = false;
		return new String[] { "go", "move", "travel", "walk" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if (params.length == 0) {
			// if there is no second word, we don't know where to go...
			World.print("Go where?\n");
		} else {
			Player player = world.getPlayer();
			String direction = params[0];

			// Try to leave current room.
			Room nextRoom = player.getCurrentRoom().nextRoom(direction);

			if (nextRoom == null) {
				World.print("You can't go that way!\n\n");
			} else if (nextRoom.isLocked()) {
				if (nextRoom.equals(world.getRoom(World.CS_CLASS)) && world.getPlayer().getCurrentRoom().equals(world.getRoom(World.QUAD))) {
					World.print(((Riddle) world.getPlayer().getCurrentRoom().getItem("riddle")).describe());
				}
			} else {

				if (nextRoom.equals(world.getRoom(World.SCIENCE_CLASS))) {
					if (!once) {
						World.print("Are you sure? Enter at your own risk!\n\n");
						once = true;
						return;
					} else if (once) {
						if (!world.getPlayer().hasItem("gas_mask")) {
							World.print(
									"Oh no! You died! The posionous-gas system designed to catch intruders in the science room got you...");
							System.exit(0);
						}
					}
				}

				player.setCurrentRoom(nextRoom);
				World.print("\n" + player.getCurrentRoom().getDescription());
				player.getCurrentRoom().doGo();
			}
		}
	}

	

	@Override
	public String getHelpDescription() {
		return "[north, east, west, south]";
	}

}
