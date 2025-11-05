package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemTaskRewardBinding implements ViewBinding {
    public final ShapeableImageView ivReward;
    private final ConstraintLayout rootView;
    public final MaterialTextView tvRewardDesc;

    private ItemTaskRewardBinding(ConstraintLayout rootView, ShapeableImageView ivReward, MaterialTextView tvRewardDesc) {
        this.rootView = rootView;
        this.ivReward = ivReward;
        this.tvRewardDesc = tvRewardDesc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTaskRewardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTaskRewardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_task_reward, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTaskRewardBinding bind(View rootView) {
        int i = R.id.ivReward;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, i);
        if (shapeableImageView != null) {
            i = R.id.tvRewardDesc;
            MaterialTextView materialTextView = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
            if (materialTextView != null) {
                return new ItemTaskRewardBinding((ConstraintLayout) rootView, shapeableImageView, materialTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
