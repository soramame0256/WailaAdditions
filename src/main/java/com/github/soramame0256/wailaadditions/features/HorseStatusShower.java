package com.github.soramame0256.wailaadditions.features;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaEntityAccessor;
import mcp.mobius.waila.api.IWailaEntityProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.AbstractHorse;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.List;

public class HorseStatusShower implements IWailaEntityProvider {
    @Nonnull
    @Override
    public List<String> getWailaBody(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config) {
        if(accessor.getEntity() instanceof AbstractHorse) {
            double jumpStrength = ((AbstractHorse) accessor.getEntity()).getHorseJumpStrength();
            double speed = ((AbstractHorse) accessor.getEntity()).getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
            Integer breed = accessor.getEntity().getEntityData().getInteger("InLove");
            if (!((AbstractHorse) accessor.getEntity()).isTame()){
                currenttip.add("Temper: " + ((AbstractHorse) accessor.getEntity()).getTemper() + "/" + ((AbstractHorse) accessor.getEntity()).getMaxTemper());
            }
            currenttip.add("Speed: " + speed);
            currenttip.add("JumpStrength: " + jumpStrength);
            currenttip.add("InLove: " + breed);
        }
        return currenttip;
    }
     public static void register(IWailaRegistrar registrar){
        HorseStatusShower instance = new HorseStatusShower();
        registrar.registerBodyProvider(instance, AbstractHorse.class);
     }

}
