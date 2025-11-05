package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateMainPageBinding implements ViewBinding {
    public final DotsIndicator dotsIndicator;
    private final LinearLayout rootView;
    public final RecyclerView rvMainItems;
    public final ViewPager2 viewPager;

    private DonateMainPageBinding(LinearLayout rootView, DotsIndicator dotsIndicator, RecyclerView rvMainItems, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.dotsIndicator = dotsIndicator;
        this.rvMainItems = rvMainItems;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DonateMainPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateMainPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_main_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateMainPageBinding bind(View rootView) {
        int i = R.id.dotsIndicator;
        DotsIndicator dotsIndicator = (DotsIndicator) ViewBindings.findChildViewById(rootView, i);
        if (dotsIndicator != null) {
            i = R.id.rv_main_items;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                i = R.id.view_pager;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(rootView, i);
                if (viewPager2 != null) {
                    return new DonateMainPageBinding((LinearLayout) rootView, dotsIndicator, recyclerView, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
