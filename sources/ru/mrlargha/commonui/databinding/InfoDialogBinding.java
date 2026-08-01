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
public final class InfoDialogBinding implements ViewBinding {
    public final ImageView btnCancel;
    public final DialogButtonsBinding buttons;
    public final TextView caption;
    public final FrameLayout infoDialogLayout;
    public final CustomCardView infoDialogListItemTabPrimary;
    public final TextView infoDialogListItemTabPrimaryText;
    public final CustomCardView infoDialogListItemTabSecondary;
    public final TextView infoDialogListItemTabSecondaryText;
    public final CustomCardView infoDialogListItemTabs;
    public final TextView infoText;
    private final FrameLayout rootView;

    private InfoDialogBinding(FrameLayout rootView, ImageView btnCancel, DialogButtonsBinding buttons, TextView caption, FrameLayout infoDialogLayout, CustomCardView infoDialogListItemTabPrimary, TextView infoDialogListItemTabPrimaryText, CustomCardView infoDialogListItemTabSecondary, TextView infoDialogListItemTabSecondaryText, CustomCardView infoDialogListItemTabs, TextView infoText) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.buttons = buttons;
        this.caption = caption;
        this.infoDialogLayout = infoDialogLayout;
        this.infoDialogListItemTabPrimary = infoDialogListItemTabPrimary;
        this.infoDialogListItemTabPrimaryText = infoDialogListItemTabPrimaryText;
        this.infoDialogListItemTabSecondary = infoDialogListItemTabSecondary;
        this.infoDialogListItemTabSecondaryText = infoDialogListItemTabSecondaryText;
        this.infoDialogListItemTabs = infoDialogListItemTabs;
        this.infoText = infoText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static InfoDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InfoDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.info_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InfoDialogBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btn_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.buttons))) != null) {
            DialogButtonsBinding bind = DialogButtonsBinding.bind(findChildViewById);
            i = R.id.caption;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.info_dialog_list_item_tab_primary;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView != null) {
                    i = R.id.info_dialog_list_item_tab_primary_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.info_dialog_list_item_tab_secondary;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView2 != null) {
                            i = R.id.info_dialog_list_item_tab_secondary_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.info_dialog_list_item_tabs;
                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                if (customCardView3 != null) {
                                    i = R.id.infoText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        return new InfoDialogBinding(frameLayout, imageView, bind, textView, frameLayout, customCardView, textView2, customCardView2, textView3, customCardView3, textView4);
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
