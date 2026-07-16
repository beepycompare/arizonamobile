package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudNoticeWarningBinding implements ViewBinding {
    public final TextView noticeWarningDescription;
    public final TextView noticeWarningTitle;
    public final TextView noticeWarningValue;
    private final FrameLayout rootView;

    private HudNoticeWarningBinding(FrameLayout rootView, TextView noticeWarningDescription, TextView noticeWarningTitle, TextView noticeWarningValue) {
        this.rootView = rootView;
        this.noticeWarningDescription = noticeWarningDescription;
        this.noticeWarningTitle = noticeWarningTitle;
        this.noticeWarningValue = noticeWarningValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudNoticeWarningBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudNoticeWarningBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_notice_warning, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudNoticeWarningBinding bind(View rootView) {
        int i = R.id.notice_warning_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.notice_warning_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.notice_warning_value;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new HudNoticeWarningBinding((FrameLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
