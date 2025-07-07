package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemQuestStageBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvDone;
    public final TextView tvProgress;
    public final TextView tvStage;
    public final TextView tvStageCount;
    public final TextView tvStageDesc;

    private ItemQuestStageBinding(ConstraintLayout rootView, TextView tvDone, TextView tvProgress, TextView tvStage, TextView tvStageCount, TextView tvStageDesc) {
        this.rootView = rootView;
        this.tvDone = tvDone;
        this.tvProgress = tvProgress;
        this.tvStage = tvStage;
        this.tvStageCount = tvStageCount;
        this.tvStageDesc = tvStageDesc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemQuestStageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemQuestStageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_quest_stage, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemQuestStageBinding bind(View rootView) {
        int i = R.id.tvDone;
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
                        i = R.id.tvStageDesc;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new ItemQuestStageBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
