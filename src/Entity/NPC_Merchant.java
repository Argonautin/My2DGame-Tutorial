package Entity;

import Object.OBJ_Axe;
import Object.OBJ_Key;
import Object.OBJ_Lantern;
import Object.OBJ_Red_Potion;
import Object.OBJ_Shield_Blue;
import Object.OBJ_Shield_Wood;
import Object.OBJ_Sword_Normal;
import Object.OBJ_Tent;
import main.GamePanel;

public class NPC_Merchant extends Entity{

	public NPC_Merchant(GamePanel gp)
	{
		super(gp);
		direction = "down";
		speed = 1;
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		setDialogue();
		setItems();
	}
public void getImage()
	{
	up1 = setup("/npc/merchant_down_1");
	up2 = setup("/npc/merchant_down_2");
	down1 = setup("/npc/merchant_down_1");
	down2 = setup("/npc/merchant_down_2");
	left1 = setup("/npc/merchant_down_1");
	left2 = setup("/npc/merchant_down_2");
	right1 = setup("/npc/merchant_down_1");
	right2 = setup("/npc/merchant_down_2");	
			
	}
	public void setDialogue() 
	{
		dialogues[0][0] = "He he, so you found me.\nI have some good stuff.\nDo you want to trade?";
		dialogues[1][0] = "Come again, hehe!";
		dialogues[2][0] = "You need more coin to buy that!";
		dialogues[3][0] = "You cannot carry any more!";
		dialogues[4][0] = "You cannot sell an equipped item!";
	}
	public void setItems()
	{
		inventory.add(new OBJ_Red_Potion(gp));
		inventory.add(new OBJ_Key(gp));
		inventory.add(new OBJ_Sword_Normal(gp));
		inventory.add(new OBJ_Axe(gp));
		inventory.add(new OBJ_Shield_Wood(gp));
		inventory.add(new OBJ_Shield_Blue(gp));
		inventory.add(new OBJ_Lantern(gp));
		inventory.add(new OBJ_Tent(gp));
		
	}
	public void speak()
	{
		facePlayer();
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
	}
}
