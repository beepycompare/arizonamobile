package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudArizonaTrainJobBinding implements ViewBinding {
    public final ImageView endPointIc;
    public final TextView income;
    public final ImageView incomeIc;
    public final Guideline incomeIcLeftLine;
    public final TextView maxKm;
    private final ConstraintLayout rootView;
    public final ConstraintLayout routeContainer;
    public final LottieAnimationView routeProgress;
    public final Guideline routeTopLine;
    public final TextView speedLimit;
    public final ImageView startPointIc;
    public final ImageView timerIc;
    public final Guideline timerIcLeftLine;
    public final TextView trainCurrentTime;
    public final ConstraintLayout trainDriverContainer;
    public final ConstraintLayout trainInfoContainer;
    public final Guideline trainInfoTopLine;
    public final TextView trainMaxTime;
    public final ImageView warningIc;
    public final TextView warningsCount;
    public final TextView warningsCountTitle;

    private HudArizonaTrainJobBinding(ConstraintLayout rootView, ImageView endPointIc, TextView income, ImageView incomeIc, Guideline incomeIcLeftLine, TextView maxKm, ConstraintLayout routeContainer, LottieAnimationView routeProgress, Guideline routeTopLine, TextView speedLimit, ImageView startPointIc, ImageView timerIc, Guideline timerIcLeftLine, TextView trainCurrentTime, ConstraintLayout trainDriverContainer, ConstraintLayout trainInfoContainer, Guideline trainInfoTopLine, TextView trainMaxTime, ImageView warningIc, TextView warningsCount, TextView warningsCountTitle) {
        this.rootView = rootView;
        this.endPointIc = endPointIc;
        this.income = income;
        this.incomeIc = incomeIc;
        this.incomeIcLeftLine = incomeIcLeftLine;
        this.maxKm = maxKm;
        this.routeContainer = routeContainer;
        this.routeProgress = routeProgress;
        this.routeTopLine = routeTopLine;
        this.speedLimit = speedLimit;
        this.startPointIc = startPointIc;
        this.timerIc = timerIc;
        this.timerIcLeftLine = timerIcLeftLine;
        this.trainCurrentTime = trainCurrentTime;
        this.trainDriverContainer = trainDriverContainer;
        this.trainInfoContainer = trainInfoContainer;
        this.trainInfoTopLine = trainInfoTopLine;
        this.trainMaxTime = trainMaxTime;
        this.warningIc = warningIc;
        this.warningsCount = warningsCount;
        this.warningsCountTitle = warningsCountTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HudArizonaTrainJobBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudArizonaTrainJobBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_arizona_train_job, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudArizonaTrainJobBinding bind(View rootView) {
        int i = R.id.end_point_ic;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.income;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.income_ic;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.income_ic_left_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline != null) {
                        i = R.id.max_km;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.route_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout != null) {
                                i = R.id.route_progress;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                                if (lottieAnimationView != null) {
                                    i = R.id.route_top_line;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline2 != null) {
                                        i = R.id.speed_limit;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            i = R.id.start_point_ic;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView3 != null) {
                                                i = R.id.timer_ic;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView4 != null) {
                                                    i = R.id.timer_ic_left_line;
                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline3 != null) {
                                                        i = R.id.train_current_time;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView4 != null) {
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                                                            i = R.id.train_info_container;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.train_info_top_line;
                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline4 != null) {
                                                                    i = R.id.train_max_time;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.warning_ic;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.warnings_count;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.warnings_count_title;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView7 != null) {
                                                                                    return new HudArizonaTrainJobBinding(constraintLayout2, imageView, textView, imageView2, guideline, textView2, constraintLayout, lottieAnimationView, guideline2, textView3, imageView3, imageView4, guideline3, textView4, constraintLayout2, constraintLayout3, guideline4, textView5, imageView5, textView6, textView7);
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
