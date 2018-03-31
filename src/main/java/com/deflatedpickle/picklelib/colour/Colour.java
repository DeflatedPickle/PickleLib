package com.deflatedpickle.picklelib.colour;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Colour {
    private static ItemStack item;

    public Colour(ItemStack itemStack){
        item = itemStack;
    }

    public List<Integer> getScaledColour() {
        IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(item, null, null);
        List<BakedQuad> quads = model.getQuads(null, null, 0);

        List<Integer> colour_list = new ArrayList<>();

        for (BakedQuad quad : quads) {
            TextureAtlasSprite sprite = quad.getSprite();
            int[] rgba = sprite.getFrameTextureData(0)[0];
            BufferedImage image = new BufferedImage(sprite.getIconWidth(), sprite.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            image.setRGB(0, 0, sprite.getIconWidth(), sprite.getIconHeight(), rgba, 0, sprite.getIconWidth());
            Image scaled = image.getScaledInstance(1, 1, BufferedImage.TYPE_INT_ARGB);

            BufferedImage buff_scaled = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            buff_scaled.getGraphics().drawImage(scaled, 0, 0, null);

            int colour = buff_scaled.getRGB(0, 0);
            colour_list.add(colour);
        }

        return colour_list;
    }

    public void getAverageColour() {

    }
}
