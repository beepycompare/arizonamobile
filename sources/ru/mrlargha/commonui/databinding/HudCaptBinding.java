package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudCaptBinding implements ViewBinding {
    public final LinearLayout btnOpenList;
    public final ImageView ivArrow;
    private final LinearLayout rootView;
    public final RecyclerView rvItems;
    public final TextView tvBtnTitle;
    public final TextView tvName;
    public final TextView tvTimer;

    private HudCaptBinding(LinearLayout rootView, LinearLayout btnOpenList, ImageView ivArrow, RecyclerView rvItems, TextView tvBtnTitle, TextView tvName, TextView tvTimer) {
        this.rootView = rootView;
        this.btnOpenList = btnOpenList;
        this.ivArrow = ivArrow;
        this.rvItems = rvItems;
        this.tvBtnTitle = tvBtnTitle;
        this.tvName = tvName;
        this.tvTimer = tvTimer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudCaptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCaptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_capt, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCaptBinding bind(View rootView) {
        int i = R.id.btn_openList;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.iv_arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.rv_items;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    i = R.id.tv_btn_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tv_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.tv_timer;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                return new HudCaptBinding((LinearLayout) rootView, linearLayout, imageView, recyclerView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
