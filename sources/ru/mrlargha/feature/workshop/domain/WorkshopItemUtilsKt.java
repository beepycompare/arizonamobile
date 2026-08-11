package ru.mrlargha.feature.workshop.domain;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WorkshopItemUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001aU\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u0001H\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"formatWorkshopAmount", "", "amount", "", "thousandSuffix", "millionSuffix", "formatScaledAmount", "divisor", "suffix", "findUpdatedWorkshopSelection", ExifInterface.GPS_DIRECTION_TRUE, "selected", "inventory", "", "slotOf", "Lkotlin/Function1;", "", "itemIdOf", "(Ljava/lang/Object;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "workshop"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkshopItemUtilsKt {
    public static final String formatWorkshopAmount(long j, String thousandSuffix, String millionSuffix) {
        Intrinsics.checkNotNullParameter(thousandSuffix, "thousandSuffix");
        Intrinsics.checkNotNullParameter(millionSuffix, "millionSuffix");
        if (j >= 1000000) {
            return formatScaledAmount(j, 1000000L, millionSuffix);
        }
        if (j >= 10000) {
            return formatScaledAmount(j, 1000L, thousandSuffix);
        }
        return String.valueOf(j);
    }

    private static final String formatScaledAmount(long j, long j2, String str) {
        return WorkshopItemUtilsKt$$ExternalSyntheticBackportWithForwarding0.m(BigDecimal.valueOf(j).divide(BigDecimal.valueOf(j2), 1, RoundingMode.HALF_UP)).toPlainString() + str;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public static final <T> T findUpdatedWorkshopSelection(T t, List<? extends T> inventory, Function1<? super T, Integer> slotOf, Function1<? super T, Integer> itemIdOf) {
        Integer invoke;
        Integer invoke2;
        Intrinsics.checkNotNullParameter(inventory, "inventory");
        Intrinsics.checkNotNullParameter(slotOf, "slotOf");
        Intrinsics.checkNotNullParameter(itemIdOf, "itemIdOf");
        if (t != null && (invoke = itemIdOf.invoke(t)) != null) {
            int intValue = invoke.intValue();
            for (T t2 : inventory) {
                if (slotOf.invoke(t2).intValue() == slotOf.invoke(t).intValue() && (invoke2 = itemIdOf.invoke(t2)) != null && invoke2.intValue() == intValue) {
                    return t2;
                }
            }
        }
        return null;
    }
}
