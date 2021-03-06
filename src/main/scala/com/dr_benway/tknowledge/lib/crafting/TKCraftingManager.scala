package com.dr_benway.tknowledge.lib.crafting

import net.minecraft.item.ItemStack
import thaumcraft.api.aspects.AspectList
import com.dr_benway.tknowledge.api.TKnowledgeAPI
import thaumcraft.api.research.ResearchHelper
import net.minecraftforge.fluids.FluidStack
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry
import thaumcraft.api.aspects.Aspect
import net.minecraft.entity.player.EntityPlayer
import scala.util.control.Breaks._
import com.dr_benway.tknowledge.api.FountainRecipe




object TKCraftingManager {
  
  object Fountain {
    
    val defaultRecipe = new FountainRecipe("FOUNTAIN", "_WATER", new FluidStack(FluidRegistry.WATER, 4000), null, new AspectList(), new AspectList().add(Aspect.WATER, 1), 0.05F)
    
     
    def findMatchingRecipe(input: Any, out: Fluid, player: EntityPlayer) = 
      (input match {
        case i: ItemStack => TKnowledgeAPI.getRecipes.toArray().toList collectFirst { case f: FountainRecipe if f.matches(i, out, player) => f }
        case _ => None }) getOrElse(defaultRecipe)
    
    
    
    def retrieveRecipe(key: String) =
      (TKnowledgeAPI.getRecipes().toArray().toList collectFirst {
        case f: FountainRecipe if key != null && f.getKey == key => f
        } ) getOrElse(defaultRecipe)
    
  }
    
    
    
  
}