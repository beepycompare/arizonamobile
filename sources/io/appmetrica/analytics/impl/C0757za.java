package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.za  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0757za {
    public static volatile C0757za c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1188a;
    public final HashMap b = new HashMap();

    public C0757za(Context context) {
        this.f1188a = context;
    }

    public static final C0757za a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0757za.class)) {
                if (c == null) {
                    c = new C0757za(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0757za c0757za = c;
        if (c0757za == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0757za;
    }

    public final synchronized X9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new X9(this.f1188a, str);
            hashMap.put(str, obj);
        }
        return (X9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
