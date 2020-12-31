package me.linus.momentum.gui.hud.components;

import me.linus.momentum.Momentum;
import me.linus.momentum.gui.hud.HUDComponent;
import me.linus.momentum.util.render.FontUtil;
import net.minecraft.util.text.TextFormatting;

import java.awt.*;

/**
 * @author linustouchtips
 * @since 12/17/2020
 */

public class Ping extends HUDComponent {
    public Ping() {
        super("Ping", 2, 24);
    }

    @Override
    public void renderComponent() {
        int ping;

        if (!mc.isSingleplayer())
            ping = mc.getConnection().getPlayerInfo(mc.player.getUniqueID()).getResponseTime();
        else
            ping = -1;

        Momentum.fontManager.getCustomFont().drawStringWithShadow(TextFormatting.GRAY + "Ping " + TextFormatting.WHITE + ping + " ms", this.x, this.y, new Color(255, 255, 255).getRGB());
        width = (int) Momentum.fontManager.getCustomFont().getStringWidth("Ping " + ping + " ms") + 2;
    }
}
