package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyMembersItemBinding implements ViewBinding {
    public final ImageView actions;
    public final TextView memberName;
    public final TextView memberOffileTime;
    public final TextView memberRole;
    public final LinearLayout neighborGameTaskScreen;
    public final ImageView onlineImage;
    public final TextView rank;
    private final LinearLayout rootView;
    public final TextView tasks;
    public final TextView warns;

    private FamilyMembersItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2, ImageView imageView2, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.actions = imageView;
        this.memberName = textView;
        this.memberOffileTime = textView2;
        this.memberRole = textView3;
        this.neighborGameTaskScreen = linearLayout2;
        this.onlineImage = imageView2;
        this.rank = textView4;
        this.tasks = textView5;
        this.warns = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilyMembersItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyMembersItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_members_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyMembersItemBinding bind(View view) {
        int i = R.id.actions;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.member_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.member_offile_time;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.member_role;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        i = R.id.online_image;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.rank;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tasks;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.warns;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        return new FamilyMembersItemBinding(linearLayout, imageView, textView, textView2, textView3, linearLayout, imageView2, textView4, textView5, textView6);
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
