package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class KeyboardGameRenderBinding implements ViewBinding {
    public final Button mainButBinder;
    public final Button mainButInputNext;
    public final Button mainButInputPrev;
    public final Button mainButInputSlash;
    public final EditText mainEtInput;
    public final RelativeLayout mainFlRoot;
    public final LinearLayout mainInput;
    public final SurfaceView mainSv;
    private final RelativeLayout rootView;

    private KeyboardGameRenderBinding(RelativeLayout rootView, Button mainButBinder, Button mainButInputNext, Button mainButInputPrev, Button mainButInputSlash, EditText mainEtInput, RelativeLayout mainFlRoot, LinearLayout mainInput, SurfaceView mainSv) {
        this.rootView = rootView;
        this.mainButBinder = mainButBinder;
        this.mainButInputNext = mainButInputNext;
        this.mainButInputPrev = mainButInputPrev;
        this.mainButInputSlash = mainButInputSlash;
        this.mainEtInput = mainEtInput;
        this.mainFlRoot = mainFlRoot;
        this.mainInput = mainInput;
        this.mainSv = mainSv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardGameRenderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardGameRenderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_game_render, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardGameRenderBinding bind(View rootView) {
        int i = R.id.main_but_binder;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.main_but_input_next;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button2 != null) {
                i = R.id.main_but_input_prev;
                Button button3 = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button3 != null) {
                    i = R.id.main_but_input_slash;
                    Button button4 = (Button) ViewBindings.findChildViewById(rootView, i);
                    if (button4 != null) {
                        i = R.id.main_et_input;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                        if (editText != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) rootView;
                            i = R.id.main_input;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                i = R.id.main_sv;
                                SurfaceView surfaceView = (SurfaceView) ViewBindings.findChildViewById(rootView, i);
                                if (surfaceView != null) {
                                    return new KeyboardGameRenderBinding(relativeLayout, button, button2, button3, button4, editText, relativeLayout, linearLayout, surfaceView);
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
