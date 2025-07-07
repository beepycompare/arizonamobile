package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class SpawnSelectorBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout spawnSelector;
    public final ConstraintLayout spawnSelectorBackground;
    public final RecyclerView spawnSelectorRc;
    public final ConstraintLayout spawnSelectorStartGameButton;
    public final TextView spawnSelectorStartGameButtonText;
    public final TextView spawnSelectorTitle;

    private SpawnSelectorBinding(ConstraintLayout rootView, ConstraintLayout spawnSelector, ConstraintLayout spawnSelectorBackground, RecyclerView spawnSelectorRc, ConstraintLayout spawnSelectorStartGameButton, TextView spawnSelectorStartGameButtonText, TextView spawnSelectorTitle) {
        this.rootView = rootView;
        this.spawnSelector = spawnSelector;
        this.spawnSelectorBackground = spawnSelectorBackground;
        this.spawnSelectorRc = spawnSelectorRc;
        this.spawnSelectorStartGameButton = spawnSelectorStartGameButton;
        this.spawnSelectorStartGameButtonText = spawnSelectorStartGameButtonText;
        this.spawnSelectorTitle = spawnSelectorTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpawnSelectorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpawnSelectorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.spawn_selector, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpawnSelectorBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.spawn_selector_background;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout2 != null) {
            i = R.id.spawn_selector_rc;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                i = R.id.spawn_selector_start_game_button;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout3 != null) {
                    i = R.id.spawn_selector_start_game_button_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.spawn_selector_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            return new SpawnSelectorBinding(constraintLayout, constraintLayout, constraintLayout2, recyclerView, constraintLayout3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
