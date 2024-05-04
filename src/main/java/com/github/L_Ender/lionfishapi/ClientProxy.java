package com.github.L_Ender.lionfishapi;

import com.github.L_Ender.lionfishapi.client.event.ClientSetUp;
import com.github.L_Ender.lionfishapi.client.model.render.RendererKobolediator;
import com.github.L_Ender.lionfishapi.server.entity.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = LionfishAPI.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {


    public void clientInit() {
        try {
            Class.forName("net.optifine.Config");
            ClientSetUp.optifinePresent = true;
        } catch (ClassNotFoundException e) {
            ClientSetUp.optifinePresent = false;
        }
        MinecraftForge.EVENT_BUS.register(new ClientSetUp());
       // EntityRenderers.register(ModEntities.KOBOLEDIATOR.get(), RendererKobolediator::new);
    }

    public Player getClientSidePlayer() {
        return Minecraft.getInstance().player;
    }

}