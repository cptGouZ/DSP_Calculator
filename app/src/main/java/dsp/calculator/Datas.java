package dsp.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.enums.FacilityTypes;
import dsp.calculator.enums.RecipeNames;

public class Datas {
    private static Datas instance;
    private static int incId = 0;
    private final List<Recipe> datas = new ArrayList<>();

    private Datas(){}
    public static Datas get(){
        if(instance == null){
            instance = new Datas();
            instance.loadDatas();
        }
        return instance;
    }

    public List<String> getRecipeNamesWithAlternatives(){
        List<String> lstReturned = new ArrayList<>();
        for(Recipe r : datas){
            if(getByName(r.getName()).size()>1 && !lstReturned.contains(r.getName())){
                lstReturned.add(r.getName());
            }
        }
        return lstReturned;
    }

    public List<Recipe> getRecipesOnFirstLevel(Recipe recipe){
        List<Recipe> lstReturned = new ArrayList<>();
        for(Consumption c : recipe.getConsumptions()){
            Recipe r = getByName(c.getConsumedRecipeName()).get(0);
            lstReturned.add(r);
        }
        return lstReturned;
    }

    public List<Recipe> getByName (String recipeName) {
        List<Recipe> lstReturned = new ArrayList<>();
        for(Recipe r : datas){
            if(recipeName.equals(r.getName())){
                lstReturned.add(r);
            }
        }
        return lstReturned;
    }

    public Recipe getById (Long id) {
        for(Recipe r : datas){
            if(id == r.getId()){
                return r;
            }
        }
        return null;
    }

    public List<Recipe> getAll() {
        return datas;
    }

    private void loadDatas(){
        HashMap<String, Float> consumedRecipes;
        Recipe r;

//ANNIHILATION_CONSTRAINT_SPHERE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PARTICLE_CONTAINER, 1f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 1f);
        r = constructRecipe(RecipeNames.ANNIHILATION_CONSTRAINT_SPHERE, FacilityTypes.ASSEMBLER, 3f, "annihilation_constraint_sphere_alt1", consumedRecipes);
        datas.add(r);

//ANTIMATTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CRITICAL_PHOTON, 1f);
        r = constructRecipe(RecipeNames.ANTIMATTER, FacilityTypes.PARTICULE_COLLIDER, 60f, "antimatter_alt1", consumedRecipes);
        datas.add(r);

//ANTIMATTER_FUEL_ROD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ANTIMATTER, 6f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 6f);
        consumedRecipes.put(RecipeNames.ANNIHILATION_CONSTRAINT_SPHERE, 0.5f);
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 0.5f);
        r = constructRecipe(RecipeNames.ANTIMATTER_FUEL_ROD, FacilityTypes.ASSEMBLER, 5f, "antimatter_fuel_rod_alt1", consumedRecipes);
        datas.add(r);

//CARBON_NANOTUBE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAPHENE, 1.5f);
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 0.5f);
        r = constructRecipe(RecipeNames.CARBON_NANOTUBE, FacilityTypes.CHEMICAL_PLANT, 30f, "carbon_nanotube_alt1", consumedRecipes);
        datas.add(r);

//CARBON_NANOTUBE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.SPINIFORM_STALAGMITE_CRYSTAL, 1f);
        r = constructRecipe(RecipeNames.CARBON_NANOTUBE, FacilityTypes.CHEMICAL_PLANT, 30f, "carbon_nanotube_alt2", consumedRecipes);
        datas.add(r);

//CASIMIR_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_CRYSTAL, 0.5f);
        consumedRecipes.put(RecipeNames.GRAPHENE, 1f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 6f);
        r = constructRecipe(RecipeNames.CASIMIR_CRYSTAL, FacilityTypes.ASSEMBLER, 15f, "casimir_crystal_alt1", consumedRecipes);
        datas.add(r);

//CASIMIR_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.OPTICAL_GRATING_CRYSTAL, 2f);
        consumedRecipes.put(RecipeNames.GRAPHENE, 1f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 6f);
        r = constructRecipe(RecipeNames.CASIMIR_CRYSTAL, FacilityTypes.ASSEMBLER, 15f, "casimir_crystal_alt2", consumedRecipes);
        datas.add(r);

//CIRCUIT_BOARD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 1f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 0.5f);
        r = constructRecipe(RecipeNames.CIRCUIT_BOARD, FacilityTypes.ASSEMBLER, 120f, "circuit_board_alt1", consumedRecipes);
        datas.add(r);

//COAL
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.COAL, FacilityTypes.MINING_MACHINE, 1000000f, "coal_alt1", consumedRecipes);
        datas.add(r);

//COPPER_INGOT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.COPPER_ORE, 1f);
        r = constructRecipe(RecipeNames.COPPER_INGOT, FacilityTypes.SMELTER, 60f, "copper_ingot_alt1", consumedRecipes);
        datas.add(r);

//COPPER_ORE
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.COPPER_ORE, FacilityTypes.MINING_MACHINE, 1000000f, "copper_ore_alt1", consumedRecipes);
        datas.add(r);

//CRITICAL_PHOTON
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.CRITICAL_PHOTON, FacilityTypes.MINING_MACHINE, 1000000f, "critical_photon_alt1", consumedRecipes);
        datas.add(r);

//CRUDE_OIL
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.CRUDE_OIL, FacilityTypes.OIL_EXTRACTOR , 1000000f, "crude_oil_alt1", consumedRecipes);
        datas.add(r);

//CRYSTAL_SILICON
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.FRACTAL_SILICON, 0.5f);
        r = constructRecipe(RecipeNames.CRYSTAL_SILICON, FacilityTypes.ASSEMBLER, 80f, "crystal_silicon_alt1", consumedRecipes);
        datas.add(r);

//CRYSTAL_SILICON
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HIGH_PURITY_SILICON, 1f);
        r = constructRecipe(RecipeNames.CRYSTAL_SILICON, FacilityTypes.SMELTER, 30f, "crystal_silicon_alt2", consumedRecipes);
        datas.add(r);

//DEUTERIUM
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HYDROGEN, 1f);
        r = constructRecipe(RecipeNames.DEUTERIUM, FacilityTypes.FRACTIONATOR, 35.3f, "deuterium_alt1", consumedRecipes);
        datas.add(r);

//DEUTERIUM
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HYDROGEN, 2f);
        r = constructRecipe(RecipeNames.DEUTERIUM, FacilityTypes.PARTICULE_COLLIDER, 30f, "deuterium_alt1", consumedRecipes);
        datas.add(r);

//DEUTERON_FUEL_ROD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 0.5f);
        consumedRecipes.put(RecipeNames.DEUTERIUM, 10f);
        consumedRecipes.put(RecipeNames.SUPER_MAGNETIC_RING, 0.5f);
        r = constructRecipe(RecipeNames.DEUTERON_FUEL_ROD, FacilityTypes.ASSEMBLER, 10f, "deuteron_fuel_rod_alt1", consumedRecipes);
        datas.add(r);

//DIAMOND
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 1f);
        r = constructRecipe(RecipeNames.DIAMOND, FacilityTypes.SMELTER, 30f, "diamond_alt1", consumedRecipes);
        datas.add(r);

//DIAMOND
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.KIMBERLITE_ORE, 0.5f);
        r = constructRecipe(RecipeNames.DIAMOND, FacilityTypes.SMELTER, 80f, "diamond_alt2", consumedRecipes);
        datas.add(r);

//DYSON_SPHERE_COMPONENT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.FRAME_MATERIAL, 3f);
        consumedRecipes.put(RecipeNames.SOLAR_SAIL, 3f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 3f);
        r = constructRecipe(RecipeNames.DYSON_SPHERE_COMPONENT, FacilityTypes.ASSEMBLER, 7.5f, "dyson_sphere_component_alt1", consumedRecipes);
        datas.add(r);

//ELECTRIC_MOTOR
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 2f);
        consumedRecipes.put(RecipeNames.GEAR, 1f);
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 1f);
        r = constructRecipe(RecipeNames.ELECTRIC_MOTOR, FacilityTypes.ASSEMBLER, 30f, "electric_motor_alt1", consumedRecipes);
        datas.add(r);

//ELECTROMAGNETIC_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 1f);
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 1f);
        r = constructRecipe(RecipeNames.ELECTROMAGNETIC_MATRIX, FacilityTypes.MATRIX_LAB, 20f, "electromagnetic_matrix_alt1", consumedRecipes);
        datas.add(r);

//ELECTROMAGNETIC_TURBINE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTRIC_MOTOR, 2f);
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 2f);
        r = constructRecipe(RecipeNames.ELECTROMAGNETIC_TURBINE, FacilityTypes.ASSEMBLER, 30f, "electromagnetic_turbine_alt1", consumedRecipes);
        datas.add(r);

//ENERGETIC_GRAPHITE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.REFINED_OIL, 1f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 2f);
        r = constructRecipe(RecipeNames.ENERGETIC_GRAPHITE, FacilityTypes.OIL_RAFINERY, 15f, "energetic_graphite_alt1", consumedRecipes);
        datas.add(r);

//ENERGETIC_GRAPHITE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 2f);
        r = constructRecipe(RecipeNames.ENERGETIC_GRAPHITE, FacilityTypes.SMELTER, 30f, "energetic_graphite_alt1", consumedRecipes);
        datas.add(r);

//ENERGY_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 2f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 2f);
        r = constructRecipe(RecipeNames.ENERGY_MATRIX, FacilityTypes.MATRIX_LAB, 10f, "energy_matrix_alt1", consumedRecipes);
        datas.add(r);

//FIRE_ICE
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.FIRE_ICE, FacilityTypes.MINING_MACHINE, 1000000f, "fire_ice_alt1", consumedRecipes);
        datas.add(r);

//FOUNDATION
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STONE_BRICK, 3f);
        consumedRecipes.put(RecipeNames.STEEL, 1f);
        r = constructRecipe(RecipeNames.FOUNDATION, FacilityTypes.ASSEMBLER, 60f, "foundation_alt1", consumedRecipes);
        datas.add(r);

//FRACTAL_SILICON
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.FRACTAL_SILICON, FacilityTypes.MINING_MACHINE, 1000000f, "fractal_silicon_alt1", consumedRecipes);
        datas.add(r);

//FRAME_MATERIAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CARBON_NANOTUBE, 4f);
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 1f);
        consumedRecipes.put(RecipeNames.HIGH_PURITY_SILICON, 1f);
        r = constructRecipe(RecipeNames.FRAME_MATERIAL, FacilityTypes.ASSEMBLER, 10f, "frame_material_alt1", consumedRecipes);
        datas.add(r);

//GEAR
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 1f);
        r = constructRecipe(RecipeNames.GEAR, FacilityTypes.ASSEMBLER, 60f, "gear_alt1", consumedRecipes);
        datas.add(r);

//GLASS
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STONE, 2f);
        r = constructRecipe(RecipeNames.GLASS, FacilityTypes.SMELTER, 30f, "glass_alt1", consumedRecipes);
        datas.add(r);

//GRAPHENE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 1.5f);
        consumedRecipes.put(RecipeNames.SULFURIC_ACID, 0.5f);
        r = constructRecipe(RecipeNames.GRAPHENE, FacilityTypes.CHEMICAL_PLANT, 40f, "graphene_alt1", consumedRecipes);
        datas.add(r);

//GRAPHENE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.FIRE_ICE, 1f);
        r = constructRecipe(RecipeNames.GRAPHENE, FacilityTypes.CHEMICAL_PLANT, 60f, "graphene_alt2", consumedRecipes);
        datas.add(r);

//GRAVITON_LENS
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.DIAMOND, 4f);
        consumedRecipes.put(RecipeNames.STRANGE_MATTER, 1f);
        r = constructRecipe(RecipeNames.GRAVITON_LENS, FacilityTypes.ASSEMBLER, 10f, "graviton_lens_alt1", consumedRecipes);
        datas.add(r);

//GRAVITY_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAVITON_LENS, 0.5f);
        consumedRecipes.put(RecipeNames.QUANTUM_CHIP, 0.5f);
        r = constructRecipe(RecipeNames.GRAVITY_MATRIX, FacilityTypes.MATRIX_LAB, 5f, "gravity_matrix_alt1", consumedRecipes);
        datas.add(r);

//HIGH_PURITY_SILICON
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.SILICON_ORE, 2f);
        r = constructRecipe(RecipeNames.HIGH_PURITY_SILICON, FacilityTypes.SMELTER, 30f, "high_purity_silicon_alt1", consumedRecipes);
        datas.add(r);

//HYDROGEN
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.HYDROGEN, FacilityTypes.OIL_EXTRACTOR , 1000000f, "hydrogen_alt1", consumedRecipes);
        datas.add(r);

//HYDROGEN_FUEL_ROD
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 0.5f);
        consumedRecipes.put(RecipeNames.HYDROGEN, 5f);
        r = constructRecipe(RecipeNames.HYDROGEN_FUEL_ROD, FacilityTypes.ASSEMBLER, 20f, "hydrogen_fuel_rod_alt1", consumedRecipes);
        datas.add(r);

//INFORMATION_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PROCESSOR, 2f);
        consumedRecipes.put(RecipeNames.PARTICLE_BROADBAND, 1f);
        r = constructRecipe(RecipeNames.INFORMATION_MATRIX, FacilityTypes.MATRIX_LAB, 6f, "information_matrix_alt1", consumedRecipes);
        datas.add(r);

//IRON_INGOT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_ORE, 1f);
        r = constructRecipe(RecipeNames.IRON_INGOT, FacilityTypes.SMELTER, 60f, "iron_ingot_alt1", consumedRecipes);
        datas.add(r);

//IRON_ORE
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.IRON_ORE, FacilityTypes.MINING_MACHINE, 1000000f, "iron_ore_alt1", consumedRecipes);
        datas.add(r);

//KIMBERLITE_ORE
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.KIMBERLITE_ORE, FacilityTypes.MINING_MACHINE, 1000000f, "kimberlite_ore_alt1", consumedRecipes);
        datas.add(r);

//LOGISTICS_DRONE
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 5f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 2f);
        consumedRecipes.put(RecipeNames.THRUSTER, 2f);
        r = constructRecipe(RecipeNames.LOGISTICS_DRONE, FacilityTypes.ASSEMBLER, 15f, "logistics_drone_alt1", consumedRecipes);
        datas.add(r);

//LOGISTICS_VESSEL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 10f);
        consumedRecipes.put(RecipeNames.PROCESSOR, 10f);
        consumedRecipes.put(RecipeNames.REINFORCED_THRUSTER, 2f);
        r = constructRecipe(RecipeNames.LOGISTICS_VESSEL, FacilityTypes.ASSEMBLER, 10f, "logistics_vessel_alt1", consumedRecipes);
        datas.add(r);

//MAGNET
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_ORE, 1f);
        r = constructRecipe(RecipeNames.MAGNET, FacilityTypes.SMELTER, 40f, "magnet_alt1", consumedRecipes);
        datas.add(r);

//MAGNETIC_COIL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.MAGNET, 1f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 0.5f);
        r = constructRecipe(RecipeNames.MAGNETIC_COIL, FacilityTypes.ASSEMBLER, 120f, "magnetic_coil_alt1", consumedRecipes);
        datas.add(r);

//MICROCRYSTALLINE_COMPONENT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.HIGH_PURITY_SILICON, 2f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 1f);
        r = constructRecipe(RecipeNames.MICROCRYSTALLINE_COMPONENT, FacilityTypes.ASSEMBLER, 30f, "microcrystalline_component_alt1", consumedRecipes);
        datas.add(r);

//OPTICAL_GRATING_CRYSTAL
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.OPTICAL_GRATING_CRYSTAL, FacilityTypes.MINING_MACHINE, 1000000f, "optical_grating_crystal_alt1", consumedRecipes);
        datas.add(r);

//ORGANIC_CRYSTAL
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.ORGANIC_CRYSTAL, FacilityTypes.MINING_MACHINE, 1000000f, "organic_crystal_alt1", consumedRecipes);
        datas.add(r);

//ORGANIC_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PLASTIC, 2f);
        consumedRecipes.put(RecipeNames.REFINED_OIL, 1f);
        consumedRecipes.put(RecipeNames.WATER, 1f);
        r = constructRecipe(RecipeNames.ORGANIC_CRYSTAL, FacilityTypes.CHEMICAL_PLANT, 10f, "organic_crystal_alt1", consumedRecipes);
        datas.add(r);

//PARTICLE_BROADBAND
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CARBON_NANOTUBE, 2f);
        consumedRecipes.put(RecipeNames.CRYSTAL_SILICON, 2f);
        consumedRecipes.put(RecipeNames.PLASTIC, 1f);
        r = constructRecipe(RecipeNames.PARTICLE_BROADBAND, FacilityTypes.ASSEMBLER, 7.5f, "particle_broadband_alt1", consumedRecipes);
        datas.add(r);

//PARTICLE_CONTAINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_TURBINE, 2f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 2f);
        consumedRecipes.put(RecipeNames.GRAPHENE, 2f);
        r = constructRecipe(RecipeNames.PARTICLE_CONTAINER, FacilityTypes.ASSEMBLER, 15f, "particle_container_alt1", consumedRecipes);
        datas.add(r);

//PARTICLE_CONTAINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.UNIPOLAR_MAGNET, 10f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 2f);
        r = constructRecipe(RecipeNames.PARTICLE_CONTAINER, FacilityTypes.ASSEMBLER, 15f, "particle_container_alt2", consumedRecipes);
        datas.add(r);

//PHOTON_COMBINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PRISM, 2f);
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 1f);
        r = constructRecipe(RecipeNames.PHOTON_COMBINER, FacilityTypes.ASSEMBLER, 20f, "photon_combiner_alt1", consumedRecipes);
        datas.add(r);

//PHOTON_COMBINER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.OPTICAL_GRATING_CRYSTAL, 1f);
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 1f);
        r = constructRecipe(RecipeNames.PHOTON_COMBINER, FacilityTypes.ASSEMBLER, 20f, "photon_combiner_alt2", consumedRecipes);
        datas.add(r);

//PLANE_FILTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CASIMIR_CRYSTAL, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_GLASS, 2f);
        r = constructRecipe(RecipeNames.PLANE_FILTER, FacilityTypes.ASSEMBLER, 5f, "plane_filter_alt1", consumedRecipes);
        datas.add(r);

//PLANT_FUEL
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.PLANT_FUEL, FacilityTypes.MINING_MACHINE, 1000000f, "plant_fuel_alt1", consumedRecipes);
        datas.add(r);

//PLASMA_EXCITER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.MAGNETIC_COIL, 4f);
        consumedRecipes.put(RecipeNames.PRISM, 2f);
        r = constructRecipe(RecipeNames.PLASMA_EXCITER, FacilityTypes.ASSEMBLER, 30f, "plasma_exciter_alt1", consumedRecipes);
        datas.add(r);

//PLASTIC
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.REFINED_OIL, 2f);
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 1f);
        r = constructRecipe(RecipeNames.PLASTIC, FacilityTypes.CHEMICAL_PLANT, 20f, "plastic_alt1", consumedRecipes);
        datas.add(r);

//PRISM
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GLASS, 1.5f);
        r = constructRecipe(RecipeNames.PRISM, FacilityTypes.ASSEMBLER, 60f, "prism_alt1", consumedRecipes);
        datas.add(r);

//PROCESSOR
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CIRCUIT_BOARD, 2f);
        consumedRecipes.put(RecipeNames.MICROCRYSTALLINE_COMPONENT, 2f);
        r = constructRecipe(RecipeNames.PROCESSOR, FacilityTypes.ASSEMBLER, 20f, "processor_alt1", consumedRecipes);
        datas.add(r);

//QUANTUM_CHIP
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PROCESSOR, 2f);
        consumedRecipes.put(RecipeNames.PLANE_FILTER, 2f);
        r = constructRecipe(RecipeNames.QUANTUM_CHIP, FacilityTypes.ASSEMBLER, 10f, "quantum_chip_alt1", consumedRecipes);
        datas.add(r);

//REFINED_OIL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.CRUDE_OIL, 1f);
        r = constructRecipe(RecipeNames.REFINED_OIL, FacilityTypes.OIL_RAFINERY, 30f, "refined_oil_alt1", consumedRecipes);
        datas.add(r);

//REINFORCED_THRUSTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ALLOY, 5f);
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_TURBINE, 5f);
        r = constructRecipe(RecipeNames.REINFORCED_THRUSTER, FacilityTypes.ASSEMBLER, 10f, "reinforced_thruster_alt1", consumedRecipes);
        datas.add(r);

//SILICON_ORE
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.SILICON_ORE, FacilityTypes.MINING_MACHINE, 1000000f, "silicon_ore_alt1", consumedRecipes);
        datas.add(r);

//SMALL_CARRIER_ROCKET
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.DYSON_SPHERE_COMPONENT, 2f);
        consumedRecipes.put(RecipeNames.DEUTERON_FUEL_ROD, 4f);
        consumedRecipes.put(RecipeNames.QUANTUM_CHIP, 2f);
        r = constructRecipe(RecipeNames.SMALL_CARRIER_ROCKET, FacilityTypes.ASSEMBLER, 10f, "small_carrier_rocket_alt1", consumedRecipes);
        datas.add(r);

//SOLAR_SAIL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAPHENE, 0.5f);
        consumedRecipes.put(RecipeNames.PHOTON_COMBINER, 0.5f);
        r = constructRecipe(RecipeNames.SOLAR_SAIL, FacilityTypes.ASSEMBLER, 30f, "solar_sail_alt1", consumedRecipes);
        datas.add(r);

//SPACE_WARPER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAVITON_LENS, 1f);
        r = constructRecipe(RecipeNames.SPACE_WARPER, FacilityTypes.ASSEMBLER, 6f, "space_warper_alt1", consumedRecipes);
        datas.add(r);

//SPACE_WARPER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GRAVITY_MATRIX, 0.125f);
        r = constructRecipe(RecipeNames.SPACE_WARPER, FacilityTypes.ASSEMBLER, 48f, "space_warper_alt2", consumedRecipes);
        datas.add(r);

//SPINIFORM_STALAGMITE_CRYSTAL
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.SPINIFORM_STALAGMITE_CRYSTAL, FacilityTypes.MINING_MACHINE, 1000000f, "spiniform_stalagmite_crystal_alt1", consumedRecipes);
        datas.add(r);

//STEEL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT, 3f);
        r = constructRecipe(RecipeNames.STEEL, FacilityTypes.SMELTER, 20f, "steel_alt1", consumedRecipes);
        datas.add(r);

//STONE
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.STONE, FacilityTypes.MINING_MACHINE, 1000000f, "stone_alt1", consumedRecipes);
        datas.add(r);

//STONE_BRICK
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STONE, 1f);
        r = constructRecipe(RecipeNames.STONE_BRICK, FacilityTypes.SMELTER, 60f, "stone_brick_alt1", consumedRecipes);
        datas.add(r);

//STRANGE_MATTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.PARTICLE_CONTAINER, 2f);
        consumedRecipes.put(RecipeNames.IRON_INGOT, 2f);
        consumedRecipes.put(RecipeNames.DEUTERIUM, 10f);
        r = constructRecipe(RecipeNames.STRANGE_MATTER, FacilityTypes.PARTICULE_COLLIDER, 7.5f, "strange_matter_alt1", consumedRecipes);
        datas.add(r);

//STRUCTURE_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.DIAMOND, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_CRYSTAL, 1f);
        r = constructRecipe(RecipeNames.STRUCTURE_MATRIX, FacilityTypes.MATRIX_LAB, 7.5f, "structure_matrix_alt1", consumedRecipes);
        datas.add(r);

//SULFURIC_ACID
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.SULFURIC_ACID, FacilityTypes.WATER_POMPE, 1000000f, "sulfuric_acid_alt1", consumedRecipes);
        datas.add(r);

//SULFURIC_ACID
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.REFINED_OIL, 1.5f);
        consumedRecipes.put(RecipeNames.STONE, 2f);
        consumedRecipes.put(RecipeNames.WATER, 1f);
        r = constructRecipe(RecipeNames.SULFURIC_ACID, FacilityTypes.CHEMICAL_PLANT, 40f, "sulfuric_acid_alt1", consumedRecipes);
        datas.add(r);

//SUPER_MAGNETIC_RING
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_TURBINE, 2f);
        consumedRecipes.put(RecipeNames.MAGNET, 3f);
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 1f);
        r = constructRecipe(RecipeNames.SUPER_MAGNETIC_RING, FacilityTypes.ASSEMBLER, 20f, "super_magnetic_ring_alt1", consumedRecipes);
        datas.add(r);

//THRUSTER
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.STEEL, 2f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 3f);
        r = constructRecipe(RecipeNames.THRUSTER, FacilityTypes.ASSEMBLER, 15f, "thruster_alt1", consumedRecipes);
        datas.add(r);

//TITANIUM_ALLOY
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 1f);
        consumedRecipes.put(RecipeNames.STEEL, 1f);
        consumedRecipes.put(RecipeNames.SULFURIC_ACID, 2f);
        r = constructRecipe(RecipeNames.TITANIUM_ALLOY, FacilityTypes.SMELTER, 20f, "titanium_alloy_alt1", consumedRecipes);
        datas.add(r);

//TITANIUM_CRYSTAL
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ORGANIC_CRYSTAL, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 3f);
        r = constructRecipe(RecipeNames.TITANIUM_CRYSTAL, FacilityTypes.ASSEMBLER, 15f, "titanium_crystal_alt1", consumedRecipes);
        datas.add(r);

//TITANIUM_GLASS
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.GLASS, 1f);
        consumedRecipes.put(RecipeNames.TITANIUM_INGOT, 1f);
        consumedRecipes.put(RecipeNames.WATER, 1f);
        r = constructRecipe(RecipeNames.TITANIUM_GLASS, FacilityTypes.ASSEMBLER, 24f, "titanium_glass_alt1", consumedRecipes);
        datas.add(r);

//TITANIUM_INGOT
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.TITANIUM_ORE, 2f);
        r = constructRecipe(RecipeNames.TITANIUM_INGOT, FacilityTypes.SMELTER, 30f, "titanium_ingot_alt1", consumedRecipes);
        datas.add(r);

//TITANIUM_ORE
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.TITANIUM_ORE, FacilityTypes.MINING_MACHINE, 1000000f, "titanium_ore_alt1", consumedRecipes);
        datas.add(r);

//UNIPOLAR_MAGNET
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.UNIPOLAR_MAGNET, FacilityTypes.MINING_MACHINE, 1000000f, "unipolar_magnet_alt1", consumedRecipes);
        datas.add(r);

//UNIVERSE_MATRIX
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ELECTROMAGNETIC_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.ENERGY_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.STRUCTURE_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.INFORMATION_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.GRAVITY_MATRIX, 1f);
        consumedRecipes.put(RecipeNames.ANTIMATTER, 1f);
        r = constructRecipe(RecipeNames.UNIVERSE_MATRIX, FacilityTypes.MATRIX_LAB, 4f, "universe_matrix_alt1", consumedRecipes);
        datas.add(r);

//WATER
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.WATER, FacilityTypes.WATER_POMPE, 1000000f, "water_alt1", consumedRecipes);
        datas.add(r);

//WOOD
        consumedRecipes = new HashMap<>();
        r = constructRecipe(RecipeNames.WOOD, FacilityTypes.MINING_MACHINE, 1000000f, "wood_alt1", consumedRecipes);
        datas.add(r);
    }

    private Recipe constructRecipe(String name, String facility, float rateByMinute, String pictureAltName, HashMap<String, Float> consumptions ){
        List<Consumption> listeOfConsumtion = new ArrayList<>();
        for (Map.Entry<String, Float> entry : consumptions.entrySet()) {
            Consumption c = new Consumption();
            c.setConsumedRecipeName(entry.getKey());
            c.setRate(entry.getValue());
            c.setRecipeId(incId);
            listeOfConsumtion.add(c);
        }
        Recipe r = new Recipe(incId, name, facility, rateByMinute, pictureAltName, listeOfConsumtion);
        incId ++;
        return r;
    }
}
