package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.sa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0577sa {
    public static volatile C0577sa c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1042a;
    public final HashMap b = new HashMap();

    public C0577sa(Context context) {
        this.f1042a = context;
    }

    public static final C0577sa a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0577sa.class)) {
                if (c == null) {
                    c = new C0577sa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0577sa c0577sa = c;
        if (c0577sa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0577sa;
    }

    public final synchronized P9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new P9(this.f1042a, str);
            hashMap.put(str, obj);
        }
        return (P9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
