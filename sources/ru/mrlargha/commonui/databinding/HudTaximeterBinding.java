package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudTaximeterBinding implements ViewBinding {
    public final HudCounterAccumulatedEnergyBinding accumulatedEnergy;
    public final HudCounterBaseJumpingBinding baseJumping;
    public final HudCounterBrokingIceBinding brokingIce;
    public final HudCounterBusConditionBinding busCondition;
    public final HudCounterCombineConditionBinding combineCondition;
    public final HudCounterConditionPackageBinding conditionPackage;
    public final HudCounterConditionSledBinding conditionSled;
    public final HudCounterBinding counter;
    public final HudCounterDeliveryGiftsBinding deliveryGifts;
    public final HudCounterDistanceToHomeBinding distanceToHome;
    public final HudCounterEscapeBinding escape;
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
    public final HudCounterShootingGalleryBinding shootingGallery;
    public final HudSupplyBinding supply;
    public final HudCounterTofuCoolingBinding tofuCooling;
    public final HudCounterZombieModeBinding zombieMode;

    private HudTaximeterBinding(FrameLayout rootView, HudCounterAccumulatedEnergyBinding accumulatedEnergy, HudCounterBaseJumpingBinding baseJumping, HudCounterBrokingIceBinding brokingIce, HudCounterBusConditionBinding busCondition, HudCounterCombineConditionBinding combineCondition, HudCounterConditionPackageBinding conditionPackage, HudCounterConditionSledBinding conditionSled, HudCounterBinding counter, HudCounterDeliveryGiftsBinding deliveryGifts, HudCounterDistanceToHomeBinding distanceToHome, HudCounterEscapeBinding escape, HudCounterFranclinSteinBinding franclinStein, HudCounterGhostsBinding ghosts, HudCounterHalloweenCoinsBinding halloweenCoins, HudTaximeterStopwatchBinding hudTaximeterArmySecond, HudTaximeterContainerBinding hudTaximeterLayoutContainer, HudCounterKilledZombiesBinding killedZombies, HudCounterLordRingsBinding lordRigns, HudCounterNewYearBinding newYearTaxi, HudCounterNoiseLevelBinding noiseLevel, HudCounterRollingSnowballBinding rollingSnowball, HudCounterSearchCrystalsBinding searchCrystal, HudCounterShootingGalleryBinding shootingGallery, HudSupplyBinding supply, HudCounterTofuCoolingBinding tofuCooling, HudCounterZombieModeBinding zombieMode) {
        this.rootView = rootView;
        this.accumulatedEnergy = accumulatedEnergy;
        this.baseJumping = baseJumping;
        this.brokingIce = brokingIce;
        this.busCondition = busCondition;
        this.combineCondition = combineCondition;
        this.conditionPackage = conditionPackage;
        this.conditionSled = conditionSled;
        this.counter = counter;
        this.deliveryGifts = deliveryGifts;
        this.distanceToHome = distanceToHome;
        this.escape = escape;
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
        this.shootingGallery = shootingGallery;
        this.supply = supply;
        this.tofuCooling = tofuCooling;
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
                        i = R.id.combine_condition;
                        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById5 != null) {
                            HudCounterCombineConditionBinding bind5 = HudCounterCombineConditionBinding.bind(findChildViewById5);
                            i = R.id.condition_package;
                            View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById6 != null) {
                                HudCounterConditionPackageBinding bind6 = HudCounterConditionPackageBinding.bind(findChildViewById6);
                                i = R.id.condition_sled;
                                View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById7 != null) {
                                    HudCounterConditionSledBinding bind7 = HudCounterConditionSledBinding.bind(findChildViewById7);
                                    i = R.id.counter;
                                    View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById8 != null) {
                                        HudCounterBinding bind8 = HudCounterBinding.bind(findChildViewById8);
                                        i = R.id.delivery_gifts;
                                        View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                        if (findChildViewById9 != null) {
                                            HudCounterDeliveryGiftsBinding bind9 = HudCounterDeliveryGiftsBinding.bind(findChildViewById9);
                                            i = R.id.distance_to_home;
                                            View findChildViewById10 = ViewBindings.findChildViewById(rootView, i);
                                            if (findChildViewById10 != null) {
                                                HudCounterDistanceToHomeBinding bind10 = HudCounterDistanceToHomeBinding.bind(findChildViewById10);
                                                i = R.id.escape;
                                                View findChildViewById11 = ViewBindings.findChildViewById(rootView, i);
                                                if (findChildViewById11 != null) {
                                                    HudCounterEscapeBinding bind11 = HudCounterEscapeBinding.bind(findChildViewById11);
                                                    i = R.id.franclin_stein;
                                                    View findChildViewById12 = ViewBindings.findChildViewById(rootView, i);
                                                    if (findChildViewById12 != null) {
                                                        HudCounterFranclinSteinBinding bind12 = HudCounterFranclinSteinBinding.bind(findChildViewById12);
                                                        i = R.id.ghosts;
                                                        View findChildViewById13 = ViewBindings.findChildViewById(rootView, i);
                                                        if (findChildViewById13 != null) {
                                                            HudCounterGhostsBinding bind13 = HudCounterGhostsBinding.bind(findChildViewById13);
                                                            i = R.id.halloween_coins;
                                                            View findChildViewById14 = ViewBindings.findChildViewById(rootView, i);
                                                            if (findChildViewById14 != null) {
                                                                HudCounterHalloweenCoinsBinding bind14 = HudCounterHalloweenCoinsBinding.bind(findChildViewById14);
                                                                i = R.id.hud_taximeter_army_second;
                                                                View findChildViewById15 = ViewBindings.findChildViewById(rootView, i);
                                                                if (findChildViewById15 != null) {
                                                                    HudTaximeterStopwatchBinding bind15 = HudTaximeterStopwatchBinding.bind(findChildViewById15);
                                                                    i = R.id.hud_taximeter_layout_container;
                                                                    View findChildViewById16 = ViewBindings.findChildViewById(rootView, i);
                                                                    if (findChildViewById16 != null) {
                                                                        HudTaximeterContainerBinding bind16 = HudTaximeterContainerBinding.bind(findChildViewById16);
                                                                        i = R.id.killed_zombies;
                                                                        View findChildViewById17 = ViewBindings.findChildViewById(rootView, i);
                                                                        if (findChildViewById17 != null) {
                                                                            HudCounterKilledZombiesBinding bind17 = HudCounterKilledZombiesBinding.bind(findChildViewById17);
                                                                            i = R.id.lord_rigns;
                                                                            View findChildViewById18 = ViewBindings.findChildViewById(rootView, i);
                                                                            if (findChildViewById18 != null) {
                                                                                HudCounterLordRingsBinding bind18 = HudCounterLordRingsBinding.bind(findChildViewById18);
                                                                                i = R.id.new_year_taxi;
                                                                                View findChildViewById19 = ViewBindings.findChildViewById(rootView, i);
                                                                                if (findChildViewById19 != null) {
                                                                                    HudCounterNewYearBinding bind19 = HudCounterNewYearBinding.bind(findChildViewById19);
                                                                                    i = R.id.noise_level;
                                                                                    View findChildViewById20 = ViewBindings.findChildViewById(rootView, i);
                                                                                    if (findChildViewById20 != null) {
                                                                                        HudCounterNoiseLevelBinding bind20 = HudCounterNoiseLevelBinding.bind(findChildViewById20);
                                                                                        i = R.id.rolling_snowball;
                                                                                        View findChildViewById21 = ViewBindings.findChildViewById(rootView, i);
                                                                                        if (findChildViewById21 != null) {
                                                                                            HudCounterRollingSnowballBinding bind21 = HudCounterRollingSnowballBinding.bind(findChildViewById21);
                                                                                            i = R.id.search_crystal;
                                                                                            View findChildViewById22 = ViewBindings.findChildViewById(rootView, i);
                                                                                            if (findChildViewById22 != null) {
                                                                                                HudCounterSearchCrystalsBinding bind22 = HudCounterSearchCrystalsBinding.bind(findChildViewById22);
                                                                                                i = R.id.shooting_gallery;
                                                                                                View findChildViewById23 = ViewBindings.findChildViewById(rootView, i);
                                                                                                if (findChildViewById23 != null) {
                                                                                                    HudCounterShootingGalleryBinding bind23 = HudCounterShootingGalleryBinding.bind(findChildViewById23);
                                                                                                    i = R.id.supply;
                                                                                                    View findChildViewById24 = ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (findChildViewById24 != null) {
                                                                                                        HudSupplyBinding bind24 = HudSupplyBinding.bind(findChildViewById24);
                                                                                                        i = R.id.tofu_cooling;
                                                                                                        View findChildViewById25 = ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (findChildViewById25 != null) {
                                                                                                            HudCounterTofuCoolingBinding bind25 = HudCounterTofuCoolingBinding.bind(findChildViewById25);
                                                                                                            i = R.id.zombie_mode;
                                                                                                            View findChildViewById26 = ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (findChildViewById26 != null) {
                                                                                                                return new HudTaximeterBinding((FrameLayout) rootView, bind, bind2, bind3, bind4, bind5, bind6, bind7, bind8, bind9, bind10, bind11, bind12, bind13, bind14, bind15, bind16, bind17, bind18, bind19, bind20, bind21, bind22, bind23, bind24, bind25, HudCounterZombieModeBinding.bind(findChildViewById26));
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
