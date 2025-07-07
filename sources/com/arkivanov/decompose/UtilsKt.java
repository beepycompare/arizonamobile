package com.arkivanov.decompose;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0007\u001aF\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\u0002\"\b\b\u0001\u0010\f*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\u000fH\u0000\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006\u0010"}, d2 = {"hashString", "", "", "keyHashString", "Lcom/arkivanov/decompose/Child;", "isDestroyed", "", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle;)Z", "keyed", "", ExifInterface.GPS_DIRECTION_TRUE, "C", "", "configuration", "Lkotlin/Function1;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final String hashString(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        StringBuilder sb = new StringBuilder();
        String uniqueName = Utils_nonJsKt.getUniqueName(Reflection.getOrCreateKotlinClass(obj.getClass()));
        if (uniqueName == null) {
            uniqueName = Reflection.getOrCreateKotlinClass(obj.getClass()).getSimpleName();
        }
        StringBuilder append = sb.append(uniqueName).append('_');
        String num = Integer.toString(obj.hashCode(), CharsKt.checkRadix(36));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return append.append(num).toString();
    }

    public static final String keyHashString(Child<?, ?> child) {
        Intrinsics.checkNotNullParameter(child, "<this>");
        StringBuilder sb = new StringBuilder();
        String uniqueName = Utils_nonJsKt.getUniqueName(Reflection.getOrCreateKotlinClass(child.getConfiguration().getClass()));
        if (uniqueName == null) {
            uniqueName = Reflection.getOrCreateKotlinClass(child.getConfiguration().getClass()).getSimpleName();
        }
        StringBuilder append = sb.append(uniqueName).append('_');
        String num = Integer.toString(child.getKey().hashCode(), CharsKt.checkRadix(36));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return append.append(num).toString();
    }

    public static final boolean isDestroyed(Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        return lifecycle.getState() == Lifecycle.State.DESTROYED;
    }

    public static final <T, C> Map<Object, T> keyed(List<? extends T> list, Function1<? super T, ? extends C> configuration) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        HashMap hashMap = new HashMap();
        List<? extends T> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            C invoke = configuration.invoke(obj);
            Integer num = (Integer) hashMap.get(invoke);
            int intValue = (num != null ? num.intValue() : 0) + 1;
            hashMap.put(invoke, Integer.valueOf(intValue));
            linkedHashMap.put(TuplesKt.to(invoke, Integer.valueOf(intValue)), obj);
        }
        return linkedHashMap;
    }
}
