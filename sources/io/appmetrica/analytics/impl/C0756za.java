package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.za  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0756za {
    public static volatile C0756za c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1188a;
    public final HashMap b = new HashMap();

    public C0756za(Context context) {
        this.f1188a = context;
    }

    public static final C0756za a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0756za.class)) {
                if (c == null) {
                    c = new C0756za(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0756za c0756za = c;
        if (c0756za == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0756za;
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
