package items;

import interfaces.isVault;
import textadventure.World;

public class PotionVault extends Container implements isVault {

	public PotionVault(World world, String name, boolean takeable, String description) {
		super(world, name, takeable, description);
		// TODO Auto-generated constructor stub
	}

	boolean isOpen;
	boolean isUnlocked;

	boolean first;
	boolean sec;
	boolean third;
	boolean passwordIsCorrect;

	@Override
	public boolean isOpen() {

		if (isOpen) {
			return true;
		}

		return false;
	}

	@Override
	public void doOpen() {
		if (isUnlocked) {
			isOpen = true;
			World.print("Opened!\n");
		} else {
			World.print("You can't open that!\n");

		}
	}

	@Override
	public void doClose() {
		if (isOpen) {
			isOpen = false;
			World.print("Closed!\n");

		} else {
			World.print("It's already closed!\n");
		}
	}

	@Override
	public boolean isLocked() {
		if (isUnlocked) {
			return false;
		}

		return true;
	}

	@Override
	public void doLock() {
		if (isUnlocked) {
			isUnlocked = false;
			World.print("done!\n");

		} else {
			World.print("done!\n");
		}
	}

	@Override
	public void doUnlock(String str) {
		if(str.equals("to_learn_is_to_grow")) {
			passwordIsCorrect = true;
		}else {
			World.print("Still not unlocked.\n");
			return;
		}
		
		if (first && sec && third && passwordIsCorrect) {
			isUnlocked = true;
			World.print("Done! Unlocked. :) \n");

		} else {
			World.print("Sorry. You can't unlock that.\n");
		}
	}

	@Override
	public void doUse() {
		World.print("You can't use this closet. ");
	}

	public void setFirstKey(boolean x) {
		first = x;
		World.print("The first keyhole is now unlocked. \n");
	}

	void setSecKey(boolean x) {
		if (first) {
			sec = x;
			World.print("The second keyhole is now unlocked. \n");

		} else {
			World.print("WRONG ORDER! You lose.\n");

			System.exit(0);
		}
	}

	public void setThirdKey(boolean x) {
		if (first && sec) {
			third = x;

			World.print("The third keyhole is now unlocked. \n");
			doUnlock("hi");

		} else {
			World.print("WRONG ORDER! You lose.\n");

			System.exit(0);
		}
	}
	


}
