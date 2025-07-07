package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class TradeScreenBinding implements ViewBinding {
    public final Button btnAccept;
    public final AppCompatImageView btnBack;
    public final Button btnCancel;
    public final EditText etReceiveItems;
    public final EditText etSendItems;
    public final Group groupProgressBar;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer3;
    public final Guideline guidelineVer4;
    public final ImageView ivReceiveStatus;
    public final ImageView ivSendStatus;
    public final LinearLayout layoutButtons;
    public final ConstraintLayout parentLayout;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final RecyclerView rvInventory;
    public final RecyclerView rvReceiveItems;
    public final RecyclerView rvSendItems;
    public final TextView tvLoadingTitle;
    public final TextView tvReceiveItems;
    public final TextView tvSendItems;
    public final TextView tvTitle;
    public final ImageView viewLine;

    private TradeScreenBinding(ConstraintLayout rootView, Button btnAccept, AppCompatImageView btnBack, Button btnCancel, EditText etReceiveItems, EditText etSendItems, Group groupProgressBar, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineVer1, Guideline guidelineVer2, Guideline guidelineVer3, Guideline guidelineVer4, ImageView ivReceiveStatus, ImageView ivSendStatus, LinearLayout layoutButtons, ConstraintLayout parentLayout, ProgressBar progressBar, RecyclerView rvInventory, RecyclerView rvReceiveItems, RecyclerView rvSendItems, TextView tvLoadingTitle, TextView tvReceiveItems, TextView tvSendItems, TextView tvTitle, ImageView viewLine) {
        this.rootView = rootView;
        this.btnAccept = btnAccept;
        this.btnBack = btnBack;
        this.btnCancel = btnCancel;
        this.etReceiveItems = etReceiveItems;
        this.etSendItems = etSendItems;
        this.groupProgressBar = groupProgressBar;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer3 = guidelineVer3;
        this.guidelineVer4 = guidelineVer4;
        this.ivReceiveStatus = ivReceiveStatus;
        this.ivSendStatus = ivSendStatus;
        this.layoutButtons = layoutButtons;
        this.parentLayout = parentLayout;
        this.progressBar = progressBar;
        this.rvInventory = rvInventory;
        this.rvReceiveItems = rvReceiveItems;
        this.rvSendItems = rvSendItems;
        this.tvLoadingTitle = tvLoadingTitle;
        this.tvReceiveItems = tvReceiveItems;
        this.tvSendItems = tvSendItems;
        this.tvTitle = tvTitle;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TradeScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TradeScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.trade_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TradeScreenBinding bind(View rootView) {
        int i = R.id.btnAccept;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btnBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.btnCancel;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button2 != null) {
                    i = R.id.etReceiveItems;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                    if (editText != null) {
                        i = R.id.etSendItems;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                        if (editText2 != null) {
                            i = R.id.groupProgressBar;
                            Group group = (Group) ViewBindings.findChildViewById(rootView, i);
                            if (group != null) {
                                i = R.id.guidelineHor1;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline != null) {
                                    i = R.id.guidelineHor2;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline2 != null) {
                                        i = R.id.guidelineVer1;
                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline3 != null) {
                                            i = R.id.guidelineVer2;
                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline4 != null) {
                                                i = R.id.guidelineVer3;
                                                Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline5 != null) {
                                                    i = R.id.guidelineVer4;
                                                    Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline6 != null) {
                                                        i = R.id.ivReceiveStatus;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView != null) {
                                                            i = R.id.ivSendStatus;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView2 != null) {
                                                                i = R.id.layoutButtons;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                    i = R.id.progressBar;
                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                    if (progressBar != null) {
                                                                        i = R.id.rvInventory;
                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (recyclerView != null) {
                                                                            i = R.id.rvReceiveItems;
                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (recyclerView2 != null) {
                                                                                i = R.id.rvSendItems;
                                                                                RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (recyclerView3 != null) {
                                                                                    i = R.id.tvLoadingTitle;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView != null) {
                                                                                        i = R.id.tvReceiveItems;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tvSendItems;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tvTitle;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.viewLine;
                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (imageView3 != null) {
                                                                                                        return new TradeScreenBinding(constraintLayout, button, appCompatImageView, button2, editText, editText2, group, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, imageView, imageView2, linearLayout, constraintLayout, progressBar, recyclerView, recyclerView2, recyclerView3, textView, textView2, textView3, textView4, imageView3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
