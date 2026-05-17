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
public final class L1 {
    public static A1 d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f672a;
    public final InterfaceC0738z1 b;
    public BinderC0713y1 c;

    public L1(Context context, InterfaceC0738z1 interfaceC0738z1) {
        this.f672a = context;
        this.b = interfaceC0738z1;
    }

    public final void b() {
        C0448na.a(this.f672a);
        PublicLogger.Companion.init(this.f672a);
        Context context = this.f672a;
        InterfaceC0738z1 interfaceC0738z1 = this.b;
        if (d == null) {
            B1 b1 = new B1(context, interfaceC0738z1, new C0188d5(context));
            C0228ek c0228ek = C0448na.I.v;
            E1 e1 = new E1(b1);
            LinkedHashMap linkedHashMap = c0228ek.f986a;
            Object obj = linkedHashMap.get(1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(1, obj);
            }
            ((List) obj).add(e1);
            d = b1;
        }
        A1 a1 = d;
        if (a1 != null) {
            this.c = new BinderC0713y1(a1);
            C0448na c0448na = C0448na.I;
            c0448na.f = new C0432mj(c0448na.f1138a, new C0457nj(a1));
            ((B1) a1).onCreate();
        }
    }

    public final boolean c(Intent intent) {
        A1 a1 = d;
        if (a1 != null) {
            ((B1) a1).b(intent);
        }
        String action = intent.getAction();
        return (action == null || !StringsKt.startsWith$default(action, "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK", false, 2, (Object) null)) && intent.getData() == null;
    }

    public final void d() {
        d = null;
    }

    public final void a(Intent intent, int i) {
        A1 a1 = d;
        if (a1 != null) {
            ((C0612u0) ((B1) a1).c).f1249a.stopSelf(i);
        }
    }

    public final void c() {
        A1 a1 = d;
        if (a1 != null) {
            ((B1) a1).onDestroy();
        }
    }

    public final int a(Intent intent, int i, int i2) {
        A1 a1 = d;
        if (a1 != null) {
            ((C0612u0) ((B1) a1).c).f1249a.stopSelf(i2);
            return 2;
        }
        return 2;
    }

    public final IBinder a(Intent intent) {
        A1 a1 = d;
        if (a1 != null) {
            ((B1) a1).a(intent);
        }
        String action = intent.getAction();
        if (action != null && StringsKt.startsWith$default(action, "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK", false, 2, (Object) null)) {
            return new Co();
        }
        BinderC0713y1 binderC0713y1 = this.c;
        if (binderC0713y1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coreBinder");
            return null;
        }
        return binderC0713y1;
    }

    public final void a(Configuration configuration) {
        if (d != null) {
            C0448na.I.v().a(configuration);
        }
    }

    public final void b(Intent intent) {
        A1 a1 = d;
        if (a1 != null) {
            ((B1) a1).c(intent);
        }
    }
}
