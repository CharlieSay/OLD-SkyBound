
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charlie
 */
public class PogoStick{
    
    public static void ItemEquip(Player p){
        ItemStack PogoStick = new ItemStack(Material.STICK,1);
        ItemMeta PogoMeta = PogoStick.getItemMeta();
        PogoMeta.setDisplayName(ChatColor.DARK_PURPLE + ""+ ChatColor.MAGIC+
                "++" + ChatColor.RESET + ChatColor.DARK_RED + "The Whacker" + ChatColor.DARK_PURPLE + ""+ ChatColor.MAGIC+
                "++");
        PogoMeta.addEnchant(Enchantment.KNOCKBACK, 3, true);
        PogoStick.setItemMeta(PogoMeta);
        p.getInventory().setItem(0, PogoStick);
    }
    
}
