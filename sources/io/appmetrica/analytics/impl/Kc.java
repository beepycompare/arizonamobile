package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingType;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.text.StringsKt;
/* loaded from: classes4.dex */
public final class Kc extends C0697x5 {
    public final C0488ok n;

    public Kc(Context context, C0398l5 c0398l5, J4 j4, AbstractC0523q5 abstractC0523q5, C0190cm c0190cm, InterfaceC0584sh interfaceC0584sh, ICommonExecutor iCommonExecutor, int i, C0488ok c0488ok, Yb yb, K9 k9) {
        super(context, c0398l5, j4, abstractC0523q5, c0190cm, interfaceC0584sh, iCommonExecutor, i, yb, k9);
        this.n = c0488ok;
    }

    public final C0446n3 a(Ic ic) {
        String str;
        BillingType billingType;
        Field field;
        Context context = this.c;
        IHandlerExecutor a2 = this.n.a();
        Executor f = this.n.f();
        try {
            Class<?> findClass = ReflectionUtils.findClass("com.android.billingclient.BuildConfig");
            str = (String) ((findClass == null || (field = findClass.getField("VERSION_NAME")) == null) ? null : field.get(null));
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null && !StringsKt.isBlank(str)) {
            if (StringsKt.startsWith$default(str, "2.", false, 2, (Object) null)) {
                billingType = BillingType.NONE;
            } else if (StringsKt.startsWith$default(str, "3.", false, 2, (Object) null)) {
                billingType = BillingType.NONE;
            } else if (StringsKt.startsWith$default(str, "4.", false, 2, (Object) null)) {
                billingType = BillingType.NONE;
            } else if (StringsKt.startsWith$default(str, "5.", false, 2, (Object) null)) {
                billingType = BillingType.LIBRARY_V6;
            } else {
                billingType = StringsKt.startsWith$default(str, "6.", false, 2, (Object) null) ? BillingType.LIBRARY_V6 : BillingType.LIBRARY_V6;
            }
        } else {
            billingType = BillingType.NONE;
        }
        return new C0446n3(context, a2, f, billingType, new C0346j3(Nm.a(C0669w2.class).a(this.c)), new C0322i3(ic, Ga.j().w().e()));
    }

    public final Ag b(Ic ic) {
        C0706xe c0706xe = new C0706xe(ic);
        Objects.requireNonNull(ic);
        return new Ag(c0706xe, new Hc(ic), ic);
    }

    @Override // io.appmetrica.analytics.impl.C0697x5
    public final I9 a(N9 n9, C0201d7 c0201d7, C0159bh c0159bh, J4 j4, C0398l5 c0398l5, Cif cif) {
        return this.l.a(n9, c0201d7, c0159bh, j4, c0398l5, cif).a();
    }
}
