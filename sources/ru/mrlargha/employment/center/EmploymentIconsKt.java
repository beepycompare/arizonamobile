package ru.mrlargha.employment.center;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.employment.center.R;
/* compiled from: EmploymentIcons.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"employmentIcon", "", "name", "", "employment-center_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmploymentIconsKt {
    public static final int employmentIcon(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        switch (name.hashCode()) {
            case -1801158984:
                if (name.equals("parkingValet")) {
                    return R.drawable.employment_center_parking;
                }
                break;
            case -1284970818:
                if (name.equals("roadWorker")) {
                    return R.drawable.employment_center_road;
                }
                break;
            case -1224361475:
                if (name.equals("hauler")) {
                    return R.drawable.employment_center_hauler;
                }
                break;
            case -1192590353:
                if (name.equals("foodCourier")) {
                    return R.drawable.employment_center_food;
                }
                break;
            case -965952153:
                if (name.equals("truckDriver")) {
                    return R.drawable.employment_center_truck;
                }
                break;
            case -948305579:
                if (name.equals("forkliftDriver")) {
                    return R.drawable.employment_center_forklift;
                }
                break;
            case -930312316:
                if (name.equals("mechanic")) {
                    return R.drawable.employment_center_mechanic;
                }
                break;
            case -876417064:
                if (name.equals("garbageCollector")) {
                    return R.drawable.employment_center_garbage;
                }
                break;
            case -543507412:
                if (name.equals("oilBarrelDelivery")) {
                    return R.drawable.employment_center_oil;
                }
                break;
            case -391198534:
                if (name.equals("postman")) {
                    return R.drawable.employment_center_postman;
                }
                break;
            case -298750679:
                if (name.equals("lifeguard")) {
                    return R.drawable.employment_center_lifeguard;
                }
                break;
            case -79774317:
                if (name.equals("moversChief")) {
                    return R.drawable.employment_center_movers;
                }
                break;
            case 3552798:
                if (name.equals("taxi")) {
                    return R.drawable.employment_center_taxi;
                }
                break;
            case 106669752:
                if (name.equals("pilot")) {
                    return R.drawable.employment_center_pilot;
                }
                break;
            case 345731058:
                if (name.equals("tramDriver")) {
                    return R.drawable.employment_center_tram;
                }
                break;
            case 444157634:
                if (name.equals("plantManager")) {
                    return R.drawable.employment_center_plant;
                }
                break;
            case 675518868:
                if (name.equals("fishSales")) {
                    return R.drawable.employment_center_fish;
                }
                break;
            case 792943258:
                if (name.equals("cashCollector")) {
                    return R.drawable.employment_center_cash_collector;
                }
                break;
            case 838850094:
                if (name.equals("hotdogSeller")) {
                    return R.drawable.employment_center_hotdog;
                }
                break;
            case 988974520:
                if (name.equals("offshoreBarrelDelivery")) {
                    return R.drawable.employment_center_offshore;
                }
                break;
            case 1057869904:
                if (name.equals("trainDriver")) {
                    return R.drawable.employment_center_train;
                }
                break;
            case 1075216739:
                if (name.equals("headFarmer")) {
                    return R.drawable.employment_center_farmer;
                }
                break;
            case 1141527708:
                if (name.equals("pizzaDelivery")) {
                    return R.drawable.employment_center_pizza;
                }
                break;
            case 2047484616:
                if (name.equals("busDriver")) {
                    return R.drawable.employment_center_bus;
                }
                break;
        }
        return R.drawable.employment_center_plant;
    }
}
