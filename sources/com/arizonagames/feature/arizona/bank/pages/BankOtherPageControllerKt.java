package com.arizonagames.feature.arizona.bank.pages;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
/* compiled from: BankOtherPageController.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"formatBankChestCountdown", "", "remainingSeconds", "", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankOtherPageControllerKt {
    public static final String formatBankChestCountdown(long j) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.ROOT, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(coerceAtLeast / 3600), Long.valueOf((coerceAtLeast % 3600) / 60), Long.valueOf(coerceAtLeast % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
