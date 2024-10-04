package minigames.momoio;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import me.neznamy.tab.api.TabAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class MoMoio extends JavaPlugin {
    private static MoMoio plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Config.setup();
        Config.get().options().copyDefaults();
        getCommand("momoio").setExecutor(new Commands());
        getCommand("shop").setExecutor(new Commands());
        getCommand("amomoio").setExecutor(new AdminCommands());
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new EntityListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ItemsListeners(), this);
        PlayerManager.init();
        EntityManger.init();
        GuiMenus.init();
    }

    public static MoMoio getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        plugin = this;
        for (Entity entity : EntityManger.getEntityList()) {
            entity.remove();
        }
    }
}