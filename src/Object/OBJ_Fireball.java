package Object;

import java.awt.Color;

import Entity.Entity;
import Entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile{

	public static final String objName = "Fireball";
	
	GamePanel gp;
		
	public OBJ_Fireball(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = objName;
		speed = 5;
		maxLife = 80;
		life = maxLife;
		attack = 1;
		knockBackPower = 5;
		useCost = 1;
		alive = false;
		getImage();
	}
	public void getImage()
	{
		up1 = setup("/projectile/fireball_up_1");
		up2 = setup("/projectile/fireball_up_2");
		down1 = setup("/projectile/fireball_down_1");
		down2 = setup("/projectile/fireball_down_2");
		left1 = setup("/projectile/fireball_left_1");
		left2 = setup("/projectile/fireball_left_2");
		right1 = setup("/projectile/fireball_right_1");
		right2 = setup("/projectile/fireball_right_2");
	}
	public boolean haveResource(Entity user)
	{
		boolean haveResource = false;
		if(user.mana >= useCost)
		{
			haveResource = true;
		}
		return haveResource;
	}
	public void subtractResource(Entity user)
	{
		user.mana -= useCost;
	}
	public Color getParticleColor()
	{
		Color color = new Color(240,50,0);
		return color;
	}
	public int getParticleSize()
	{
		int size = 8;
		return size;
	}
	public int getParticleSpeed()
	{
		int speed = 1;
		return speed;
	}
	public int getParticleMaxLife()
	{
		int maxLife = 20;
		return maxLife;
	}
}
