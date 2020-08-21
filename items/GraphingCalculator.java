package items;

import textadventure.World;

public class GraphingCalculator extends Item{

	public GraphingCalculator(World world, String name, boolean takeable, String description) {
		super(world, name, takeable, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doUse() {
		World.print("The graphing calculator is now turned on. It displays this on its screen:\n");
		World.print("60 T0 L17 C1A55.\n");
	}

}
