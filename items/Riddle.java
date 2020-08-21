package items;

import interfaces.Closeable;
import interfaces.isVault;
import textadventure.World;

public class Riddle extends Container implements isVault {

	boolean isOpen;
	boolean isUnlocked;
	
	int incorrect;
	String description;
	World worlds;
	
	public Riddle(World world, String name, boolean takeable, String description) {
		super(world, name, takeable, description);
		worlds = world;
	}


	public String describe() {
		String str = "After the last statement has been executed, how many objects are now accessible?\n"
				+ "String straA = new String(\"Cheese\")\n"
				+ "String strB = strA;\n"
				+ "String strC = strA;\n"
				+ "String strD = strA;\n"
				+ "String strE = strA;\n"
				+ "Options:\n"
				+ "one, two, three, four, five\n"
				+ "\n"
				+ "Think carefully! You have two chances!\n"
				+ "Make Mr. Ferrante proud. :) \n"
				+ "HINT: Once you decide on an answer you should: enter [the answer] into riddle.";

		str += "";
		return str;
	}

	public void addIncorrect() {
		incorrect++;
		if (incorrect > 2) {
			World.print(
					"You got the riddle wrong more than two times... The alarm bells ring and you are caught by Mr. Ferrante!");
			World.print("You are caught and given detention.. FOR THE REST OF YOUR LIFE!");
			System.exit(0);
		}
	}

	@Override
	public boolean isOpen() {
		if (isOpen) {
			return true;
		}
		return false;
	}

	public boolean isLocked() {
		if (!isUnlocked) {
			return true;
		}
		return false;
	}

	public void doUnlock() {
		isUnlocked = true;
		World.print("Unlocked!\n");
	}

	@Override
	public void doOpen() {
		if (isUnlocked) {
			isOpen = Closeable.OPEN;
			World.print("Opened.\n");
		} else {
			World.print("It's locked!\n");
		}
	}

	@Override
	public void doClose() {
		isOpen = Closeable.CLOSED;
		World.print("Done.\n");
	}

	@Override
	public Item doTake(Item item) {
		if (isOpen && isUnlocked) {
			getWorld().getPlayer().addItem(item);
			this.removeItem(item);
			World.print("Done!\n");
			return item;
		} else {
			World.print("The " + getName() + "is closed. You cannot take the " + getItemString() + "\n\n");
			return null;
		}
	}

	@Override
	public Item doPut(Item item, Container source) {
		if (isOpen && isUnlocked) {
			addItem(item);
			getWorld().getPlayer().removeItem(item);
			World.print("Done!\n\n");
			return item;
		} else {
			World.print("The " + getName() + " is closed.\n");
			return null;
		}
	}

	@Override
	public void doLock() {
		World.print("You can't do that.");
	}

	@Override
	public void doUnlock(String str) {
		if(str.equals("one")) {
			isUnlocked = true;
			worlds.getRoom(World.CS_CLASS).doUnlock();
			World.print("unlocked.\n");
		}else
			World.print("Incorrect.\n");

	}

	@Override
	public void doUse() {
		// TODO Auto-generated method stub
		
	}
	

}
