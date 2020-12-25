package me.linus.momentum.module.modules.movement;

import me.linus.momentum.module.Module;
import me.linus.momentum.setting.mode.Mode;
import me.linus.momentum.util.client.external.MessageUtil;
import net.minecraft.util.text.TextFormatting;

/**
 * @author linustouchtips
 * @since 12/03/2020
 */

public class AntiVoid extends Module {
    public AntiVoid() {
        super("AntiVoid", Category.MOVEMENT, "Pulls you out of the void");
    }

    private static final Mode mode = new Mode("Mode", "Float", "Freeze", "SlowFall");

    @Override
    public void setup() {
        addSetting(mode);
    }

    @Override
    public void onUpdate() {
        if (nullCheck())
            return;

        if (mc.player.posY <= 0.5) {
            MessageUtil.sendClientMessage(TextFormatting.RED + "Attempting to get you out of the void!");

            switch (mode.getValue()) {
                case 0:
                    mc.player.moveVertical = 10;
                    mc.player.jump();
                    break;
                case 1:
                    mc.player.motionY = 0;
                    break;
                case 2:
                    mc.player.motionY = mc.player.motionY / 4;
                    break;
            }
        }
    }

    @Override
    public String getHUDData() {
        return " " + mode.getMode(mode.getValue());
    }
}
