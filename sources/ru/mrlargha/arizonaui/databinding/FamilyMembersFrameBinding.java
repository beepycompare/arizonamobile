package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyMembersFrameBinding implements ViewBinding {
    public final CardView buttonClose;
    public final CardView buttonKick;
    public final TextView buttonKickText;
    public final CardView buttonPrem;
    public final TextView buttonPremText;
    public final CardView buttonRank;
    public final TextView buttonRankText;
    public final CardView buttonWarn;
    public final TextView buttonWarnText;
    public final CardView card1;
    private final LinearLayout rootView;

    private FamilyMembersFrameBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2, TextView textView, CardView cardView3, TextView textView2, CardView cardView4, TextView textView3, CardView cardView5, TextView textView4, CardView cardView6) {
        this.rootView = linearLayout;
        this.buttonClose = cardView;
        this.buttonKick = cardView2;
        this.buttonKickText = textView;
        this.buttonPrem = cardView3;
        this.buttonPremText = textView2;
        this.buttonRank = cardView4;
        this.buttonRankText = textView3;
        this.buttonWarn = cardView5;
        this.buttonWarnText = textView4;
        this.card1 = cardView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilyMembersFrameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyMembersFrameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_members_frame, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyMembersFrameBinding bind(View view) {
        int i = R.id.button_close;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.button_kick;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView2 != null) {
                i = R.id.button_kick_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.button_prem;
                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView3 != null) {
                        i = R.id.button_prem_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.button_rank;
                            CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, i);
                            if (cardView4 != null) {
                                i = R.id.button_rank_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.button_warn;
                                    CardView cardView5 = (CardView) ViewBindings.findChildViewById(view, i);
                                    if (cardView5 != null) {
                                        i = R.id.button_warn_text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.card1;
                                            CardView cardView6 = (CardView) ViewBindings.findChildViewById(view, i);
                                            if (cardView6 != null) {
                                                return new FamilyMembersFrameBinding((LinearLayout) view, cardView, cardView2, textView, cardView3, textView2, cardView4, textView3, cardView5, textView4, cardView6);
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
