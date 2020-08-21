package command;

import items.Potion;
import textadventure.World;

public class CommandDrink extends Command{
	
	@Override
	public String[] getCommandWords() {
		return new String[] {"drink", "sip", "swallow", "eat"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		
		String name = params[0];
		
		if(!(cmd.equals("drink") || cmd.equals("sip") || cmd.equals("swallow") || cmd.equals("eat"))) {
			World.print("I'm not sure what you mean...\n");
			return;
		}
		
		if(world.getPlayer().getItem(name) instanceof Potion) {
			if(!world.getPlayer().hasItem(name)) {
				World.print("You need to take the drink before you can drink it.\n");
				return;
			}
			Potion potion = (Potion) world.getPlayer().getItem(name);
			potion.doUse();
			return;
		}else{
			world.print("You can't drink that.");
		}

	}

	@Override
	public String getHelpDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
