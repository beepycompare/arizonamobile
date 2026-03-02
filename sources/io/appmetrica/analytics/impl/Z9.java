package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes5.dex */
public final class Z9 {
    public static volatile Z9 c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f882a;
    public final HashMap b = new HashMap();

    public Z9(Context context) {
        this.f882a = context;
    }

    public static final Z9 a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(Z9.class)) {
                if (c == null) {
                    c = new Z9(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Z9 z9 = c;
        if (z9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return z9;
    }

    public final synchronized C0696x9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new C0696x9(this.f882a, str);
            hashMap.put(str, obj);
        }
        return (C0696x9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
