package com.arizonagames.feature.minigames.blueprint;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: Snowmen.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\"\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"snowmenList", "", "Lcom/arizonagames/feature/minigames/blueprint/HalloweenObject;", "getSnowmenList", "()Ljava/util/List;", "snowmenGameVariation1", "Lcom/arizonagames/feature/minigames/blueprint/HalloweenGameVariation;", "getSnowmenGameVariation1", "()Lcom/arizonagames/feature/minigames/blueprint/HalloweenGameVariation;", "snowmenGameVariation2", "getSnowmenGameVariation2", "snowmenGameVariation3", "getSnowmenGameVariation3", "snowmenGamesVariations", "getSnowmenGamesVariations", "blueprint_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SnowmenKt {
    private static final HalloweenGameVariation snowmenGameVariation1;
    private static final HalloweenGameVariation snowmenGameVariation2;
    private static final HalloweenGameVariation snowmenGameVariation3;
    private static final List<HalloweenGameVariation> snowmenGamesVariations;
    private static final List<HalloweenObject> snowmenList = CollectionsKt.listOf((Object[]) new HalloweenObject[]{new HalloweenObject(1, R.drawable.blue_print_snowmen_print1, R.drawable.blue_print_snowmen1, false, 8, null), new HalloweenObject(2, R.drawable.blue_print_snowmen_print2, R.drawable.blue_print_snowmen2, false, 8, null), new HalloweenObject(3, R.drawable.blue_print_snowmen_print3, R.drawable.blue_print_snowmen3, false, 8, null), new HalloweenObject(4, R.drawable.blue_print_snowmen_print4, R.drawable.blue_print_snowmen4, false, 8, null), new HalloweenObject(5, R.drawable.blue_print_snowmen_print5, R.drawable.blue_print_snowmen5, false, 8, null), new HalloweenObject(6, R.drawable.blue_print_snowmen_print6, R.drawable.blue_print_snowmen6, false, 8, null)});

    public static final List<HalloweenObject> getSnowmenList() {
        return snowmenList;
    }

    public static final HalloweenGameVariation getSnowmenGameVariation1() {
        return snowmenGameVariation1;
    }

    static {
        HalloweenGameVariation halloweenGameVariation = new HalloweenGameVariation(CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 6, 2, 4, 5}));
        snowmenGameVariation1 = halloweenGameVariation;
        HalloweenGameVariation halloweenGameVariation2 = new HalloweenGameVariation(CollectionsKt.listOf((Object[]) new Integer[]{3, 6, 1, 5, 2, 4}));
        snowmenGameVariation2 = halloweenGameVariation2;
        HalloweenGameVariation halloweenGameVariation3 = new HalloweenGameVariation(CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 4, 3, 6, 5}));
        snowmenGameVariation3 = halloweenGameVariation3;
        snowmenGamesVariations = CollectionsKt.listOf((Object[]) new HalloweenGameVariation[]{halloweenGameVariation, halloweenGameVariation2, halloweenGameVariation3});
    }

    public static final HalloweenGameVariation getSnowmenGameVariation2() {
        return snowmenGameVariation2;
    }

    public static final HalloweenGameVariation getSnowmenGameVariation3() {
        return snowmenGameVariation3;
    }

    public static final List<HalloweenGameVariation> getSnowmenGamesVariations() {
        return snowmenGamesVariations;
    }
}
