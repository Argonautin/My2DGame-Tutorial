package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity
{
	public static final String objName = "Key";
	
	GamePanel gp;
	public OBJ_Key(GamePanel gp) 
	{
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		down1 = setup("/objects/key");
		description = "[" + name + "]\nIt opens a door.";
		price = 10;
		stackable = true;
		
		setDialogue();
	}
	public void setDialogue()
	{
		dialogues[0][0] = "You used the " + name + " and open the door";
		
		dialogues[1][0] = "What are you dooing?";
	}
	public boolean use(Entity entity)
	{
		int objIndex = getDetected(entity, gp.obj, "Door");	
		if(objIndex != 999)
		{
			startDialogue(this,0);
			gp.playSE(3);
			gp.obj[gp.currentMap][objIndex] = null;
			return true;
		}
		else 
		{
			startDialogue(this,1);
			return false;
		}
	}
}
