package me.xiaozhangup.randomsheep;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(this + " LOADED...");
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onSheepHurt(EntityDamageEvent e) {
                if (e.getEntityType() == EntityType.SHEEP) {
                    Location loc = e.getEntity().getLocation();
                    e.getEntity().remove();
                    loc.createExplosion(1 , false , false);
                    createSheep(e.getEntity().getWorld());
                }
            }
        } , this);
    }

    public static void createSheep(World world) {
        Location loc = world.getSpawnLocation();
        loc.setX(loc.getX() + getRandom(-3 , 3));
        loc.setZ(loc.getZ() + getRandom(-3 , 3));

        Sheep sheep = (Sheep) world.spawnEntity(loc , EntityType.SHEEP);
        sheep.setAdult();
        sheep.setColor(Enums.random(DyeColor.class));
    }

    public static int getRandom(int start, int end) {
        return (int)(Math.random() * (end - start + 1) + start);
    }
}
