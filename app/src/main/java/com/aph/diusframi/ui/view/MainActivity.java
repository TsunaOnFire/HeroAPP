package com.aph.diusframi.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

import com.aph.diusframi.R;
import com.aph.diusframi.databinding.ActivityMainBinding;
import com.aph.diusframi.domain.model.Character;
import com.aph.diusframi.ui.adapters.CharactersAdapter;
import com.aph.diusframi.ui.viewmodel.CharacterViewModel;
import com.aph.diusframi.utils.APH_toolbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Unit;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    private ActivityMainBinding binding;
    public static CharacterViewModel charactersViewModel;
    private CharactersAdapter charactersadapter;
    private List<Character> characters= new ArrayList<Character>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        charactersViewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        setContentView(binding.getRoot());
        initRecyclerView();

        charactersViewModel.onCreate();

        binding.searchView.setOnQueryTextListener(this);


        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {//SWIPE TO REFRESH ACTION
                binding.searchView.setQuery("", false);
                binding.searchView.setIconified(true);
                hideKeyboard();
                charactersViewModel.onCreate();
            }
        });

        final Observer<Boolean> LoadingObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable final Boolean isLoading) {
                // Update the UI, in this case, a TextView.
                if(isLoading!=null) {
                    binding.swipeRefreshLayout.setRefreshing(isLoading);
                }
            }
        };
        charactersViewModel.isLoading().observe(this,LoadingObserver);


        final Observer<List<Character>> ListObserver = new Observer<List<Character>>() {
            @Override
            public void onChanged(@Nullable final List<Character> updated_list) {
                // Update the UI, in this case, a TextView.
                if(updated_list!=null) {
                    characters.clear();
                    characters.addAll(updated_list);
                    charactersadapter.notifyDataSetChanged();
                }
            }
        };


        charactersViewModel.getCharacterListFiltered().observe(this, ListObserver);
    }


    @Override
    protected void onResume() {
        super.onResume();
        charactersViewModel.filterCharacters(binding.searchView.getQuery().toString().toLowerCase(Locale.ROOT));
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(binding.viewRoot.getWindowToken(), 0);
    }


    private void initRecyclerView() {
        charactersadapter= new CharactersAdapter(characters);
        binding.rvCharacters.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCharacters.setAdapter(charactersadapter);
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String toSearch) {

        charactersViewModel.filterCharacters(toSearch.toLowerCase(Locale.ROOT));

        return true;
    }

}
