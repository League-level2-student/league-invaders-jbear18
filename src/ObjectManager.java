import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Rocketship rocket;
public ObjectManager(Rocketship rocket) {
	this.rocket=rocket;	
}
void update() {
rocket.update();
for (int i = 0; i < list.size(); i++) {
list.get(i).update();
}
}
void draw(Graphics g) {
	rocket.draw(g);
	for (int i = 0; i < list.size(); i++) {
		list.get(i).draw(g);
	}
}
ArrayList<Projectile>list= new ArrayList<Projectile>();
void addProjectile(Projectile projectile) {
list.add(projectile);
}
}
