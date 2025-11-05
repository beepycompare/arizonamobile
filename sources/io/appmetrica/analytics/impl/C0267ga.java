package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0267ga {
    public static volatile C0267ga c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f891a;
    public final HashMap b = new HashMap();

    public C0267ga(Context context) {
        this.f891a = context;
    }

    public static final C0267ga a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0267ga.class)) {
                if (c == null) {
                    c = new C0267ga(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0267ga c0267ga = c;
        if (c0267ga == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0267ga;
    }

    public final synchronized E9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new E9(this.f891a, str);
            hashMap.put(str, obj);
        }
        return (E9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
