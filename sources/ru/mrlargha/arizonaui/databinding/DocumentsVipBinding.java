package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentsVipBinding implements ViewBinding {
    public final LinearLayout documentsButton1;
    public final TextView documentsButton1Desc;
    public final TextView documentsButton1Title;
    public final LinearLayout documentsButton2;
    public final TextView documentsButton2Title;
    public final TextView documentsVipDesc;
    public final TextView documentsVipEmpty;
    public final TextView documentsVipLevel;
    public final LinearLayout documentsVipStatusGold;
    public final ImageView documentsVipStatusIc;
    public final TextView documentsVipStatysBottom;
    public final TextView documentsVipStatysTop;
    public final RecyclerView levelRecycleView;
    private final ConstraintLayout rootView;
    public final LinearLayout table1;
    public final LinearLayout table2;
    public final LinearLayout tableTop;
    public final RecyclerView typeRecycleView;
    public final LinearLayout vipInfo;

    private DocumentsVipBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout3, ImageView imageView, TextView textView7, TextView textView8, RecyclerView recyclerView, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView2, LinearLayout linearLayout7) {
        this.rootView = constraintLayout;
        this.documentsButton1 = linearLayout;
        this.documentsButton1Desc = textView;
        this.documentsButton1Title = textView2;
        this.documentsButton2 = linearLayout2;
        this.documentsButton2Title = textView3;
        this.documentsVipDesc = textView4;
        this.documentsVipEmpty = textView5;
        this.documentsVipLevel = textView6;
        this.documentsVipStatusGold = linearLayout3;
        this.documentsVipStatusIc = imageView;
        this.documentsVipStatysBottom = textView7;
        this.documentsVipStatysTop = textView8;
        this.levelRecycleView = recyclerView;
        this.table1 = linearLayout4;
        this.table2 = linearLayout5;
        this.tableTop = linearLayout6;
        this.typeRecycleView = recyclerView2;
        this.vipInfo = linearLayout7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DocumentsVipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsVipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_vip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsVipBinding bind(View view) {
        int i = R.id.documents_button1;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.documents_button1_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.documents_button1_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.documents_button2;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.documents_button2_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.documents_vip_desc;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.documents_vip_empty;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.documents_vip_level;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.documents_vip_status_gold;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.documents_vip_status_ic;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = R.id.documents_vip_statys_bottom;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.documents_vip_statys_top;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        i = R.id.level_recycle_view;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                        if (recyclerView != null) {
                                                            i = R.id.table1;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.table2;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.tableTop;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.type_recycle_view;
                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                        if (recyclerView2 != null) {
                                                                            i = R.id.vip_info;
                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout7 != null) {
                                                                                return new DocumentsVipBinding((ConstraintLayout) view, linearLayout, textView, textView2, linearLayout2, textView3, textView4, textView5, textView6, linearLayout3, imageView, textView7, textView8, recyclerView, linearLayout4, linearLayout5, linearLayout6, recyclerView2, linearLayout7);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
