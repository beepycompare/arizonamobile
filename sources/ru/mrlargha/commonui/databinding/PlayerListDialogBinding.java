package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class PlayerListDialogBinding implements ViewBinding {
    public final DialogBackgroundBinding bg;
    public final Guideline guideline3;
    public final Guideline guideline4;
    public final Guideline guideline5;
    public final Guideline guideline6;
    public final LinearLayout header;
    public final ConstraintLayout playerListDialogLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPLayerList;
    public final TextInputLayout textInputLayout;
    public final TextView tvCaption;
    public final TextView tvPlayersCount;
    public final TextInputEditText userInput;

    private PlayerListDialogBinding(ConstraintLayout rootView, DialogBackgroundBinding bg, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, LinearLayout header, ConstraintLayout playerListDialogLayout, RecyclerView rvPLayerList, TextInputLayout textInputLayout, TextView tvCaption, TextView tvPlayersCount, TextInputEditText userInput) {
        this.rootView = rootView;
        this.bg = bg;
        this.guideline3 = guideline3;
        this.guideline4 = guideline4;
        this.guideline5 = guideline5;
        this.guideline6 = guideline6;
        this.header = header;
        this.playerListDialogLayout = playerListDialogLayout;
        this.rvPLayerList = rvPLayerList;
        this.textInputLayout = textInputLayout;
        this.tvCaption = tvCaption;
        this.tvPlayersCount = tvPlayersCount;
        this.userInput = userInput;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PlayerListDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PlayerListDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.player_list_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static PlayerListDialogBinding bind(View rootView) {
        int i = R.id.bg;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            DialogBackgroundBinding bind = DialogBackgroundBinding.bind(findChildViewById);
            i = R.id.guideline3;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.guideline4;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.guideline5;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline3 != null) {
                        i = R.id.guideline6;
                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline4 != null) {
                            i = R.id.header;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                i = R.id.rvPLayerList;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.textInputLayout;
                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (textInputLayout != null) {
                                        i = R.id.tvCaption;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            i = R.id.tvPlayersCount;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                i = R.id.user_input;
                                                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
                                                if (textInputEditText != null) {
                                                    return new PlayerListDialogBinding(constraintLayout, bind, guideline, guideline2, guideline3, guideline4, linearLayout, constraintLayout, recyclerView, textInputLayout, textView, textView2, textInputEditText);
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
