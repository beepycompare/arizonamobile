package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.aa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0112aa {
    public static volatile C0112aa c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f795a;
    public final HashMap b = new HashMap();

    public C0112aa(Context context) {
        this.f795a = context;
    }

    public static final C0112aa a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0112aa.class)) {
                if (c == null) {
                    c = new C0112aa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0112aa c0112aa = c;
        if (c0112aa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0112aa;
    }

    public final synchronized C0719y9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new C0719y9(this.f795a, str);
            hashMap.put(str, obj);
        }
        return (C0719y9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
