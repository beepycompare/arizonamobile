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
public final class M1 {
    public static B1 d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f677a;
    public final A1 b;
    public BinderC0735z1 c;

    public M1(Context context, A1 a1) {
        this.f677a = context;
        this.b = a1;
    }

    public final void b() {
        C0470oa.a(this.f677a);
        PublicLogger.Companion.init(this.f677a);
        Context context = this.f677a;
        A1 a1 = this.b;
        if (d == null) {
            C1 c1 = new C1(context, a1, new C0209e5(context));
            C0250fk c0250fk = C0470oa.I.v;
            F1 f1 = new F1(c1);
            LinkedHashMap linkedHashMap = c0250fk.f992a;
            Object obj = linkedHashMap.get(1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(1, obj);
            }
            ((List) obj).add(f1);
            d = c1;
        }
        B1 b1 = d;
        if (b1 != null) {
            this.c = new BinderC0735z1(b1);
            C0470oa c0470oa = C0470oa.I;
            c0470oa.f = new C0454nj(c0470oa.f1144a, new C0479oj(b1));
            ((C1) b1).onCreate();
        }
    }

    public final boolean c(Intent intent) {
        B1 b1 = d;
        if (b1 != null) {
            ((C1) b1).b(intent);
        }
        String action = intent.getAction();
        return (action == null || !StringsKt.startsWith$default(action, "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK", false, 2, (Object) null)) && intent.getData() == null;
    }

    public final void d() {
        d = null;
    }

    public final void a(Intent intent, int i) {
        B1 b1 = d;
        if (b1 != null) {
            ((C0609u0) ((C1) b1).c).f1238a.stopSelf(i);
        }
    }

    public final void c() {
        B1 b1 = d;
        if (b1 != null) {
            ((C1) b1).onDestroy();
        }
    }

    public final int a(Intent intent, int i, int i2) {
        B1 b1 = d;
        if (b1 != null) {
            ((C0609u0) ((C1) b1).c).f1238a.stopSelf(i2);
            return 2;
        }
        return 2;
    }

    public final IBinder a(Intent intent) {
        B1 b1 = d;
        if (b1 != null) {
            ((C1) b1).a(intent);
        }
        String action = intent.getAction();
        if (action != null && StringsKt.startsWith$default(action, "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK", false, 2, (Object) null)) {
            return new Do();
        }
        BinderC0735z1 binderC0735z1 = this.c;
        if (binderC0735z1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coreBinder");
            return null;
        }
        return binderC0735z1;
    }

    public final void a(Configuration configuration) {
        if (d != null) {
            C0470oa.I.v().a(configuration);
        }
    }

    public final void b(Intent intent) {
        B1 b1 = d;
        if (b1 != null) {
            ((C1) b1).c(intent);
        }
    }
}
