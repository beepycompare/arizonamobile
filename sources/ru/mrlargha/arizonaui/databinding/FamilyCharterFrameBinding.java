package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyCharterFrameBinding implements ViewBinding {
    public final TextView activeDay;
    public final TextView activeMonth;
    public final TextView activeWeek;
    public final CardView buttonClose;
    public final CardView card1;
    public final LinearLayout containerBalance;
    public final LinearLayout containerCoins;
    public final TextView days;
    public final TextView memberName;
    public final TextView memberRole;
    public final ImageView onlineImage;
    public final TextView rank;
    private final LinearLayout rootView;
    public final TextView times;

    private FamilyCharterFrameBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, CardView cardView, CardView cardView2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.activeDay = textView;
        this.activeMonth = textView2;
        this.activeWeek = textView3;
        this.buttonClose = cardView;
        this.card1 = cardView2;
        this.containerBalance = linearLayout2;
        this.containerCoins = linearLayout3;
        this.days = textView4;
        this.memberName = textView5;
        this.memberRole = textView6;
        this.onlineImage = imageView;
        this.rank = textView7;
        this.times = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilyCharterFrameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyCharterFrameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_charter_frame, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyCharterFrameBinding bind(View view) {
        int i = R.id.active_day;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.active_month;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.active_week;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.button_close;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView != null) {
                        i = R.id.card1;
                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                        if (cardView2 != null) {
                            i = R.id.container_balance;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.container_coins;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.days;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.member_name;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.member_role;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.online_image;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = R.id.rank;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.times;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            return new FamilyCharterFrameBinding((LinearLayout) view, textView, textView2, textView3, cardView, cardView2, linearLayout, linearLayout2, textView4, textView5, textView6, imageView, textView7, textView8);
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
