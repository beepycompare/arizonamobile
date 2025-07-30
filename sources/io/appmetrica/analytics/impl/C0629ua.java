package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.ua  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0629ua {
    public static volatile C0629ua c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1082a;
    public final HashMap b = new HashMap();

    public C0629ua(Context context) {
        this.f1082a = context;
    }

    public static final C0629ua a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0629ua.class)) {
                if (c == null) {
                    c = new C0629ua(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0629ua c0629ua = c;
        if (c0629ua == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0629ua;
    }

    public final synchronized S9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new S9(this.f1082a, str);
            hashMap.put(str, obj);
        }
        return (S9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
