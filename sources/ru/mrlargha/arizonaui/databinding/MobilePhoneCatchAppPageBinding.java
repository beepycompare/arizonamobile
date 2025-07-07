package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneCatchAppPageBinding implements ViewBinding {
    public final ImageView backButton;
    public final TextView bizCount;
    public final ImageView bizIc;
    public final ConstraintLayout catchButton;
    public final TextView catchText;
    public final ImageView clockIc;
    public final TextView endOfSeasonTitle;
    public final TextView homeCount;
    public final ImageView homeIc;
    public final ImageView infoButton;
    public final TextView leftTime;
    public final ImageView locationIc;
    public final ConstraintLayout mpCatchAppPage;
    public final ConstraintLayout permissionButton;
    public final TextView permissionButtonText;
    private final ConstraintLayout rootView;
    public final TextView seasonName;
    public final TextView seasonTitle;
    public final TextView statTitle;
    public final CardView statisticCard;
    public final ConstraintLayout timerContainer;

    private MobilePhoneCatchAppPageBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView2, ImageView imageView3, TextView textView3, TextView textView4, ImageView imageView4, ImageView imageView5, TextView textView5, ImageView imageView6, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView6, TextView textView7, TextView textView8, TextView textView9, CardView cardView, ConstraintLayout constraintLayout5) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.bizCount = textView;
        this.bizIc = imageView2;
        this.catchButton = constraintLayout2;
        this.catchText = textView2;
        this.clockIc = imageView3;
        this.endOfSeasonTitle = textView3;
        this.homeCount = textView4;
        this.homeIc = imageView4;
        this.infoButton = imageView5;
        this.leftTime = textView5;
        this.locationIc = imageView6;
        this.mpCatchAppPage = constraintLayout3;
        this.permissionButton = constraintLayout4;
        this.permissionButtonText = textView6;
        this.seasonName = textView7;
        this.seasonTitle = textView8;
        this.statTitle = textView9;
        this.statisticCard = cardView;
        this.timerContainer = constraintLayout5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneCatchAppPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneCatchAppPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_catch_app_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneCatchAppPageBinding bind(View view) {
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.biz_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.biz_ic;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.catch_button;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.catch_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.clock_ic;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.end_of_season_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.home_count;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.home_ic;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = R.id.info_button;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = R.id.left_time;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.location_ic;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView6 != null) {
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                                        i = R.id.permission_button;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout3 != null) {
                                                            i = R.id.permission_button_text;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.season_name;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.season_title;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.stat_title;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.statistic_card;
                                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                                                            if (cardView != null) {
                                                                                i = R.id.timer_container;
                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout4 != null) {
                                                                                    return new MobilePhoneCatchAppPageBinding(constraintLayout2, imageView, textView, imageView2, constraintLayout, textView2, imageView3, textView3, textView4, imageView4, imageView5, textView5, imageView6, constraintLayout2, constraintLayout3, textView6, textView7, textView8, textView9, cardView, constraintLayout4);
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
