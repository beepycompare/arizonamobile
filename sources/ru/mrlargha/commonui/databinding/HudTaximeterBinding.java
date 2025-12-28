package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudTaximeterBinding implements ViewBinding {
    public final HudCounterAccumulatedEnergyBinding accumulatedEnergy;
    public final HudCounterBaseJumpingBinding baseJumping;
    public final HudCounterBrokingIceBinding brokingIce;
    public final HudCounterBusConditionBinding busCondition;
    public final HudCounterConditionPackageBinding conditionPackage;
    public final HudCounterConditionSledBinding conditionSled;
    public final HudCounterBinding counter;
    public final HudCounterDeliveryGiftsBinding deliveryGifts;
    public final HudCounterDistanceToHomeBinding distanceToHome;
    public final HudCounterFranclinSteinBinding franclinStein;
    public final HudCounterGhostsBinding ghosts;
    public final HudCounterHalloweenCoinsBinding halloweenCoins;
    public final HudTaximeterStopwatchBinding hudTaximeterArmySecond;
    public final HudTaximeterContainerBinding hudTaximeterLayoutContainer;
    public final HudCounterKilledZombiesBinding killedZombies;
    public final HudCounterLordRingsBinding lordRigns;
    public final HudCounterNewYearBinding newYearTaxi;
    public final HudCounterNoiseLevelBinding noiseLevel;
    public final HudCounterRollingSnowballBinding rollingSnowball;
    private final FrameLayout rootView;
    public final HudCounterSearchCrystalsBinding searchCrystal;
    public final HudCounterZombieModeBinding zombieMode;

    private HudTaximeterBinding(FrameLayout rootView, HudCounterAccumulatedEnergyBinding accumulatedEnergy, HudCounterBaseJumpingBinding baseJumping, HudCounterBrokingIceBinding brokingIce, HudCounterBusConditionBinding busCondition, HudCounterConditionPackageBinding conditionPackage, HudCounterConditionSledBinding conditionSled, HudCounterBinding counter, HudCounterDeliveryGiftsBinding deliveryGifts, HudCounterDistanceToHomeBinding distanceToHome, HudCounterFranclinSteinBinding franclinStein, HudCounterGhostsBinding ghosts, HudCounterHalloweenCoinsBinding halloweenCoins, HudTaximeterStopwatchBinding hudTaximeterArmySecond, HudTaximeterContainerBinding hudTaximeterLayoutContainer, HudCounterKilledZombiesBinding killedZombies, HudCounterLordRingsBinding lordRigns, HudCounterNewYearBinding newYearTaxi, HudCounterNoiseLevelBinding noiseLevel, HudCounterRollingSnowballBinding rollingSnowball, HudCounterSearchCrystalsBinding searchCrystal, HudCounterZombieModeBinding zombieMode) {
        this.rootView = rootView;
        this.accumulatedEnergy = accumulatedEnergy;
        this.baseJumping = baseJumping;
        this.brokingIce = brokingIce;
        this.busCondition = busCondition;
        this.conditionPackage = conditionPackage;
        this.conditionSled = conditionSled;
        this.counter = counter;
        this.deliveryGifts = deliveryGifts;
        this.distanceToHome = distanceToHome;
        this.franclinStein = franclinStein;
        this.ghosts = ghosts;
        this.halloweenCoins = halloweenCoins;
        this.hudTaximeterArmySecond = hudTaximeterArmySecond;
        this.hudTaximeterLayoutContainer = hudTaximeterLayoutContainer;
        this.killedZombies = killedZombies;
        this.lordRigns = lordRigns;
        this.newYearTaxi = newYearTaxi;
        this.noiseLevel = noiseLevel;
        this.rollingSnowball = rollingSnowball;
        this.searchCrystal = searchCrystal;
        this.zombieMode = zombieMode;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTaximeterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTaximeterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_taximeter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTaximeterBinding bind(View rootView) {
        int i = R.id.accumulated_energy;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            HudCounterAccumulatedEnergyBinding bind = HudCounterAccumulatedEnergyBinding.bind(findChildViewById);
            i = R.id.base_jumping;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null) {
                HudCounterBaseJumpingBinding bind2 = HudCounterBaseJumpingBinding.bind(findChildViewById2);
                i = R.id.broking_ice;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById3 != null) {
                    HudCounterBrokingIceBinding bind3 = HudCounterBrokingIceBinding.bind(findChildViewById3);
                    i = R.id.bus_condition;
                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById4 != null) {
                        HudCounterBusConditionBinding bind4 = HudCounterBusConditionBinding.bind(findChildViewById4);
                        i = R.id.condition_package;
                        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById5 != null) {
                            HudCounterConditionPackageBinding bind5 = HudCounterConditionPackageBinding.bind(findChildViewById5);
                            i = R.id.condition_sled;
                            View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById6 != null) {
                                HudCounterConditionSledBinding bind6 = HudCounterConditionSledBinding.bind(findChildViewById6);
                                i = R.id.counter;
                                View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById7 != null) {
                                    HudCounterBinding bind7 = HudCounterBinding.bind(findChildViewById7);
                                    i = R.id.delivery_gifts;
                                    View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById8 != null) {
                                        HudCounterDeliveryGiftsBinding bind8 = HudCounterDeliveryGiftsBinding.bind(findChildViewById8);
                                        i = R.id.distance_to_home;
                                        View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                        if (findChildViewById9 != null) {
                                            HudCounterDistanceToHomeBinding bind9 = HudCounterDistanceToHomeBinding.bind(findChildViewById9);
                                            i = R.id.franclin_stein;
                                            View findChildViewById10 = ViewBindings.findChildViewById(rootView, i);
                                            if (findChildViewById10 != null) {
                                                HudCounterFranclinSteinBinding bind10 = HudCounterFranclinSteinBinding.bind(findChildViewById10);
                                                i = R.id.ghosts;
                                                View findChildViewById11 = ViewBindings.findChildViewById(rootView, i);
                                                if (findChildViewById11 != null) {
                                                    HudCounterGhostsBinding bind11 = HudCounterGhostsBinding.bind(findChildViewById11);
                                                    i = R.id.halloween_coins;
                                                    View findChildViewById12 = ViewBindings.findChildViewById(rootView, i);
                                                    if (findChildViewById12 != null) {
                                                        HudCounterHalloweenCoinsBinding bind12 = HudCounterHalloweenCoinsBinding.bind(findChildViewById12);
                                                        i = R.id.hud_taximeter_army_second;
                                                        View findChildViewById13 = ViewBindings.findChildViewById(rootView, i);
                                                        if (findChildViewById13 != null) {
                                                            HudTaximeterStopwatchBinding bind13 = HudTaximeterStopwatchBinding.bind(findChildViewById13);
                                                            i = R.id.hud_taximeter_layout_container;
                                                            View findChildViewById14 = ViewBindings.findChildViewById(rootView, i);
                                                            if (findChildViewById14 != null) {
                                                                HudTaximeterContainerBinding bind14 = HudTaximeterContainerBinding.bind(findChildViewById14);
                                                                i = R.id.killed_zombies;
                                                                View findChildViewById15 = ViewBindings.findChildViewById(rootView, i);
                                                                if (findChildViewById15 != null) {
                                                                    HudCounterKilledZombiesBinding bind15 = HudCounterKilledZombiesBinding.bind(findChildViewById15);
                                                                    i = R.id.lord_rigns;
                                                                    View findChildViewById16 = ViewBindings.findChildViewById(rootView, i);
                                                                    if (findChildViewById16 != null) {
                                                                        HudCounterLordRingsBinding bind16 = HudCounterLordRingsBinding.bind(findChildViewById16);
                                                                        i = R.id.new_year_taxi;
                                                                        View findChildViewById17 = ViewBindings.findChildViewById(rootView, i);
                                                                        if (findChildViewById17 != null) {
                                                                            HudCounterNewYearBinding bind17 = HudCounterNewYearBinding.bind(findChildViewById17);
                                                                            i = R.id.noise_level;
                                                                            View findChildViewById18 = ViewBindings.findChildViewById(rootView, i);
                                                                            if (findChildViewById18 != null) {
                                                                                HudCounterNoiseLevelBinding bind18 = HudCounterNoiseLevelBinding.bind(findChildViewById18);
                                                                                i = R.id.rolling_snowball;
                                                                                View findChildViewById19 = ViewBindings.findChildViewById(rootView, i);
                                                                                if (findChildViewById19 != null) {
                                                                                    HudCounterRollingSnowballBinding bind19 = HudCounterRollingSnowballBinding.bind(findChildViewById19);
                                                                                    i = R.id.search_crystal;
                                                                                    View findChildViewById20 = ViewBindings.findChildViewById(rootView, i);
                                                                                    if (findChildViewById20 != null) {
                                                                                        HudCounterSearchCrystalsBinding bind20 = HudCounterSearchCrystalsBinding.bind(findChildViewById20);
                                                                                        i = R.id.zombie_mode;
                                                                                        View findChildViewById21 = ViewBindings.findChildViewById(rootView, i);
                                                                                        if (findChildViewById21 != null) {
                                                                                            return new HudTaximeterBinding((FrameLayout) rootView, bind, bind2, bind3, bind4, bind5, bind6, bind7, bind8, bind9, bind10, bind11, bind12, bind13, bind14, bind15, bind16, bind17, bind18, bind19, bind20, HudCounterZombieModeBinding.bind(findChildViewById21));
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
