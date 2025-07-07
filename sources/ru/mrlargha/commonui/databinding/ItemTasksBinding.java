package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemTasksBinding implements ViewBinding {
    public final Button btnShowClue;
    public final ConstraintLayout expandedLayout;
    public final Guideline guideline1;
    public final Guideline guideline2;
    public final Guideline guideline3;
    public final AppCompatImageView ivItemIcon;
    public final ShapeableImageView ivTaskShow;
    public final ConstraintLayout linearItem;
    public final ConstraintLayout parentLayout;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final RecyclerView rvTaskRewards;
    public final MaterialTextView tvTaskDescription;
    public final MaterialTextView tvTaskInfo;
    public final MaterialTextView tvTaskReward;
    public final MaterialTextView tvTasksDone;
    public final MaterialTextView tvTasksRemain;

    private ItemTasksBinding(ConstraintLayout rootView, Button btnShowClue, ConstraintLayout expandedLayout, Guideline guideline1, Guideline guideline2, Guideline guideline3, AppCompatImageView ivItemIcon, ShapeableImageView ivTaskShow, ConstraintLayout linearItem, ConstraintLayout parentLayout, ProgressBar progressBar, RecyclerView rvTaskRewards, MaterialTextView tvTaskDescription, MaterialTextView tvTaskInfo, MaterialTextView tvTaskReward, MaterialTextView tvTasksDone, MaterialTextView tvTasksRemain) {
        this.rootView = rootView;
        this.btnShowClue = btnShowClue;
        this.expandedLayout = expandedLayout;
        this.guideline1 = guideline1;
        this.guideline2 = guideline2;
        this.guideline3 = guideline3;
        this.ivItemIcon = ivItemIcon;
        this.ivTaskShow = ivTaskShow;
        this.linearItem = linearItem;
        this.parentLayout = parentLayout;
        this.progressBar = progressBar;
        this.rvTaskRewards = rvTaskRewards;
        this.tvTaskDescription = tvTaskDescription;
        this.tvTaskInfo = tvTaskInfo;
        this.tvTaskReward = tvTaskReward;
        this.tvTasksDone = tvTasksDone;
        this.tvTasksRemain = tvTasksRemain;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTasksBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTasksBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_tasks, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTasksBinding bind(View rootView) {
        int i = R.id.btnShowClue;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.expandedLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout != null) {
                i = R.id.guideline1;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline != null) {
                    i = R.id.guideline2;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline2 != null) {
                        i = R.id.guideline3;
                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline3 != null) {
                            i = R.id.ivItemIcon;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatImageView != null) {
                                i = R.id.ivTaskShow;
                                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, i);
                                if (shapeableImageView != null) {
                                    i = R.id.linearItem;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout2 != null) {
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                                        i = R.id.progressBar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                        if (progressBar != null) {
                                            i = R.id.rvTaskRewards;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView != null) {
                                                i = R.id.tvTaskDescription;
                                                MaterialTextView materialTextView = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                if (materialTextView != null) {
                                                    i = R.id.tvTaskInfo;
                                                    MaterialTextView materialTextView2 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (materialTextView2 != null) {
                                                        i = R.id.tvTaskReward;
                                                        MaterialTextView materialTextView3 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (materialTextView3 != null) {
                                                            i = R.id.tvTasksDone;
                                                            MaterialTextView materialTextView4 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (materialTextView4 != null) {
                                                                i = R.id.tvTasksRemain;
                                                                MaterialTextView materialTextView5 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (materialTextView5 != null) {
                                                                    return new ItemTasksBinding(constraintLayout3, button, constraintLayout, guideline, guideline2, guideline3, appCompatImageView, shapeableImageView, constraintLayout2, constraintLayout3, progressBar, recyclerView, materialTextView, materialTextView2, materialTextView3, materialTextView4, materialTextView5);
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
