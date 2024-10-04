package minigames.momoio;


import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
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
    private static GuiItem itemMushket = new GuiItem(new ItemStack(Material.BRICK));
    private static final int lvlForMushket = Config.get().getInt("items.mushket.lvl");
    private static final int woodForMushket = Config.get().getInt("items.mushket.wood");
    private static final int stoneForMushket = Config.get().getInt("items.mushket.stone");
    private static final int goldForMushket = Config.get().getInt("items.mushket.gold");

    private static GuiItem itemStonePickaxe = new GuiItem(new ItemStack(Material.STONE_PICKAXE));
    private static final int lvlForStonePickaxe = Config.get().getInt("items.stonePickaxe.lvl");
    private static final int woodForStonePickaxe = Config.get().getInt("items.stonePickaxe.wood");
    private static final int stoneForStonePickaxe = Config.get().getInt("items.stonePickaxe.stone");
    private static final int goldForStonePickaxe = Config.get().getInt("items.stonePickaxe.gold");
    private static GuiItem itemIronPickaxe = new GuiItem(new ItemStack(Material.IRON_PICKAXE));
    private static final int lvlForIronPickaxe = Config.get().getInt("items.ironPickaxe.lvl");
    private static final int woodForIronPickaxe = Config.get().getInt("items.ironPickaxe.wood");
    private static final int stoneForIronPickaxe = Config.get().getInt("items.ironPickaxe.stone");
    private static final int goldForIronPickaxe = Config.get().getInt("items.ironPickaxe.gold");
    private static GuiItem itemDiamondPickaxe = new GuiItem(new ItemStack(Material.DIAMOND_PICKAXE));
    private static final int lvlForDiamondPickaxe = Config.get().getInt("items.diamondPickaxe.lvl");
    private static final int woodForDiamondPickaxe = Config.get().getInt("items.diamondPickaxe.wood");
    private static final int stoneForDiamondPickaxe = Config.get().getInt("items.diamondPickaxe.stone");
    private static final int goldForDiamondPickaxe = Config.get().getInt("items.diamondPickaxe.gold");
    private static GuiItem itemStoneAxe = new GuiItem(new ItemStack(Material.STONE_AXE));
    private static final int lvlForStoneAxe = Config.get().getInt("items.stoneAxe.lvl");
    private static final int woodForStoneAxe = Config.get().getInt("items.stoneAxe.wood");
    private static final int stoneForStoneAxe = Config.get().getInt("items.stoneAxe.stone");
    private static final int goldForStoneAxe = Config.get().getInt("items.stoneAxe.gold");
    private static GuiItem itemIronAxe = new GuiItem(new ItemStack(Material.IRON_AXE));
    private static final int lvlForIronAxe = Config.get().getInt("items.ironAxe.lvl");
    private static final int woodForIronAxe = Config.get().getInt("items.ironAxe.wood");
    private static final int stoneForIronAxe = Config.get().getInt("items.ironAxe.stone");
    private static final int goldForIronAxe = Config.get().getInt("items.ironAxe.gold");
    private static GuiItem itemDiamondAxe = new GuiItem(new ItemStack(Material.DIAMOND_AXE));
    private static final int lvlForDiamondAxe = Config.get().getInt("items.diamondAxe.lvl");
    private static final int woodForDiamondAxe = Config.get().getInt("items.diamondAxe.wood");
    private static final int stoneForDiamondAxe = Config.get().getInt("items.diamondAxe.stone");
    private static final int goldForDiamondAxe = Config.get().getInt("items.diamondAxe.gold");
    private static GuiItem itemStoneSword = new GuiItem(new ItemStack(Material.STONE_SWORD));
    private static final int lvlForStoneSword = Config.get().getInt("items.stoneSword.lvl");
    private static final int woodForStoneSword = Config.get().getInt("items.stoneSword.wood");
    private static final int stoneForStoneSword = Config.get().getInt("items.stoneSword.stone");
    private static final int goldForStoneSword = Config.get().getInt("items.stoneSword.gold");
    private static GuiItem itemIronSword = new GuiItem(new ItemStack(Material.IRON_SWORD));
    private static final int lvlForIronSword = Config.get().getInt("items.ironSword.lvl");
    private static final int woodForIronSword = Config.get().getInt("items.ironSword.wood");
    private static final int stoneForIronSword = Config.get().getInt("items.ironSword.stone");
    private static final int goldForIronSword = Config.get().getInt("items.ironSword.gold");
    private static GuiItem itemDiamondSword = new GuiItem(new ItemStack(Material.DIAMOND_SWORD));
    private static final int lvlForDiamondSword = Config.get().getInt("items.diamondSword.lvl");
    private static final int woodForDiamondSword = Config.get().getInt("items.diamondSword.wood");
    private static final int stoneForDiamondSword = Config.get().getInt("items.diamondSword.stone");
    private static final int goldForDiamondSword = Config.get().getInt("items.diamondSword.gold");
    private static GuiItem itemStoneShovel = new GuiItem(new ItemStack(Material.STONE_SHOVEL));
    private static final int lvlForStoneShovel = Config.get().getInt("items.stoneShovel.lvl");
    private static final int woodForStoneShovel = Config.get().getInt("items.stoneShovel.wood");
    private static final int stoneForStoneShovel = Config.get().getInt("items.stoneShovel.stone");
    private static final int goldForStoneShovel = Config.get().getInt("items.stoneShovel.gold");
    private static GuiItem itemIronShovel = new GuiItem(new ItemStack(Material.IRON_SHOVEL));
    private static final int lvlForIronShovel = Config.get().getInt("items.ironShovel.lvl");
    private static final int woodForIronShovel = Config.get().getInt("items.ironShovel.wood");
    private static final int stoneForIronShovel = Config.get().getInt("items.ironShovel.stone");
    private static final int goldForIronShovel = Config.get().getInt("items.ironShovel.gold");
    private static GuiItem itemDiamondShovel = new GuiItem(new ItemStack(Material.DIAMOND_SHOVEL));
    private static final int lvlForDiamondShovel = Config.get().getInt("items.diamondShovel.lvl");
    private static final int woodForDiamondShovel = Config.get().getInt("items.diamondShovel.wood");
    private static final int stoneForDiamondShovel = Config.get().getInt("items.diamondShovel.stone");
    private static final int goldForDiamondShovel = Config.get().getInt("items.diamondShovel.gold");
    private static GuiItem itemStoneHoe = new GuiItem(new ItemStack(Material.STONE_HOE));
    private static final int lvlForStoneHoe = Config.get().getInt("items.stoneHoe.lvl");
    private static final int woodForStoneHoe = Config.get().getInt("items.stoneHoe.wood");
    private static final int stoneForStoneHoe = Config.get().getInt("items.stoneHoe.stone");
    private static final int goldForStoneHoe = Config.get().getInt("items.stoneHoe.gold");
    private static GuiItem itemIronHoe = new GuiItem(new ItemStack(Material.IRON_HOE));
    private static final int lvlForIronHoe = Config.get().getInt("items.ironHoe.lvl");
    private static final int woodForIronHoe = Config.get().getInt("items.ironHoe.wood");
    private static final int stoneForIronHoe = Config.get().getInt("items.ironHoe.stone");
    private static final int goldForIronHoe = Config.get().getInt("items.ironHoe.gold");
    private static GuiItem itemDiamondHoe = new GuiItem(new ItemStack(Material.DIAMOND_HOE));
    private static final int lvlForDiamondHoe = Config.get().getInt("items.diamondHoe.lvl");
    private static final int woodForDiamondHoe = Config.get().getInt("items.diamondHoe.wood");
    private static final int stoneForDiamondHoe = Config.get().getInt("items.diamondHoe.stone");
    private static final int goldForDiamondHoe = Config.get().getInt("items.diamondHoe.gold");
    private static GuiItem itemLeatherHelmet = new GuiItem(new ItemStack(Material.LEATHER_HELMET));
    private static final int lvlForLeatherHelmet = Config.get().getInt("items.leatherHelmet.lvl");
    private static final int woodForLeatherHelmet = Config.get().getInt("items.leatherHelmet.wood");
    private static final int stoneForLeatherHelmet = Config.get().getInt("items.leatherHelmet.stone");
    private static final int goldForLeatherHelmet = Config.get().getInt("items.leatherHelmet.gold");
    private static GuiItem itemLeatherChestplate = new GuiItem(new ItemStack(Material.LEATHER_CHESTPLATE));
    private static final int lvlForLeatherChestplate = Config.get().getInt("items.leatherChestplate.lvl");
    private static final int woodForLeatherChestplate = Config.get().getInt("items.leatherChestplate.wood");
    private static final int stoneForLeatherChestplate = Config.get().getInt("items.leatherChestplate.stone");
    private static final int goldForLeatherChestplate = Config.get().getInt("items.leatherChestplate.gold");
    private static GuiItem itemLeatherLeggings = new GuiItem(new ItemStack(Material.LEATHER_LEGGINGS));
    private static final int lvlForLeatherLeggings = Config.get().getInt("items.leatherLeggings.lvl");
    private static final int woodForLeatherLeggings = Config.get().getInt("items.leatherLeggings.wood");
    private static final int stoneForLeatherLeggings = Config.get().getInt("items.leatherLeggings.stone");
    private static final int goldForLeatherLeggings = Config.get().getInt("items.leatherLeggings.gold");
    private static GuiItem itemLeatherBoots = new GuiItem(new ItemStack(Material.LEATHER_BOOTS));
    private static final int lvlForLeatherBoots = Config.get().getInt("items.leatherBoots.lvl");
    private static final int woodForLeatherBoots = Config.get().getInt("items.leatherBoots.wood");
    private static final int stoneForLeatherBoots = Config.get().getInt("items.leatherBoots.stone");
    private static final int goldForLeatherBoots = Config.get().getInt("items.leatherBoots.gold");
    private static GuiItem itemIronHelmet = new GuiItem(new ItemStack(Material.IRON_HELMET));
    private static final int lvlForIronHelmet = Config.get().getInt("items.ironHelmet.lvl");
    private static final int woodForIronHelmet = Config.get().getInt("items.ironHelmet.wood");
    private static final int stoneForIronHelmet = Config.get().getInt("items.ironHelmet.stone");
    private static final int goldForIronHelmet = Config.get().getInt("items.ironHelmet.gold");
    private static GuiItem itemIronChestplate = new GuiItem(new ItemStack(Material.IRON_CHESTPLATE));
    private static final int lvlForIronChestplate = Config.get().getInt("items.ironChestplate.lvl");
    private static final int woodForIronChestplate = Config.get().getInt("items.ironChestplate.wood");
    private static final int stoneForIronChestplate = Config.get().getInt("items.ironChestplate.stone");
    private static final int goldForIronChestplate = Config.get().getInt("items.ironChestplate.gold");
    private static GuiItem itemIronLeggings = new GuiItem(new ItemStack(Material.IRON_LEGGINGS));
    private static final int lvlForIronLeggings = Config.get().getInt("items.ironLeggings.lvl");
    private static final int woodForIronLeggings = Config.get().getInt("items.ironLeggings.wood");
    private static final int stoneForIronLeggings = Config.get().getInt("items.ironLeggings.stone");
    private static final int goldForIronLeggings = Config.get().getInt("items.ironLeggings.gold");
    private static GuiItem itemIronBoots = new GuiItem(new ItemStack(Material.IRON_BOOTS));
    private static final int lvlForIronBoots = Config.get().getInt("items.ironBoots.lvl");
    private static final int woodForIronBoots = Config.get().getInt("items.ironBoots.wood");
    private static final int stoneForIronBoots = Config.get().getInt("items.ironBoots.stone");
    private static final int goldForIronBoots = Config.get().getInt("items.ironBoots.gold");
    private static GuiItem itemDiamondHelmet = new GuiItem(new ItemStack(Material.DIAMOND_HELMET));
    private static final int lvlForDiamondHelmet = Config.get().getInt("items.diamondHelmet.lvl");
    private static final int woodForDiamondHelmet = Config.get().getInt("items.diamondHelmet.wood");
    private static final int stoneForDiamondHelmet = Config.get().getInt("items.diamondHelmet.stone");
    private static final int goldForDiamondHelmet = Config.get().getInt("items.diamondHelmet.gold");
    private static GuiItem itemDiamondChestplate = new GuiItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
    private static final int lvlForDiamondChestplate = Config.get().getInt("items.diamondChestplate.lvl");
    private static final int woodForDiamondChestplate = Config.get().getInt("items.diamondChestplate.wood");
    private static final int stoneForDiamondChestplate = Config.get().getInt("items.diamondChestplate.stone");
    private static final int goldForDiamondChestplate = Config.get().getInt("items.diamondChestplate.gold");
    private static GuiItem itemDiamondLeggings = new GuiItem(new ItemStack(Material.DIAMOND_LEGGINGS));
    private static final int lvlForDiamondLeggings = Config.get().getInt("items.diamondLeggings.lvl");
    private static final int woodForDiamondLeggings = Config.get().getInt("items.diamondLeggings.wood");
    private static final int stoneForDiamondLeggings = Config.get().getInt("items.diamondLeggings.stone");
    private static final int goldForDiamondLeggings = Config.get().getInt("items.diamondLeggings.gold");
    private static GuiItem itemDiamondBoots = new GuiItem(new ItemStack(Material.DIAMOND_BOOTS));
    private static final int lvlForDiamondBoots = Config.get().getInt("items.diamondBoots.lvl");
    private static final int woodForDiamondBoots = Config.get().getInt("items.diamondBoots.wood");
    private static final int stoneForDiamondBoots = Config.get().getInt("items.diamondBoots.stone");
    private static final int goldForDiamondBoots = Config.get().getInt("items.diamondBoots.gold");
    private static GuiItem itemBow = new GuiItem(new ItemStack(Material.BOW));
    private static final int lvlForBow = Config.get().getInt("items.bow.lvl");
    private static final int woodForBow = Config.get().getInt("items.bow.wood");
    private static final int stoneForBow = Config.get().getInt("items.bow.stone");
    private static final int goldForBow = Config.get().getInt("items.bow.gold");
    private static GuiItem itemPearl = new GuiItem(new ItemStack(Material.ENDER_PEARL));
    private static final int lvlForPearl = Config.get().getInt("items.pearl.lvl");
    private static final int woodForPearl = Config.get().getInt("items.pearl.wood");
    private static final int stoneForPearl = Config.get().getInt("items.pearl.stone");
    private static final int goldForPearl = Config.get().getInt("items.pearl.gold");
    private static GuiItem itemEnderEye = new GuiItem(new ItemStack(Material.ENDER_EYE));
    private static final int lvlForEnderEye = Config.get().getInt("items.enderEye.lvl");
    private static final int woodForEnderEye = Config.get().getInt("items.enderEye.wood");
    private static final int stoneForEnderEye = Config.get().getInt("items.enderEye.stone");
    private static final int goldForEnderEye = Config.get().getInt("items.enderEye.gold");
    private static GuiItem itemCobWeb = new GuiItem(new ItemStack(Material.COBWEB));
    private static final int lvlForCobWeb = Config.get().getInt("items.cobWeb.lvl");
    private static final int woodForCobWeb = Config.get().getInt("items.cobWeb.wood");
    private static final int stoneForCobWeb = Config.get().getInt("items.cobWeb.stone");
    private static final int goldForCobWeb = Config.get().getInt("items.cobWeb.gold");
    private static GuiItem itemFeather = new GuiItem(new ItemStack(Material.FEATHER));
    private static final int lvlForFeather = Config.get().getInt("items.feather.lvl");
    private static final int woodForFeather = Config.get().getInt("items.feather.wood");
    private static final int stoneForFeather = Config.get().getInt("items.feather.stone");
    private static final int goldForFeather = Config.get().getInt("items.feather.gold");
    private static GuiItem itemOakPlanks = new GuiItem(new ItemStack(Material.OAK_PLANKS));
    private static final int lvlForOakPlanks = Config.get().getInt("items.oakPlanks.lvl");
    private static final int woodForOakPlanks = Config.get().getInt("items.oakPlanks.wood");
    private static final int stoneForOakPlanks = Config.get().getInt("items.oakPlanks.stone");
    private static final int goldForOakPlanks = Config.get().getInt("items.oakPlanks.gold");
    private static GuiItem itemStoneBricks = new GuiItem(new ItemStack(Material.STONE_BRICKS));
    private static final int lvlForStoneBricks = Config.get().getInt("items.stoneBricks.lvl");
    private static final int woodForStoneBricks = Config.get().getInt("items.stoneBricks.wood");
    private static final int stoneForStoneBricks = Config.get().getInt("items.stoneBricks.stone");
    private static final int goldForStoneBricks = Config.get().getInt("items.stoneBricks.gold");

    static ChestGui gui = new ChestGui(6, "Shop");
    static StaticPane pane = new StaticPane(0,0, 9,6);

    public static void init() {
        pane.addItem(itemMushket, 0,0);
        pane.addItem(itemStonePickaxe, 1,0);
        pane.addItem(itemIronPickaxe, 2,0);
        pane.addItem(itemDiamondPickaxe, 3,0);
        pane.addItem(itemStoneAxe, 4,0);
        pane.addItem(itemIronAxe, 5,0);
        pane.addItem(itemDiamondAxe, 6,0);
        pane.addItem(itemStoneSword, 7,0);
        pane.addItem(itemIronSword, 8,0);
        pane.addItem(itemDiamondSword, 0,1);
        pane.addItem(itemStoneShovel, 1,1);
        pane.addItem(itemIronShovel, 2,1);
        pane.addItem(itemDiamondShovel, 3,1);
        pane.addItem(itemStoneHoe, 4,1);
        pane.addItem(itemIronHoe, 5,1);
        pane.addItem(itemDiamondHoe, 6,1);
        pane.addItem(itemLeatherHelmet, 7,1);
        pane.addItem(itemLeatherChestplate, 8,1);
        pane.addItem(itemLeatherLeggings, 0,2);
        pane.addItem(itemLeatherBoots, 1,2);
        pane.addItem(itemIronHelmet, 2,2);
        pane.addItem(itemIronChestplate, 3,2);
        pane.addItem(itemIronLeggings, 4,2);
        pane.addItem(itemIronBoots, 5,2);
        pane.addItem(itemDiamondHelmet, 6,2);
        pane.addItem(itemDiamondChestplate, 7,2);
        pane.addItem(itemDiamondLeggings, 8,2);
        pane.addItem(itemDiamondBoots, 0,3);
        pane.addItem(itemBow, 1,3);
        pane.addItem(itemPearl, 2,3);
        pane.addItem(itemEnderEye, 3,3);
        pane.addItem(itemFeather, 4,3);
        pane.addItem(itemCobWeb, 5,3);
        pane.addItem(itemOakPlanks, 6,3);
        pane.addItem(itemStoneBricks, 7,3);

        pane.setOnClick(event -> {
            Player player = (Player) event.getWhoClicked();
            PlayerModel playerModel = PlayerManager.getPlayerModel(player);
            switch (event.getCurrentItem().getType()) {
                case BRICK:
                    if (playerModel.getLvl() < lvlForMushket || playerModel.getStone() < stoneForMushket || playerModel.getGold() < goldForMushket || playerModel.getWood() < woodForMushket) return;
                    playerModel.removeStone(woodForMushket);
                    playerModel.removeStone(stoneForMushket);
                    playerModel.removeGold(goldForMushket);
                    player.getInventory().addItem(new ItemStack(Material.BRICK));
                    break;
                case STONE_PICKAXE:
                    if (playerModel.getLvl() < lvlForStonePickaxe || playerModel.getStone() < stoneForStonePickaxe || playerModel.getGold() < goldForStonePickaxe || playerModel.getWood() < woodForStonePickaxe) return;
                    playerModel.removeStone(woodForStonePickaxe);
                    playerModel.removeStone(stoneForStonePickaxe);
                    playerModel.removeGold(goldForStonePickaxe);
                    player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
                    break;
                case IRON_PICKAXE:
                    if (playerModel.getLvl() < lvlForIronPickaxe || playerModel.getStone() < stoneForIronPickaxe || playerModel.getGold() < goldForIronPickaxe || playerModel.getWood() < woodForIronPickaxe) return;
                    playerModel.removeStone(woodForIronPickaxe);
                    playerModel.removeStone(stoneForIronPickaxe);
                    playerModel.removeGold(goldForIronPickaxe);
                    player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
                    break;
                case DIAMOND_PICKAXE:
                    if (playerModel.getLvl() < lvlForDiamondPickaxe || playerModel.getStone() < stoneForDiamondPickaxe || playerModel.getGold() < goldForDiamondPickaxe || playerModel.getWood() < woodForDiamondPickaxe) return;
                    playerModel.removeStone(woodForDiamondPickaxe);
                    playerModel.removeStone(stoneForDiamondPickaxe);
                    playerModel.removeGold(goldForDiamondPickaxe);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
                    break;
                case STONE_AXE:
                    if (playerModel.getLvl() < lvlForStoneAxe || playerModel.getStone() < stoneForStoneAxe || playerModel.getGold() < goldForStoneAxe || playerModel.getWood() < woodForStoneAxe) return;
                    playerModel.removeStone(woodForStoneAxe);
                    playerModel.removeStone(stoneForStoneAxe);
                    playerModel.removeGold(goldForStoneAxe);
                    player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
                    break;
                case IRON_AXE:
                    if (playerModel.getLvl() < lvlForIronAxe || playerModel.getStone() < stoneForIronAxe || playerModel.getGold() < goldForIronAxe || playerModel.getWood() < woodForIronAxe) return;
                    playerModel.removeStone(woodForIronAxe);
                    playerModel.removeStone(stoneForIronAxe);
                    playerModel.removeGold(goldForIronAxe);
                    player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
                    break;
                case DIAMOND_AXE:
                    if (playerModel.getLvl() < lvlForDiamondAxe || playerModel.getStone() < stoneForDiamondAxe || playerModel.getGold() < goldForDiamondAxe || playerModel.getWood() < woodForDiamondAxe) return;
                    playerModel.removeStone(woodForDiamondAxe);
                    playerModel.removeStone(stoneForDiamondAxe);
                    playerModel.removeGold(goldForDiamondAxe);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
                    break;
                case STONE_SWORD:
                    if (playerModel.getLvl() < lvlForStoneSword || playerModel.getStone() < stoneForStoneSword || playerModel.getGold() < goldForStoneSword || playerModel.getWood() < woodForStoneSword) return;
                    playerModel.removeStone(woodForMushket);
                    playerModel.removeStone(stoneForStoneSword);
                    playerModel.removeGold(goldForStoneSword);
                    player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
                    break;
                case IRON_SWORD:
                    if (playerModel.getLvl() < lvlForIronSword || playerModel.getStone() < stoneForIronSword || playerModel.getGold() < goldForIronSword || playerModel.getWood() < woodForIronSword) return;
                    playerModel.removeStone(woodForIronSword);
                    playerModel.removeStone(stoneForIronSword);
                    playerModel.removeGold(goldForIronSword);
                    player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                    break;
                case DIAMOND_SWORD:
                    if (playerModel.getLvl() < lvlForDiamondSword || playerModel.getStone() < stoneForDiamondSword || playerModel.getGold() < goldForDiamondSword || playerModel.getWood() < woodForDiamondSword) return;
                    playerModel.removeStone(woodForDiamondSword);
                    playerModel.removeStone(stoneForDiamondSword);
                    playerModel.removeGold(goldForDiamondSword);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    break;
                case STONE_SHOVEL:
                    if (playerModel.getLvl() < lvlForStoneShovel || playerModel.getStone() < stoneForStoneShovel || playerModel.getGold() < goldForStoneShovel || playerModel.getWood() < woodForStoneShovel) return;
                    playerModel.removeStone(woodForStoneShovel);
                    playerModel.removeStone(stoneForStoneShovel);
                    playerModel.removeGold(goldForStoneShovel);
                    player.getInventory().addItem(new ItemStack(Material.STONE_SHOVEL));
                    break;
                case IRON_SHOVEL:
                    if (playerModel.getLvl() < lvlForIronShovel || playerModel.getStone() < stoneForIronShovel || playerModel.getGold() < goldForIronShovel || playerModel.getWood() < woodForIronShovel) return;
                    playerModel.removeStone(woodForIronSword);
                    playerModel.removeStone(stoneForIronSword);
                    playerModel.removeGold(goldForIronSword);
                    player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                    break;
                case DIAMOND_SHOVEL:
                    if (playerModel.getLvl() < lvlForDiamondShovel || playerModel.getStone() < stoneForDiamondShovel || playerModel.getGold() < goldForDiamondShovel || playerModel.getWood() < woodForDiamondShovel) return;
                    playerModel.removeStone(woodForDiamondShovel);
                    playerModel.removeStone(stoneForDiamondShovel);
                    playerModel.removeGold(goldForDiamondShovel);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SHOVEL));
                    break;
                case STONE_HOE:
                    if (playerModel.getLvl() < lvlForStoneHoe || playerModel.getStone() < stoneForStoneHoe || playerModel.getGold() < goldForStoneHoe || playerModel.getWood() < woodForStoneHoe) return;
                    playerModel.removeStone(woodForStoneHoe);
                    playerModel.removeStone(stoneForStoneHoe);
                    playerModel.removeGold(goldForStoneHoe);
                    player.getInventory().addItem(new ItemStack(Material.STONE_HOE));
                    break;
                case IRON_HOE:
                    if (playerModel.getLvl() < lvlForIronHoe || playerModel.getStone() < stoneForIronHoe || playerModel.getGold() < goldForIronHoe || playerModel.getWood() < woodForIronHoe) return;
                    playerModel.removeStone(woodForIronSword);
                    playerModel.removeStone(stoneForIronSword);
                    playerModel.removeGold(goldForIronSword);
                    player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                    break;
                case DIAMOND_HOE:
                    if (playerModel.getLvl() < lvlForDiamondHoe || playerModel.getStone() < stoneForDiamondHoe || playerModel.getGold() < goldForDiamondHoe || playerModel.getWood() < woodForDiamondHoe) return;
                    playerModel.removeStone(woodForDiamondHoe);
                    playerModel.removeStone(stoneForDiamondHoe);
                    playerModel.removeGold(goldForDiamondHoe);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_HOE));
                    break;
                case LEATHER_HELMET:
                    if (playerModel.getLvl() < lvlForLeatherHelmet || playerModel.getStone() < stoneForLeatherHelmet || playerModel.getGold() < goldForLeatherHelmet || playerModel.getWood() < woodForLeatherHelmet) return;
                    playerModel.removeStone(woodForLeatherHelmet);
                    playerModel.removeStone(stoneForLeatherHelmet);
                    playerModel.removeGold(goldForLeatherHelmet);
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_HELMET));
                    break;
                case LEATHER_CHESTPLATE:
                    if (playerModel.getLvl() < lvlForLeatherChestplate || playerModel.getStone() < stoneForLeatherChestplate || playerModel.getGold() < goldForLeatherChestplate || playerModel.getWood() < woodForLeatherChestplate) return;
                    playerModel.removeStone(woodForLeatherChestplate);
                    playerModel.removeStone(stoneForLeatherChestplate);
                    playerModel.removeGold(goldForLeatherChestplate);
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE));
                    break;
                case LEATHER_LEGGINGS:
                    if (playerModel.getLvl() < lvlForLeatherLeggings || playerModel.getStone() < stoneForLeatherLeggings || playerModel.getGold() < goldForLeatherLeggings || playerModel.getWood() < woodForLeatherLeggings) return;
                    playerModel.removeStone(woodForLeatherLeggings);
                    playerModel.removeStone(stoneForLeatherLeggings);
                    playerModel.removeGold(goldForLeatherLeggings);
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS));
                    break;
                case LEATHER_BOOTS:
                    if (playerModel.getLvl() < lvlForLeatherBoots || playerModel.getStone() < stoneForLeatherBoots || playerModel.getGold() < goldForLeatherBoots || playerModel.getWood() < woodForLeatherBoots) return;
                    playerModel.removeStone(woodForLeatherBoots);
                    playerModel.removeStone(stoneForLeatherBoots);
                    playerModel.removeGold(goldForLeatherBoots);
                    player.getInventory().addItem(new ItemStack(Material.LEATHER_BOOTS));
                    break;
                case IRON_HELMET:
                    if (playerModel.getLvl() < lvlForIronHelmet || playerModel.getStone() < stoneForIronHelmet || playerModel.getGold() < goldForIronHelmet || playerModel.getWood() < woodForIronHelmet) return;
                    playerModel.removeStone(woodForIronHelmet);
                    playerModel.removeStone(stoneForIronHelmet);
                    playerModel.removeGold(goldForIronHelmet);
                    player.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
                    break;
                case IRON_CHESTPLATE:
                    if (playerModel.getLvl() < lvlForIronChestplate || playerModel.getStone() < stoneForIronChestplate || playerModel.getGold() < goldForIronChestplate || playerModel.getWood() < woodForIronChestplate) return;
                    playerModel.removeStone(woodForIronChestplate);
                    playerModel.removeStone(stoneForIronChestplate);
                    playerModel.removeGold(goldForIronChestplate);
                    player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
                    break;
                case IRON_LEGGINGS:
                    if (playerModel.getLvl() < lvlForIronLeggings || playerModel.getStone() < stoneForIronLeggings || playerModel.getGold() < goldForIronLeggings || playerModel.getWood() < woodForIronLeggings) return;
                    playerModel.removeStone(woodForIronLeggings);
                    playerModel.removeStone(stoneForIronLeggings);
                    playerModel.removeGold(goldForIronLeggings);
                    player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
                    break;
                case IRON_BOOTS:
                    if (playerModel.getLvl() < lvlForIronBoots || playerModel.getStone() < stoneForIronBoots || playerModel.getGold() < goldForIronBoots || playerModel.getWood() < woodForIronBoots) return;
                    playerModel.removeStone(woodForIronBoots);
                    playerModel.removeStone(stoneForIronBoots);
                    playerModel.removeGold(goldForIronBoots);
                    player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
                    break;
                case DIAMOND_HELMET:
                    if (playerModel.getLvl() < lvlForDiamondHelmet || playerModel.getStone() < stoneForDiamondHelmet || playerModel.getGold() < goldForDiamondHelmet || playerModel.getWood() < woodForDiamondHelmet) return;
                    playerModel.removeStone(woodForDiamondHelmet);
                    playerModel.removeStone(stoneForDiamondHelmet);
                    playerModel.removeGold(goldForDiamondHelmet);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
                    break;
                case DIAMOND_CHESTPLATE:
                    if (playerModel.getLvl() < lvlForDiamondChestplate || playerModel.getStone() < stoneForDiamondChestplate || playerModel.getGold() < goldForDiamondChestplate || playerModel.getWood() < woodForDiamondChestplate) return;
                    playerModel.removeStone(woodForDiamondChestplate);
                    playerModel.removeStone(stoneForDiamondChestplate);
                    playerModel.removeGold(goldForDiamondChestplate);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
                    break;
                case DIAMOND_LEGGINGS:
                    if (playerModel.getLvl() < lvlForDiamondLeggings || playerModel.getStone() < stoneForDiamondLeggings || playerModel.getGold() < goldForDiamondLeggings || playerModel.getWood() < woodForDiamondLeggings) return;
                    playerModel.removeStone(woodForDiamondLeggings);
                    playerModel.removeStone(stoneForDiamondLeggings);
                    playerModel.removeGold(goldForDiamondLeggings);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
                    break;
                case DIAMOND_BOOTS:
                    if (playerModel.getLvl() < lvlForDiamondBoots || playerModel.getStone() < stoneForDiamondBoots || playerModel.getGold() < goldForDiamondBoots || playerModel.getWood() < woodForDiamondBoots) return;
                    playerModel.removeStone(woodForDiamondBoots);
                    playerModel.removeStone(stoneForDiamondBoots);
                    playerModel.removeGold(goldForDiamondBoots);
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
                    break;
                case BOW:
                    if (playerModel.getLvl() < lvlForBow || playerModel.getStone() < stoneForBow || playerModel.getGold() < goldForBow || playerModel.getWood() < woodForBow) return;
                    playerModel.removeStone(woodForBow);
                    playerModel.removeStone(stoneForBow);
                    playerModel.removeGold(goldForBow);
                    player.getInventory().addItem(new ItemStack(Material.BOW));
                    break;
                case ENDER_PEARL:
                    if (playerModel.getLvl() < lvlForPearl || playerModel.getStone() < stoneForPearl || playerModel.getGold() < goldForPearl || playerModel.getWood() < woodForPearl) return;
                    playerModel.removeStone(woodForPearl);
                    playerModel.removeStone(stoneForPearl);
                    playerModel.removeGold(goldForPearl);
                    player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                    break;
                case ENDER_EYE:
                    if (playerModel.getLvl() < lvlForEnderEye || playerModel.getStone() < stoneForEnderEye || playerModel.getGold() < goldForEnderEye || playerModel.getWood() < woodForEnderEye) return;
                    playerModel.removeStone(woodForEnderEye);
                    playerModel.removeStone(stoneForEnderEye);
                    playerModel.removeGold(goldForEnderEye);
                    player.getInventory().addItem(new ItemStack(Material.ENDER_EYE));
                    break;
                case COBWEB:
                    if (playerModel.getLvl() < lvlForCobWeb || playerModel.getStone() < stoneForCobWeb || playerModel.getGold() < goldForCobWeb || playerModel.getWood() < woodForCobWeb) return;
                    playerModel.removeStone(woodForCobWeb);
                    playerModel.removeStone(stoneForCobWeb);
                    playerModel.removeGold(goldForCobWeb);
                    player.getInventory().addItem(new ItemStack(Material.COBWEB));
                    break;
                case OAK_PLANKS:
                    if (playerModel.getLvl() < lvlForOakPlanks || playerModel.getStone() < stoneForOakPlanks || playerModel.getGold() < goldForOakPlanks || playerModel.getWood() < woodForOakPlanks) return;
                    playerModel.removeStone(woodForOakPlanks);
                    playerModel.removeStone(stoneForOakPlanks);
                    playerModel.removeGold(goldForOakPlanks);
                    player.getInventory().addItem(new ItemStack(Material.OAK_PLANKS, 16));
                    break;
                case STONE_BRICKS:
                    if (playerModel.getLvl() < lvlForStoneBricks || playerModel.getStone() < stoneForStoneBricks || playerModel.getGold() < goldForStoneBricks || playerModel.getWood() < woodForStoneBricks) return;
                    playerModel.removeStone(woodForStoneBricks);
                    playerModel.removeStone(stoneForStoneBricks);
                    playerModel.removeGold(goldForStoneBricks);
                    player.getInventory().addItem(new ItemStack(Material.STONE_BRICKS, 16));
                    break;
            }
        });
        gui.addPane(pane);
        gui.update();
    }
    public static void openGuiShop(Player player) {
        gui.show(player);
    }

}
