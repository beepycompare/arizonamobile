package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.sa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0585sa {
    public static volatile C0585sa c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1041a;
    public final HashMap b = new HashMap();

    public C0585sa(Context context) {
        this.f1041a = context;
    }

    public static final C0585sa a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0585sa.class)) {
                if (c == null) {
                    c = new C0585sa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0585sa c0585sa = c;
        if (c0585sa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0585sa;
    }

    public final synchronized P9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new P9(this.f1041a, str);
            hashMap.put(str, obj);
        }
        return (P9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
