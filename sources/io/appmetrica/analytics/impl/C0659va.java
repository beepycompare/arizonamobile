package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.va  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0659va {
    public static volatile C0659va c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1249a;
    public final HashMap b = new HashMap();

    public C0659va(Context context) {
        this.f1249a = context;
    }

    public static final C0659va a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0659va.class)) {
                if (c == null) {
                    c = new C0659va(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0659va c0659va = c;
        if (c0659va == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0659va;
    }

    public final synchronized R9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new R9(this.f1249a, str);
            hashMap.put(str, obj);
        }
        return (R9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
