package ru.rustore.sdk.metrics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Y {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f1426a;

    public Y(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1426a = context.getSharedPreferences("metrics_sdk_sp", 0);
    }
}
