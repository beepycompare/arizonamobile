package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudGroupItemBinding implements ViewBinding {
    public final TextView def;
    public final LinearLayout defContainer;
    public final TextView hp;
    public final LinearLayout hpContainer;
    public final ImageView itemImage;
    public final TextView name;
    public final LinearLayout neighborGameTaskScreen;
    private final LinearLayout rootView;

    private HudGroupItemBinding(LinearLayout rootView, TextView def, LinearLayout defContainer, TextView hp, LinearLayout hpContainer, ImageView itemImage, TextView name, LinearLayout neighborGameTaskScreen) {
        this.rootView = rootView;
        this.def = def;
        this.defContainer = defContainer;
        this.hp = hp;
        this.hpContainer = hpContainer;
        this.itemImage = itemImage;
        this.name = name;
        this.neighborGameTaskScreen = neighborGameTaskScreen;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudGroupItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudGroupItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_group_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudGroupItemBinding bind(View rootView) {
        int i = R.id.def;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.def_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.hp;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.hp_container;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null) {
                        i = R.id.item_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.name;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                LinearLayout linearLayout3 = (LinearLayout) rootView;
                                return new HudGroupItemBinding(linearLayout3, textView, linearLayout, textView2, linearLayout2, imageView, textView3, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
