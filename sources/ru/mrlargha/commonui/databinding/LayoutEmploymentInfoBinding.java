package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutEmploymentInfoBinding implements ViewBinding {
    public final ConstraintLayout itemBlacklist;
    public final ConstraintLayout itemBonus;
    public final ConstraintLayout itemInfo;
    public final ConstraintLayout itemLevelInfo;
    public final ConstraintLayout itemPension;
    public final ConstraintLayout itemRespect;
    public final ImageView ivEllipse;
    public final ImageView ivEllipseBlacklist;
    public final ImageView ivEllipsePension;
    public final ImageView ivEllipseThunder;
    public final ImageView ivLockItemBonus;
    public final ImageView ivLockItemInfo;
    public final ImageView ivLockItemPension;
    public final ImageView ivLockLevelInfo;
    public final ImageView ivLockRespect;
    public final ConstraintLayout parentLayout;
    public final ProgressBar progressBar;
    public final ProgressBar progressBarThunder;
    public final LinearLayout progressThunderContainer;
    private final ConstraintLayout rootView;
    public final TextView tvCountDescription;
    public final TextView tvDescription;
    public final TextView tvDescriptionBlacklist;
    public final TextView tvHours;
    public final TextView tvHoursDescription;
    public final TextView tvLevel;
    public final TextView tvLevelMax;
    public final TextView tvLevelMaxThunder;
    public final TextView tvLevelThunder;
    public final TextView tvPensionDescription;
    public final TextView tvRespectCount;
    public final TextView tvThunderDescription;
    public final TextView tvTitleItem;
    public final View viewLockedBonus;
    public final View viewLockedItemInfo;
    public final View viewLockedLevelInfo;
    public final View viewLockedPension;
    public final View viewLockedRespect;

    private LayoutEmploymentInfoBinding(ConstraintLayout rootView, ConstraintLayout itemBlacklist, ConstraintLayout itemBonus, ConstraintLayout itemInfo, ConstraintLayout itemLevelInfo, ConstraintLayout itemPension, ConstraintLayout itemRespect, ImageView ivEllipse, ImageView ivEllipseBlacklist, ImageView ivEllipsePension, ImageView ivEllipseThunder, ImageView ivLockItemBonus, ImageView ivLockItemInfo, ImageView ivLockItemPension, ImageView ivLockLevelInfo, ImageView ivLockRespect, ConstraintLayout parentLayout, ProgressBar progressBar, ProgressBar progressBarThunder, LinearLayout progressThunderContainer, TextView tvCountDescription, TextView tvDescription, TextView tvDescriptionBlacklist, TextView tvHours, TextView tvHoursDescription, TextView tvLevel, TextView tvLevelMax, TextView tvLevelMaxThunder, TextView tvLevelThunder, TextView tvPensionDescription, TextView tvRespectCount, TextView tvThunderDescription, TextView tvTitleItem, View viewLockedBonus, View viewLockedItemInfo, View viewLockedLevelInfo, View viewLockedPension, View viewLockedRespect) {
        this.rootView = rootView;
        this.itemBlacklist = itemBlacklist;
        this.itemBonus = itemBonus;
        this.itemInfo = itemInfo;
        this.itemLevelInfo = itemLevelInfo;
        this.itemPension = itemPension;
        this.itemRespect = itemRespect;
        this.ivEllipse = ivEllipse;
        this.ivEllipseBlacklist = ivEllipseBlacklist;
        this.ivEllipsePension = ivEllipsePension;
        this.ivEllipseThunder = ivEllipseThunder;
        this.ivLockItemBonus = ivLockItemBonus;
        this.ivLockItemInfo = ivLockItemInfo;
        this.ivLockItemPension = ivLockItemPension;
        this.ivLockLevelInfo = ivLockLevelInfo;
        this.ivLockRespect = ivLockRespect;
        this.parentLayout = parentLayout;
        this.progressBar = progressBar;
        this.progressBarThunder = progressBarThunder;
        this.progressThunderContainer = progressThunderContainer;
        this.tvCountDescription = tvCountDescription;
        this.tvDescription = tvDescription;
        this.tvDescriptionBlacklist = tvDescriptionBlacklist;
        this.tvHours = tvHours;
        this.tvHoursDescription = tvHoursDescription;
        this.tvLevel = tvLevel;
        this.tvLevelMax = tvLevelMax;
        this.tvLevelMaxThunder = tvLevelMaxThunder;
        this.tvLevelThunder = tvLevelThunder;
        this.tvPensionDescription = tvPensionDescription;
        this.tvRespectCount = tvRespectCount;
        this.tvThunderDescription = tvThunderDescription;
        this.tvTitleItem = tvTitleItem;
        this.viewLockedBonus = viewLockedBonus;
        this.viewLockedItemInfo = viewLockedItemInfo;
        this.viewLockedLevelInfo = viewLockedLevelInfo;
        this.viewLockedPension = viewLockedPension;
        this.viewLockedRespect = viewLockedRespect;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutEmploymentInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutEmploymentInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_employment_info, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutEmploymentInfoBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        int i = R.id.itemBlacklist;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.itemBonus;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout2 != null) {
                i = R.id.itemInfo;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout3 != null) {
                    i = R.id.itemLevelInfo;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout4 != null) {
                        i = R.id.itemPension;
                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout5 != null) {
                            i = R.id.itemRespect;
                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout6 != null) {
                                i = R.id.ivEllipse;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView != null) {
                                    i = R.id.ivEllipseBlacklist;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView2 != null) {
                                        i = R.id.ivEllipsePension;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView3 != null) {
                                            i = R.id.ivEllipseThunder;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView4 != null) {
                                                i = R.id.ivLockItemBonus;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView5 != null) {
                                                    i = R.id.ivLockItemInfo;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView6 != null) {
                                                        i = R.id.ivLockItemPension;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView7 != null) {
                                                            i = R.id.ivLockLevelInfo;
                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView8 != null) {
                                                                i = R.id.ivLockRespect;
                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView9 != null) {
                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) rootView;
                                                                    i = R.id.progressBar;
                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                    if (progressBar != null) {
                                                                        i = R.id.progressBarThunder;
                                                                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                        if (progressBar2 != null) {
                                                                            i = R.id.progressThunderContainer;
                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (linearLayout != null) {
                                                                                i = R.id.tvCountDescription;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView != null) {
                                                                                    i = R.id.tvDescription;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tvDescriptionBlacklist;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tvHours;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tvHoursDescription;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.tvLevel;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.tvLevelMax;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.tvLevelMaxThunder;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.tvLevelThunder;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.tvPensionDescription;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.tvRespectCount;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i = R.id.tvThunderDescription;
                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (textView12 != null) {
                                                                                                                                i = R.id.tvTitleItem;
                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (textView13 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewLockedBonus))) != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.viewLockedItemInfo))) != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.viewLockedLevelInfo))) != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.viewLockedPension))) != null && (findChildViewById5 = ViewBindings.findChildViewById(rootView, (i = R.id.viewLockedRespect))) != null) {
                                                                                                                                    return new LayoutEmploymentInfoBinding(constraintLayout7, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, constraintLayout7, progressBar, progressBar2, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
