package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textview.MaterialTextView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemQuestTaskBinding implements ViewBinding {
    public final Button btnShowClue;
    public final ConstraintLayout expandedLayout;
    public final Guideline guidelineVer;
    public final ImageView ivTaskShow;
    public final LinearLayout layoutProgressCount;
    public final ConstraintLayout parentItem;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvQuestRewards;
    public final TextView tvDone;
    public final TextView tvProgress;
    public final TextView tvStage;
    public final TextView tvStageCount;
    public final MaterialTextView tvTaskDescription;
    public final MaterialTextView tvTaskReward;

    private ItemQuestTaskBinding(ConstraintLayout rootView, Button btnShowClue, ConstraintLayout expandedLayout, Guideline guidelineVer, ImageView ivTaskShow, LinearLayout layoutProgressCount, ConstraintLayout parentItem, ConstraintLayout parentLayout, RecyclerView rvQuestRewards, TextView tvDone, TextView tvProgress, TextView tvStage, TextView tvStageCount, MaterialTextView tvTaskDescription, MaterialTextView tvTaskReward) {
        this.rootView = rootView;
        this.btnShowClue = btnShowClue;
        this.expandedLayout = expandedLayout;
        this.guidelineVer = guidelineVer;
        this.ivTaskShow = ivTaskShow;
        this.layoutProgressCount = layoutProgressCount;
        this.parentItem = parentItem;
        this.parentLayout = parentLayout;
        this.rvQuestRewards = rvQuestRewards;
        this.tvDone = tvDone;
        this.tvProgress = tvProgress;
        this.tvStage = tvStage;
        this.tvStageCount = tvStageCount;
        this.tvTaskDescription = tvTaskDescription;
        this.tvTaskReward = tvTaskReward;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemQuestTaskBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemQuestTaskBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_quest_task, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemQuestTaskBinding bind(View rootView) {
        int i = R.id.btnShowClue;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.expandedLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout != null) {
                i = R.id.guidelineVer;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline != null) {
                    i = R.id.ivTaskShow;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView != null) {
                        i = R.id.layoutProgressCount;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.parentItem;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout2 != null) {
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                                i = R.id.rvQuestRewards;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.tvDone;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.tvProgress;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView2 != null) {
                                            i = R.id.tvStage;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                i = R.id.tvStageCount;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    i = R.id.tvTaskDescription;
                                                    MaterialTextView materialTextView = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (materialTextView != null) {
                                                        i = R.id.tvTaskReward;
                                                        MaterialTextView materialTextView2 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (materialTextView2 != null) {
                                                            return new ItemQuestTaskBinding(constraintLayout3, button, constraintLayout, guideline, imageView, linearLayout, constraintLayout2, constraintLayout3, recyclerView, textView, textView2, textView3, textView4, materialTextView, materialTextView2);
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
