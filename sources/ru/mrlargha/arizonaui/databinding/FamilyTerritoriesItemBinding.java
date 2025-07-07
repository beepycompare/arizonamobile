package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyTerritoriesItemBinding implements ViewBinding {
    public final CardView buttonAlliance;
    public final TextView coins;
    public final LinearLayout gpsButton;
    public final CardView infoBtn;
    public final TextView money;
    public final LinearLayout neighborGameTaskScreen;
    private final LinearLayout rootView;
    public final TextView title;
    public final ImageView uniq;

    private FamilyTerritoriesItemBinding(LinearLayout linearLayout, CardView cardView, TextView textView, LinearLayout linearLayout2, CardView cardView2, TextView textView2, LinearLayout linearLayout3, TextView textView3, ImageView imageView) {
        this.rootView = linearLayout;
        this.buttonAlliance = cardView;
        this.coins = textView;
        this.gpsButton = linearLayout2;
        this.infoBtn = cardView2;
        this.money = textView2;
        this.neighborGameTaskScreen = linearLayout3;
        this.title = textView3;
        this.uniq = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilyTerritoriesItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyTerritoriesItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_territories_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyTerritoriesItemBinding bind(View view) {
        int i = R.id.button_alliance;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.coins;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.gps_button;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.info_btn;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView2 != null) {
                        i = R.id.money;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view;
                            i = R.id.title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.uniq;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    return new FamilyTerritoriesItemBinding(linearLayout2, cardView, textView, linearLayout, cardView2, textView2, linearLayout2, textView3, imageView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
