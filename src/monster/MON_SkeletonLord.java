package monster;

import java.util.Random;

import Entity.Entity;
import Object.OBJ_Coin_Bronze;
import Object.OBJ_Door_Iron;
import Object.OBJ_Heart;
import Object.OBJ_ManaCrystal;
import data.Progress;
import main.GamePanel;

public class MON_SkeletonLord extends Entity{

	GamePanel gp;
	public static final String monName = "Skeleton Lord";
	
	public MON_SkeletonLord(GamePanel gp) 
	{
		super(gp);

		this.gp = gp;
		
		type = type_monster;
		boss = true;
		name = monName;
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 50;
		life = maxLife;
		attack = 10;
		defense = 2;
		exp = 50;
		knockBackPower = 5;
		sleep = true;
		
		int size = gp.tileSize*5;
		
		solidArea.x = 48;
		solidArea.y = 48;
		solidArea.width = size - 48*2;
		solidArea.height = size - 48;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		attackArea.width = 170;
		attackArea.height = 170;
		motion1_duration = 25;
		motion2_duration = 50;
		
		getImage();
		getAttackImage();
		setDialogue();
	}
	public void getImage()
	{
		int i = 5;
		if(inRage == false)
		{
			up1 = setupAttackImage("/monster/skeletonlord_up_1",gp.tileSize*i,gp.tileSize*i);
			up2 = setupAttackImage("/monster/skeletonlord_up_2",gp.tileSize*i,gp.tileSize*i);
			down1 = setupAttackImage("/monster/skeletonlord_down_1",gp.tileSize*i,gp.tileSize*i);
			down2 = setupAttackImage("/monster/skeletonlord_down_2",gp.tileSize*i,gp.tileSize*i);
			left1 = setupAttackImage("/monster/skeletonlord_left_1",gp.tileSize*i,gp.tileSize*i);
			left2 = setupAttackImage("/monster/skeletonlord_left_2",gp.tileSize*i,gp.tileSize*i);
			right1 = setupAttackImage("/monster/skeletonlord_right_1",gp.tileSize*i,gp.tileSize*i);
			right2 = setupAttackImage("/monster/skeletonlord_right_2",gp.tileSize*i,gp.tileSize*i);
		}
		if(inRage == true)
		{
			up1 = setupAttackImage("/monster/skeletonlord_phase2_up_1",gp.tileSize*i,gp.tileSize*i);
			up2 = setupAttackImage("/monster/skeletonlord_phase2_up_2",gp.tileSize*i,gp.tileSize*i);
			down1 = setupAttackImage("/monster/skeletonlord_phase2_down_1",gp.tileSize*i,gp.tileSize*i);
			down2 = setupAttackImage("/monster/skeletonlord_phase2_down_2",gp.tileSize*i,gp.tileSize*i);
			left1 = setupAttackImage("/monster/skeletonlord_phase2_left_1",gp.tileSize*i,gp.tileSize*i);
			left2 = setupAttackImage("/monster/skeletonlord_phase2_left_2",gp.tileSize*i,gp.tileSize*i);
			right1 = setupAttackImage("/monster/skeletonlord_phase2_right_1",gp.tileSize*i,gp.tileSize*i);
			right2 = setupAttackImage("/monster/skeletonlord_phase2_right_2",gp.tileSize*i,gp.tileSize*i);
		}
	}
	public void getAttackImage()
	{
		
		int i = 5;
		if(inRage == false)
		{
			attackUp1 = setupAttackImage("/monster/skeletonlord_attack_up_1",gp.tileSize*i,gp.tileSize*i*2);
			attackUp2 = setupAttackImage("/monster/skeletonlord_attack_up_2",gp.tileSize*i,gp.tileSize*i*2);
			attackDown1 = setupAttackImage("/monster/skeletonlord_attack_down_1",gp.tileSize*i,gp.tileSize*i*2);
			attackDown2 = setupAttackImage("/monster/skeletonlord_attack_down_2",gp.tileSize*i,gp.tileSize*i*2);
			attackLeft1 = setupAttackImage("/monster/skeletonlord_attack_left_1",gp.tileSize*i*2,gp.tileSize*i);
			attackLeft2 = setupAttackImage("/monster/skeletonlord_attack_left_2",gp.tileSize*i*2,gp.tileSize*i);
			attackRight1 = setupAttackImage("/monster/skeletonlord_attack_Right_1",gp.tileSize*i*2,gp.tileSize*i);
			attackRight2 = setupAttackImage("/monster/skeletonlord_attack_Right_2",gp.tileSize*i*2,gp.tileSize*i);
		}
		if(inRage == true)
		{
			attackUp1 = setupAttackImage("/monster/skeletonlord_phase2_attack_up_1",gp.tileSize*i,gp.tileSize*i*2);
			attackUp2 = setupAttackImage("/monster/skeletonlord_phase2_attack_up_2",gp.tileSize*i,gp.tileSize*i*2);
			attackDown1 = setupAttackImage("/monster/skeletonlord_phase2_attack_down_1",gp.tileSize*i,gp.tileSize*i*2);
			attackDown2 = setupAttackImage("/monster/skeletonlord_phase2_attack_down_2",gp.tileSize*i,gp.tileSize*i*2);
			attackLeft1 = setupAttackImage("/monster/skeletonlord_phase2_attack_left_1",gp.tileSize*i*2,gp.tileSize*i);
			attackLeft2 = setupAttackImage("/monster/skeletonlord_phase2_attack_left_2",gp.tileSize*i*2,gp.tileSize*i);
			attackRight1 = setupAttackImage("/monster/skeletonlord_phase2_attack_Right_1",gp.tileSize*i*2,gp.tileSize*i);
			attackRight2 = setupAttackImage("/monster/skeletonlord_phase2_attack_Right_2",gp.tileSize*i*2,gp.tileSize*i);
		}
	}
	public void setDialogue()
	{
		
		dialogues[0][0] = "No one can steal my treasure!";
		dialogues[0][1] = "You will die here!";
		dialogues[0][2] = "WELCOME TO YOUR DOOM!";
	}
	public void setAction()
	{
		if(inRage == false && life < maxLife/2)
		{
			inRage = true;
			getImage();
			getAttackImage();
			defaultSpeed++;
			speed = defaultSpeed;
			attack *= 2;
		}
		
		
		if(getTileDistance(gp.player) < 10)
		{
			moveTowardPlayer(60);
		}
		else
		{
			getRandomDirection(120);
		}
		
		// Check if it attacks
		if(attacking == false) {
			checkAttack(60, gp.tileSize*7, gp.tileSize*5);
			
		}
	}
	public void damageReaction()
	{
		actionLockCounter = 0;
	}
	public void checkDrop()
	{
		gp.bossBattleOn = false;
		Progress.skeletonLordDefeated = true;
		
		gp.stopMusic();
		gp.playMusic(18);
		
		for(int i = 0; i < gp.obj[1].length; i++)
		{
			if(gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].name.equals(OBJ_Door_Iron.objName))
			{
				gp.playSE(20);
				gp.obj[gp.currentMap][i] = null;
			}
		}
		
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		// SET THE MONSTER DROP
		if(i < 50)
		{
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
