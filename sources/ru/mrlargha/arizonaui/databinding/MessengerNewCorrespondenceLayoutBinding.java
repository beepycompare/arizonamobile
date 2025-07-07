package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MessengerNewCorrespondenceLayoutBinding implements ViewBinding {
    public final LinearLayout addFromContactsContainer;
    public final LinearLayout findByNumberContainer;
    private final RelativeLayout rootView;

    private MessengerNewCorrespondenceLayoutBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = relativeLayout;
        this.addFromContactsContainer = linearLayout;
        this.findByNumberContainer = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MessengerNewCorrespondenceLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessengerNewCorrespondenceLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.messenger_new_correspondence_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MessengerNewCorrespondenceLayoutBinding bind(View view) {
        int i = R.id.add_from_contacts_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.find_by_number_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                return new MessengerNewCorrespondenceLayoutBinding((RelativeLayout) view, linearLayout, linearLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
