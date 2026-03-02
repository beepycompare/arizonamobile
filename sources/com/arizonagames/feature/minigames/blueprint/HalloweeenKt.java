package com.arizonagames.feature.minigames.blueprint;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: Halloweeen.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\"\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"halloweenList", "", "Lcom/arizonagames/feature/minigames/blueprint/HalloweenObject;", "getHalloweenList", "()Ljava/util/List;", "halloweenGameVariation1", "Lcom/arizonagames/feature/minigames/blueprint/HalloweenGameVariation;", "getHalloweenGameVariation1", "()Lcom/arizonagames/feature/minigames/blueprint/HalloweenGameVariation;", "halloweenGameVariation2", "getHalloweenGameVariation2", "halloweenGameVariation3", "getHalloweenGameVariation3", "gamesVariations", "getGamesVariations", "blueprint"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HalloweeenKt {
    private static final List<HalloweenGameVariation> gamesVariations;
    private static final HalloweenGameVariation halloweenGameVariation1;
    private static final HalloweenGameVariation halloweenGameVariation2;
    private static final HalloweenGameVariation halloweenGameVariation3;
    private static final List<HalloweenObject> halloweenList = CollectionsKt.listOf((Object[]) new HalloweenObject[]{new HalloweenObject(1, R.drawable.blueprint_halloween_print1, R.drawable.blueprint_halloween_1, false, 8, null), new HalloweenObject(2, R.drawable.blueprint_halloween_print2, R.drawable.blueprint_halloween_2, false, 8, null), new HalloweenObject(3, R.drawable.blueprint_halloween_print3, R.drawable.blueprint_halloween_3, false, 8, null), new HalloweenObject(4, R.drawable.blueprint_halloween_print4, R.drawable.blueprint_halloween_4, false, 8, null), new HalloweenObject(5, R.drawable.blueprint_halloween_print5, R.drawable.blueprint_halloween_5, false, 8, null), new HalloweenObject(6, R.drawable.blueprint_halloween_print6, R.drawable.blueprint_halloween_6, false, 8, null)});

    public static final List<HalloweenObject> getHalloweenList() {
        return halloweenList;
    }

    public static final HalloweenGameVariation getHalloweenGameVariation1() {
        return halloweenGameVariation1;
    }

    static {
        HalloweenGameVariation halloweenGameVariation = new HalloweenGameVariation(CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 6, 2, 4, 5}));
        halloweenGameVariation1 = halloweenGameVariation;
        HalloweenGameVariation halloweenGameVariation4 = new HalloweenGameVariation(CollectionsKt.listOf((Object[]) new Integer[]{3, 6, 1, 5, 2, 4}));
        halloweenGameVariation2 = halloweenGameVariation4;
        HalloweenGameVariation halloweenGameVariation5 = new HalloweenGameVariation(CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 4, 3, 6, 5}));
        halloweenGameVariation3 = halloweenGameVariation5;
        gamesVariations = CollectionsKt.listOf((Object[]) new HalloweenGameVariation[]{halloweenGameVariation, halloweenGameVariation4, halloweenGameVariation5});
    }

    public static final HalloweenGameVariation getHalloweenGameVariation2() {
        return halloweenGameVariation2;
    }

    public static final HalloweenGameVariation getHalloweenGameVariation3() {
        return halloweenGameVariation3;
    }

    public static final List<HalloweenGameVariation> getGamesVariations() {
        return gamesVariations;
    }
}
