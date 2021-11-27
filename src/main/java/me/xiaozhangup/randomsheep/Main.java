package me.xiaozhangup.randomsheep;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

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
                }
            }
        } , this);
    }
}
