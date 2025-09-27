package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class InventoryPersonSectionBinding implements ViewBinding {
    public final ImageView btnAccessories;
    public final ImageView btnSetLeft;
    public final ImageView btnSetRight;
    public final ImageView btnUpgrades;
    public final ImageView btnWallet;
    public final FrameLayout layoutAcsUpg;
    public final LinearLayout linearButtons;
    private final LinearLayout rootView;
    public final RecyclerView rvAccessoriesInventory;
    public final RecyclerView rvSubInventory;
    public final RecyclerView rvUpgradesInventory;
    public final RecyclerView rvWalletInventory;
    public final LinearLayout setContainer;
    public final TextView tvSetNumber;

    private InventoryPersonSectionBinding(LinearLayout rootView, ImageView btnAccessories, ImageView btnSetLeft, ImageView btnSetRight, ImageView btnUpgrades, ImageView btnWallet, FrameLayout layoutAcsUpg, LinearLayout linearButtons, RecyclerView rvAccessoriesInventory, RecyclerView rvSubInventory, RecyclerView rvUpgradesInventory, RecyclerView rvWalletInventory, LinearLayout setContainer, TextView tvSetNumber) {
        this.rootView = rootView;
        this.btnAccessories = btnAccessories;
        this.btnSetLeft = btnSetLeft;
        this.btnSetRight = btnSetRight;
        this.btnUpgrades = btnUpgrades;
        this.btnWallet = btnWallet;
        this.layoutAcsUpg = layoutAcsUpg;
        this.linearButtons = linearButtons;
        this.rvAccessoriesInventory = rvAccessoriesInventory;
        this.rvSubInventory = rvSubInventory;
        this.rvUpgradesInventory = rvUpgradesInventory;
        this.rvWalletInventory = rvWalletInventory;
        this.setContainer = setContainer;
        this.tvSetNumber = tvSetNumber;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static InventoryPersonSectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryPersonSectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_person_section, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryPersonSectionBinding bind(View rootView) {
        int i = R.id.btnAccessories;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btn_set_left;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.btn_set_right;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.btnUpgrades;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView4 != null) {
                        i = R.id.btnWallet;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView5 != null) {
                            i = R.id.layoutAcsUpg;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                            if (frameLayout != null) {
                                i = R.id.linearButtons;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout != null) {
                                    i = R.id.rvAccessoriesInventory;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView != null) {
                                        i = R.id.rvSubInventory;
                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView2 != null) {
                                            i = R.id.rvUpgradesInventory;
                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView3 != null) {
                                                i = R.id.rvWalletInventory;
                                                RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                if (recyclerView4 != null) {
                                                    i = R.id.set_container;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.tv_set_number;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView != null) {
                                                            return new InventoryPersonSectionBinding((LinearLayout) rootView, imageView, imageView2, imageView3, imageView4, imageView5, frameLayout, linearLayout, recyclerView, recyclerView2, recyclerView3, recyclerView4, linearLayout2, textView);
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
