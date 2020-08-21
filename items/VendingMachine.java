package items;

import interfaces.isVault;
import textadventure.World;

public class VendingMachine extends Container implements isVault{

	public VendingMachine(World world, String name, boolean takeable, String description) {
		super(world, name, takeable, description);
		// TODO Auto-generated constructor stub
	}

	boolean isOpen;
	boolean isUnlocked;
	
	@Override
	public boolean isOpen() {

		if(isOpen) {
			return true;
		}
		
		return false;
	}

	@Override
	public void doOpen() {
		if(isUnlocked) {
			isOpen = true;
			World.print("Opened!\n");
		}else {
			World.print("You can't open that!\n");

		}
	}

	@Override
	public void doClose() {
		if(isOpen) {
			isOpen = false;
			World.print("Closed!\n");

		}else {
			World.print("It's already closed!\n");
		}
	}

	@Override
	public boolean isLocked() {
		if(isUnlocked) {
			return false;
		}
		
		return true;
	}

	@Override
	public void doLock() {
		if(isUnlocked) {
			isUnlocked = false;
			World.print("done!\n");

		}else {
			World.print("done!\n");
		}
	}

	@Override
	public void doUnlock(String str) {
		if(str.equals("lockpick")) {
			isUnlocked = true;
			World.print("done!\n");

		}else {
			World.print("Sorry. You can't unlock that.\n");
		}
	}

	@Override
	public void doUse() {
		World.print("You can't use a vending machine without money... and you don't have any! ");
	}



}
