package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.va  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0660va {
    public static volatile C0660va c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1246a;
    public final HashMap b = new HashMap();

    public C0660va(Context context) {
        this.f1246a = context;
    }

    public static final C0660va a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0660va.class)) {
                if (c == null) {
                    c = new C0660va(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0660va c0660va = c;
        if (c0660va == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0660va;
    }

    public final synchronized R9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new R9(this.f1246a, str);
            hashMap.put(str, obj);
        }
        return (R9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
