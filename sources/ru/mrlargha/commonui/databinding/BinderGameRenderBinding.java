package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class BinderGameRenderBinding implements ViewBinding {
    public final TextView backKeyboard;
    public final RecyclerView bindRecycler;
    public final FrameLayout binderMainFlRoot;
    public final ConstraintLayout binderMainInput;
    public final TextView binderText;
    public final AppCompatImageView imageButton;
    public final AppCompatImageView imageView;
    private final FrameLayout rootView;

    private BinderGameRenderBinding(FrameLayout rootView, TextView backKeyboard, RecyclerView bindRecycler, FrameLayout binderMainFlRoot, ConstraintLayout binderMainInput, TextView binderText, AppCompatImageView imageButton, AppCompatImageView imageView) {
        this.rootView = rootView;
        this.backKeyboard = backKeyboard;
        this.bindRecycler = bindRecycler;
        this.binderMainFlRoot = binderMainFlRoot;
        this.binderMainInput = binderMainInput;
        this.binderText = binderText;
        this.imageButton = imageButton;
        this.imageView = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BinderGameRenderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BinderGameRenderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.binder_game_render, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BinderGameRenderBinding bind(View rootView) {
        int i = R.id.back_keyboard;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.bind_recycler;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.binder_main_input;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout != null) {
                    i = R.id.binder_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.imageButton;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView != null) {
                            i = R.id.imageView;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatImageView2 != null) {
                                return new BinderGameRenderBinding(frameLayout, textView, recyclerView, frameLayout, constraintLayout, textView2, appCompatImageView, appCompatImageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
