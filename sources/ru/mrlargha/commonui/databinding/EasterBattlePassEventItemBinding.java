package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlePassEventItemBinding implements ViewBinding {
    public final LinearLayout attempsContainer;
    public final TextView btnJoin;
    public final LinearLayout errorOverlay;
    public final EasterBattlepassPriseItemEventBinding item1;
    public final EasterBattlepassPriseItemEventBinding item2;
    public final EasterBattlepassPriseItemEventBinding item3;
    public final ImageView ivEventBg;
    public final LinearLayout playersContainer;
    private final CardView rootView;
    public final TextView tvAttemptsAvailable;
    public final TextView tvErrorText;
    public final TextView tvEventDescription;
    public final TextView tvEventName;
    public final TextView tvParticipants;

    private EasterBattlePassEventItemBinding(CardView rootView, LinearLayout attempsContainer, TextView btnJoin, LinearLayout errorOverlay, EasterBattlepassPriseItemEventBinding item1, EasterBattlepassPriseItemEventBinding item2, EasterBattlepassPriseItemEventBinding item3, ImageView ivEventBg, LinearLayout playersContainer, TextView tvAttemptsAvailable, TextView tvErrorText, TextView tvEventDescription, TextView tvEventName, TextView tvParticipants) {
        this.rootView = rootView;
        this.attempsContainer = attempsContainer;
        this.btnJoin = btnJoin;
        this.errorOverlay = errorOverlay;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.ivEventBg = ivEventBg;
        this.playersContainer = playersContainer;
        this.tvAttemptsAvailable = tvAttemptsAvailable;
        this.tvErrorText = tvErrorText;
        this.tvEventDescription = tvEventDescription;
        this.tvEventName = tvEventName;
        this.tvParticipants = tvParticipants;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassEventItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassEventItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_event_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassEventItemBinding bind(View rootView) {
        View findChildViewById;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attemps_container);
        int i = R.id.btn_join;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.error_overlay;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.item1))) != null) {
                EasterBattlepassPriseItemEventBinding bind = EasterBattlepassPriseItemEventBinding.bind(findChildViewById);
                i = R.id.item2;
                View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById2 != null) {
                    EasterBattlepassPriseItemEventBinding bind2 = EasterBattlepassPriseItemEventBinding.bind(findChildViewById2);
                    i = R.id.item3;
                    View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById3 != null) {
                        EasterBattlepassPriseItemEventBinding bind3 = EasterBattlepassPriseItemEventBinding.bind(findChildViewById3);
                        i = R.id.iv_event_bg;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.players_container;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout3 != null) {
                                i = R.id.tv_attempts_available;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tv_error_text;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_event_description;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.tv_event_name;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.tv_participants;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView6 != null) {
                                                    return new EasterBattlePassEventItemBinding((CardView) rootView, linearLayout, textView, linearLayout2, bind, bind2, bind3, imageView, linearLayout3, textView2, textView3, textView4, textView5, textView6);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
