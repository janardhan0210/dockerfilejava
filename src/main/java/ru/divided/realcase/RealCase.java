package ru.divided.realcase;

import org.bukkit.plugin.java.JavaPlugin;

public final class RealCase extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("opencase").setExecutor(new OpenCaseCommand());
    }
}