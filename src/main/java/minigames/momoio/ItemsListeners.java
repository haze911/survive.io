package minigames.momoio;

import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;

public class ItemsListeners implements Listener {
    private static final int pearlCooldown = Config.get().getInt("items.pearl.cooldown");
    private static final int bowCost = Config.get().getInt("items.bow.cost");

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
            case ENDER_PEARL:
                player.setCooldown(Material.ENDER_PEARL, pearlCooldown);
                break;
            case COBWEB:
                ItemManager.stan(player);
        }
    }
    @EventHandler
    public void onShootBow(EntityShootBowEvent event) {
        Player player = (Player) event.getEntity();
        PlayerManager.getPlayerModel(player).removeWood(bowCost);
    }
}
