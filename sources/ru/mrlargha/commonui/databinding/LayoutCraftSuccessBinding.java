package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutCraftSuccessBinding implements ViewBinding {
    public final Button btnAcceptCraft;
    public final MaterialCardView cvSuccessCraft;
    public final ImageView ivBgCraftResult;
    public final ImageView ivCraftedItem;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final TextView tvCraftItemName;
    public final TextView tvCraftSuccessSubTitle;
    public final TextView tvCraftSuccessTitle;
    public final View viewShiningLight;
    public final CardView viewTopRight;

    private LayoutCraftSuccessBinding(ConstraintLayout rootView, Button btnAcceptCraft, MaterialCardView cvSuccessCraft, ImageView ivBgCraftResult, ImageView ivCraftedItem, ConstraintLayout parentLayout, TextView tvCraftItemName, TextView tvCraftSuccessSubTitle, TextView tvCraftSuccessTitle, View viewShiningLight, CardView viewTopRight) {
        this.rootView = rootView;
        this.btnAcceptCraft = btnAcceptCraft;
        this.cvSuccessCraft = cvSuccessCraft;
        this.ivBgCraftResult = ivBgCraftResult;
        this.ivCraftedItem = ivCraftedItem;
        this.parentLayout = parentLayout;
        this.tvCraftItemName = tvCraftItemName;
        this.tvCraftSuccessSubTitle = tvCraftSuccessSubTitle;
        this.tvCraftSuccessTitle = tvCraftSuccessTitle;
        this.viewShiningLight = viewShiningLight;
        this.viewTopRight = viewTopRight;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCraftSuccessBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutCraftSuccessBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_craft_success, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutCraftSuccessBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btnAcceptCraft;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.cvSuccessCraft;
            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
            if (materialCardView != null) {
                i = R.id.ivBgCraftResult;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.ivCraftedItem;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                        i = R.id.tvCraftItemName;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tvCraftSuccessSubTitle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.tvCraftSuccessTitle;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewShiningLight))) != null) {
                                    i = R.id.viewTopRight;
                                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                                    if (cardView != null) {
                                        return new LayoutCraftSuccessBinding(constraintLayout, button, materialCardView, imageView, imageView2, constraintLayout, textView, textView2, textView3, findChildViewById, cardView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
