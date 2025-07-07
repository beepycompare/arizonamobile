package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutGuardInventoryBinding implements ViewBinding {
    public final LayoutGuardBtnInventoryBinding btnGuardInventory;
    public final LayoutGuardBtnMenuBinding btnGuardMenu;
    public final AppCompatButton btnGuardTypeFour;
    public final AppCompatButton btnGuardTypeOne;
    public final AppCompatButton btnGuardTypeThree;
    public final AppCompatButton btnGuardTypeTwo;
    public final LinearLayout guardInfo;
    public final LinearLayout guardInfoButtons;
    public final LinearLayout guardName;
    public final LinearLayout guardTypeButtons;
    public final AppCompatImageView ivGuardDamageTab;
    public final AppCompatImageView ivGuardHealthTab;
    public final AppCompatImageView ivGuardShieldTab;
    public final AppCompatImageView ivGuardSkin;
    public final CardView layoutGuardInfo;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvGuardSubInventory;
    public final AppCompatTextView tvGuardDamage;
    public final AppCompatTextView tvGuardDamageCount;
    public final AppCompatTextView tvGuardExpPoints;
    public final AppCompatTextView tvGuardHealth;
    public final AppCompatTextView tvGuardHealthCount;
    public final AppCompatTextView tvGuardLevel;
    public final AppCompatTextView tvGuardName;
    public final AppCompatTextView tvGuardShield;
    public final AppCompatTextView tvGuardShieldCount;
    public final AppCompatTextView tvGuardStatus;
    public final AppCompatTextView tvGuardType;

    private LayoutGuardInventoryBinding(ConstraintLayout rootView, LayoutGuardBtnInventoryBinding btnGuardInventory, LayoutGuardBtnMenuBinding btnGuardMenu, AppCompatButton btnGuardTypeFour, AppCompatButton btnGuardTypeOne, AppCompatButton btnGuardTypeThree, AppCompatButton btnGuardTypeTwo, LinearLayout guardInfo, LinearLayout guardInfoButtons, LinearLayout guardName, LinearLayout guardTypeButtons, AppCompatImageView ivGuardDamageTab, AppCompatImageView ivGuardHealthTab, AppCompatImageView ivGuardShieldTab, AppCompatImageView ivGuardSkin, CardView layoutGuardInfo, ConstraintLayout parentLayout, RecyclerView rvGuardSubInventory, AppCompatTextView tvGuardDamage, AppCompatTextView tvGuardDamageCount, AppCompatTextView tvGuardExpPoints, AppCompatTextView tvGuardHealth, AppCompatTextView tvGuardHealthCount, AppCompatTextView tvGuardLevel, AppCompatTextView tvGuardName, AppCompatTextView tvGuardShield, AppCompatTextView tvGuardShieldCount, AppCompatTextView tvGuardStatus, AppCompatTextView tvGuardType) {
        this.rootView = rootView;
        this.btnGuardInventory = btnGuardInventory;
        this.btnGuardMenu = btnGuardMenu;
        this.btnGuardTypeFour = btnGuardTypeFour;
        this.btnGuardTypeOne = btnGuardTypeOne;
        this.btnGuardTypeThree = btnGuardTypeThree;
        this.btnGuardTypeTwo = btnGuardTypeTwo;
        this.guardInfo = guardInfo;
        this.guardInfoButtons = guardInfoButtons;
        this.guardName = guardName;
        this.guardTypeButtons = guardTypeButtons;
        this.ivGuardDamageTab = ivGuardDamageTab;
        this.ivGuardHealthTab = ivGuardHealthTab;
        this.ivGuardShieldTab = ivGuardShieldTab;
        this.ivGuardSkin = ivGuardSkin;
        this.layoutGuardInfo = layoutGuardInfo;
        this.parentLayout = parentLayout;
        this.rvGuardSubInventory = rvGuardSubInventory;
        this.tvGuardDamage = tvGuardDamage;
        this.tvGuardDamageCount = tvGuardDamageCount;
        this.tvGuardExpPoints = tvGuardExpPoints;
        this.tvGuardHealth = tvGuardHealth;
        this.tvGuardHealthCount = tvGuardHealthCount;
        this.tvGuardLevel = tvGuardLevel;
        this.tvGuardName = tvGuardName;
        this.tvGuardShield = tvGuardShield;
        this.tvGuardShieldCount = tvGuardShieldCount;
        this.tvGuardStatus = tvGuardStatus;
        this.tvGuardType = tvGuardType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutGuardInventoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutGuardInventoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_guard_inventory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutGuardInventoryBinding bind(View rootView) {
        int i = R.id.btnGuardInventory;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            LayoutGuardBtnInventoryBinding bind = LayoutGuardBtnInventoryBinding.bind(findChildViewById);
            i = R.id.btnGuardMenu;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null) {
                LayoutGuardBtnMenuBinding bind2 = LayoutGuardBtnMenuBinding.bind(findChildViewById2);
                i = R.id.btnGuardTypeFour;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                if (appCompatButton != null) {
                    i = R.id.btnGuardTypeOne;
                    AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatButton2 != null) {
                        i = R.id.btnGuardTypeThree;
                        AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatButton3 != null) {
                            i = R.id.btnGuardTypeTwo;
                            AppCompatButton appCompatButton4 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatButton4 != null) {
                                i = R.id.guardInfo;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout != null) {
                                    i = R.id.guardInfoButtons;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.guardName;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.guardTypeButtons;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.ivGuardDamageTab;
                                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (appCompatImageView != null) {
                                                    i = R.id.ivGuardHealthTab;
                                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (appCompatImageView2 != null) {
                                                        i = R.id.ivGuardShieldTab;
                                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (appCompatImageView3 != null) {
                                                            i = R.id.ivGuardSkin;
                                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (appCompatImageView4 != null) {
                                                                i = R.id.layout_guard_info;
                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                                                                if (cardView != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                    i = R.id.rvGuardSubInventory;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.tvGuardDamage;
                                                                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (appCompatTextView != null) {
                                                                            i = R.id.tvGuardDamageCount;
                                                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (appCompatTextView2 != null) {
                                                                                i = R.id.tvGuardExpPoints;
                                                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (appCompatTextView3 != null) {
                                                                                    i = R.id.tvGuardHealth;
                                                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (appCompatTextView4 != null) {
                                                                                        i = R.id.tvGuardHealthCount;
                                                                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (appCompatTextView5 != null) {
                                                                                            i = R.id.tvGuardLevel;
                                                                                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (appCompatTextView6 != null) {
                                                                                                i = R.id.tvGuardName;
                                                                                                AppCompatTextView appCompatTextView7 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (appCompatTextView7 != null) {
                                                                                                    i = R.id.tvGuardShield;
                                                                                                    AppCompatTextView appCompatTextView8 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (appCompatTextView8 != null) {
                                                                                                        i = R.id.tvGuardShieldCount;
                                                                                                        AppCompatTextView appCompatTextView9 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (appCompatTextView9 != null) {
                                                                                                            i = R.id.tvGuardStatus;
                                                                                                            AppCompatTextView appCompatTextView10 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (appCompatTextView10 != null) {
                                                                                                                i = R.id.tvGuardType;
                                                                                                                AppCompatTextView appCompatTextView11 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (appCompatTextView11 != null) {
                                                                                                                    return new LayoutGuardInventoryBinding(constraintLayout, bind, bind2, appCompatButton, appCompatButton2, appCompatButton3, appCompatButton4, linearLayout, linearLayout2, linearLayout3, linearLayout4, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, cardView, constraintLayout, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10, appCompatTextView11);
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
