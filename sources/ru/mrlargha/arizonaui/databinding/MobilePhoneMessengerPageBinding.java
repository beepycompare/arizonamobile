package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerPageBinding implements ViewBinding {
    public final MessengerEmptyContactsLayoutBinding emptyContactsLayout;
    public final MessengerEmptyMessagesLayoutBinding emptyMessagesLayout;
    public final AppCompatImageView headerAddBtn;
    public final AppCompatImageView headerBack;
    public final LinearLayout headerContainer;
    public final AppCompatImageView headerSettingsBtn;
    public final TextView headerTitle;
    public final MessengerLoadingLayoutBinding loadingLayout;
    public final MessengerMessagesLayoutBinding messagesLayout;
    public final ConstraintLayout messangerMainPage;
    public final MessengerNewCorrespondenceLayoutBinding newCorrespondenceLayout;
    private final ConstraintLayout rootView;
    public final MessengerProfileLayoutBinding settingsLayout;

    private MobilePhoneMessengerPageBinding(ConstraintLayout constraintLayout, MessengerEmptyContactsLayoutBinding messengerEmptyContactsLayoutBinding, MessengerEmptyMessagesLayoutBinding messengerEmptyMessagesLayoutBinding, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, AppCompatImageView appCompatImageView3, TextView textView, MessengerLoadingLayoutBinding messengerLoadingLayoutBinding, MessengerMessagesLayoutBinding messengerMessagesLayoutBinding, ConstraintLayout constraintLayout2, MessengerNewCorrespondenceLayoutBinding messengerNewCorrespondenceLayoutBinding, MessengerProfileLayoutBinding messengerProfileLayoutBinding) {
        this.rootView = constraintLayout;
        this.emptyContactsLayout = messengerEmptyContactsLayoutBinding;
        this.emptyMessagesLayout = messengerEmptyMessagesLayoutBinding;
        this.headerAddBtn = appCompatImageView;
        this.headerBack = appCompatImageView2;
        this.headerContainer = linearLayout;
        this.headerSettingsBtn = appCompatImageView3;
        this.headerTitle = textView;
        this.loadingLayout = messengerLoadingLayoutBinding;
        this.messagesLayout = messengerMessagesLayoutBinding;
        this.messangerMainPage = constraintLayout2;
        this.newCorrespondenceLayout = messengerNewCorrespondenceLayoutBinding;
        this.settingsLayout = messengerProfileLayoutBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneMessengerPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneMessengerPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_messenger_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneMessengerPageBinding bind(View view) {
        View findChildViewById;
        int i = R.id.empty_contacts_layout;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            MessengerEmptyContactsLayoutBinding bind = MessengerEmptyContactsLayoutBinding.bind(findChildViewById2);
            i = R.id.empty_messages_layout;
            View findChildViewById3 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById3 != null) {
                MessengerEmptyMessagesLayoutBinding bind2 = MessengerEmptyMessagesLayoutBinding.bind(findChildViewById3);
                i = R.id.header_add_btn;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.header_back;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.header_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.header_settings_btn;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView3 != null) {
                                i = R.id.header_title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.loading_layout))) != null) {
                                    MessengerLoadingLayoutBinding bind3 = MessengerLoadingLayoutBinding.bind(findChildViewById);
                                    i = R.id.messages_layout;
                                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById4 != null) {
                                        MessengerMessagesLayoutBinding bind4 = MessengerMessagesLayoutBinding.bind(findChildViewById4);
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i = R.id.new_correspondence_layout;
                                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById5 != null) {
                                            MessengerNewCorrespondenceLayoutBinding bind5 = MessengerNewCorrespondenceLayoutBinding.bind(findChildViewById5);
                                            i = R.id.settings_layout;
                                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById6 != null) {
                                                return new MobilePhoneMessengerPageBinding(constraintLayout, bind, bind2, appCompatImageView, appCompatImageView2, linearLayout, appCompatImageView3, textView, bind3, bind4, constraintLayout, bind5, MessengerProfileLayoutBinding.bind(findChildViewById6));
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
