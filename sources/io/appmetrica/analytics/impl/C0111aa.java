package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.aa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0111aa {
    public static volatile C0111aa c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f893a;
    public final HashMap b = new HashMap();

    public C0111aa(Context context) {
        this.f893a = context;
    }

    public static final C0111aa a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0111aa.class)) {
                if (c == null) {
                    c = new C0111aa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0111aa c0111aa = c;
        if (c0111aa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0111aa;
    }

    public final synchronized C0718y9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new C0718y9(this.f893a, str);
            hashMap.put(str, obj);
        }
        return (C0718y9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
