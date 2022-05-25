package com.aph.diusframi.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aph.diusframi.R;
import com.aph.diusframi.databinding.ActivityDetailBinding;
import com.aph.diusframi.databinding.ActivityMainBinding;
import com.aph.diusframi.domain.SetFavCharacter;
import com.aph.diusframi.domain.model.Character;
import com.aph.diusframi.ui.viewmodel.CharacterViewModel;
import com.squareup.picasso.Picasso;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private boolean fav = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        Character character = this.getIntent().getParcelableExtra("character");


        binding.ivClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (character != null) {

            Picasso.get().load(character.getImage()).into(binding.ivCharacterDetails);


            if (character.getFav() != null && character.getFav()) {
                fav = true;
                binding.imgFav.setImageResource(R.drawable.ic_fav_confirmed);
            } else {
                fav = false;
                binding.imgFav.setImageResource(R.drawable.ic_fav);
            }
            binding.imgFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (character.getId() != null) {
                        fav = !fav;
                        MainActivity.charactersViewModel.updateCharacterList(fav, character.getId());
                        if (fav) {
                            binding.imgFav.setImageResource(R.drawable.ic_fav_confirmed);
                        } else {
                            binding.imgFav.setImageResource(R.drawable.ic_fav);
                        }
                    }

                }
            });

            binding.tvNameDetails.setText(character.getName());

            //SET STATS
            if (character.getPowerstats() != null) {
                if (character.getPowerstats().getIntelligence() != null) {
                    binding.tvIntelligenceValue.setText(character.getPowerstats().getIntelligence().toString());
                }
                if (character.getPowerstats().getStrength() != null) {
                    binding.tvStrengthValue.setText(character.getPowerstats().getStrength().toString());
                }
                if (character.getPowerstats().getSpeed() != null) {
                    binding.tvSpeedValue.setText(character.getPowerstats().getSpeed().toString());
                }
                if (character.getPowerstats().getDurability() != null) {
                    binding.tvDurabilityValue.setText(character.getPowerstats().getDurability().toString());
                }
                if (character.getPowerstats().getPower() != null) {
                    binding.tvPowerValue.setText(character.getPowerstats().getPower().toString());
                }
                if (character.getPowerstats().getCombat() != null) {
                    binding.tvCombatValue.setText(character.getPowerstats().getCombat().toString());
                }
            }


            //SET BIOGRAPHY
            if (character.getBiography() != null) {
                if (character.getBiography().getFullName() != null) {
                    binding.tvFullNameValue.setText(character.getBiography().getFullName());
                }
                if (character.getBiography().getAlterEgos() != null) {
                    binding.tvAlterEgosValue.setText(character.getBiography().getAlterEgos());
                }
                if (character.getBiography().getPlaceOfBirth() != null) {
                    binding.tvPlaceOfBirthValue.setText(character.getBiography().getPlaceOfBirth());
                }
                if (character.getBiography().getFirstAppearance() != null) {
                    binding.tvFirstAppearanceValue.setText(character.getBiography().getFirstAppearance());
                }
                if (character.getBiography().getPublisher() != null) {
                    binding.tvPublisherValue.setText(character.getBiography().getPublisher());
                }
                if (character.getBiography().getAlignment() != null) {
                    binding.tvAlignmentValue.setText(character.getBiography().getAlignment());
                }
            }

            //SET APPEARANCE
            if (character.getAppearance() != null) {
                if (character.getAppearance().getGender() != null) {
                    binding.tvGenderValue.setText(character.getAppearance().getGender());
                }
                if (character.getAppearance().getRace() != null) {
                    binding.tvRaceValue.setText(character.getAppearance().getRace());
                }
                if (character.getAppearance().getEyeColor() != null) {
                    binding.tvEyeColorValue.setText(character.getAppearance().getEyeColor());
                }
                if (character.getAppearance().getHairColor() != null) {
                    binding.tvHairColorValue.setText(character.getAppearance().getHairColor());
                }
            }
        }
    }
}