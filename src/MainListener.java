
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Charlie
 */
public class MainListener implements Listener {
    
    public static List<String> Playerlist = new ArrayList();
    
    @EventHandler
    public void playerjoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PogoStick.ItemEquip(e.getPlayer());
        e.getPlayer().getInventory().clear();       
        Playerlist.add(e.getPlayer().getName());
        e.setJoinMessage(GravityXMain.gamename + e.getPlayer().getName() + " has joined the game!");
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
    }
    
    @EventHandler
    public void playerleave(PlayerQuitEvent e) {
        Playerlist.remove(e.getPlayer().getName());
    }
    
    @EventHandler
    public void FallDamage(EntityDamageEvent e) {
        if (e.getCause().equals(DamageCause.FALL)) {
            e.setCancelled(true);
        }else if (e.getCause().equals(DamageCause.ENTITY_ATTACK)){
            e.setCancelled(false);
        }
    }
}
