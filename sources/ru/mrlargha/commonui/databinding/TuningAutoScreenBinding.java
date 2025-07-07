package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class TuningAutoScreenBinding implements ViewBinding {
    public final View bgUserCart;
    public final Button btnAddCart;
    public final AppCompatImageView btnBack;
    public final AppCompatImageView btnExit;
    public final LayoutCarCharacteristicBinding carCharacteristicLayout;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineHor3;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer3;
    public final Guideline guidelineVer4;
    public final Guideline guidelineVer5;
    public final AppCompatImageView ivCart;
    public final LinearLayout linearCart;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvCategoryComponents;
    public final RecyclerView rvMenu;
    public final RecyclerView rvSubMenu;
    public final LayoutSelectColorBinding selectColorLayout;
    public final LayoutTintSettingsBinding tintSettingsLayout;
    public final TextView tvBack;
    public final TextView tvCartCount;
    public final TextView tvCartTotal;
    public final TextView tvClose;
    public final TextView tvTitle;
    public final TextView tvUserMoney;
    public final LayoutTuningCartBinding userCartLayout;
    public final ImageView viewLine;
    public final ImageView viewLineMenu;
    public final LayoutWheelSettingsBinding wheelSettingsLayout;

    private TuningAutoScreenBinding(ConstraintLayout rootView, View bgUserCart, Button btnAddCart, AppCompatImageView btnBack, AppCompatImageView btnExit, LayoutCarCharacteristicBinding carCharacteristicLayout, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineHor3, Guideline guidelineVer1, Guideline guidelineVer2, Guideline guidelineVer3, Guideline guidelineVer4, Guideline guidelineVer5, AppCompatImageView ivCart, LinearLayout linearCart, ConstraintLayout parentLayout, RecyclerView rvCategoryComponents, RecyclerView rvMenu, RecyclerView rvSubMenu, LayoutSelectColorBinding selectColorLayout, LayoutTintSettingsBinding tintSettingsLayout, TextView tvBack, TextView tvCartCount, TextView tvCartTotal, TextView tvClose, TextView tvTitle, TextView tvUserMoney, LayoutTuningCartBinding userCartLayout, ImageView viewLine, ImageView viewLineMenu, LayoutWheelSettingsBinding wheelSettingsLayout) {
        this.rootView = rootView;
        this.bgUserCart = bgUserCart;
        this.btnAddCart = btnAddCart;
        this.btnBack = btnBack;
        this.btnExit = btnExit;
        this.carCharacteristicLayout = carCharacteristicLayout;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineHor3 = guidelineHor3;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer3 = guidelineVer3;
        this.guidelineVer4 = guidelineVer4;
        this.guidelineVer5 = guidelineVer5;
        this.ivCart = ivCart;
        this.linearCart = linearCart;
        this.parentLayout = parentLayout;
        this.rvCategoryComponents = rvCategoryComponents;
        this.rvMenu = rvMenu;
        this.rvSubMenu = rvSubMenu;
        this.selectColorLayout = selectColorLayout;
        this.tintSettingsLayout = tintSettingsLayout;
        this.tvBack = tvBack;
        this.tvCartCount = tvCartCount;
        this.tvCartTotal = tvCartTotal;
        this.tvClose = tvClose;
        this.tvTitle = tvTitle;
        this.tvUserMoney = tvUserMoney;
        this.userCartLayout = userCartLayout;
        this.viewLine = viewLine;
        this.viewLineMenu = viewLineMenu;
        this.wheelSettingsLayout = wheelSettingsLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TuningAutoScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TuningAutoScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tuning_auto_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TuningAutoScreenBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        int i = R.id.bgUserCart;
        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById5 != null) {
            i = R.id.btnAddCart;
            Button button = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button != null) {
                i = R.id.btnBack;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    i = R.id.btnExit;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.carCharacteristicLayout))) != null) {
                        LayoutCarCharacteristicBinding bind = LayoutCarCharacteristicBinding.bind(findChildViewById);
                        i = R.id.guidelineHor1;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline != null) {
                            i = R.id.guidelineHor2;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline2 != null) {
                                i = R.id.guidelineHor3;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline3 != null) {
                                    i = R.id.guidelineVer1;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline4 != null) {
                                        i = R.id.guidelineVer2;
                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline5 != null) {
                                            i = R.id.guidelineVer3;
                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline6 != null) {
                                                i = R.id.guidelineVer4;
                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline7 != null) {
                                                    i = R.id.guidelineVer5;
                                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline8 != null) {
                                                        i = R.id.ivCart;
                                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (appCompatImageView3 != null) {
                                                            i = R.id.linearCart;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                i = R.id.rvCategoryComponents;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                if (recyclerView != null) {
                                                                    i = R.id.rvMenu;
                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (recyclerView2 != null) {
                                                                        i = R.id.rvSubMenu;
                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (recyclerView3 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.selectColorLayout))) != null) {
                                                                            LayoutSelectColorBinding bind2 = LayoutSelectColorBinding.bind(findChildViewById2);
                                                                            i = R.id.tintSettingsLayout;
                                                                            View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                                                            if (findChildViewById6 != null) {
                                                                                LayoutTintSettingsBinding bind3 = LayoutTintSettingsBinding.bind(findChildViewById6);
                                                                                i = R.id.tvBack;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView != null) {
                                                                                    i = R.id.tvCartCount;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tvCartTotal;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tvClose;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tvTitle;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.tvUserMoney;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView6 != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.userCartLayout))) != null) {
                                                                                                        LayoutTuningCartBinding bind4 = LayoutTuningCartBinding.bind(findChildViewById3);
                                                                                                        i = R.id.viewLine;
                                                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (imageView != null) {
                                                                                                            i = R.id.viewLineMenu;
                                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (imageView2 != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.wheelSettingsLayout))) != null) {
                                                                                                                return new TuningAutoScreenBinding(constraintLayout, findChildViewById5, button, appCompatImageView, appCompatImageView2, bind, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, appCompatImageView3, linearLayout, constraintLayout, recyclerView, recyclerView2, recyclerView3, bind2, bind3, textView, textView2, textView3, textView4, textView5, textView6, bind4, imageView, imageView2, LayoutWheelSettingsBinding.bind(findChildViewById4));
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
