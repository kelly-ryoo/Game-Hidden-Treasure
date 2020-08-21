package items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import interfaces.Closeable;
import textadventure.World;

public class CloseableContainer extends Container implements Closeable {

	private boolean isOpen;

	public CloseableContainer(World world, String name, String description, boolean isOpens) {
		super(world, name, Item.NOT_TAKEABLE, description);
		isOpen = isOpens;
	}
	

	@Override
	public boolean isOpen() {
		if (isOpen) {
			return true;
		}
		return false;
	}

	@Override
	public void doOpen() {
		isOpen = Closeable.OPEN;
		World.print("Opened\n");
	}

	@Override
	public void doClose() {
		isOpen = Closeable.CLOSED;
		World.print("Done.\n");
	}

	@Override
	public Item doTake(Item item) {
		if (isOpen) {
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
		if (isOpen) {
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
	public void doExamine() {
		if (!isOpen) {
			World.print("The " + getName() + " is closed.\n");
		} else {
			World.print("Inside the " + getName() + " you see " + getItemString() + ".\n");
		}
	}

}
