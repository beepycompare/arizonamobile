package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class HudTaximeterBinding implements ViewBinding {
    public final HudCounterAccumulatedEnergyBinding accumulatedEnergy;
    public final HudCounterBusConditionBinding busCondition;
    public final HudCounterBinding counter;
    public final HudCounterDistanceToHomeBinding distanceToHome;
    public final HudCounterFranclinSteinBinding franclinStein;
    public final HudCounterGhostsBinding ghosts;
    public final HudCounterHalloweenCoinsBinding halloweenCoins;
    public final HudTaximeterStopwatchBinding hudTaximeterArmySecond;
    public final HudTaximeterContainerBinding hudTaximeterLayoutContainer;
    public final HudCounterKilledZombiesBinding killedZombies;
    public final HudCounterLordRingsBinding lordRigns;
    public final HudCounterNoiseLevelBinding noiseLevel;
    private final FrameLayout rootView;
    public final HudCounterZombieModeBinding zombieMode;

    private HudTaximeterBinding(FrameLayout rootView, HudCounterAccumulatedEnergyBinding accumulatedEnergy, HudCounterBusConditionBinding busCondition, HudCounterBinding counter, HudCounterDistanceToHomeBinding distanceToHome, HudCounterFranclinSteinBinding franclinStein, HudCounterGhostsBinding ghosts, HudCounterHalloweenCoinsBinding halloweenCoins, HudTaximeterStopwatchBinding hudTaximeterArmySecond, HudTaximeterContainerBinding hudTaximeterLayoutContainer, HudCounterKilledZombiesBinding killedZombies, HudCounterLordRingsBinding lordRigns, HudCounterNoiseLevelBinding noiseLevel, HudCounterZombieModeBinding zombieMode) {
        this.rootView = rootView;
        this.accumulatedEnergy = accumulatedEnergy;
        this.busCondition = busCondition;
        this.counter = counter;
        this.distanceToHome = distanceToHome;
        this.franclinStein = franclinStein;
        this.ghosts = ghosts;
        this.halloweenCoins = halloweenCoins;
        this.hudTaximeterArmySecond = hudTaximeterArmySecond;
        this.hudTaximeterLayoutContainer = hudTaximeterLayoutContainer;
        this.killedZombies = killedZombies;
        this.lordRigns = lordRigns;
        this.noiseLevel = noiseLevel;
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
            i = R.id.bus_condition;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null) {
                HudCounterBusConditionBinding bind2 = HudCounterBusConditionBinding.bind(findChildViewById2);
                i = R.id.counter;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById3 != null) {
                    HudCounterBinding bind3 = HudCounterBinding.bind(findChildViewById3);
                    i = R.id.distance_to_home;
                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById4 != null) {
                        HudCounterDistanceToHomeBinding bind4 = HudCounterDistanceToHomeBinding.bind(findChildViewById4);
                        i = R.id.franclin_stein;
                        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById5 != null) {
                            HudCounterFranclinSteinBinding bind5 = HudCounterFranclinSteinBinding.bind(findChildViewById5);
                            i = R.id.ghosts;
                            View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById6 != null) {
                                HudCounterGhostsBinding bind6 = HudCounterGhostsBinding.bind(findChildViewById6);
                                i = R.id.halloween_coins;
                                View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById7 != null) {
                                    HudCounterHalloweenCoinsBinding bind7 = HudCounterHalloweenCoinsBinding.bind(findChildViewById7);
                                    i = R.id.hud_taximeter_army_second;
                                    View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById8 != null) {
                                        HudTaximeterStopwatchBinding bind8 = HudTaximeterStopwatchBinding.bind(findChildViewById8);
                                        i = R.id.hud_taximeter_layout_container;
                                        View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                        if (findChildViewById9 != null) {
                                            HudTaximeterContainerBinding bind9 = HudTaximeterContainerBinding.bind(findChildViewById9);
                                            i = R.id.killed_zombies;
                                            View findChildViewById10 = ViewBindings.findChildViewById(rootView, i);
                                            if (findChildViewById10 != null) {
                                                HudCounterKilledZombiesBinding bind10 = HudCounterKilledZombiesBinding.bind(findChildViewById10);
                                                i = R.id.lord_rigns;
                                                View findChildViewById11 = ViewBindings.findChildViewById(rootView, i);
                                                if (findChildViewById11 != null) {
                                                    HudCounterLordRingsBinding bind11 = HudCounterLordRingsBinding.bind(findChildViewById11);
                                                    i = R.id.noise_level;
                                                    View findChildViewById12 = ViewBindings.findChildViewById(rootView, i);
                                                    if (findChildViewById12 != null) {
                                                        HudCounterNoiseLevelBinding bind12 = HudCounterNoiseLevelBinding.bind(findChildViewById12);
                                                        i = R.id.zombie_mode;
                                                        View findChildViewById13 = ViewBindings.findChildViewById(rootView, i);
                                                        if (findChildViewById13 != null) {
                                                            return new HudTaximeterBinding((FrameLayout) rootView, bind, bind2, bind3, bind4, bind5, bind6, bind7, bind8, bind9, bind10, bind11, bind12, HudCounterZombieModeBinding.bind(findChildViewById13));
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
