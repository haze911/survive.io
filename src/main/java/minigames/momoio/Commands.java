package minigames.momoio;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;
        if (command.getName().equals("momoio")) {
            if (args[0].equals("join")) {
                PlayerManager.addPlayer(player);
                PlayerManager.randomPlayerTeleport(player);
                ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
                ItemStack axe = new ItemStack(Material.WOODEN_AXE);
                ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                pickaxeMeta.setUnbreakable(true);
                pickaxe.setItemMeta(pickaxeMeta);
                ItemMeta axeMeta = axe.getItemMeta();
                axeMeta.setUnbreakable(true);
                axe.setItemMeta(axeMeta);
                player.getInventory().setItem(0, pickaxe);
                player.getInventory().setItem(1, axe);
            }
        }
        if (command.getName().equals("shop")) {
            GuiMenus.openGuiShop(player);
        }
        return false;
    }
}
