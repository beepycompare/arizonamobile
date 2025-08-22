package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* renamed from: io.appmetrica.analytics.impl.wa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0677wa {
    public static volatile C0677wa c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1119a;
    public final HashMap b = new HashMap();

    public C0677wa(Context context) {
        this.f1119a = context;
    }

    public static final C0677wa a(Context context) {
        if (c == null) {
            synchronized (Reflection.getOrCreateKotlinClass(C0677wa.class)) {
                if (c == null) {
                    c = new C0677wa(context);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        C0677wa c0677wa = c;
        if (c0677wa == null) {
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }
        return c0677wa;
    }

    public final synchronized U9 b(String str) {
        Object obj;
        HashMap hashMap = this.b;
        obj = hashMap.get(str);
        if (obj == null) {
            obj = new U9(this.f1119a, str);
            hashMap.put(str, obj);
        }
        return (U9) obj;
    }

    public final synchronized void a(String str) {
        this.b.remove(str);
    }
}
