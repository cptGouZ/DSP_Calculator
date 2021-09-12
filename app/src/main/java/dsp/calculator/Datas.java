package dsp.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.dao.RecipeDao;
import dsp.calculator.enums.FacilityTypes;
import dsp.calculator.enums.RecipeNames;

public class Datas {
    private static RecipeDao recipeDao;
    public static List<Recipe> recipesToLoadInDatabase(RecipeDao recipeDao){
        Datas.recipeDao = recipeDao;
        HashMap<String, Float> consumedRecipes;
        Recipe r;
        List<Recipe> recipesToLoadInDatabase = new ArrayList<>();

        //ANNIHILATION_CONSTRAINT_SPHERE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PARTICLE_CONTAINER, 1f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 1f);
        r = constructRecipe(RecipeNames.ANNIHILATION_CONSTRAINT_SPHERE, FacilityTypes.ASSEMBLER, 3f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ANTIMATTER_FUEL_ROD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ANTIMATTER, 6f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 6f);
        consumedRecipes.put(RecipeNames.ANNIHILATION_CONSTRAINT_SPHERE, 0.5f);
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 0.5f);
        r = constructRecipe(RecipeNames.ANTIMATTER_FUEL_ROD, FacilityTypes.ASSEMBLER, 5f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //CARBON_NANOTUBE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAPHENE, 44317f);
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 0.5f);
        r = constructRecipe(RecipeNames.CARBON_NANOTUBE, FacilityTypes.CHEMICAL_PLANT, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //CARBON_NANOTUBE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.SPINIFORM_STALAGMITE_CRYSTAL, 1f);
        r = constructRecipe(RecipeNames.CARBON_NANOTUBE, FacilityTypes.CHEMICAL_PLANT, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //CASIMIR_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_CRYSTAL, 0.5f);
        consumedRecipes.put(RecipeNames.GRAPHENE, 1f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 6f);
        r = constructRecipe(RecipeNames.CASIMIR_CRYSTAL, FacilityTypes.ASSEMBLER, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //CASIMIR_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.OPTICAL_GRATING_CRYSTAL, 2f);
        consumedRecipes.put(RecipeNames.GRAPHENE, 1f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 6f);
        r = constructRecipe(RecipeNames.CASIMIR_CRYSTAL, FacilityTypes.ASSEMBLER, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ANTIMATTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CRITICAL_PHOTON, 1f);
        r = constructRecipe(RecipeNames.ANTIMATTER, FacilityTypes.PARTICULE_COLLIDER, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //CIRCUIT_BOARD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 1f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 0.5f);
        r = constructRecipe(RecipeNames.CIRCUIT_BOARD, FacilityTypes.ASSEMBLER, 120f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //COPPER_INGOT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.COPPER_ORE, 1f);
        r = constructRecipe(RecipeNames.COPPER_INGOT, FacilityTypes.SMELTER, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //CRYSTAL_SILICON
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.FRACTAL_SILICON, 0.5f);
        r = constructRecipe(RecipeNames.CRYSTAL_SILICON, FacilityTypes.ASSEMBLER, 80f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //CRYSTAL_SILICON
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HIGH_PURITY_SILICON, 1f);
        r = constructRecipe(RecipeNames.CRYSTAL_SILICON, FacilityTypes.SMELTER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //DEUTERIUM
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HYDROGEN, 1f);
        r = constructRecipe(RecipeNames.DEUTERIUM, FacilityTypes.FRACTIONATOR, 35.3f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //DEUTERIUM
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HYDROGEN, 2f);
        r = constructRecipe(RecipeNames.DEUTERIUM, FacilityTypes.PARTICULE_COLLIDER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //DEUTERON_FUEL_ROD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 0.5f);
        consumedRecipes.put(RecipeNames.DEUTERIUM, 10f);
        consumedRecipes.put(RecipeNames.SUPER_MAGNETIC_RING, 0.5f);
        r = constructRecipe(RecipeNames.DEUTERON_FUEL_ROD, FacilityTypes.ASSEMBLER, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //DIAMOND
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 1f);
        r = constructRecipe(RecipeNames.DIAMOND, FacilityTypes.SMELTER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //DIAMOND
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.KIMBERLITE_ORE, 0.5f);
        r = constructRecipe(RecipeNames.DIAMOND, FacilityTypes.SMELTER, 80f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //DYSON_SPHERE_COMPONENT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.FRAME_MATERIAL, 3f);
        consumedRecipes.put(RecipeNames.SOLAR_SAIL, 3f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 3f);
        r = constructRecipe(RecipeNames.DYSON_SPHERE_COMPONENT, FacilityTypes.ASSEMBLER, 7.5f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ELECTRIC_MOTOR
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 2f);
        consumedRecipes.put(RecipeNames.GEAR, 1f);
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 1f);
        r = constructRecipe(RecipeNames.ELECTRIC_MOTOR, FacilityTypes.ASSEMBLER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ELECTROMAGNETIC_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 1f);
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 1f);
        r = constructRecipe(RecipeNames.ELECTROMAGNETIC_MATRIX, FacilityTypes.MATRIX_LAB, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ELECTROMAGNETIC_TURBINE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTRIC_MOTOR, 2f);
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 2f);
        r = constructRecipe(RecipeNames.ELECTROMAGNETIC_TURBINE, FacilityTypes.ASSEMBLER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ENERGETIC_GRAPHIT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.REFINED_OIL, 1f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 2f);
        r = constructRecipe(RecipeNames.ENERGETIC_GRAPHITE, FacilityTypes.OIL_RAFINERY, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ENERGETIC_GRAPHIT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 2f);
        r = constructRecipe(RecipeNames.ENERGETIC_GRAPHITE, FacilityTypes.SMELTER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ENERGY_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 2f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 2f);
        r = constructRecipe(RecipeNames.ENERGY_MATRIX, FacilityTypes.MATRIX_LAB, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //FOUNDATION
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STONE_BRICK, 3f);
        consumedRecipes.put(RecipeNames.STEEL, 1f);
        r = constructRecipe(RecipeNames.FOUNDATION, FacilityTypes.ASSEMBLER, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //FRAME_MATERIAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CARBON_NANOTUBE, 4f);
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 1f);
        consumedRecipes.put(RecipeNames.HIGH_PURITY_SILICON, 1f);
        r = constructRecipe(RecipeNames.FRAME_MATERIAL, FacilityTypes.ASSEMBLER, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //GEAR
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 1f);
        r = constructRecipe(RecipeNames.GEAR, FacilityTypes.ASSEMBLER, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //GLASS
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STONE, 2f);
        r = constructRecipe(RecipeNames.GLASS, FacilityTypes.SMELTER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //GRAPHENE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 44317f);
        consumedRecipes.put(RecipeNames.SULFURIC_ACID, 0.5f);
        r = constructRecipe(RecipeNames.GRAPHENE, FacilityTypes.CHEMICAL_PLANT, 40f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //GRAPHENE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.FIRE_ICE, 1f);
        r = constructRecipe(RecipeNames.GRAPHENE, FacilityTypes.CHEMICAL_PLANT, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //GRAVITON_LENS
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.DIAMOND, 4f);
        consumedRecipes.put(RecipeNames.STRANGE_MATTER, 1f);
        r = constructRecipe(RecipeNames.GRAVITON_LENS, FacilityTypes.ASSEMBLER, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //GRAVITY_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAVITON_LENS, 0.5f);
        consumedRecipes.put(RecipeNames.QUANTUM_CHIP, 0.5f);
        r = constructRecipe(RecipeNames.GRAVITY_MATRIX, FacilityTypes.MATRIX_LAB, 5f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //HIGH_PURITY_SILICON
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.SILICON_ORE, 2f);
        r = constructRecipe(RecipeNames.HIGH_PURITY_SILICON, FacilityTypes.SMELTER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //HYDROGEN_FUEL_ROD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 0.5f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 5f);
        r = constructRecipe(RecipeNames.HYDROGEN_FUEL_ROD, FacilityTypes.ASSEMBLER, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //INFORMATION_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PROCESSOR, 2f);
        consumedRecipes.put(RecipeNames.PARTICLE_BROADBAND, 1f);
        r = constructRecipe(RecipeNames.INFORMATION_MATRIX, FacilityTypes.MATRIX_LAB, 6f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //IRON_INGOT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_ORE, 1f);
        r = constructRecipe(RecipeNames.IRON_INGOT, FacilityTypes.SMELTER, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //LOGISTICS_DRONE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 5f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 2f);
        consumedRecipes.put(RecipeNames.THRUSTER, 2f);
        r = constructRecipe(RecipeNames.LOGISTICS_DRONE, FacilityTypes.ASSEMBLER, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //LOGISTICS_VESSEL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 10f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 10f);
        consumedRecipes.put(RecipeNames.REINFORCED_THRUSTER, 2f);
        r = constructRecipe(RecipeNames.LOGISTICS_VESSEL, FacilityTypes.ASSEMBLER, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //MAGNET
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_ORE, 1f);
        r = constructRecipe(RecipeNames.MAGNET, FacilityTypes.SMELTER, 40f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //MAGNETIC_COIL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.MAGNET, 1f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 0.5f);
        r = constructRecipe(RecipeNames.MAGNETIC_COIL, FacilityTypes.ASSEMBLER, 120f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //MICROCRYSTALLINE_COMPONENT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HIGH_PURITY_SILICON, 2f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 1f);
        r = constructRecipe(RecipeNames.MICROCRYSTALLINE_COMPONENT, FacilityTypes.ASSEMBLER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //ORGANIC_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PLASTIC, 2f);
        consumedRecipes.put(RecipeNames.REFINED_OIL, 1f);
        consumedRecipes.put(RecipeNames.WATER, 1f);
        r = constructRecipe(RecipeNames.ORGANIC_CRYSTAL, FacilityTypes.CHEMICAL_PLANT, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PARTICLE_BROADBAND
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CARBON_NANOTUBE, 2f);
        consumedRecipes.put(RecipeNames.CRYSTAL_SILICON, 2f);
        consumedRecipes.put(RecipeNames.PLASTIC, 1f);
        r = constructRecipe(RecipeNames.PARTICLE_BROADBAND, FacilityTypes.ASSEMBLER, 7.5f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PARTICLE_CONTAINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_TURBINE, 2f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 2f);
        consumedRecipes.put(RecipeNames.GRAPHENE, 2f);
        r = constructRecipe(RecipeNames.PARTICLE_CONTAINER, FacilityTypes.ASSEMBLER, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PARTICLE_CONTAINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.UNIPOLAR_MAGNET, 10f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 2f);
        r = constructRecipe(RecipeNames.PARTICLE_CONTAINER, FacilityTypes.ASSEMBLER, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PHOTON_COMBINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PRISM, 2f);
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 1f);
        r = constructRecipe(RecipeNames.PHOTON_COMBINER, FacilityTypes.ASSEMBLER, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PHOTON_COMBINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.OPTICAL_GRATING_CRYSTAL, 1f);
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 1f);
        r = constructRecipe(RecipeNames.PHOTON_COMBINER, FacilityTypes.ASSEMBLER, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PLANE_FILTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CASIMIR_CRYSTAL, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_GLASS, 2f);
        r = constructRecipe(RecipeNames.PLANE_FILTER, FacilityTypes.ASSEMBLER, 5f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PLASMA_EXCITER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 4f);
        consumedRecipes.put(RecipeNames.PRISM, 2f);
        r = constructRecipe(RecipeNames.PLASMA_EXCITER, FacilityTypes.ASSEMBLER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PLASTIC
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.REFINED_OIL, 2f);
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 1f);
        r = constructRecipe(RecipeNames.PLASTIC, FacilityTypes.CHEMICAL_PLANT, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PRISM
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GLASS, 44317f);
        r = constructRecipe(RecipeNames.PRISM, FacilityTypes.ASSEMBLER, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //PROCESSOR
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 2f);
        consumedRecipes.put(RecipeNames.MICROCRYSTALLINE_COMPONENT, 2f);
        r = constructRecipe(RecipeNames.PROCESSOR, FacilityTypes.ASSEMBLER, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //QUANTUM_CHIP
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PROCESSOR, 2f);
        consumedRecipes.put(RecipeNames.PLANE_FILTER, 2f);
        r = constructRecipe(RecipeNames.QUANTUM_CHIP, FacilityTypes.ASSEMBLER, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //REFINED_OIL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CRUDE_OIL, 1f);
        r = constructRecipe(RecipeNames.REFINED_OIL, FacilityTypes.OIL_RAFINERY, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //REINFORCED_THRUSTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 5f);
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_TURBINE, 5f);
        r = constructRecipe(RecipeNames.REINFORCED_THRUSTER, FacilityTypes.ASSEMBLER, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //SMALL_CARRIER_ROCKET
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.DYSON_SPHERE_COMPONENT, 2f);
        consumedRecipes.put(RecipeNames.DEUTERON_FUEL_ROD, 4f);
        consumedRecipes.put(RecipeNames.QUANTUM_CHIP, 2f);
        r = constructRecipe(RecipeNames.SMALL_CARRIER_ROCKET, FacilityTypes.ASSEMBLER, 10f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //SOLAR_SAIL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAPHENE, 0.5f);
        consumedRecipes.put(RecipeNames.PHOTON_COMBINER, 0.5f);
        r = constructRecipe(RecipeNames.SOLAR_SAIL, FacilityTypes.ASSEMBLER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //SPACE_WARPER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAVITON_LENS, 1f);
        r = constructRecipe(RecipeNames.SPACE_WARPER, FacilityTypes.ASSEMBLER, 6f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //SPACE_WARPER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAVITY_MATRIX, 0.125f);
        r = constructRecipe(RecipeNames.SPACE_WARPER, FacilityTypes.ASSEMBLER, 48f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //STEEL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 3f);
        r = constructRecipe(RecipeNames.STEEL, FacilityTypes.SMELTER, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //STONE_BRICK
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STONE, 1f);
        r = constructRecipe(RecipeNames.STONE_BRICK, FacilityTypes.SMELTER, 60f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //STRANGE_MATTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PARTICLE_CONTAINER, 2f);
        consumedRecipes.put(RecipeNames.IRON_INGOT, 2f);
        consumedRecipes.put(RecipeNames.DEUTERIUM, 10f);
        r = constructRecipe(RecipeNames.STRANGE_MATTER, FacilityTypes.PARTICULE_COLLIDER, 7.5f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //STRUCTURE_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.DIAMOND, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_CRYSTAL, 1f);
        r = constructRecipe(RecipeNames.STRUCTURE_MATRIX, FacilityTypes.MATRIX_LAB, 7.5f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //SULFURIC_ACID
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.REFINED_OIL, 44317f);
        consumedRecipes.put(RecipeNames.STONE, 2f);
        consumedRecipes.put(RecipeNames.WATER, 1f);
        r = constructRecipe(RecipeNames.SULFURIC_ACID, FacilityTypes.CHEMICAL_PLANT, 40f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //SUPER_MAGNETIC_RING
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_TURBINE, 2f);
        consumedRecipes.put(RecipeNames.MAGNET, 3f);
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 1f);
        r = constructRecipe(RecipeNames.SUPER_MAGNETIC_RING, FacilityTypes.ASSEMBLER, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //THRUSTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STEEL, 2f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 3f);
        r = constructRecipe(RecipeNames.THRUSTER, FacilityTypes.ASSEMBLER, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //TITANIUM_ALLOY
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 1f);
        consumedRecipes.put(RecipeNames.STEEL, 1f);
        consumedRecipes.put(RecipeNames.SULFURIC_ACID, 2f);
        r = constructRecipe(RecipeNames.TITANIUM_ALLOY, FacilityTypes.SMELTER, 20f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //TITANIUM_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ORGANIC_CRYSTAL, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 3f);
        r = constructRecipe(RecipeNames.TITANIUM_CRYSTAL, FacilityTypes.ASSEMBLER, 15f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //TITANIUM_GLASS
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GLASS, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 1f);
        consumedRecipes.put(RecipeNames.WATER, 1f);
        r = constructRecipe(RecipeNames.TITANIUM_GLASS, FacilityTypes.ASSEMBLER, 24f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //TITANIUM_INGOT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ORE, 2f);
        r = constructRecipe(RecipeNames.TITANIUM_INGOT, FacilityTypes.SMELTER, 30f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //UNIVERSE_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.ENERGY_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.STRUCTURE_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.INFORMATION_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.GRAVITY_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.ANTIMATTER, 1f);
        r = constructRecipe(RecipeNames.UNIVERSE_MATRIX, FacilityTypes.MATRIX_LAB, 4f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        return recipesToLoadInDatabase;
    }

    private static Recipe constructRecipe(String name, String facility, float rateByMinute, HashMap<String, Float> consumptions ){
        List<Consumption> liste = new ArrayList<>();
        for (Map.Entry<String, Float> entry : consumptions.entrySet()) {
            Consumption c = new Consumption();
            c.setConsumedRecipeName(entry.getKey());
            c.setRate(entry.getValue());
            liste.add(c);
        }
        Recipe r = new Recipe(name, facility, rateByMinute, liste);
        return r;
    }
}
