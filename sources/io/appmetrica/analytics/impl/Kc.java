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
public final class Kc extends C0705x5 {
    public final C0496ok n;

    public Kc(Context context, C0406l5 c0406l5, J4 j4, AbstractC0531q5 abstractC0531q5, C0198cm c0198cm, InterfaceC0592sh interfaceC0592sh, ICommonExecutor iCommonExecutor, int i, C0496ok c0496ok, Yb yb, K9 k9) {
        super(context, c0406l5, j4, abstractC0531q5, c0198cm, interfaceC0592sh, iCommonExecutor, i, yb, k9);
        this.n = c0496ok;
    }

    public final C0454n3 a(Ic ic) {
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
        return new C0454n3(context, a2, f, billingType, new C0354j3(Nm.a(C0677w2.class).a(this.c)), new C0330i3(ic, Ga.j().w().e()));
    }

    public final Ag b(Ic ic) {
        C0714xe c0714xe = new C0714xe(ic);
        Objects.requireNonNull(ic);
        return new Ag(c0714xe, new Hc(ic), ic);
    }

    @Override // io.appmetrica.analytics.impl.C0705x5
    public final I9 a(N9 n9, C0209d7 c0209d7, C0167bh c0167bh, J4 j4, C0406l5 c0406l5, Cif cif) {
        return this.l.a(n9, c0209d7, c0167bh, j4, c0406l5, cif).a();
    }
}
