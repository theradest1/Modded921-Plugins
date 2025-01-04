package com.landonbakken.modded921;

import java.lang.reflect.Method;

import org.bukkit.entity.Player;

public class Weapons {
    public void callMethod(String methodString, Player player){
        try {
            //get method
            Method methodToCall = this.getClass().getMethod(methodString, Player.class);

            //call method
            methodToCall.invoke(this, player);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void thorsAxeRight(Player player){
        player.sendMessage("Right");
    }

    void thorsAxeLeft(Player player){
        player.sendMessage("Left");
    }
}
