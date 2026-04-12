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
import ru.mrlargha.commonui.utils.ui.StrokeTextView;
/* loaded from: classes3.dex */
public final class AtmScreenChickenBinding implements ViewBinding {
    public final ImageView atmImage;
    public final ImageView backgroundImage;
    public final ImageView bagImage;
    public final View bagTouchArea;
    public final ImageView bgResult;
    public final FrameLayout bottomArea;
    public final LinearLayout centerPanel;
    public final View close;
    public final LinearLayout contentContainer;
    public final FrameLayout dragLayer;
    public final CustomCardView infoCard;
    public final ImageView infoIcon;
    public final TextView infoText;
    public final LinearLayout leftPanel;
    public final FrameLayout progressBlock;
    public final ImageView progressIcon;
    public final StrokeTextView progressText;
    public final StrokeTextView progressTitleText;
    public final LinearLayout rightPanel;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final FrameLayout slot100Container;
    public final FrameLayout slot10Container;
    public final FrameLayout slot1Container;
    public final FrameLayout slot50Container;
    public final LinearLayout slotsRow;
    public final CustomCardView statusPanel;
    public final TextView statusText;
    public final StrokeTextView titleText;
    public final LinearLayout topRow;

    private AtmScreenChickenBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, View view, ImageView imageView4, FrameLayout frameLayout2, LinearLayout linearLayout, View view2, LinearLayout linearLayout2, FrameLayout frameLayout3, CustomCardView customCardView, ImageView imageView5, TextView textView, LinearLayout linearLayout3, FrameLayout frameLayout4, ImageView imageView6, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, LinearLayout linearLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, FrameLayout frameLayout7, FrameLayout frameLayout8, FrameLayout frameLayout9, LinearLayout linearLayout5, CustomCardView customCardView2, TextView textView2, StrokeTextView strokeTextView3, LinearLayout linearLayout6) {
        this.rootView = frameLayout;
        this.atmImage = imageView;
        this.backgroundImage = imageView2;
        this.bagImage = imageView3;
        this.bagTouchArea = view;
        this.bgResult = imageView4;
        this.bottomArea = frameLayout2;
        this.centerPanel = linearLayout;
        this.close = view2;
        this.contentContainer = linearLayout2;
        this.dragLayer = frameLayout3;
        this.infoCard = customCardView;
        this.infoIcon = imageView5;
        this.infoText = textView;
        this.leftPanel = linearLayout3;
        this.progressBlock = frameLayout4;
        this.progressIcon = imageView6;
        this.progressText = strokeTextView;
        this.progressTitleText = strokeTextView2;
        this.rightPanel = linearLayout4;
        this.root = frameLayout5;
        this.slot100Container = frameLayout6;
        this.slot10Container = frameLayout7;
        this.slot1Container = frameLayout8;
        this.slot50Container = frameLayout9;
        this.slotsRow = linearLayout5;
        this.statusPanel = customCardView2;
        this.statusText = textView2;
        this.titleText = strokeTextView3;
        this.topRow = linearLayout6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AtmScreenChickenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AtmScreenChickenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.atm_screen_chicken, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AtmScreenChickenBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.atmImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backgroundImage;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.bagImage;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bagTouchArea))) != null) {
                    i = R.id.bgResult;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.bottomArea;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = R.id.centerPanel;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.close))) != null) {
                                i = R.id.contentContainer;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.dragLayer;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout2 != null) {
                                        i = R.id.infoCard;
                                        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                        if (customCardView != null) {
                                            i = R.id.infoIcon;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = R.id.infoText;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.leftPanel;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.progressBlock;
                                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                        if (frameLayout3 != null) {
                                                            i = R.id.progressIcon;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.progressText;
                                                                StrokeTextView strokeTextView = (StrokeTextView) ViewBindings.findChildViewById(view, i);
                                                                if (strokeTextView != null) {
                                                                    i = R.id.progressTitleText;
                                                                    StrokeTextView strokeTextView2 = (StrokeTextView) ViewBindings.findChildViewById(view, i);
                                                                    if (strokeTextView2 != null) {
                                                                        i = R.id.rightPanel;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout4 != null) {
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
                                                                                            i = R.id.slotsRow;
                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout5 != null) {
                                                                                                i = R.id.statusPanel;
                                                                                                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                if (customCardView2 != null) {
                                                                                                    i = R.id.statusText;
                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView2 != null) {
                                                                                                        i = R.id.titleText;
                                                                                                        StrokeTextView strokeTextView3 = (StrokeTextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (strokeTextView3 != null) {
                                                                                                            i = R.id.topRow;
                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout6 != null) {
                                                                                                                return new AtmScreenChickenBinding(frameLayout4, imageView, imageView2, imageView3, findChildViewById, imageView4, frameLayout, linearLayout, findChildViewById2, linearLayout2, frameLayout2, customCardView, imageView5, textView, linearLayout3, frameLayout3, imageView6, strokeTextView, strokeTextView2, linearLayout4, frameLayout4, frameLayout5, frameLayout6, frameLayout7, frameLayout8, linearLayout5, customCardView2, textView2, strokeTextView3, linearLayout6);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
