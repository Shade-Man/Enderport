package com.github.stars_sea.enderport;

import com.github.stars_sea.enderport.event.listener.BlockEntityEventsHandler;
import com.github.stars_sea.enderport.event.listener.LootTableLoadingHandler;
import com.github.stars_sea.enderport.item.EnderPortItems;
import com.github.stars_sea.enderport.recipe.EnderPortRecipeSerializers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class EnderPortMod implements ModInitializer {
	public static final String ID = "enderport";

	@Override
	public void onInitialize() {
		EnderPortItems.registerAll();
		EnderPortRecipeSerializers.registerAll();
		LootTableLoadingHandler.register();
		BlockEntityEventsHandler.register();
	}

	@NotNull @Contract("_ -> new")
	public static Identifier genId(String path) {
		return new Identifier(ID, path);
	}
}
