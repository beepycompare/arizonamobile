package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class TradeScreenBinding implements ViewBinding {
    public final Button btnAccept;
    public final CustomCardView btnArizonaReceiveItem;
    public final AppCompatImageView btnBack;
    public final Button btnCancel;
    public final CustomCardView btnReceiveItem;
    public final TextView btnReceiveItemText;
    public final CustomCardView btnSendItem;
    public final TextView btnSendItemText;
    public final CustomCardView buttonCurrency1;
    public final CustomCardView buttonCurrency2;
    public final CustomCardView buttonCurrency3;
    public final CustomCardView buttonCurrency4;
    public final FrameLayout currencyChoice;
    public final ViewUniversalMoneyInputBinding etReceiveItems;
    public final ViewUniversalMoneyInputBinding etSendItems;
    public final Group groupProgressBar;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer3;
    public final Guideline guidelineVer4;
    public final Guideline guidelineVer5;
    public final Guideline guidelineVer6;
    public final ImageView ivReceiveStatus;
    public final ImageView ivSendStatus;
    public final LinearLayout layoutButtons;
    public final ConstraintLayout parentLayout;
    public final ProgressBar progressBar;
    public final LinearLayout receiveItemsContainer;
    public final FrameLayout receiveItemsLabelContainer;
    private final ConstraintLayout rootView;
    public final RecyclerView rvInventory;
    public final RecyclerView rvReceiveItems;
    public final RecyclerView rvSendItems;
    public final LinearLayout sendItemContainer;
    public final FrameLayout sendItemsLabelContainer;
    public final TextView tvLoadingTitle;
    public final TextView tvReceiveItems;
    public final TextView tvSendItems;
    public final TextView tvTitle;
    public final ImageView viewLine;

    private TradeScreenBinding(ConstraintLayout rootView, Button btnAccept, CustomCardView btnArizonaReceiveItem, AppCompatImageView btnBack, Button btnCancel, CustomCardView btnReceiveItem, TextView btnReceiveItemText, CustomCardView btnSendItem, TextView btnSendItemText, CustomCardView buttonCurrency1, CustomCardView buttonCurrency2, CustomCardView buttonCurrency3, CustomCardView buttonCurrency4, FrameLayout currencyChoice, ViewUniversalMoneyInputBinding etReceiveItems, ViewUniversalMoneyInputBinding etSendItems, Group groupProgressBar, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineVer1, Guideline guidelineVer2, Guideline guidelineVer3, Guideline guidelineVer4, Guideline guidelineVer5, Guideline guidelineVer6, ImageView ivReceiveStatus, ImageView ivSendStatus, LinearLayout layoutButtons, ConstraintLayout parentLayout, ProgressBar progressBar, LinearLayout receiveItemsContainer, FrameLayout receiveItemsLabelContainer, RecyclerView rvInventory, RecyclerView rvReceiveItems, RecyclerView rvSendItems, LinearLayout sendItemContainer, FrameLayout sendItemsLabelContainer, TextView tvLoadingTitle, TextView tvReceiveItems, TextView tvSendItems, TextView tvTitle, ImageView viewLine) {
        this.rootView = rootView;
        this.btnAccept = btnAccept;
        this.btnArizonaReceiveItem = btnArizonaReceiveItem;
        this.btnBack = btnBack;
        this.btnCancel = btnCancel;
        this.btnReceiveItem = btnReceiveItem;
        this.btnReceiveItemText = btnReceiveItemText;
        this.btnSendItem = btnSendItem;
        this.btnSendItemText = btnSendItemText;
        this.buttonCurrency1 = buttonCurrency1;
        this.buttonCurrency2 = buttonCurrency2;
        this.buttonCurrency3 = buttonCurrency3;
        this.buttonCurrency4 = buttonCurrency4;
        this.currencyChoice = currencyChoice;
        this.etReceiveItems = etReceiveItems;
        this.etSendItems = etSendItems;
        this.groupProgressBar = groupProgressBar;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer3 = guidelineVer3;
        this.guidelineVer4 = guidelineVer4;
        this.guidelineVer5 = guidelineVer5;
        this.guidelineVer6 = guidelineVer6;
        this.ivReceiveStatus = ivReceiveStatus;
        this.ivSendStatus = ivSendStatus;
        this.layoutButtons = layoutButtons;
        this.parentLayout = parentLayout;
        this.progressBar = progressBar;
        this.receiveItemsContainer = receiveItemsContainer;
        this.receiveItemsLabelContainer = receiveItemsLabelContainer;
        this.rvInventory = rvInventory;
        this.rvReceiveItems = rvReceiveItems;
        this.rvSendItems = rvSendItems;
        this.sendItemContainer = sendItemContainer;
        this.sendItemsLabelContainer = sendItemsLabelContainer;
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
        View findChildViewById;
        int i = R.id.btnAccept;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btn_arizona_receive_item;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.btnBack;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    i = R.id.btnCancel;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                    if (button2 != null) {
                        i = R.id.btn_receive_item;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView2 != null) {
                            i = R.id.btn_receive_itemText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.btnSendItem;
                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                if (customCardView3 != null) {
                                    i = R.id.btnSendItemText;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        i = R.id.buttonCurrency1;
                                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                        if (customCardView4 != null) {
                                            i = R.id.buttonCurrency2;
                                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                            if (customCardView5 != null) {
                                                i = R.id.buttonCurrency3;
                                                CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                if (customCardView6 != null) {
                                                    i = R.id.buttonCurrency4;
                                                    CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                    if (customCardView7 != null) {
                                                        i = R.id.currencyChoice;
                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.etReceiveItems))) != null) {
                                                            ViewUniversalMoneyInputBinding bind = ViewUniversalMoneyInputBinding.bind(findChildViewById);
                                                            i = R.id.etSendItems;
                                                            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
                                                            if (findChildViewById2 != null) {
                                                                ViewUniversalMoneyInputBinding bind2 = ViewUniversalMoneyInputBinding.bind(findChildViewById2);
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
                                                                                            i = R.id.guidelineVer5;
                                                                                            Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (guideline7 != null) {
                                                                                                i = R.id.guidelineVer6;
                                                                                                Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (guideline8 != null) {
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
                                                                                                                    i = R.id.receive_items_container;
                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (linearLayout2 != null) {
                                                                                                                        i = R.id.receive_items_label_container;
                                                                                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (frameLayout2 != null) {
                                                                                                                            i = R.id.rvInventory;
                                                                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (recyclerView != null) {
                                                                                                                                i = R.id.rvReceiveItems;
                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                    i = R.id.rvSendItems;
                                                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (recyclerView3 != null) {
                                                                                                                                        i = R.id.send_item_container;
                                                                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (linearLayout3 != null) {
                                                                                                                                            i = R.id.send_items_label_container;
                                                                                                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (frameLayout3 != null) {
                                                                                                                                                i = R.id.tvLoadingTitle;
                                                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (textView3 != null) {
                                                                                                                                                    i = R.id.tvReceiveItems;
                                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (textView4 != null) {
                                                                                                                                                        i = R.id.tvSendItems;
                                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                            i = R.id.tvTitle;
                                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (textView6 != null) {
                                                                                                                                                                i = R.id.viewLine;
                                                                                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (imageView3 != null) {
                                                                                                                                                                    return new TradeScreenBinding(constraintLayout, button, customCardView, appCompatImageView, button2, customCardView2, textView, customCardView3, textView2, customCardView4, customCardView5, customCardView6, customCardView7, frameLayout, bind, bind2, group, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, imageView, imageView2, linearLayout, constraintLayout, progressBar, linearLayout2, frameLayout2, recyclerView, recyclerView2, recyclerView3, linearLayout3, frameLayout3, textView3, textView4, textView5, textView6, imageView3);
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
