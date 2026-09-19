package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudRodinaTrainInstructionBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final CustomCardView trainInstructionCard;
    public final TextView trainInstructionDescription;
    public final ImageView trainInstructionIcon;
    public final TextView trainInstructionTitle;

    private HudRodinaTrainInstructionBinding(FrameLayout rootView, CustomCardView trainInstructionCard, TextView trainInstructionDescription, ImageView trainInstructionIcon, TextView trainInstructionTitle) {
        this.rootView = rootView;
        this.trainInstructionCard = trainInstructionCard;
        this.trainInstructionDescription = trainInstructionDescription;
        this.trainInstructionIcon = trainInstructionIcon;
        this.trainInstructionTitle = trainInstructionTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudRodinaTrainInstructionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudRodinaTrainInstructionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_rodina_train_instruction, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudRodinaTrainInstructionBinding bind(View rootView) {
        int i = R.id.train_instruction_card;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.train_instruction_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.train_instruction_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.train_instruction_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new HudRodinaTrainInstructionBinding((FrameLayout) rootView, customCardView, textView, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
