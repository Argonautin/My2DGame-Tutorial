package Object;

import java.awt.Color;

import Entity.Entity;
import Entity.Projectile;
import main.GamePanel;

public class OBJ_Rock extends Projectile{

	public static final String objName = "Rock";
	
	GamePanel gp;
	
	public OBJ_Rock(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = objName;
		speed = 8;
		maxLife = 80;
		life = maxLife;
		attack = 2;
		useCost = 1;
		alive = false;
		getImage();
	}
	public void getImage()
	{
		up1 = setup("/projectile/rock_down_1");
		up2 = setup("/projectile/rock_down_1");
		down1 = setup("/projectile/rock_down_1");
		down2 = setup("/projectile/rock_down_1");
		left1 = setup("/projectile/rock_down_1");
		left2 = setup("/projectile/rock_down_1");
		right1 = setup("/projectile/rock_down_1");
		right2 = setup("/projectile/rock_down_1");
	}
	public boolean haveResource(Entity user)
	{
		boolean haveResource = false;
		if(user.ammo >= useCost)
		{
			haveResource = true;
		}
		return haveResource;
	}
	public void subtractResource(Entity user)
	{
		user.ammo -= useCost;
	}
	public Color getParticleColor()
	{
		Color color = new Color(40,50,0);
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
