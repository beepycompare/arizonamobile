package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class CaseRouletteItemBinding implements ViewBinding {
    public final ConstraintLayout caseRouletteItem;
    public final ConstraintLayout itemContainer;
    public final ImageView itemIc;
    public final TextView itemName;
    public final ImageView itemRarityGlow;
    public final CardView itemRarityStick;
    private final ConstraintLayout rootView;

    private CaseRouletteItemBinding(ConstraintLayout rootView, ConstraintLayout caseRouletteItem, ConstraintLayout itemContainer, ImageView itemIc, TextView itemName, ImageView itemRarityGlow, CardView itemRarityStick) {
        this.rootView = rootView;
        this.caseRouletteItem = caseRouletteItem;
        this.itemContainer = itemContainer;
        this.itemIc = itemIc;
        this.itemName = itemName;
        this.itemRarityGlow = itemRarityGlow;
        this.itemRarityStick = itemRarityStick;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CaseRouletteItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CaseRouletteItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.case_roulette_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CaseRouletteItemBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.item_container;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout2 != null) {
            i = R.id.item_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.item_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.item_rarity_glow;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.item_rarity_stick;
                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                        if (cardView != null) {
                            return new CaseRouletteItemBinding(constraintLayout, constraintLayout, constraintLayout2, imageView, textView, imageView2, cardView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
