package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class SpawnerItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout spawnItem;
    public final AppCompatImageView spawnItemArrow;
    public final AppCompatImageView spawnItemIcon;
    public final TextView spawnItemTitle;

    private SpawnerItemBinding(ConstraintLayout rootView, ConstraintLayout spawnItem, AppCompatImageView spawnItemArrow, AppCompatImageView spawnItemIcon, TextView spawnItemTitle) {
        this.rootView = rootView;
        this.spawnItem = spawnItem;
        this.spawnItemArrow = spawnItemArrow;
        this.spawnItemIcon = spawnItemIcon;
        this.spawnItemTitle = spawnItemTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpawnerItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpawnerItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.spawner_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpawnerItemBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.spawn_item_arrow;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.spawn_item_icon;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView2 != null) {
                i = R.id.spawn_item_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new SpawnerItemBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatImageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
