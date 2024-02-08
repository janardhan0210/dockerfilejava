package ru.divided.realcase;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Marker;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import javax.smartcardio.ResponseAPDU;
import java.util.Random;

public class OpenCaseCommand implements CommandExecutor {

    private static int count = 0;
}
@Override
public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
    if (sender instanceof Player) {
        Player p = (Player) sender;
        Inventory inv = Bukkit.createInventory(null, 27, "Открытие кейса");
        ItemStack itemStack = new ItemStack(Material.IRON_BLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ItemMeta.setDisplayName(" ");
        ItemStack.setItemMeta(ItemMeta);
        inv.setItem(4, itemStack);
        inv.setItem(22, itemStack);
        p.openInventory(inv);
        new BukkitRunnable() {

            @Override
            public void run() {
                if (count < 25) {
                    for (int i = 9; i <= 17; i++) {
                        inv.setItem(i, getRandomItem());
                    }
                    p.playSound(p.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 0);
                    count++;
                } else {
                    if (inv.getItem(13) != null) {
                        p.sendMessage("Вы выиграли!" + inv.getItem(13));
                        p.getInventory().addItem(inv.getItem(13));
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 0);
                    } else {
                        p.sendMessage("Вы проиграли!");
                    }
                    p.closeInventory();
                    cancel();
                }
            }
        }.runTaskTimer(RealCase.getPlugin(RealCase.class), 0, 4);

    }
    return true;
}

private static ItemStack getRandomItem() {
    return new ItemStack(Material.values()[new Random().nextInt(Material.values().length)]
}
}