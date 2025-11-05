package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudLeftMenuBinding implements ViewBinding {
    public final ImageView btnOpenBattlePass;
    public final ImageView btnOpenQuest;
    public final ImageView btnOpenRadialMenu;
    private final LinearLayout rootView;

    private HudLeftMenuBinding(LinearLayout rootView, ImageView btnOpenBattlePass, ImageView btnOpenQuest, ImageView btnOpenRadialMenu) {
        this.rootView = rootView;
        this.btnOpenBattlePass = btnOpenBattlePass;
        this.btnOpenQuest = btnOpenQuest;
        this.btnOpenRadialMenu = btnOpenRadialMenu;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudLeftMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudLeftMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_left_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudLeftMenuBinding bind(View rootView) {
        int i = R.id.btn_open_battle_pass;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btn_open_quest;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.btn_open_radial_menu;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    return new HudLeftMenuBinding((LinearLayout) rootView, imageView, imageView2, imageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
