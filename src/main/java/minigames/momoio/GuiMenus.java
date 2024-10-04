package minigames.momoio;


import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.github.stefvanschie.inventoryframework.pane.util.Slot;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.MatchResult;

public class GuiMenus {
    static ChestGui gui = new ChestGui(6, "Shop");
    static StaticPane pane = new StaticPane(0,0, 9,6);
    private static List<CustomItem> itemList = new ArrayList<>();

    private static CustomItem getItemFromConfig(String id) {
        ItemStack itemStack = new ItemStack(
                Material.getMaterial(Config.get().getString("items." + id + ".material")),
                Config.get().getInt("items." + id + ".amount")
                );
        String name = Config.get().getString("items." + id + ".name");
        ItemMeta meta = itemStack.getItemMeta();
        if (name != null) {
            meta.displayName(Component.text(name));
        }
        List<Component> loreList = new ArrayList<>();
        loreList.add(Component.text("Требования: ").color(NamedTextColor.WHITE));
        loreList.add(Component.text("Уровень: " + Config.get().getInt("items." + id + ".lvl")).color(NamedTextColor.WHITE));
        loreList.add(Component.text("Золото: " + Config.get().getInt("items." + id + ".gold")).color(NamedTextColor.WHITE));
        loreList.add(Component.text("Дерево: " + Config.get().getInt("items." + id + ".wood")).color(NamedTextColor.WHITE));
        loreList.add(Component.text("Камень: " + Config.get().getInt("items." + id + ".stone")).color(NamedTextColor.WHITE));
        meta.lore(loreList);
        itemStack.setItemMeta(meta);
        return new CustomItem(
                itemStack,
                Config.get().getInt("items." + id + ".wood"),
                Config.get().getInt("items." + id + ".stone"),
                Config.get().getInt("items." + id + ".lvl"),
                Config.get().getInt("items." + id + ".gold")
        );
    }
    private static void checkItem(PlayerModel model, CustomItem item) {
        Player player = model.getPlayer();
        if (model.getLvl() < item.getLvl() || model.getStone() < item.getStone() || model.getWood() < item.getWood() || model.getGold() < item.getGold()) {
            model.getPlayer().sendMessage("У вас ненаход");
            return;
        }
        model.removeGold(item.getGold());
        model.removeStone(item.getStone());
        model.removeWood(item.getWood());
        player.getInventory().addItem(item.getItemStack());
    }
    public static void init() {
        itemList.clear();
        int i = 0;
        for (String key : Config.get().getConfigurationSection("items").getKeys(false)) {
            CustomItem item = getItemFromConfig(key);
            itemList.add(item);
            pane.addItem( new GuiItem(item.getItemStack()), Slot.fromIndex(i));
            i++;
        }
        pane.setOnClick(event -> {
            if (event.getCurrentItem() == null) return;
            Player player = (Player) event.getWhoClicked();
            PlayerModel playerModel = PlayerManager.getPlayerModel(player);
            for (CustomItem item : itemList) {
                if (item.getItemStack().getType().equals(event.getCurrentItem().getType())) {
                    checkItem(playerModel, item);
                    break;
                }
            }
            event.setCancelled(true);
        });
        gui.addPane(pane);
        gui.update();
    }
    public static void openGuiShop(Player player) {
        gui.show(player);
    }
}
class CustomItem {
    private ItemStack itemStack;
    private int wood;
    private int stone;
    private int lvl;
    private int gold;
    public CustomItem(ItemStack itemStack, int wood, int stone, int lvl, int gold) {
        this.itemStack = itemStack;
        this.wood = wood;
        this.stone = stone;
        this.lvl = lvl;
        this.gold = gold;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getLvl() {
        return lvl;
    }

    public int getGold() {
        return gold;
    }
}
