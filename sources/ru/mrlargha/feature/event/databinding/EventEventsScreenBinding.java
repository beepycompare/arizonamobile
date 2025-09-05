package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.event.R;
/* loaded from: classes3.dex */
public final class EventEventsScreenBinding implements ViewBinding {
    public final EventEventsItemBinding event1;
    public final EventEventsItemBinding event2;
    public final EventEventsItemBinding event3;
    private final ConstraintLayout rootView;

    private EventEventsScreenBinding(ConstraintLayout constraintLayout, EventEventsItemBinding eventEventsItemBinding, EventEventsItemBinding eventEventsItemBinding2, EventEventsItemBinding eventEventsItemBinding3) {
        this.rootView = constraintLayout;
        this.event1 = eventEventsItemBinding;
        this.event2 = eventEventsItemBinding2;
        this.event3 = eventEventsItemBinding3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EventEventsScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventEventsScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_events_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventEventsScreenBinding bind(View view) {
        int i = R.id.event1;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            EventEventsItemBinding bind = EventEventsItemBinding.bind(findChildViewById);
            int i2 = R.id.event2;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i2);
            if (findChildViewById2 != null) {
                EventEventsItemBinding bind2 = EventEventsItemBinding.bind(findChildViewById2);
                int i3 = R.id.event3;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i3);
                if (findChildViewById3 != null) {
                    return new EventEventsScreenBinding((ConstraintLayout) view, bind, bind2, EventEventsItemBinding.bind(findChildViewById3));
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
