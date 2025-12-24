package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class PiratesShipScreenBinding implements ViewBinding {
    public final ImageView currency;
    public final TextView currentExp;
    public final TextView level;
    public final TextView maxExp;
    public final ConstraintLayout parent;
    public final CustomCardView progressBar;
    public final CustomCardView rating;
    private final ConstraintLayout rootView;
    public final ImageView ship;
    public final TextView tabShip;
    public final PiratesShipUpgradeItemBinding upgrade1;
    public final PiratesShipUpgradeItemBinding upgrade2;
    public final PiratesShipUpgradeItemBinding upgrade3;
    public final PiratesShipUpgradeItemBinding upgrade4;

    private PiratesShipScreenBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView2, TextView textView4, PiratesShipUpgradeItemBinding piratesShipUpgradeItemBinding, PiratesShipUpgradeItemBinding piratesShipUpgradeItemBinding2, PiratesShipUpgradeItemBinding piratesShipUpgradeItemBinding3, PiratesShipUpgradeItemBinding piratesShipUpgradeItemBinding4) {
        this.rootView = constraintLayout;
        this.currency = imageView;
        this.currentExp = textView;
        this.level = textView2;
        this.maxExp = textView3;
        this.parent = constraintLayout2;
        this.progressBar = customCardView;
        this.rating = customCardView2;
        this.ship = imageView2;
        this.tabShip = textView4;
        this.upgrade1 = piratesShipUpgradeItemBinding;
        this.upgrade2 = piratesShipUpgradeItemBinding2;
        this.upgrade3 = piratesShipUpgradeItemBinding3;
        this.upgrade4 = piratesShipUpgradeItemBinding4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PiratesShipScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PiratesShipScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pirates_ship_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PiratesShipScreenBinding bind(View view) {
        View findChildViewById;
        int i = R.id.currency;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.current_exp;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.level;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.max_exp;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.parent;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.progress_bar;
                            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView != null) {
                                i = R.id.rating;
                                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView2 != null) {
                                    i = R.id.ship;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.tab_ship;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.upgrade1))) != null) {
                                            PiratesShipUpgradeItemBinding bind = PiratesShipUpgradeItemBinding.bind(findChildViewById);
                                            i = R.id.upgrade2;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById2 != null) {
                                                PiratesShipUpgradeItemBinding bind2 = PiratesShipUpgradeItemBinding.bind(findChildViewById2);
                                                i = R.id.upgrade3;
                                                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                                                if (findChildViewById3 != null) {
                                                    PiratesShipUpgradeItemBinding bind3 = PiratesShipUpgradeItemBinding.bind(findChildViewById3);
                                                    i = R.id.upgrade4;
                                                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                                    if (findChildViewById4 != null) {
                                                        return new PiratesShipScreenBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, constraintLayout, customCardView, customCardView2, imageView2, textView4, bind, bind2, bind3, PiratesShipUpgradeItemBinding.bind(findChildViewById4));
                                                    }
                                                }
                                            }
                                        }
                                    }
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
