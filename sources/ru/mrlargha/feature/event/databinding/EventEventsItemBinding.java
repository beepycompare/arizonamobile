package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class EventEventsItemBinding implements ViewBinding {
    public final LinearLayout attempsContainer;
    public final TextView btnJoin;
    public final LinearLayout errorOverlay;
    public final EventPriseItemEventBinding item1;
    public final EventPriseItemEventBinding item2;
    public final EventPriseItemEventBinding item3;
    public final ImageView ivEventBg;
    public final LinearLayout playersContainer;
    private final CardView rootView;
    public final TextView tvAttemptsAvailable;
    public final TextView tvErrorText;
    public final TextView tvEventDescription;
    public final TextView tvEventName;
    public final TextView tvParticipants;

    private EventEventsItemBinding(CardView cardView, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, EventPriseItemEventBinding eventPriseItemEventBinding, EventPriseItemEventBinding eventPriseItemEventBinding2, EventPriseItemEventBinding eventPriseItemEventBinding3, ImageView imageView, LinearLayout linearLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = cardView;
        this.attempsContainer = linearLayout;
        this.btnJoin = textView;
        this.errorOverlay = linearLayout2;
        this.item1 = eventPriseItemEventBinding;
        this.item2 = eventPriseItemEventBinding2;
        this.item3 = eventPriseItemEventBinding3;
        this.ivEventBg = imageView;
        this.playersContainer = linearLayout3;
        this.tvAttemptsAvailable = textView2;
        this.tvErrorText = textView3;
        this.tvEventDescription = textView4;
        this.tvEventName = textView5;
        this.tvParticipants = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static EventEventsItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventEventsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_events_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventEventsItemBinding bind(View view) {
        View findChildViewById;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.attemps_container);
        int i = R.id.btn_join;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.error_overlay;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.item1))) != null) {
                EventPriseItemEventBinding bind = EventPriseItemEventBinding.bind(findChildViewById);
                i = R.id.item2;
                View findChildViewById2 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById2 != null) {
                    EventPriseItemEventBinding bind2 = EventPriseItemEventBinding.bind(findChildViewById2);
                    i = R.id.item3;
                    View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById3 != null) {
                        EventPriseItemEventBinding bind3 = EventPriseItemEventBinding.bind(findChildViewById3);
                        i = R.id.iv_event_bg;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.players_container;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = R.id.tv_attempts_available;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_error_text;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_event_description;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.tv_event_name;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.tv_participants;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    return new EventEventsItemBinding((CardView) view, linearLayout, textView, linearLayout2, bind, bind2, bind3, imageView, linearLayout3, textView2, textView3, textView4, textView5, textView6);
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
