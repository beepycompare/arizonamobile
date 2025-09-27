package ru.rustore.sdk.core.util;

import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: CollectionExt.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a$\u0010\t\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"findActivityComponentName", "Landroid/content/ComponentName;", "", "Landroid/content/pm/ResolveInfo;", "releasePackage", "", "debugPackage", "findRuStoreActivityComponentName", "findRuStoreServiceComponentName", "findServiceComponentName", "sdk-public-core_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CollectionExtKt {
    public static final ComponentName findRuStoreServiceComponentName(List<? extends ResolveInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return findServiceComponentName(list, "ru.vk.store", "ru.vk.store.qa");
    }

    public static final ComponentName findRuStoreActivityComponentName(List<? extends ResolveInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return findActivityComponentName(list, "ru.vk.store", "ru.vk.store.qa");
    }

    public static final ComponentName findServiceComponentName(List<? extends ResolveInfo> list, String releasePackage, String debugPackage) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(releasePackage, "releasePackage");
        Intrinsics.checkNotNullParameter(debugPackage, "debugPackage");
        List<? extends ResolveInfo> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (ResolveInfo resolveInfo : list2) {
            Pair pair = TuplesKt.to(resolveInfo.serviceInfo.packageName, resolveInfo);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        ResolveInfo resolveInfo2 = (ResolveInfo) linkedHashMap.get(debugPackage);
        if (resolveInfo2 == null) {
            resolveInfo2 = (ResolveInfo) linkedHashMap.get(releasePackage);
        }
        if (resolveInfo2 != null) {
            return new ComponentName(resolveInfo2.serviceInfo.packageName, resolveInfo2.serviceInfo.name);
        }
        return null;
    }

    public static final ComponentName findActivityComponentName(List<? extends ResolveInfo> list, String releasePackage, String debugPackage) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(releasePackage, "releasePackage");
        Intrinsics.checkNotNullParameter(debugPackage, "debugPackage");
        List<? extends ResolveInfo> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (ResolveInfo resolveInfo : list2) {
            Pair pair = TuplesKt.to(resolveInfo.activityInfo.packageName, resolveInfo);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        ResolveInfo resolveInfo2 = (ResolveInfo) linkedHashMap.get(debugPackage);
        if (resolveInfo2 == null) {
            resolveInfo2 = (ResolveInfo) linkedHashMap.get(releasePackage);
        }
        if (resolveInfo2 != null) {
            return new ComponentName(resolveInfo2.activityInfo.packageName, resolveInfo2.activityInfo.name);
        }
        return null;
    }
}
