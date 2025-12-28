package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudImprovingSkillsBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final FrameLayout skillToContainer;
    public final FrameLayout skillsFromContainer;
    public final TextView tvDescription;
    public final TextView tvHaveExp;
    public final TextView tvNeedExp;
    public final TextView tvSkillsFrom;
    public final TextView tvSkillsTo;
    public final TextView tvTitle;

    private HudImprovingSkillsBinding(LinearLayout rootView, ProgressBar progressBar, FrameLayout skillToContainer, FrameLayout skillsFromContainer, TextView tvDescription, TextView tvHaveExp, TextView tvNeedExp, TextView tvSkillsFrom, TextView tvSkillsTo, TextView tvTitle) {
        this.rootView = rootView;
        this.progressBar = progressBar;
        this.skillToContainer = skillToContainer;
        this.skillsFromContainer = skillsFromContainer;
        this.tvDescription = tvDescription;
        this.tvHaveExp = tvHaveExp;
        this.tvNeedExp = tvNeedExp;
        this.tvSkillsFrom = tvSkillsFrom;
        this.tvSkillsTo = tvSkillsTo;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudImprovingSkillsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudImprovingSkillsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_improving_skills, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudImprovingSkillsBinding bind(View rootView) {
        int i = R.id.progressBar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
        if (progressBar != null) {
            i = R.id.skill_to_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout != null) {
                i = R.id.skills_from_container;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                if (frameLayout2 != null) {
                    i = R.id.tv_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tv_have_exp;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.tv_need_exp;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.tv_skills_from;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.tv_skills_to;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.tv_title;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            return new HudImprovingSkillsBinding((LinearLayout) rootView, progressBar, frameLayout, frameLayout2, textView, textView2, textView3, textView4, textView5, textView6);
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
