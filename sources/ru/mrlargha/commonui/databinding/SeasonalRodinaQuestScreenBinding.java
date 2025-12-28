package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class SeasonalRodinaQuestScreenBinding implements ViewBinding {
    public final Guideline bottomLine;
    public final ImageView btnBack;
    public final ImageView btnExit;
    public final Guideline centerLine;
    public final LinearLayout cvUserName;
    public final ImageView ivGetQuest;
    public final Guideline leftLine;
    public final ConstraintLayout parentLayout;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final RecyclerView rvQuestActivity;
    public final RecyclerView rvQuestStages;
    public final RecyclerView rvQuestTasks;
    public final Guideline topLine;
    public final TextView tvGetQuest;
    public final TextView tvTitle;
    public final TextView tvTitleQuestStages;
    public final TextView tvTitleQuestTasks;
    public final TextView tvUserName;

    private SeasonalRodinaQuestScreenBinding(ConstraintLayout rootView, Guideline bottomLine, ImageView btnBack, ImageView btnExit, Guideline centerLine, LinearLayout cvUserName, ImageView ivGetQuest, Guideline leftLine, ConstraintLayout parentLayout, Guideline rightLine, RecyclerView rvQuestActivity, RecyclerView rvQuestStages, RecyclerView rvQuestTasks, Guideline topLine, TextView tvGetQuest, TextView tvTitle, TextView tvTitleQuestStages, TextView tvTitleQuestTasks, TextView tvUserName) {
        this.rootView = rootView;
        this.bottomLine = bottomLine;
        this.btnBack = btnBack;
        this.btnExit = btnExit;
        this.centerLine = centerLine;
        this.cvUserName = cvUserName;
        this.ivGetQuest = ivGetQuest;
        this.leftLine = leftLine;
        this.parentLayout = parentLayout;
        this.rightLine = rightLine;
        this.rvQuestActivity = rvQuestActivity;
        this.rvQuestStages = rvQuestStages;
        this.rvQuestTasks = rvQuestTasks;
        this.topLine = topLine;
        this.tvGetQuest = tvGetQuest;
        this.tvTitle = tvTitle;
        this.tvTitleQuestStages = tvTitleQuestStages;
        this.tvTitleQuestTasks = tvTitleQuestTasks;
        this.tvUserName = tvUserName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SeasonalRodinaQuestScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SeasonalRodinaQuestScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.seasonal_rodina_quest_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SeasonalRodinaQuestScreenBinding bind(View rootView) {
        int i = R.id.bottom_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.btnBack;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.btnExit;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.center_line;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline2 != null) {
                        i = R.id.cvUserName;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.ivGetQuest;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView3 != null) {
                                i = R.id.left_line;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline3 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                    i = R.id.right_line;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline4 != null) {
                                        i = R.id.rvQuestActivity;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.rvQuestStages;
                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView2 != null) {
                                                i = R.id.rvQuestTasks;
                                                RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                if (recyclerView3 != null) {
                                                    i = R.id.top_line;
                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline5 != null) {
                                                        i = R.id.tvGetQuest;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView != null) {
                                                            i = R.id.tvTitle;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tvTitleQuestStages;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tvTitleQuestTasks;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tvUserName;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView5 != null) {
                                                                            return new SeasonalRodinaQuestScreenBinding(constraintLayout, guideline, imageView, imageView2, guideline2, linearLayout, imageView3, guideline3, constraintLayout, guideline4, recyclerView, recyclerView2, recyclerView3, guideline5, textView, textView2, textView3, textView4, textView5);
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
