package me.linus.momentum.gui.hud.components;

import me.linus.momentum.Momentum;
import me.linus.momentum.gui.hud.HUDComponent;
import me.linus.momentum.util.render.FontUtil;
import me.linus.momentum.util.world.InventoryUtil;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.awt.*;

/**
 * @author linustouchtips
 * @since 12/17/2020
 */

public class Crystal extends HUDComponent {
    public Crystal() {
        super("Crystal", 2, 57);
    }

    @Override
    public void renderComponent() {
        Momentum.fontManager.getCustomFont().drawStringWithShadow(TextFormatting.GRAY + "Crystals: " + TextFormatting.WHITE + InventoryUtil.getItemCount(Items.END_CRYSTAL), this.x, this.y, new Color(255, 255, 255).getRGB());
        width = Momentum.fontManager.getCustomFont().getStringWidth("Crystals: " + InventoryUtil.getItemCount(Items.END_CRYSTAL)) + 2;
    }
}
