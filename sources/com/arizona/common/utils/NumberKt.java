package com.arizona.common.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Number.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0004\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toPx", "", "", "CommonLibs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NumberKt {
    public static final float toPx(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return TypedValue.applyDimension(1, number.floatValue(), Resources.getSystem().getDisplayMetrics());
    }
}
