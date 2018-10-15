package com.deflatedpickle.picklelib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.stream.IntStream;

public class TextureUtil {
    public static BufferedImage bufferedImageFromResourceLocation(ResourceLocation resourceLocation) {
        InputStream inputStream = null;
        try {
            inputStream = Minecraft.getMinecraft().getResourceManager().getResource(resourceLocation).getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return ImageIO.read(Objects.requireNonNull(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Credit: https://stackoverflow.com/a/14513703
    public static BufferedImage applyGrayscale(ResourceLocation resourceLocation) {
        BufferedImage image = bufferedImageFromResourceLocation(resourceLocation);

        ColorConvertOp colorConvertOp = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        colorConvertOp.filter(Objects.requireNonNull(image), image);

        return image;
    }

    // Credit:
    // http://www.java2s.com/Tutorials/Java/Graphics_How_to/Image/Change_color_of_png_format_image.htm
    // https://stackoverflow.com/a/38731130
    public static BufferedImage applyColour(ResourceLocation resourceLocation, Integer red, Integer green, Integer blue) {
        BufferedImage image = applyGrayscale(resourceLocation);
        WritableRaster raster = image.getRaster();

        IntStream.range(0, image.getWidth()).forEachOrdered(x ->
                IntStream.range(0, image.getHeight()).forEachOrdered(y -> {
            int[] pixel = raster.getPixel(x, y, (int[]) null);

            pixel[0] = red * pixel[0] / 255;
            pixel[1] = green * pixel[1] / 255;
            pixel[2] = blue * pixel[2] / 255;

            raster.setPixel(x, y, pixel);
        }));

        return image;
    }

    public static ResourceLocation registerTexture(BufferedImage texture, String name) {
        DynamicTexture dynamicTexture = new DynamicTexture(texture);

        ResourceLocation resourceLocation = new ResourceLocation(name);
        Minecraft.getMinecraft().getTextureManager().loadTexture(resourceLocation, dynamicTexture);

        return resourceLocation;
    }

    public static ResourceLocation recolourTexture(ResourceLocation resourceLocation, String name, Integer red, Integer green, Integer blue) {
        BufferedImage image = applyColour(resourceLocation, red, green, blue);

        return registerTexture(image, name);
    }

    public static ResourceLocation recolourTexture(ResourceLocation resourceLocation, String name, String hex) {
        Color colour = Color.decode(hex);

        return recolourTexture(resourceLocation, name, colour.getRed(), colour.getGreen(), colour.getBlue());
    }
}
