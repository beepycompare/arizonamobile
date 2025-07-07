package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyCharterMembersBinding implements ViewBinding {
    public final ImageView arrow1;
    public final ImageView arrow2;
    public final ImageView arrow3;
    public final ImageView arrow4;
    public final LinearLayout container;
    public final TextView empty;
    public final ProgressBar loaderBar;
    public final ConstraintLayout neighborGameTaskScreen;
    private final ConstraintLayout rootView;
    public final RecyclerView taskRecycleView;
    public final TextView text1;
    public final ImageView text2;
    public final TextView text3;
    public final TextView text4;

    private FamilyCharterMembersBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, TextView textView, ProgressBar progressBar, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView2, ImageView imageView5, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.arrow1 = imageView;
        this.arrow2 = imageView2;
        this.arrow3 = imageView3;
        this.arrow4 = imageView4;
        this.container = linearLayout;
        this.empty = textView;
        this.loaderBar = progressBar;
        this.neighborGameTaskScreen = constraintLayout2;
        this.taskRecycleView = recyclerView;
        this.text1 = textView2;
        this.text2 = imageView5;
        this.text3 = textView3;
        this.text4 = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamilyCharterMembersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyCharterMembersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_charter_members, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyCharterMembersBinding bind(View view) {
        int i = R.id.arrow1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.arrow2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.arrow3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.arrow4;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.empty;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.loader_bar;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i = R.id.task_recycle_view;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.text1;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.text2;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = R.id.text3;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.text4;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        return new FamilyCharterMembersBinding(constraintLayout, imageView, imageView2, imageView3, imageView4, linearLayout, textView, progressBar, constraintLayout, recyclerView, textView2, imageView5, textView3, textView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
