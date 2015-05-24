package cf.mcdTeam.Immersion.magic.block.tile.container.gui;

import java.awt.Color;

import cf.mcdTeam.Immersion.magic.block.tile.TileVCombiner;
import cf.mcdTeam.Immersion.magic.block.tile.container.ContainerVCombiner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiVCombiner extends GuiContainer
{
	final ResourceLocation texture = new ResourceLocation("immersion", "textures/gui/container/vcombiner.png");
	
	final String s;
			
	public GuiVCombiner(InventoryPlayer inv, TileVCombiner tile) 
	{
		super(new ContainerVCombiner(inv, tile));
		s = tile.getDisplayName().getUnformattedText();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
	
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		su
		fontRendererObj.drawString(s, 5, 5, Color.darkGray.getRGB());
	}
}
