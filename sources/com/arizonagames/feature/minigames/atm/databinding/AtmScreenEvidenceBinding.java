package com.arizonagames.feature.minigames.atm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.atm.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class AtmScreenEvidenceBinding implements ViewBinding {
    public final ImageView backgroundImage;
    public final ImageView bagImage;
    public final View bagTouchArea;
    public final ImageView bgResult;
    public final FrameLayout bottomArea;
    public final FrameLayout centerPanel;
    public final View close;
    public final FrameLayout dragLayer;
    public final CustomCardView infoCard;
    public final ImageView infoIcon;
    public final TextView infoText;
    public final LinearLayout leftPanel;
    public final LinearLayout progressBlock;
    public final ImageView progressIcon;
    public final TextView progressText;
    public final TextView progressTitleText;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final FrameLayout slot100Container;
    public final FrameLayout slot10Container;
    public final FrameLayout slot1Container;
    public final FrameLayout slot50Container;
    public final FrameLayout slotExtraContainer;
    public final CustomCardView statusPanel;
    public final TextView statusText;
    public final TextView titleText;

    private AtmScreenEvidenceBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, View view, ImageView imageView3, FrameLayout frameLayout2, FrameLayout frameLayout3, View view2, FrameLayout frameLayout4, CustomCardView customCardView, ImageView imageView4, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView5, TextView textView2, TextView textView3, FrameLayout frameLayout5, FrameLayout frameLayout6, FrameLayout frameLayout7, FrameLayout frameLayout8, FrameLayout frameLayout9, FrameLayout frameLayout10, CustomCardView customCardView2, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.backgroundImage = imageView;
        this.bagImage = imageView2;
        this.bagTouchArea = view;
        this.bgResult = imageView3;
        this.bottomArea = frameLayout2;
        this.centerPanel = frameLayout3;
        this.close = view2;
        this.dragLayer = frameLayout4;
        this.infoCard = customCardView;
        this.infoIcon = imageView4;
        this.infoText = textView;
        this.leftPanel = linearLayout;
        this.progressBlock = linearLayout2;
        this.progressIcon = imageView5;
        this.progressText = textView2;
        this.progressTitleText = textView3;
        this.root = frameLayout5;
        this.slot100Container = frameLayout6;
        this.slot10Container = frameLayout7;
        this.slot1Container = frameLayout8;
        this.slot50Container = frameLayout9;
        this.slotExtraContainer = frameLayout10;
        this.statusPanel = customCardView2;
        this.statusText = textView4;
        this.titleText = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AtmScreenEvidenceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AtmScreenEvidenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.atm_screen_evidence, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AtmScreenEvidenceBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.backgroundImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bagImage;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bagTouchArea))) != null) {
                i = R.id.bgResult;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.bottomArea;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.centerPanel;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.close))) != null) {
                            i = R.id.dragLayer;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = R.id.infoCard;
                                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView != null) {
                                    i = R.id.infoIcon;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = R.id.infoText;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.leftPanel;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout != null) {
                                                i = R.id.progressBlock;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout2 != null) {
                                                    i = R.id.progressIcon;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.progressText;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.progressTitleText;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                FrameLayout frameLayout4 = (FrameLayout) view;
                                                                i = R.id.slot100Container;
                                                                FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                if (frameLayout5 != null) {
                                                                    i = R.id.slot10Container;
                                                                    FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (frameLayout6 != null) {
                                                                        i = R.id.slot1Container;
                                                                        FrameLayout frameLayout7 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (frameLayout7 != null) {
                                                                            i = R.id.slot50Container;
                                                                            FrameLayout frameLayout8 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (frameLayout8 != null) {
                                                                                i = R.id.slotExtraContainer;
                                                                                FrameLayout frameLayout9 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (frameLayout9 != null) {
                                                                                    i = R.id.statusPanel;
                                                                                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView2 != null) {
                                                                                        i = R.id.statusText;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.titleText;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView5 != null) {
                                                                                                return new AtmScreenEvidenceBinding(frameLayout4, imageView, imageView2, findChildViewById, imageView3, frameLayout, frameLayout2, findChildViewById2, frameLayout3, customCardView, imageView4, textView, linearLayout, linearLayout2, imageView5, textView2, textView3, frameLayout4, frameLayout5, frameLayout6, frameLayout7, frameLayout8, frameLayout9, customCardView2, textView4, textView5);
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
