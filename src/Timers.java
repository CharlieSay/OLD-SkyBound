
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Timers extends JavaPlugin {

    public static int pregametimer = 30;
    public static int actualtimer = 300;

    public static void pregame() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask((GravityXMain.instance), new Runnable() {
            @Override
            public void run() {
                Player[] players = Bukkit.getServer().getOnlinePlayers();
                pregametimer--;
                for (Player p1 : players) {
                    p1.setLevel(pregametimer);
                }
                if (pregametimer < 11) {
                    for (Player p : players) {
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0, 10);
                    }
                } else if (pregametimer < 5) {
                    Bukkit.broadcastMessage(GravityXMain.gamename + pregametimer + " seconds left!");
                } else if (pregametimer == 0) {
                    for (Player p : players) {
                        Vector v = p.getLocation().getDirection().multiply(-1).setX(0.1);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 0, 10);
                        p.setVelocity(v);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, Integer.MAX_VALUE));
                    }
                    Bukkit.broadcastMessage(GravityXMain.gamename + "Start hitting!");
                }
            }
        }, 0, 20);
    }

//    public void actualgame() {
//        Bukkit.getScheduler().scheduleSyncRepeatingTask((GravityXMain.instance), new Runnable() {
//            @Override
//            public void run() {
//                Player[] players = Bukkit.getServer().getOnlinePlayers();
//                actualtimer--;
//                if (actualtimer < 11) {
//                    for (Player p : players) {
//                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0, 10);
//                    }
//                } else if (actualtimer == 0) {
//                    for (Player p : players) {
//                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 0, 10);
//                    }
//                    Bukkit.broadcastMessage(GravityXMain.gamename + "Start hitting!");
//                } else {
//               }
//            }
//        }, 0, 20);
//    }
}
