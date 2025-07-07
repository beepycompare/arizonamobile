package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.AvatarView;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerItemContactBinding implements ViewBinding {
    public final LinearLayout actionsContainer;
    public final AppCompatImageView addOrRemoveUserBtn;
    public final AvatarView avatar;
    public final AppCompatTextView contactName;
    public final AppCompatImageView icAttach;
    public final AppCompatImageView icNotificationOff;
    public final View itemDivider;
    public final AppCompatTextView lastTimeMessage;
    public final CardView messageStatus;
    public final AppCompatTextView messageText;
    private final LinearLayout rootView;
    public final AppCompatImageView sendMessageBtn;
    public final LinearLayout statusContainer;

    private MobilePhoneMessengerItemContactBinding(LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatImageView appCompatImageView, AvatarView avatarView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, View view, AppCompatTextView appCompatTextView2, CardView cardView, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.actionsContainer = linearLayout2;
        this.addOrRemoveUserBtn = appCompatImageView;
        this.avatar = avatarView;
        this.contactName = appCompatTextView;
        this.icAttach = appCompatImageView2;
        this.icNotificationOff = appCompatImageView3;
        this.itemDivider = view;
        this.lastTimeMessage = appCompatTextView2;
        this.messageStatus = cardView;
        this.messageText = appCompatTextView3;
        this.sendMessageBtn = appCompatImageView4;
        this.statusContainer = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneMessengerItemContactBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneMessengerItemContactBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_messenger_item_contact, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneMessengerItemContactBinding bind(View view) {
        View findChildViewById;
        int i = R.id.actions_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.add_or_remove_user_btn;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.avatar;
                AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
                if (avatarView != null) {
                    i = R.id.contact_name;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView != null) {
                        i = R.id.ic_attach;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.ic_notification_off;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.item_divider))) != null) {
                                i = R.id.last_time_message;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                if (appCompatTextView2 != null) {
                                    i = R.id.message_status;
                                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                    if (cardView != null) {
                                        i = R.id.message_text;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatTextView3 != null) {
                                            i = R.id.send_message_btn;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatImageView4 != null) {
                                                i = R.id.status_container;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout2 != null) {
                                                    return new MobilePhoneMessengerItemContactBinding((LinearLayout) view, linearLayout, appCompatImageView, avatarView, appCompatTextView, appCompatImageView2, appCompatImageView3, findChildViewById, appCompatTextView2, cardView, appCompatTextView3, appCompatImageView4, linearLayout2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
