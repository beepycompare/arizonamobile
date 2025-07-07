package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class MainInventoryBinding implements ViewBinding {
    public final Button btnAccessories;
    public final AppCompatImageView btnBack;
    public final AppCompatButton btnMedbook;
    public final AppCompatButton btnPassport;
    public final AppCompatButton btnSortItems;
    public final AppCompatButton btnStats;
    public final Button btnUpgrades;
    public final AppCompatButton btnVipStatus;
    public final Button btnWallet;
    public final Group groupCharacter;
    public final Group groupCharacterInfo;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineHor4;
    public final Guideline guidelineHor5;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer3;
    public final Guideline guidelineVer4;
    public final AppCompatImageView ivCharacterImage;
    public final LinearProgressIndicator ivFoodBar;
    public final AppCompatImageView ivFoodTab;
    public final LinearProgressIndicator ivHealthBar;
    public final AppCompatImageView ivHealthTab;
    public final LinearProgressIndicator ivShieldBar;
    public final AppCompatImageView ivShieldTab;
    public final ConstraintLayout layoutAcsUpg;
    public final LayoutGuardInventoryBinding layoutGuards;
    public final LayoutVehicleInventoryBinding layoutVehicle;
    public final LayoutWarehouseBinding layoutWarehouse;
    public final LinearLayout linearButtons;
    public final ConstraintLayout parentLayout;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final RecyclerView rvAccessoriesInventory;
    public final RecyclerView rvCategoryMenu;
    public final RecyclerView rvGuardInventory;
    public final RecyclerView rvMainInventory;
    public final RecyclerView rvSubInventory;
    public final RecyclerView rvUpgradesInventory;
    public final RecyclerView rvWalletInventory;
    public final AppCompatTextView tvFoodCount;
    public final AppCompatTextView tvHealthCount;
    public final AppCompatTextView tvInventory;
    public final AppCompatTextView tvShieldCount;
    public final ImageView viewLine;

    private MainInventoryBinding(ConstraintLayout rootView, Button btnAccessories, AppCompatImageView btnBack, AppCompatButton btnMedbook, AppCompatButton btnPassport, AppCompatButton btnSortItems, AppCompatButton btnStats, Button btnUpgrades, AppCompatButton btnVipStatus, Button btnWallet, Group groupCharacter, Group groupCharacterInfo, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineHor4, Guideline guidelineHor5, Guideline guidelineVer1, Guideline guidelineVer2, Guideline guidelineVer3, Guideline guidelineVer4, AppCompatImageView ivCharacterImage, LinearProgressIndicator ivFoodBar, AppCompatImageView ivFoodTab, LinearProgressIndicator ivHealthBar, AppCompatImageView ivHealthTab, LinearProgressIndicator ivShieldBar, AppCompatImageView ivShieldTab, ConstraintLayout layoutAcsUpg, LayoutGuardInventoryBinding layoutGuards, LayoutVehicleInventoryBinding layoutVehicle, LayoutWarehouseBinding layoutWarehouse, LinearLayout linearButtons, ConstraintLayout parentLayout, ProgressBar progressBar, RecyclerView rvAccessoriesInventory, RecyclerView rvCategoryMenu, RecyclerView rvGuardInventory, RecyclerView rvMainInventory, RecyclerView rvSubInventory, RecyclerView rvUpgradesInventory, RecyclerView rvWalletInventory, AppCompatTextView tvFoodCount, AppCompatTextView tvHealthCount, AppCompatTextView tvInventory, AppCompatTextView tvShieldCount, ImageView viewLine) {
        this.rootView = rootView;
        this.btnAccessories = btnAccessories;
        this.btnBack = btnBack;
        this.btnMedbook = btnMedbook;
        this.btnPassport = btnPassport;
        this.btnSortItems = btnSortItems;
        this.btnStats = btnStats;
        this.btnUpgrades = btnUpgrades;
        this.btnVipStatus = btnVipStatus;
        this.btnWallet = btnWallet;
        this.groupCharacter = groupCharacter;
        this.groupCharacterInfo = groupCharacterInfo;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineHor4 = guidelineHor4;
        this.guidelineHor5 = guidelineHor5;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer3 = guidelineVer3;
        this.guidelineVer4 = guidelineVer4;
        this.ivCharacterImage = ivCharacterImage;
        this.ivFoodBar = ivFoodBar;
        this.ivFoodTab = ivFoodTab;
        this.ivHealthBar = ivHealthBar;
        this.ivHealthTab = ivHealthTab;
        this.ivShieldBar = ivShieldBar;
        this.ivShieldTab = ivShieldTab;
        this.layoutAcsUpg = layoutAcsUpg;
        this.layoutGuards = layoutGuards;
        this.layoutVehicle = layoutVehicle;
        this.layoutWarehouse = layoutWarehouse;
        this.linearButtons = linearButtons;
        this.parentLayout = parentLayout;
        this.progressBar = progressBar;
        this.rvAccessoriesInventory = rvAccessoriesInventory;
        this.rvCategoryMenu = rvCategoryMenu;
        this.rvGuardInventory = rvGuardInventory;
        this.rvMainInventory = rvMainInventory;
        this.rvSubInventory = rvSubInventory;
        this.rvUpgradesInventory = rvUpgradesInventory;
        this.rvWalletInventory = rvWalletInventory;
        this.tvFoodCount = tvFoodCount;
        this.tvHealthCount = tvHealthCount;
        this.tvInventory = tvInventory;
        this.tvShieldCount = tvShieldCount;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MainInventoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MainInventoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.main_inventory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static MainInventoryBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btnAccessories;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btnBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.btnMedbook;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                if (appCompatButton != null) {
                    i = R.id.btnPassport;
                    AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatButton2 != null) {
                        i = R.id.btnSortItems;
                        AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatButton3 != null) {
                            i = R.id.btnStats;
                            AppCompatButton appCompatButton4 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatButton4 != null) {
                                i = R.id.btnUpgrades;
                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                                if (button2 != null) {
                                    i = R.id.btnVipStatus;
                                    AppCompatButton appCompatButton5 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatButton5 != null) {
                                        i = R.id.btnWallet;
                                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, i);
                                        if (button3 != null) {
                                            i = R.id.groupCharacter;
                                            Group group = (Group) ViewBindings.findChildViewById(rootView, i);
                                            if (group != null) {
                                                i = R.id.groupCharacterInfo;
                                                Group group2 = (Group) ViewBindings.findChildViewById(rootView, i);
                                                if (group2 != null) {
                                                    i = R.id.guidelineHor1;
                                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline != null) {
                                                        i = R.id.guidelineHor2;
                                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                        if (guideline2 != null) {
                                                            i = R.id.guidelineHor4;
                                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                            if (guideline3 != null) {
                                                                i = R.id.guidelineHor5;
                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline4 != null) {
                                                                    i = R.id.guidelineVer1;
                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                    if (guideline5 != null) {
                                                                        i = R.id.guidelineVer2;
                                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                        if (guideline6 != null) {
                                                                            i = R.id.guidelineVer3;
                                                                            Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                            if (guideline7 != null) {
                                                                                i = R.id.guidelineVer4;
                                                                                Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                if (guideline8 != null) {
                                                                                    i = R.id.ivCharacterImage;
                                                                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (appCompatImageView2 != null) {
                                                                                        i = R.id.ivFoodBar;
                                                                                        LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (linearProgressIndicator != null) {
                                                                                            i = R.id.ivFoodTab;
                                                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (appCompatImageView3 != null) {
                                                                                                i = R.id.ivHealthBar;
                                                                                                LinearProgressIndicator linearProgressIndicator2 = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (linearProgressIndicator2 != null) {
                                                                                                    i = R.id.ivHealthTab;
                                                                                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (appCompatImageView4 != null) {
                                                                                                        i = R.id.ivShieldBar;
                                                                                                        LinearProgressIndicator linearProgressIndicator3 = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (linearProgressIndicator3 != null) {
                                                                                                            i = R.id.ivShieldTab;
                                                                                                            AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (appCompatImageView5 != null) {
                                                                                                                i = R.id.layoutAcsUpg;
                                                                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (constraintLayout != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.layoutGuards))) != null) {
                                                                                                                    LayoutGuardInventoryBinding bind = LayoutGuardInventoryBinding.bind(findChildViewById);
                                                                                                                    i = R.id.layoutVehicle;
                                                                                                                    View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (findChildViewById2 != null) {
                                                                                                                        LayoutVehicleInventoryBinding bind2 = LayoutVehicleInventoryBinding.bind(findChildViewById2);
                                                                                                                        i = R.id.layoutWarehouse;
                                                                                                                        View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (findChildViewById3 != null) {
                                                                                                                            LayoutWarehouseBinding bind3 = LayoutWarehouseBinding.bind(findChildViewById3);
                                                                                                                            i = R.id.linearButtons;
                                                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (linearLayout != null) {
                                                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                                                                                                                                i = R.id.progressBar;
                                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (progressBar != null) {
                                                                                                                                    i = R.id.rvAccessoriesInventory;
                                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (recyclerView != null) {
                                                                                                                                        i = R.id.rvCategoryMenu;
                                                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                            i = R.id.rvGuardInventory;
                                                                                                                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (recyclerView3 != null) {
                                                                                                                                                i = R.id.rvMainInventory;
                                                                                                                                                RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (recyclerView4 != null) {
                                                                                                                                                    i = R.id.rvSubInventory;
                                                                                                                                                    RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (recyclerView5 != null) {
                                                                                                                                                        i = R.id.rvUpgradesInventory;
                                                                                                                                                        RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (recyclerView6 != null) {
                                                                                                                                                            i = R.id.rvWalletInventory;
                                                                                                                                                            RecyclerView recyclerView7 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (recyclerView7 != null) {
                                                                                                                                                                i = R.id.tvFoodCount;
                                                                                                                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (appCompatTextView != null) {
                                                                                                                                                                    i = R.id.tvHealthCount;
                                                                                                                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (appCompatTextView2 != null) {
                                                                                                                                                                        i = R.id.tvInventory;
                                                                                                                                                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (appCompatTextView3 != null) {
                                                                                                                                                                            i = R.id.tvShieldCount;
                                                                                                                                                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (appCompatTextView4 != null) {
                                                                                                                                                                                i = R.id.viewLine;
                                                                                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                                if (imageView != null) {
                                                                                                                                                                                    return new MainInventoryBinding(constraintLayout2, button, appCompatImageView, appCompatButton, appCompatButton2, appCompatButton3, appCompatButton4, button2, appCompatButton5, button3, group, group2, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, appCompatImageView2, linearProgressIndicator, appCompatImageView3, linearProgressIndicator2, appCompatImageView4, linearProgressIndicator3, appCompatImageView5, constraintLayout, bind, bind2, bind3, linearLayout, constraintLayout2, progressBar, recyclerView, recyclerView2, recyclerView3, recyclerView4, recyclerView5, recyclerView6, recyclerView7, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, imageView);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
