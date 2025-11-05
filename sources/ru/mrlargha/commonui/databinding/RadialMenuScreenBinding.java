package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RadialMenuScreenBinding implements ViewBinding {
    public final RadialMenuBottomItemsBinding bottomItem;
    public final RadialMenuCenterElementBinding centerElement;
    public final RadialMenuItemBinding leftFirstItem;
    public final LinearLayout leftItemsContainer;
    public final RadialMenuItemBinding leftSecondItem;
    public final RadialMenuItemBinding leftThirdItem;
    public final ConstraintLayout radialMenu;
    public final RadialMenuItemBinding rightFirstItem;
    public final LinearLayout rightItemsContainer;
    public final RadialMenuItemBinding rightSecondItem;
    public final RadialMenuItemBinding rightThirdItem;
    private final ConstraintLayout rootView;
    public final RadialMenuItemBinding topItem;

    private RadialMenuScreenBinding(ConstraintLayout rootView, RadialMenuBottomItemsBinding bottomItem, RadialMenuCenterElementBinding centerElement, RadialMenuItemBinding leftFirstItem, LinearLayout leftItemsContainer, RadialMenuItemBinding leftSecondItem, RadialMenuItemBinding leftThirdItem, ConstraintLayout radialMenu, RadialMenuItemBinding rightFirstItem, LinearLayout rightItemsContainer, RadialMenuItemBinding rightSecondItem, RadialMenuItemBinding rightThirdItem, RadialMenuItemBinding topItem) {
        this.rootView = rootView;
        this.bottomItem = bottomItem;
        this.centerElement = centerElement;
        this.leftFirstItem = leftFirstItem;
        this.leftItemsContainer = leftItemsContainer;
        this.leftSecondItem = leftSecondItem;
        this.leftThirdItem = leftThirdItem;
        this.radialMenu = radialMenu;
        this.rightFirstItem = rightFirstItem;
        this.rightItemsContainer = rightItemsContainer;
        this.rightSecondItem = rightSecondItem;
        this.rightThirdItem = rightThirdItem;
        this.topItem = topItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RadialMenuScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RadialMenuScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.radial_menu_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RadialMenuScreenBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.bottom_item;
        View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById3 != null) {
            RadialMenuBottomItemsBinding bind = RadialMenuBottomItemsBinding.bind(findChildViewById3);
            i = R.id.center_element;
            View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById4 != null) {
                RadialMenuCenterElementBinding bind2 = RadialMenuCenterElementBinding.bind(findChildViewById4);
                i = R.id.left_first_item;
                View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById5 != null) {
                    RadialMenuItemBinding bind3 = RadialMenuItemBinding.bind(findChildViewById5);
                    i = R.id.left_items_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.left_second_item))) != null) {
                        RadialMenuItemBinding bind4 = RadialMenuItemBinding.bind(findChildViewById);
                        i = R.id.left_third_item;
                        View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById6 != null) {
                            RadialMenuItemBinding bind5 = RadialMenuItemBinding.bind(findChildViewById6);
                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                            i = R.id.right_first_item;
                            View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById7 != null) {
                                RadialMenuItemBinding bind6 = RadialMenuItemBinding.bind(findChildViewById7);
                                i = R.id.right_items_container;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.right_second_item))) != null) {
                                    RadialMenuItemBinding bind7 = RadialMenuItemBinding.bind(findChildViewById2);
                                    i = R.id.right_third_item;
                                    View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById8 != null) {
                                        RadialMenuItemBinding bind8 = RadialMenuItemBinding.bind(findChildViewById8);
                                        i = R.id.top_item;
                                        View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                        if (findChildViewById9 != null) {
                                            return new RadialMenuScreenBinding(constraintLayout, bind, bind2, bind3, linearLayout, bind4, bind5, constraintLayout, bind6, linearLayout2, bind7, bind8, RadialMenuItemBinding.bind(findChildViewById9));
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
