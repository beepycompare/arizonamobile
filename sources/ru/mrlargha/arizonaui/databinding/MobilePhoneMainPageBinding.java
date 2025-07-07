package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import me.relex.circleindicator.CircleIndicator3;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneMainPageBinding implements ViewBinding {
    public final ConstraintLayout mpMainPage;
    public final TextView phoneDate;
    public final ViewPager2 phoneMenuPager;
    public final CircleIndicator3 phoneMenuPagerIndicator;
    public final TextView phoneTimeBar;
    public final ConstraintLayout phoneTimeBarContainer;
    private final ConstraintLayout rootView;

    private MobilePhoneMainPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ViewPager2 viewPager2, CircleIndicator3 circleIndicator3, TextView textView2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.mpMainPage = constraintLayout2;
        this.phoneDate = textView;
        this.phoneMenuPager = viewPager2;
        this.phoneMenuPagerIndicator = circleIndicator3;
        this.phoneTimeBar = textView2;
        this.phoneTimeBarContainer = constraintLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneMainPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneMainPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_main_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneMainPageBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.phone_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.phone_menu_pager;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
            if (viewPager2 != null) {
                i = R.id.phone_menu_pager_indicator;
                CircleIndicator3 circleIndicator3 = (CircleIndicator3) ViewBindings.findChildViewById(view, i);
                if (circleIndicator3 != null) {
                    i = R.id.phone_time_bar;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.phone_time_bar_container;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            return new MobilePhoneMainPageBinding(constraintLayout, constraintLayout, textView, viewPager2, circleIndicator3, textView2, constraintLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
