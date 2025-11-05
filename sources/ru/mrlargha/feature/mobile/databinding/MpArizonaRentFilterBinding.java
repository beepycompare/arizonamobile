package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MpArizonaRentFilterBinding implements ViewBinding {
    public final ImageView btnClose;
    public final CustomCardView btnCost;
    public final CustomCardView btnFind;
    public final CustomCardView btnRating;
    public final ImageView costArrowDown;
    public final ImageView costArrowUp;
    public final EditText etSearchByNumber;
    public final ImageView ratingArrowDown;
    public final ImageView ratingArrowUp;
    private final FrameLayout rootView;
    public final SwitchCompat switchBasement;
    public final SwitchCompat switchGarage;
    public final CustomCardView switchGarageBg;
    public final CustomCardView swithcBasementBg;
    public final TextView tvCost;
    public final TextView tvRating;

    private MpArizonaRentFilterBinding(FrameLayout frameLayout, ImageView imageView, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, ImageView imageView2, ImageView imageView3, EditText editText, ImageView imageView4, ImageView imageView5, SwitchCompat switchCompat, SwitchCompat switchCompat2, CustomCardView customCardView4, CustomCardView customCardView5, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.btnClose = imageView;
        this.btnCost = customCardView;
        this.btnFind = customCardView2;
        this.btnRating = customCardView3;
        this.costArrowDown = imageView2;
        this.costArrowUp = imageView3;
        this.etSearchByNumber = editText;
        this.ratingArrowDown = imageView4;
        this.ratingArrowUp = imageView5;
        this.switchBasement = switchCompat;
        this.switchGarage = switchCompat2;
        this.switchGarageBg = customCardView4;
        this.swithcBasementBg = customCardView5;
        this.tvCost = textView;
        this.tvRating = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MpArizonaRentFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MpArizonaRentFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mp_arizona_rent_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MpArizonaRentFilterBinding bind(View view) {
        int i = R.id.btn_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_cost;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.btn_find;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.btn_rating;
                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView3 != null) {
                        i = R.id.cost_arrow_down;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.cost_arrow_up;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.et_search_by_number;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText != null) {
                                    i = R.id.rating_arrow_down;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = R.id.rating_arrow_up;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView5 != null) {
                                            i = R.id.switch_basement;
                                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                            if (switchCompat != null) {
                                                i = R.id.switch_garage;
                                                SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                                                if (switchCompat2 != null) {
                                                    i = R.id.switch_garage_bg;
                                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView4 != null) {
                                                        i = R.id.swithc_basement_bg;
                                                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView5 != null) {
                                                            i = R.id.tv_cost;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.tv_rating;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    return new MpArizonaRentFilterBinding((FrameLayout) view, imageView, customCardView, customCardView2, customCardView3, imageView2, imageView3, editText, imageView4, imageView5, switchCompat, switchCompat2, customCardView4, customCardView5, textView, textView2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
