
import java.util.ArrayList;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
public class MainListener implements Listener{
    
    public static List<String> Playerlist = new ArrayList();
    
    @EventHandler
    public void playerjoin(PlayerJoinEvent e){
        PogoStick.ItemEquip(e.getPlayer());
        Playerlist.add(e.getPlayer().getName());
        e.setJoinMessage(GravityXMain.gamename + e.getPlayer().getName() + " has joined the game!");
    }
    
    @EventHandler
    public void playerleave(PlayerQuitEvent e){
        Playerlist.remove(e.getPlayer().getName());
    }
}
