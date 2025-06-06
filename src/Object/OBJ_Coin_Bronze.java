package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Coin_Bronze extends Entity
{
	public static final String objName = "bronze Coin";
	
	GamePanel gp;

	public OBJ_Coin_Bronze(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		value = 1;
		down1 = setup("/Objects/coin_bronze");
	}

	public boolean use(Entity entity)
	{
		gp.playSE(1);
		gp.ui.addMessage("Coin +" + value);
		gp.player.coin += value;
		return true;
	}
}
