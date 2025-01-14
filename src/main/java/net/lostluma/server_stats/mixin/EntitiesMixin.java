package net.lostluma.server_stats.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.lostluma.server_stats.stats.Stats;
import net.minecraft.entity.Entities;

@Mixin(Entities.class)
public class EntitiesMixin {
    @Inject(method = "registerWithSpawnEgg", at = @At("TAIL"))
    private static void registerWithSpawnEgg(Class<?> type, String key, int id, int baseColor, int spotsColor, CallbackInfo callbackInfo) {
        Stats.createEntityKillStat(key);
        Stats.createKilledByEntityStat(key);
    }
}
