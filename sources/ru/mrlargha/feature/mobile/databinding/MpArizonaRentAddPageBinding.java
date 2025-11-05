package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.CustomEditText;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MpArizonaRentAddPageBinding implements ViewBinding {
    public final LinearLayout arizonaRentAddPage;
    public final CustomCardView btnCreateAd;
    public final CustomCardView btnFully;
    public final CustomCardView btnRoom;
    public final CustomCardView costContainer;
    public final CustomCardView descContainer;
    public final CustomEditText etCost;
    public final CustomEditText etDesc;
    public final CustomEditText etFrom;
    public final CustomEditText etTo;
    public final CustomCardView fromContainer;
    public final ImageView ivSpinnerArrow;
    private final LinearLayout rootView;
    public final Spinner spinnerRealEstate;
    public final CustomCardView toContainer;
    public final MpArizonaRentTopBarBinding topBar;
    public final TextView tvAvailableOutOf;
    public final TextView tvCost;
    public final TextView tvCostError;
    public final TextView tvCreateAd;
    public final TextView tvDataError;
    public final TextView tvDesc;
    public final TextView tvDescError;
    public final TextView tvDescOutOf;
    public final TextView tvFully;
    public final TextView tvRentalTime;
    public final TextView tvRoom;

    private MpArizonaRentAddPageBinding(LinearLayout linearLayout, LinearLayout linearLayout2, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, CustomCardView customCardView4, CustomCardView customCardView5, CustomEditText customEditText, CustomEditText customEditText2, CustomEditText customEditText3, CustomEditText customEditText4, CustomCardView customCardView6, ImageView imageView, Spinner spinner, CustomCardView customCardView7, MpArizonaRentTopBarBinding mpArizonaRentTopBarBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.arizonaRentAddPage = linearLayout2;
        this.btnCreateAd = customCardView;
        this.btnFully = customCardView2;
        this.btnRoom = customCardView3;
        this.costContainer = customCardView4;
        this.descContainer = customCardView5;
        this.etCost = customEditText;
        this.etDesc = customEditText2;
        this.etFrom = customEditText3;
        this.etTo = customEditText4;
        this.fromContainer = customCardView6;
        this.ivSpinnerArrow = imageView;
        this.spinnerRealEstate = spinner;
        this.toContainer = customCardView7;
        this.topBar = mpArizonaRentTopBarBinding;
        this.tvAvailableOutOf = textView;
        this.tvCost = textView2;
        this.tvCostError = textView3;
        this.tvCreateAd = textView4;
        this.tvDataError = textView5;
        this.tvDesc = textView6;
        this.tvDescError = textView7;
        this.tvDescOutOf = textView8;
        this.tvFully = textView9;
        this.tvRentalTime = textView10;
        this.tvRoom = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MpArizonaRentAddPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MpArizonaRentAddPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mp_arizona_rent_add_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MpArizonaRentAddPageBinding bind(View view) {
        View findChildViewById;
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.btn_create_ad;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.btn_fully;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.btn_room;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.cost_container;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView4 != null) {
                        i = R.id.desc_container;
                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView5 != null) {
                            i = R.id.et_cost;
                            CustomEditText customEditText = (CustomEditText) ViewBindings.findChildViewById(view, i);
                            if (customEditText != null) {
                                i = R.id.et_desc;
                                CustomEditText customEditText2 = (CustomEditText) ViewBindings.findChildViewById(view, i);
                                if (customEditText2 != null) {
                                    i = R.id.et_from;
                                    CustomEditText customEditText3 = (CustomEditText) ViewBindings.findChildViewById(view, i);
                                    if (customEditText3 != null) {
                                        i = R.id.et_to;
                                        CustomEditText customEditText4 = (CustomEditText) ViewBindings.findChildViewById(view, i);
                                        if (customEditText4 != null) {
                                            i = R.id.from_container;
                                            CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView6 != null) {
                                                i = R.id.iv_spinner_arrow;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = R.id.spinner_real_estate;
                                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
                                                    if (spinner != null) {
                                                        i = R.id.to_container;
                                                        CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView7 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.top_bar))) != null) {
                                                            MpArizonaRentTopBarBinding bind = MpArizonaRentTopBarBinding.bind(findChildViewById);
                                                            i = R.id.tv_available_out_of;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.tv_cost;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.tv_cost_error;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.tv_create_ad;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            i = R.id.tv_data_error;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.tv_desc;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.tv_desc_error;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.tv_desc_out_of;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.tv_fully;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.tv_rental_time;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.tv_room;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView11 != null) {
                                                                                                        return new MpArizonaRentAddPageBinding(linearLayout, linearLayout, customCardView, customCardView2, customCardView3, customCardView4, customCardView5, customEditText, customEditText2, customEditText3, customEditText4, customCardView6, imageView, spinner, customCardView7, bind, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
