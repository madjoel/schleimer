package one.laqua.schleimer;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Schleimer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onRightClickEvent(PlayerInteractEvent event) {
        if (!event.hasItem()
                || !event.getAction().equals(Action.RIGHT_CLICK_AIR)
                || !event.getItem().getType().equals(Material.APPLE)
                || !event.getItem().getItemMeta().getDisplayName().equals("Schleimer")) {
            return;
        }

        if (event.getPlayer().getLocation().getChunk().isSlimeChunk()) {
            event.getPlayer().playNote(event.getPlayer().getLocation(), Instrument.CHIME, Note.natural(1, Note.Tone.A));
        } else {
            event.getPlayer().playNote(event.getPlayer().getLocation(), Instrument.STICKS, Note.natural(0, Note.Tone.F));
        }
    }
}
