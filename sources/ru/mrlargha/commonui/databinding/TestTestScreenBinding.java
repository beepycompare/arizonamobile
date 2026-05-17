package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class TestTestScreenBinding implements ViewBinding {
    public final FrameLayout baseTest;
    public final TextView btnMinus;
    public final TextView btnPlusqqqqq;
    public final TextView etValue1123213e;
    public final TextView etValue2;
    public final TextView etValue3;
    private final FrameLayout rootView;

    private TestTestScreenBinding(FrameLayout rootView, FrameLayout baseTest, TextView btnMinus, TextView btnPlusqqqqq, TextView etValue1123213e, TextView etValue2, TextView etValue3) {
        this.rootView = rootView;
        this.baseTest = baseTest;
        this.btnMinus = btnMinus;
        this.btnPlusqqqqq = btnPlusqqqqq;
        this.etValue1123213e = etValue1123213e;
        this.etValue2 = etValue2;
        this.etValue3 = etValue3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TestTestScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TestTestScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.test_test_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TestTestScreenBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.btnMinus;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.btnPlusqqqqq;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.etValue1123213e;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.etValue2;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.etValue3;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new TestTestScreenBinding(frameLayout, frameLayout, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
