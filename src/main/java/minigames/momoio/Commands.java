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
                PlayerManager.joinPlayer(player);
            }
            if(args[0].equals("spawn")) {
                PlayerManager.teleportToGreenZone(player);
            }
            if(args[0].equals("quit")) {
                PlayerManager.randomPlayerTeleport(player);
                PlayerManager.getPlayerModel(player).setGreenZone(false);
            }
        }
        if (command.getName().equals("shop")) {
            GuiMenus.openGuiShop(player);
        }
        return false;
    }
}
