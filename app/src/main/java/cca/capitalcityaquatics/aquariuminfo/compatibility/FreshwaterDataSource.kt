package cca.capitalcityaquatics.aquariuminfo.compatibility

import cca.capitalcityaquatics.aquariuminfo.R

class FreshwaterDataSource {
	fun loadFishCardsFresh(): List<Freshwater> {
		return listOf(
			//Malawi
			Freshwater(
				R.drawable.mbuba_cichlid,
				R.string.text_malawi,
				R.string.text_latin_various,
				R.string.list_compatible_malawi,
				R.string.list_caution_malawi,
				R.string.list_incompatible_malawi
			),
			//Tanganyikan
			Freshwater(
				R.drawable.tanganyikan,
				R.string.text_tanganyikan,
				R.string.text_latin_various,
				R.string.list_compatible_tanganyikan,
				R.string.list_caution_tanganyikan,
				R.string.list_incompatible_tanganyikan
			),
			// Misc. African
			Freshwater(
				R.drawable.misc_african,
				R.string.text_african_cichlid,
				R.string.text_latin_various,
				R.string.list_compatible_african_cichlid,
				R.string.list_caution_african_cichlid,
				R.string.list_incompatible_african_cichlid
			),
			//American Cichlids
			Freshwater(
				R.drawable.american_cichlid,
				R.string.text_cichlids_american,
				R.string.text_latin_various,
				R.string.list_compatible_cichlids_american,
				R.string.list_caution_cichlids_american,
				R.string.list_incompatible_cichlids_american
			),
			//Angelfish
			Freshwater(
				R.drawable.angelfish,
				R.string.text_angelfish,
				R.string.text_latin_angelfish,
				R.string.list_compatible_angelfish,
				R.string.list_caution_angelfish,
				R.string.list_incompatible_angelfish
			),
			//Barb
			Freshwater(
				R.drawable.barb,
				R.string.text_barbs,
				R.string.text_latin_barb,
				R.string.list_compatible_barb,
				R.string.list_caution_barb,
				R.string.list_incompatible_barb
			),
			//Betta
			Freshwater(
				R.drawable.betta,
				R.string.text_betta,
				R.string.text_latin_betta,
				R.string.list_compatible_betta,
				R.string.list_caution_betta,
				R.string.list_incompatible_betta
			),
			//Cory Cats
			Freshwater(
				R.drawable.cory_cats,
				R.string.text_cory_cats,
				R.string.text_latin_cory,
				R.string.list_compatible_cory,
				R.string.list_caution_cory,
				R.string.list_incompatible_cory
			),
			//Danios / Minnows
			Freshwater(
				R.drawable.danios,
				R.string.text_danios,
				R.string.text_latin_danio,
				R.string.list_compatible_danios,
				R.string.list_caution_danios,
				R.string.list_incompatible_danios
			),
			//Discus
			Freshwater(
				R.drawable.discus,
				R.string.text_discus,
				R.string.text_latin_discus,
				R.string.list_compatible_discus,
				R.string.list_caution_discus,
				R.string.list_incompatible_discus
			),
			//Fancy Goldfish
			Freshwater(
				R.drawable.fancy_goldfish,
				R.string.text_fancy_goldfish,
				R.string.text_latin_fancy_goldfish,
				R.string.list_compatible_fancy_goldfish,
				R.string.list_caution_fancy_goldfish,
				R.string.list_incompatible_fancy_goldfish
			),
			//Gouramis
			Freshwater(
				R.drawable.gourami,
				R.string.text_gouramis,
				R.string.text_latin_gourami,
				R.string.list_compatible_gourami,
				R.string.list_caution_gourami,
				R.string.list_incompatible_gourami
			),
			//Guppy
			Freshwater(
				R.drawable.guppy,
				R.string.text_guppies,
				R.string.text_latin_guppy,
				R.string.list_compatible_guppies,
				R.string.list_caution_guppies,
				R.string.list_incompatible_guppies
			),
			//Hatchets
			Freshwater(
				R.drawable.hatchets,
				R.string.text_hatchets,
				R.string.text_latin_hatchet,
				R.string.list_compatible_hatchets,
				R.string.list_caution_hatchets,
				R.string.list_incompatible_hatchets
			),
			//Killifish
			Freshwater(
				R.drawable.killifish,
				R.string.text_killifish,
				R.string.text_latin_killifish,
				R.string.list_compatible_killifish,
				R.string.list_caution_killifish,
				R.string.list_incompatible_killifish
			),
			//Larger Catfish
			Freshwater(
				R.drawable.large_catfish,
				R.string.text_catfish,
				R.string.text_latin_larger_catfish,
				R.string.list_compatible_catfish,
				R.string.list_caution_catfish,
				R.string.list_incompatible_catfish
			),
			//Loach
			Freshwater(
				R.drawable.loaches,
				R.string.text_loach,
				R.string.text_latin_loach,
				R.string.list_compatible_loach,
				R.string.list_caution_loach,
				R.string.list_incompatible_loach
			),
			//Molly
			Freshwater(
				R.drawable.molly,
				R.string.text_molly,
				R.string.text_latin_molly,
				R.string.list_compatible_molly,
				R.string.list_caution_molly,
				R.string.list_incompatible_molly
			),
			//Platy
			Freshwater(
				R.drawable.platy,
				R.string.text_platy,
				R.string.text_latin_platy,
				R.string.list_compatible_platy,
				R.string.list_caution_platy,
				R.string.list_incompatible_platy
			),
			//Pleco
			Freshwater(
				R.drawable.pleco,
				R.string.text_pleco,
				R.string.text_pleco_latin,
				R.string.list_compatible_pleco,
				R.string.list_caution_pleco,
				R.string.list_incompatible_pleco
			),
			//Rainbowfish
			Freshwater(
				R.drawable.rainbowfish,
				R.string.text_rainbowfish,
				R.string.text_latin_rainbowfish,
				R.string.list_compatible_rainbowfish,
				R.string.list_caution_rainbowfish,
				R.string.list_incompatible_rainbowfish
			),
			//Rasboras
			Freshwater(
				R.drawable.rasbora,
				R.string.text_rasboras,
				R.string.text_latin_rasbora,
				R.string.list_compatible_rasboras,
				R.string.list_caution_rasboras,
				R.string.list_incompatible_rasboras
			),
			//Sharks
			Freshwater(
				R.drawable.freshwater_shark,
				R.string.text_shark,
				R.string.text_latin_shark,
				R.string.list_compatible_shark,
				R.string.list_caution_shark,
				R.string.list_incompatible_shark
			),
			//Suckermouth Catfish
			Freshwater(
				R.drawable.suckermouth_catfish,
				R.string.text_sucker_catfish,
				R.string.text_latin_larger_catfish,
				R.string.list_compatible_suckermouth_catfish,
				R.string.list_caution_suckermouth_catfish,
				R.string.list_incompatible_suckermouth_catfish
			),
			//Swordtails
			Freshwater(
				R.drawable.swordtail,
				R.string.text_swordtail,
				R.string.text_latin_swordtail,
				R.string.list_compatible_swordtail,
				R.string.list_caution_swordtail,
				R.string.list_incompatible_swordtail
			),
			//Tetras
			Freshwater(
				R.drawable.tetra,
				R.string.text_tetra,
				R.string.text_latin_tetra,
				R.string.list_compatible_tetra,
				R.string.list_compatible_tetra,
				R.string.list_incompatible_tetra
			),
			//Misc. Fish
			Freshwater(
				R.drawable.misc_fish,
				R.string.text_misc_fish,
				R.string.text_latin_various,
				R.string.list_compatible_misc,
				R.string.list_caution_misc,
				R.string.list_incompatible_misc
			),
			//Invertebrates
			Freshwater(
				R.drawable.shrimp,
				R.string.text_inverts,
				R.string.text_latin_various,
				R.string.list_compatible_inverts,
				R.string.list_caution_inverts,
				R.string.list_incompatible_inverts
			),
			//Brackish Fish
			Freshwater(
				R.drawable.brackish,
				R.string.text_brackish,
				R.string.text_latin_various,
				R.string.list_compatible_brackish,
				R.string.list_caution_brackish,
				R.string.list_incompatible_brackish
			),
			//Pond Fish
			Freshwater(
				R.drawable.koi,
				R.string.text_pond,
				R.string.text_latin_various,
				R.string.list_compatible_pond,
				R.string.list_compatible_pond,
				R.string.list_incompatible_pond
			),
			//Freshwater Plants
			Freshwater(
				R.drawable.java_fern,
				R.string.text_freshwater_plants,
				R.string.text_latin_various,
				R.string.list_compatible_freshwater_plants,
				R.string.list_caution_freshwater_plants,
				R.string.list_incompatible_freshwater_plants
			),
		)
	}
}