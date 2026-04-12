package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class HudTargetPlateBinding implements ViewBinding {
    public final CustomCardView armorContainer;
    public final LinearLayout bulletContainer;
    public final LinearLayout energyContainer;
    public final LinearLayout infoContainer;
    public final LinearLayout luckContainer;
    public final CustomCardView progressArmor;
    public final CustomCardView progressHealth;
    private final CustomCardView rootView;
    public final LinearLayout shieldContainer;
    public final TextView tvArmor;
    public final TextView tvBullet;
    public final TextView tvEnergy;
    public final TextView tvHealth;
    public final TextView tvLevel;
    public final TextView tvLuck;
    public final TextView tvShield;
    public final TextView tvUserName;
    public final TextView tvUserNumber;

    private HudTargetPlateBinding(CustomCardView rootView, CustomCardView armorContainer, LinearLayout bulletContainer, LinearLayout energyContainer, LinearLayout infoContainer, LinearLayout luckContainer, CustomCardView progressArmor, CustomCardView progressHealth, LinearLayout shieldContainer, TextView tvArmor, TextView tvBullet, TextView tvEnergy, TextView tvHealth, TextView tvLevel, TextView tvLuck, TextView tvShield, TextView tvUserName, TextView tvUserNumber) {
        this.rootView = rootView;
        this.armorContainer = armorContainer;
        this.bulletContainer = bulletContainer;
        this.energyContainer = energyContainer;
        this.infoContainer = infoContainer;
        this.luckContainer = luckContainer;
        this.progressArmor = progressArmor;
        this.progressHealth = progressHealth;
        this.shieldContainer = shieldContainer;
        this.tvArmor = tvArmor;
        this.tvBullet = tvBullet;
        this.tvEnergy = tvEnergy;
        this.tvHealth = tvHealth;
        this.tvLevel = tvLevel;
        this.tvLuck = tvLuck;
        this.tvShield = tvShield;
        this.tvUserName = tvUserName;
        this.tvUserNumber = tvUserNumber;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static HudTargetPlateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTargetPlateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_target_plate, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTargetPlateBinding bind(View rootView) {
        int i = R.id.armor_container;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.bullet_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.energy_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.info_container;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout3 != null) {
                        i = R.id.luck_container;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout4 != null) {
                            i = R.id.progress_armor;
                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView2 != null) {
                                i = R.id.progress_health;
                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                if (customCardView3 != null) {
                                    i = R.id.shield_container;
                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout5 != null) {
                                        i = R.id.tv_armor;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            i = R.id.tv_bullet;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_energy;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_health;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_level;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_luck;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_shield;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_user_name;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.tv_user_number;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView9 != null) {
                                                                            return new HudTargetPlateBinding((CustomCardView) rootView, customCardView, linearLayout, linearLayout2, linearLayout3, linearLayout4, customCardView2, customCardView3, linearLayout5, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
