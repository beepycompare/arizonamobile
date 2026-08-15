package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes5.dex */
public final class Y1 {
    public static C1 d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f850a;
    public final B1 b;
    public A1 c;

    public Y1(Context context, B1 b1) {
        this.f850a = context;
        this.b = b1;
    }

    public final void b() {
        Na.a(this.f850a);
        PublicLogger.Companion.init(this.f850a);
        Context context = this.f850a;
        B1 b1 = this.b;
        if (d == null) {
            O1 o1 = new O1(context, b1, new C0602t5(context));
            Gk gk = Na.I.v;
            R1 r1 = new R1(o1);
            LinkedHashMap linkedHashMap = gk.f566a;
            Object obj = linkedHashMap.get(1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(1, obj);
            }
            ((List) obj).add(r1);
            d = new N1(Na.I.d.b(), o1);
        }
        C1 c1 = d;
        if (c1 != null) {
            this.c = new A1(c1);
            Na na = Na.I;
            na.f = new Mj(na.f683a, new Nj(c1));
            c1.onCreate();
        }
    }

    public final boolean c(Intent intent) {
        C1 c1 = d;
        if (c1 != null) {
            c1.b(intent);
        }
        String action = intent.getAction();
        return (action == null || !StringsKt.startsWith$default(action, "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK", false, 2, (Object) null)) && intent.getData() == null;
    }

    public final void d() {
        d = null;
    }

    public final void a(Intent intent, int i) {
        C1 c1 = d;
        if (c1 != null) {
            c1.a(intent, i);
        }
    }

    public final int a(Intent intent, int i, int i2) {
        C1 c1 = d;
        if (c1 != null) {
            c1.a(intent, i, i2);
            return 2;
        }
        return 2;
    }

    public final void c() {
        C1 c1 = d;
        if (c1 != null) {
            c1.onDestroy();
        }
    }

    public final IBinder a(Intent intent) {
        C1 c1 = d;
        if (c1 != null) {
            c1.a(intent);
        }
        String action = intent.getAction();
        if (action != null && StringsKt.startsWith$default(action, "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK", false, 2, (Object) null)) {
            return new gp();
        }
        A1 a1 = this.c;
        if (a1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coreBinder");
            return null;
        }
        return a1;
    }

    public final void a(Configuration configuration) {
        C1 c1 = d;
        if (c1 != null) {
            c1.onConfigurationChanged(configuration);
        }
    }

    public final void b(Intent intent) {
        C1 c1 = d;
        if (c1 != null) {
            c1.c(intent);
        }
    }
}
