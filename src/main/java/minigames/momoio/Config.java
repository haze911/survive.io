package minigames.momoio;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private  static File file;
    private  static FileConfiguration fileConfiguration;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("MoMoio").getDataFolder(), "customconfig.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException e) {}
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration get() {
        return fileConfiguration;
    }
    public static void reload() {
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }
}
