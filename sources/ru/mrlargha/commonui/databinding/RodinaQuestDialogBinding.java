package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaQuestDialogBinding implements ViewBinding {
    public final Guideline guideline28;
    public final Guideline guidelineEnd;
    public final Guideline guidelineStart;
    public final AppCompatImageView imageView26;
    public final LinearLayout linearLayout;
    public final RecyclerView rodinaQuestDialogRecycler;
    public final ConstraintLayout rodinaQuestDialogRoot;
    public final TextView rodinaQuestNpcName;
    public final TextView rodinaQuestNpcText;
    public final TextView rodinaQuestTitle;
    private final ConstraintLayout rootView;

    private RodinaQuestDialogBinding(ConstraintLayout rootView, Guideline guideline28, Guideline guidelineEnd, Guideline guidelineStart, AppCompatImageView imageView26, LinearLayout linearLayout, RecyclerView rodinaQuestDialogRecycler, ConstraintLayout rodinaQuestDialogRoot, TextView rodinaQuestNpcName, TextView rodinaQuestNpcText, TextView rodinaQuestTitle) {
        this.rootView = rootView;
        this.guideline28 = guideline28;
        this.guidelineEnd = guidelineEnd;
        this.guidelineStart = guidelineStart;
        this.imageView26 = imageView26;
        this.linearLayout = linearLayout;
        this.rodinaQuestDialogRecycler = rodinaQuestDialogRecycler;
        this.rodinaQuestDialogRoot = rodinaQuestDialogRoot;
        this.rodinaQuestNpcName = rodinaQuestNpcName;
        this.rodinaQuestNpcText = rodinaQuestNpcText;
        this.rodinaQuestTitle = rodinaQuestTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RodinaQuestDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaQuestDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_quest_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaQuestDialogBinding bind(View rootView) {
        int i = R.id.guideline28;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.guideline_end;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.guideline_start;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.imageView26;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.linearLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.rodina_quest_dialog_recycler;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                            if (recyclerView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                i = R.id.rodina_quest_npc_name;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    i = R.id.rodina_quest_npc_text;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        i = R.id.rodina_quest_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            return new RodinaQuestDialogBinding(constraintLayout, guideline, guideline2, guideline3, appCompatImageView, linearLayout, recyclerView, constraintLayout, textView, textView2, textView3);
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
