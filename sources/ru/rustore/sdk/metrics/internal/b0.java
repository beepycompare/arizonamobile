package ru.rustore.sdk.metrics.internal;

import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class b0 {
    public static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Y f1593a;
    public final c0 b;

    public b0(Y sharedPreferenceProvider, c0 uuidFactory) {
        Intrinsics.checkNotNullParameter(sharedPreferenceProvider, "sharedPreferenceProvider");
        Intrinsics.checkNotNullParameter(uuidFactory, "uuidFactory");
        this.f1593a = sharedPreferenceProvider;
        this.b = uuidFactory;
    }

    public final String a() {
        this.b.getClass();
        String value = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(value, "randomUUID().toString()");
        SharedPreferences sharedPreferences = this.f1593a.f1589a;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("USER_ID_KEY", value);
        edit.apply();
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }
}
