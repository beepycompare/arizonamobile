package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.va  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0653va {
    public static volatile C0653va c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1252a;
    public final HashMap b = new HashMap();

    public C0653va(Context context) {
        this.f1252a = context;
    }

    public static final C0653va a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0653va.class)) {
                if (c == null) {
                    c = new C0653va(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0653va c0653va = c;
        if (c0653va == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0653va;
    }

    public final synchronized R9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new R9(this.f1252a, str);
            hashMap.put(str, obj);
        }
        return (R9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
