package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MessengerMessagesLayoutBinding implements ViewBinding {
    public final LinearLayout emptySearchContainer;
    public final RecyclerView listMessages;
    public final LinearLayout loaderContainer;
    public final LinearLayout messengerSearchContainer;
    public final TextView resultSearchTitle;
    private final LinearLayout rootView;
    public final EditText searchEditText;

    private MessengerMessagesLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, EditText editText) {
        this.rootView = linearLayout;
        this.emptySearchContainer = linearLayout2;
        this.listMessages = recyclerView;
        this.loaderContainer = linearLayout3;
        this.messengerSearchContainer = linearLayout4;
        this.resultSearchTitle = textView;
        this.searchEditText = editText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MessengerMessagesLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessengerMessagesLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.messenger_messages_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MessengerMessagesLayoutBinding bind(View view) {
        int i = R.id.empty_search_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.list_messages;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.loader_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.messenger_search_container;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.result_search_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.search_edit_text;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                return new MessengerMessagesLayoutBinding((LinearLayout) view, linearLayout, recyclerView, linearLayout2, linearLayout3, textView, editText);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
