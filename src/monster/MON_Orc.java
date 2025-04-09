package monster;

import java.util.Random;

import Entity.Entity;
import Object.OBJ_Coin_Bronze;
import Object.OBJ_Heart;
import Object.OBJ_ManaCrystal;
import main.GamePanel;

public class MON_Orc extends Entity{


	GamePanel gp;
	public MON_Orc(GamePanel gp) 
	{
		super(gp);

		this.gp = gp;
		
		type = type_monster;
		name = "Orc";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 10;
		life = maxLife;
		attack = 8;
		defense = 3;
		exp = 10;
		knockBackPower = 5;
		
		solidArea.x = 4;
		solidArea.y = 4;
		solidArea.width = 40;
		solidArea.height = 44;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		attackArea.width = 48;
		attackArea.height = 48;
		motion1_duration = 40;
		motion2_duration = 85;
		
		getImage();
		getAttackImage();
	}
	public void getImage()
	{
		up1 = setup("/monster/orc_up_1");
		up2 = setup("/monster/orc_up_2");
		down1 = setup("/monster/orc_down_1");
		down2 = setup("/monster/orc_down_2");
		left1 = setup("/monster/orc_left_1");
		left2 = setup("/monster/orc_left_2");
		right1 = setup("/monster/orc_right_1");
		right2 = setup("/monster/orc_right_2");
	}
	public void getAttackImage()
	{
		attackUp1 = setupAttackImage("/monster/orc_attack_up_1",gp.tileSize,gp.tileSize*2);
		attackUp2 = setupAttackImage("/monster/orc_attack_up_2",gp.tileSize,gp.tileSize*2);
		attackDown1 = setupAttackImage("/monster/orc_attack_down_1",gp.tileSize,gp.tileSize*2);
		attackDown2 = setupAttackImage("/monster/orc_attack_down_2",gp.tileSize,gp.tileSize*2);
		attackLeft1 = setupAttackImage("/monster/orc_attack_left_1",gp.tileSize*2,gp.tileSize);
		attackLeft2 = setupAttackImage("/monster/orc_attack_left_2",gp.tileSize*2,gp.tileSize);
		attackRight1 = setupAttackImage("/monster/orc_attack_Right_1",gp.tileSize*2,gp.tileSize);
		attackRight2 = setupAttackImage("/monster/orc_attack_Right_2",gp.tileSize*2,gp.tileSize);
	}
	public void setAction()
	{
		if(onPath == true)
		{
			// check if it stops chasing
			checkStopChasing(gp.player, 15, 100);
			// search the direction to go
			searchPath(getGoalCol(gp.player),getGoalRow(gp.player));
		}
		else
		{
			//check if it starts chasing
			checkChasing(gp.player, 5, 100);
			//get a Random direction
			getRandomDirection(120);
		}
		
		// Check if it attacks
		if(attacking == false) {
			checkAttack(30, gp.tileSize*4, gp.tileSize);
			
		}
	}
	public void damageReaction()
	{
		actionLockCounter = 0;
//		direction = gp.player.direction;
		onPath = true;
	}
	public void checkDrop()
	{
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		// SET THE MONSTER DROP
		if(i < 50)
		{
			dropItem(new OBJ_Coin_Bronze(gp));
			dropItem(new OBJ_Coin_Bronze(gp));
			dropItem(new OBJ_Coin_Bronze(gp));
		}
		if(i >= 50 && i < 75)
		{
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 75 && i < 100)
		{
			dropItem(new OBJ_ManaCrystal(gp));
		}
	}
}
