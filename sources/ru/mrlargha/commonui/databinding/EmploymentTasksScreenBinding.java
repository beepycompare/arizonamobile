package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EmploymentTasksScreenBinding implements ViewBinding {
    public final AppCompatButton btnClose;
    public final AppCompatButton btnHistory;
    public final AppCompatButton btnMenu;
    public final AppCompatButton btnStats;
    public final AppCompatButton btnUpdate;
    public final Guideline guidelineHor;
    public final Guideline guidelineVer;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer3;
    public final Guideline guidelineVer4;
    public final Guideline guidelineVer5;
    public final LayoutEmploymentInfoBinding itemTaskInfo;
    public final ItemEmploymentTopTableBinding itemTopTable;
    public final ShapeableImageView ivNoFraction;
    public final LinearLayout linearTaskStatus;
    public final ConstraintLayout parentLayout;
    public final ProgressBar progressBarAllTasks;
    private final ConstraintLayout rootView;
    public final RecyclerView rvEmploymentHistory;
    public final RecyclerView rvEmploymentTasks;
    public final TextView tvFractionName;
    public final TextView tvInfo;
    public final MaterialTextView tvNoFraction;
    public final TextView tvTasksDone;
    public final TextView tvTasksRemain;
    public final TextView tvTitle;
    public final TextView tvTitleRankName;
    public final TextView tvTitleTable;

    private EmploymentTasksScreenBinding(ConstraintLayout rootView, AppCompatButton btnClose, AppCompatButton btnHistory, AppCompatButton btnMenu, AppCompatButton btnStats, AppCompatButton btnUpdate, Guideline guidelineHor, Guideline guidelineVer, Guideline guidelineVer1, Guideline guidelineVer2, Guideline guidelineVer3, Guideline guidelineVer4, Guideline guidelineVer5, LayoutEmploymentInfoBinding itemTaskInfo, ItemEmploymentTopTableBinding itemTopTable, ShapeableImageView ivNoFraction, LinearLayout linearTaskStatus, ConstraintLayout parentLayout, ProgressBar progressBarAllTasks, RecyclerView rvEmploymentHistory, RecyclerView rvEmploymentTasks, TextView tvFractionName, TextView tvInfo, MaterialTextView tvNoFraction, TextView tvTasksDone, TextView tvTasksRemain, TextView tvTitle, TextView tvTitleRankName, TextView tvTitleTable) {
        this.rootView = rootView;
        this.btnClose = btnClose;
        this.btnHistory = btnHistory;
        this.btnMenu = btnMenu;
        this.btnStats = btnStats;
        this.btnUpdate = btnUpdate;
        this.guidelineHor = guidelineHor;
        this.guidelineVer = guidelineVer;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer3 = guidelineVer3;
        this.guidelineVer4 = guidelineVer4;
        this.guidelineVer5 = guidelineVer5;
        this.itemTaskInfo = itemTaskInfo;
        this.itemTopTable = itemTopTable;
        this.ivNoFraction = ivNoFraction;
        this.linearTaskStatus = linearTaskStatus;
        this.parentLayout = parentLayout;
        this.progressBarAllTasks = progressBarAllTasks;
        this.rvEmploymentHistory = rvEmploymentHistory;
        this.rvEmploymentTasks = rvEmploymentTasks;
        this.tvFractionName = tvFractionName;
        this.tvInfo = tvInfo;
        this.tvNoFraction = tvNoFraction;
        this.tvTasksDone = tvTasksDone;
        this.tvTasksRemain = tvTasksRemain;
        this.tvTitle = tvTitle;
        this.tvTitleRankName = tvTitleRankName;
        this.tvTitleTable = tvTitleTable;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EmploymentTasksScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EmploymentTasksScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.employment_tasks_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentTasksScreenBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btnClose;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
        if (appCompatButton != null) {
            i = R.id.btnHistory;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
            if (appCompatButton2 != null) {
                i = R.id.btnMenu;
                AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                if (appCompatButton3 != null) {
                    i = R.id.btnStats;
                    AppCompatButton appCompatButton4 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatButton4 != null) {
                        i = R.id.btnUpdate;
                        AppCompatButton appCompatButton5 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatButton5 != null) {
                            i = R.id.guidelineHor;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline != null) {
                                i = R.id.guidelineVer;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline2 != null) {
                                    i = R.id.guidelineVer1;
                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline3 != null) {
                                        i = R.id.guidelineVer2;
                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline4 != null) {
                                            i = R.id.guidelineVer3;
                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline5 != null) {
                                                i = R.id.guidelineVer4;
                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline6 != null) {
                                                    i = R.id.guidelineVer5;
                                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline7 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.itemTaskInfo))) != null) {
                                                        LayoutEmploymentInfoBinding bind = LayoutEmploymentInfoBinding.bind(findChildViewById);
                                                        i = R.id.itemTopTable;
                                                        View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
                                                        if (findChildViewById2 != null) {
                                                            ItemEmploymentTopTableBinding bind2 = ItemEmploymentTopTableBinding.bind(findChildViewById2);
                                                            i = R.id.ivNoFraction;
                                                            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (shapeableImageView != null) {
                                                                i = R.id.linearTaskStatus;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                    i = R.id.progressBarAllTasks;
                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                    if (progressBar != null) {
                                                                        i = R.id.rvEmploymentHistory;
                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (recyclerView != null) {
                                                                            i = R.id.rvEmploymentTasks;
                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (recyclerView2 != null) {
                                                                                i = R.id.tvFractionName;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView != null) {
                                                                                    i = R.id.tvInfo;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tvNoFraction;
                                                                                        MaterialTextView materialTextView = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (materialTextView != null) {
                                                                                            i = R.id.tvTasksDone;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tvTasksRemain;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.tvTitle;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = R.id.tvTitleRankName;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (textView6 != null) {
                                                                                                            i = R.id.tvTitleTable;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (textView7 != null) {
                                                                                                                return new EmploymentTasksScreenBinding(constraintLayout, appCompatButton, appCompatButton2, appCompatButton3, appCompatButton4, appCompatButton5, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, bind, bind2, shapeableImageView, linearLayout, constraintLayout, progressBar, recyclerView, recyclerView2, textView, textView2, materialTextView, textView3, textView4, textView5, textView6, textView7);
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
