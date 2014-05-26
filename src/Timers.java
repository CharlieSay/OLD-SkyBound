
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
    public static int PreGameTask;

    public static void pregame() {
        PreGameTask = Bukkit.getScheduler().scheduleSyncRepeatingTask((GravityXMain.instance), new Runnable() {
            @Override
            public void run() {
                pregametimer--; 
                for (Player p1 : Bukkit.getOnlinePlayers()) {
                    p1.setLevel(pregametimer);
                    }
                if (pregametimer < 11 && pregametimer > 0) {
                    for (Player p1 : Bukkit.getOnlinePlayers()) {
                        p1.playSound(p1.getLocation(), Sound.ORB_PICKUP, 0, 10);
                    }
                    if (pregametimer < 6) {
                        Bukkit.broadcastMessage(GravityXMain.gamename + pregametimer + " seconds left!");
                    }               
                   
                } else if (pregametimer == 0) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        Vector v = p.getLocation().getDirection().multiply(-1).setY(7);
                        p.setVelocity(v);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 0, 10);
                        p.setLevel(0);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, 100));
                        PogoStick.ItemEquip(p);
                    }
                    GravityXMain.gamestart = true;
                    Bukkit.getScheduler().cancelTask(PreGameTask);
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
