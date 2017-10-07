package com.github.stephenvinouze.advancedrecyclerviewsample.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.stephenvinouze.advancedrecyclerview_core.adapters.RecyclerAdapter;
import com.github.stephenvinouze.advancedrecyclerview_core.callbacks.ClickCallback;
import com.github.stephenvinouze.advancedrecyclerviewsample.adapters.SampleAdapter;
import com.github.stephenvinouze.advancedrecyclerviewsample.models.Sample;

/**
 * Created by Stephen Vinouze on 06/11/2015.
 */
public class MultipleChoiceRecyclerFragment extends AbstractRecyclerFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SampleAdapter adapter = new SampleAdapter(getActivity());
        adapter.setItems(SampleAdapter.buildSamples());
        adapter.setChoiceMode(RecyclerAdapter.ChoiceMode.MULTIPLE);
        adapter.setClickCallback(new ClickCallback() {
            @Override
            public void onItemClick(@NonNull View view, int position) {
                Sample sample = adapter.getItems().get(position);
                Toast.makeText(getActivity(), "Item clicked : " + sample.getId() + " (" + adapter.getSelectedItemViewCount() + " selected)", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(adapter);
    }

}
