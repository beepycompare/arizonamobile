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
public final class Oc extends C0697x5 {
    public final C0687wk n;

    public Oc(Context context, C0398l5 c0398l5, J4 j4, AbstractC0523q5 abstractC0523q5, C0389km c0389km, InterfaceC0759zh interfaceC0759zh, ICommonExecutor iCommonExecutor, int i, C0687wk c0687wk, C0173cc c0173cc, P9 p9) {
        super(context, c0398l5, j4, abstractC0523q5, c0389km, interfaceC0759zh, iCommonExecutor, i, c0173cc, p9);
        this.n = c0687wk;
    }

    public final C0446n3 a(Mc mc) {
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
            } else if (StringsKt.startsWith$default(str, "6.", false, 2, (Object) null)) {
                billingType = BillingType.LIBRARY_V6;
            } else if (StringsKt.startsWith$default(str, "7.", false, 2, (Object) null)) {
                billingType = BillingType.LIBRARY_V6;
            } else {
                billingType = StringsKt.startsWith$default(str, "8.", false, 2, (Object) null) ? BillingType.LIBRARY_V8 : BillingType.LIBRARY_V8;
            }
        } else {
            billingType = BillingType.NONE;
        }
        return new C0446n3(context, a2, f, billingType, new C0344j3(Vm.a(C0669w2.class).a(this.c)), new C0319i3(mc, Ka.j().w().e()));
    }

    public final Hg b(Mc mc) {
        Be be = new Be(mc);
        Objects.requireNonNull(mc);
        return new Hg(be, new Lc(mc), mc);
    }

    @Override // io.appmetrica.analytics.impl.C0697x5
    public final N9 a(S9 s9, C0297h7 c0297h7, C0332ih c0332ih, J4 j4, C0398l5 c0398l5, C0433mf c0433mf) {
        return this.l.a(s9, c0297h7, c0332ih, j4, c0398l5, c0433mf).a();
    }
}
