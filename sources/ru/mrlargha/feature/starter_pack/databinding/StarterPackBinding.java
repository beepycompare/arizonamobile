package ru.mrlargha.feature.starter_pack.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.starter_pack.R;
/* loaded from: classes6.dex */
public final class StarterPackBinding implements ViewBinding {
    public final ImageView bg1;
    public final ImageView bg2;
    public final LinearLayout button1;
    public final LinearLayout button2;
    public final LinearLayout buttonClose;
    public final TextView discount;
    public final FrameLayout discountContainer;
    public final ImageView ivSecondContainerBg;
    public final TextView newbieLevel;
    public final TextView price1;
    public final TextView price2;
    public final TextView price2Old;
    public final TextView richLevel;
    private final ConstraintLayout rootView;
    public final RecyclerView rvNewbie;
    public final RecyclerView rvRich;
    public final ConstraintLayout starterPack;
    public final TextView time;
    public final LinearLayout timeContainer;
    public final TextView title;
    public final TextView tvNewbieTitle;
    public final TextView tvRich1;
    public final TextView tvRich2;

    private StarterPackBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, FrameLayout frameLayout, ImageView imageView3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RecyclerView recyclerView, RecyclerView recyclerView2, ConstraintLayout constraintLayout2, TextView textView7, LinearLayout linearLayout4, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = constraintLayout;
        this.bg1 = imageView;
        this.bg2 = imageView2;
        this.button1 = linearLayout;
        this.button2 = linearLayout2;
        this.buttonClose = linearLayout3;
        this.discount = textView;
        this.discountContainer = frameLayout;
        this.ivSecondContainerBg = imageView3;
        this.newbieLevel = textView2;
        this.price1 = textView3;
        this.price2 = textView4;
        this.price2Old = textView5;
        this.richLevel = textView6;
        this.rvNewbie = recyclerView;
        this.rvRich = recyclerView2;
        this.starterPack = constraintLayout2;
        this.time = textView7;
        this.timeContainer = linearLayout4;
        this.title = textView8;
        this.tvNewbieTitle = textView9;
        this.tvRich1 = textView10;
        this.tvRich2 = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StarterPackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StarterPackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.starter_pack, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StarterPackBinding bind(View view) {
        int i = R.id.bg1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bg2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.button_1;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.button_2;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.button_close;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.discount;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.discount_container;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = R.id.iv_second_container_bg;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.newbie_level;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.price1;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.price2;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.price2_old;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.rich_level;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.rv_newbie;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (recyclerView != null) {
                                                                i = R.id.rv_rich;
                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                if (recyclerView2 != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                    i = R.id.time;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.time_container;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.title;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_newbie_title;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.tv_rich_1;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.tv_rich_2;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView11 != null) {
                                                                                            return new StarterPackBinding(constraintLayout, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, textView, frameLayout, imageView3, textView2, textView3, textView4, textView5, textView6, recyclerView, recyclerView2, constraintLayout, textView7, linearLayout4, textView8, textView9, textView10, textView11);
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
