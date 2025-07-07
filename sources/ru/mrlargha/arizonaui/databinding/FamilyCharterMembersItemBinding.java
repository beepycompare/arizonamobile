package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyCharterMembersItemBinding implements ViewBinding {
    public final CardView button;
    public final ImageView isPaid;
    public final TextView memberName;
    public final TextView memberRole;
    public final LinearLayout neighborGameTaskScreen;
    public final ImageView onlineImage;
    public final TextView rank;
    private final LinearLayout rootView;
    public final TextView time;

    private FamilyCharterMembersItemBinding(LinearLayout linearLayout, CardView cardView, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout2, ImageView imageView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.button = cardView;
        this.isPaid = imageView;
        this.memberName = textView;
        this.memberRole = textView2;
        this.neighborGameTaskScreen = linearLayout2;
        this.onlineImage = imageView2;
        this.rank = textView3;
        this.time = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilyCharterMembersItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyCharterMembersItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_charter_members_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyCharterMembersItemBinding bind(View view) {
        int i = R.id.button;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.is_paid;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.member_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.member_role;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        i = R.id.online_image;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.rank;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.time;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new FamilyCharterMembersItemBinding(linearLayout, cardView, imageView, textView, textView2, linearLayout, imageView2, textView3, textView4);
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
