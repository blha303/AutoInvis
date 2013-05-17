package me.blha303.autoinvis;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import java.util.logging.Logger;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;

public class AutoInvis extends JavaPlugin implements Listener {

    private Logger log;

    public void onEnable() {
        log = this.getLogger();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission("autoinvis.bypass")) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.getById(14), 1000000*20, 0));
            log.info(event.getPlayer().getName() + " given invisibility");
        } else {
            log.info(event.getPlayer().getName() + " has the override permission.");
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if (!event.getPlayer().hasPermission("autoinvis.bypass")) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.getById(14), 1000000*20, 0));
            log.info(event.getPlayer().getName() + " given invisibility");
        } else {
            log.info(event.getPlayer().getName() + " has the override permission.");
        }
    }

}
