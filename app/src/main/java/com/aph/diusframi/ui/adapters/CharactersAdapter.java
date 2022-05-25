package com.aph.diusframi.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.aph.diusframi.R;
import com.aph.diusframi.databinding.ItemCharacterBinding;
import com.aph.diusframi.domain.model.Character;
import com.aph.diusframi.ui.view.DetailActivity;
import com.aph.diusframi.utils.APH_toolbox;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {


    private List<Character> localCharacters;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public CharactersAdapter(List<Character> characters) {
        localCharacters = characters;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_character, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Character item = localCharacters.get(position);
        ItemCharacterBinding binding = ItemCharacterBinding.bind(viewHolder.itemView);

        if(item.getFav()!=null &&item.getFav()){
            binding.imgIsFav.setVisibility(View.VISIBLE);
        }
        else{
            binding.imgIsFav.setVisibility(View.GONE);

        }

        binding.tvName.setText(item.getName());
        Picasso.get().load(item.getImage()).into(binding.ivCharacter);
        if(item.getPowerstats()!=null){
            if(item.getPowerstats().getIntelligence()!=null){
                binding.tvIntelligenceValue.setText(item.getPowerstats().getIntelligence().toString());
            }
            if(item.getPowerstats().getStrength()!=null){
                binding.tvStrengthValue.setText(item.getPowerstats().getStrength().toString());
            }
            if(item.getPowerstats().getSpeed()!=null){
                binding.tvSpeedValue.setText(item.getPowerstats().getSpeed().toString());
            }
            if(item.getPowerstats().getDurability()!=null){
                binding.tvDurabilityValue.setText(item.getPowerstats().getDurability().toString());
            }
            if(item.getPowerstats().getPower()!=null){
                binding.tvPowerValue.setText(item.getPowerstats().getPower().toString());
            }
            if(item.getPowerstats().getCombat()!=null){
                binding.tvCombatValue.setText(item.getPowerstats().getCombat().toString());
            }
        }





        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(binding.getRoot().getContext(), item);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localCharacters.size();
    }

    private void openDetails(Context context, Character character){
        Intent intent =new Intent(context, DetailActivity.class);
        Bundle b =new Bundle();
        b.putParcelable("character", APH_toolbox.Companion.ToParcelable(character));
        intent.putExtras(b);

        context.startActivity(intent);
    }
}