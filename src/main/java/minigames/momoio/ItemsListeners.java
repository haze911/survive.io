package minigames.momoio;

import com.github.stefvanschie.inventoryframework.pane.Pane;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;

public class ItemsListeners implements Listener {
    private static final int pearlCooldown = Config.get().getInt("items.pearl.cooldown");
    private static final int shootCost = Config.get().getInt("items.bow.shootCost");

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (!event.getAction().isRightClick()) return;
        Player player = event.getPlayer();
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        switch (item.getType()){
            case BRICK:
                ItemManager.shoot(player);
                break;
            case FEATHER:
                ItemManager.dash(player);
                break;
            case ENDER_EYE:
                ItemManager.randomTeleport(player);
                break;
            case COBWEB:
                ItemManager.stan(player);
        }
    }
    @EventHandler
    public void onShootBow(EntityShootBowEvent event) {
        Player player = (Player) event.getEntity();
        PlayerManager.getPlayerModel(player).removeWood(shootCost);
    }
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity().getShooter() instanceof Player)) return;
        Player player = (Player) event.getEntity().getShooter();
        if (event.getEntity().getType().equals(EntityType.ENDER_PEARL)) {
            BukkitRunnable timer = new BukkitRunnable() {
                @Override
                public void run() {
                    player.setCooldown(Material.ENDER_PEARL, pearlCooldown);
                }
            };timer.runTaskLater(MoMoio.getPlugin(), 1);
        }
    }
}
