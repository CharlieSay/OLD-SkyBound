
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathCheck implements Listener {
    
    @EventHandler
    public void PlayerDeathCheck(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if ((player.getLocation().getBlock().getType() == Material.LAVA)
                || (player.getLocation().getBlock().getType() == Material.STATIONARY_LAVA)) {
            player.setHealth(0D);
        }
        
    }
    
    @EventHandler
    public void PlayerRespawn(PlayerRespawnEvent e){
        PogoStick.ItemEquip(e.getPlayer());
    }
    
    @EventHandler
    public void DeathMessage(PlayerDeathEvent e){
        e.getDrops().clear();
        e.setDeathMessage(null);
    }
}
