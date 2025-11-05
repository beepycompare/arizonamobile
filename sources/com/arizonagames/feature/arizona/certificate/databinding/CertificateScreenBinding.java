package com.arizonagames.feature.arizona.certificate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.certificate.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class CertificateScreenBinding implements ViewBinding {
    public final View blackOverlay;
    public final TextView bonusTitle;
    public final LinearLayout bottomContainer;
    public final CustomCardView buttonGet;
    public final CustomCardView buttonSell;
    public final CustomCardView cardInfo;
    public final ImageView image;
    public final CertificateInfoItemBinding info1;
    public final CertificateInfoItemBinding info2;
    public final CertificateInfoItemLeftBinding info3;
    public final CertificateInfoItemLeftBinding info4;
    public final View overlay;
    public final CustomCardView qualityBg;
    public final CustomCardView qualityButton;
    public final TextView qualityText;
    private final ConstraintLayout rootView;
    public final ImageView sellIc;
    public final TextView sellText;
    public final TextView textBonus;
    public final TextView title;
    public final LinearLayout topContainer;
    public final ConstraintLayout transportScreen;

    private CertificateScreenBinding(ConstraintLayout constraintLayout, View view, TextView textView, LinearLayout linearLayout, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, ImageView imageView, CertificateInfoItemBinding certificateInfoItemBinding, CertificateInfoItemBinding certificateInfoItemBinding2, CertificateInfoItemLeftBinding certificateInfoItemLeftBinding, CertificateInfoItemLeftBinding certificateInfoItemLeftBinding2, View view2, CustomCardView customCardView4, CustomCardView customCardView5, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.blackOverlay = view;
        this.bonusTitle = textView;
        this.bottomContainer = linearLayout;
        this.buttonGet = customCardView;
        this.buttonSell = customCardView2;
        this.cardInfo = customCardView3;
        this.image = imageView;
        this.info1 = certificateInfoItemBinding;
        this.info2 = certificateInfoItemBinding2;
        this.info3 = certificateInfoItemLeftBinding;
        this.info4 = certificateInfoItemLeftBinding2;
        this.overlay = view2;
        this.qualityBg = customCardView4;
        this.qualityButton = customCardView5;
        this.qualityText = textView2;
        this.sellIc = imageView2;
        this.sellText = textView3;
        this.textBonus = textView4;
        this.title = textView5;
        this.topContainer = linearLayout2;
        this.transportScreen = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CertificateScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CertificateScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.certificate_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CertificateScreenBinding bind(View view) {
        View findChildViewById;
        int i = R.id.black_overlay;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = R.id.bonus_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.bottom_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.button_get;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView != null) {
                        i = R.id.button_sell;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView2 != null) {
                            i = R.id.card_info;
                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView3 != null) {
                                i = R.id.image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.info1))) != null) {
                                    CertificateInfoItemBinding bind = CertificateInfoItemBinding.bind(findChildViewById);
                                    i = R.id.info2;
                                    View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById3 != null) {
                                        CertificateInfoItemBinding bind2 = CertificateInfoItemBinding.bind(findChildViewById3);
                                        i = R.id.info3;
                                        View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById4 != null) {
                                            CertificateInfoItemLeftBinding bind3 = CertificateInfoItemLeftBinding.bind(findChildViewById4);
                                            i = R.id.info4;
                                            View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById5 != null) {
                                                CertificateInfoItemLeftBinding bind4 = CertificateInfoItemLeftBinding.bind(findChildViewById5);
                                                i = R.id.overlay;
                                                View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                                if (findChildViewById6 != null) {
                                                    i = R.id.quality_bg;
                                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView4 != null) {
                                                        i = R.id.quality_button;
                                                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView5 != null) {
                                                            i = R.id.quality_text;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.sell_ic;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView2 != null) {
                                                                    i = R.id.sell_text;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.text_bonus;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            i = R.id.title;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.top_container;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout2 != null) {
                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                    return new CertificateScreenBinding(constraintLayout, findChildViewById2, textView, linearLayout, customCardView, customCardView2, customCardView3, imageView, bind, bind2, bind3, bind4, findChildViewById6, customCardView4, customCardView5, textView2, imageView2, textView3, textView4, textView5, linearLayout2, constraintLayout);
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
