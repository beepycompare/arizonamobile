package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class FragmentServersListTabBinding implements ViewBinding {
    public final ImageView imageView16;
    public final RecyclerView list;
    public final ImageView projectBigLogo;
    public final TextView projectName;
    private final ConstraintLayout rootView;

    private FragmentServersListTabBinding(ConstraintLayout rootView, ImageView imageView16, RecyclerView list, ImageView projectBigLogo, TextView projectName) {
        this.rootView = rootView;
        this.imageView16 = imageView16;
        this.list = list;
        this.projectBigLogo = projectBigLogo;
        this.projectName = projectName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentServersListTabBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentServersListTabBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_servers_list_tab, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentServersListTabBinding bind(View rootView) {
        int i = R.id.imageView16;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                i = R.id.project_big_logo;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.project_name;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        return new FragmentServersListTabBinding((ConstraintLayout) rootView, imageView, recyclerView, imageView2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
