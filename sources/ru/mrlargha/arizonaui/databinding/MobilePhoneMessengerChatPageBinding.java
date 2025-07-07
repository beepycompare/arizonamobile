package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.AvatarView;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerChatPageBinding implements ViewBinding {
    public final AvatarView avatar;
    public final MessengerChatLayoutBinding chatLayout;
    public final AppCompatTextView contactId;
    public final AppCompatTextView contactName;
    public final MessengerEmptyChatLayoutBinding emptyChatLayout;
    public final AppCompatImageView headerBack;
    public final LinearLayout headerContainer;
    public final View headerDivider;
    public final AppCompatImageView headerSettingsBtn;
    public final AppCompatImageView icAttach;
    public final AppCompatImageView icNotificationOff;
    public final MessengerInputFieldLayoutBinding inputFieldChatLayout;
    public final MessengerLoaderChatLayoutBinding loaderChatLayout;
    public final MessengerMenuLayoutBinding menuChatLayout;
    public final ConstraintLayout messangerMainPage;
    private final ConstraintLayout rootView;

    private MobilePhoneMessengerChatPageBinding(ConstraintLayout constraintLayout, AvatarView avatarView, MessengerChatLayoutBinding messengerChatLayoutBinding, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, MessengerEmptyChatLayoutBinding messengerEmptyChatLayoutBinding, AppCompatImageView appCompatImageView, LinearLayout linearLayout, View view, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, MessengerInputFieldLayoutBinding messengerInputFieldLayoutBinding, MessengerLoaderChatLayoutBinding messengerLoaderChatLayoutBinding, MessengerMenuLayoutBinding messengerMenuLayoutBinding, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.avatar = avatarView;
        this.chatLayout = messengerChatLayoutBinding;
        this.contactId = appCompatTextView;
        this.contactName = appCompatTextView2;
        this.emptyChatLayout = messengerEmptyChatLayoutBinding;
        this.headerBack = appCompatImageView;
        this.headerContainer = linearLayout;
        this.headerDivider = view;
        this.headerSettingsBtn = appCompatImageView2;
        this.icAttach = appCompatImageView3;
        this.icNotificationOff = appCompatImageView4;
        this.inputFieldChatLayout = messengerInputFieldLayoutBinding;
        this.loaderChatLayout = messengerLoaderChatLayoutBinding;
        this.menuChatLayout = messengerMenuLayoutBinding;
        this.messangerMainPage = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneMessengerChatPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneMessengerChatPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_messenger_chat_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneMessengerChatPageBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        int i = R.id.avatar;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
        if (avatarView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.chat_layout))) != null) {
            MessengerChatLayoutBinding bind = MessengerChatLayoutBinding.bind(findChildViewById);
            i = R.id.contact_id;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView != null) {
                i = R.id.contact_name;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView2 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.empty_chat_layout))) != null) {
                    MessengerEmptyChatLayoutBinding bind2 = MessengerEmptyChatLayoutBinding.bind(findChildViewById2);
                    i = R.id.header_back;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView != null) {
                        i = R.id.header_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.header_divider))) != null) {
                            i = R.id.header_settings_btn;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.ic_attach;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                if (appCompatImageView3 != null) {
                                    i = R.id.ic_notification_off;
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatImageView4 != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.input_field_chat_layout))) != null) {
                                        MessengerInputFieldLayoutBinding bind3 = MessengerInputFieldLayoutBinding.bind(findChildViewById4);
                                        i = R.id.loader_chat_layout;
                                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById5 != null) {
                                            MessengerLoaderChatLayoutBinding bind4 = MessengerLoaderChatLayoutBinding.bind(findChildViewById5);
                                            i = R.id.menu_chat_layout;
                                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById6 != null) {
                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                return new MobilePhoneMessengerChatPageBinding(constraintLayout, avatarView, bind, appCompatTextView, appCompatTextView2, bind2, appCompatImageView, linearLayout, findChildViewById3, appCompatImageView2, appCompatImageView3, appCompatImageView4, bind3, bind4, MessengerMenuLayoutBinding.bind(findChildViewById6), constraintLayout);
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
