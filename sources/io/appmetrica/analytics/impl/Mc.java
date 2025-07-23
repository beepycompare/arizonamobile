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
public final class Mc extends C0699x5 {
    public final C0564rk n;

    public Mc(Context context, C0400l5 c0400l5, J4 j4, AbstractC0525q5 abstractC0525q5, C0267fm c0267fm, InterfaceC0636uh interfaceC0636uh, ICommonExecutor iCommonExecutor, int i, C0564rk c0564rk, C0128ac c0128ac, N9 n9) {
        super(context, c0400l5, j4, abstractC0525q5, c0267fm, interfaceC0636uh, iCommonExecutor, i, c0128ac, n9);
        this.n = c0564rk;
    }

    public final C0448n3 a(Kc kc) {
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
        return new C0448n3(context, a2, f, billingType, new C0348j3(Qm.a(C0671w2.class).a(this.c)), new C0324i3(kc, Ia.j().w().e()));
    }

    public final Cg b(Kc kc) {
        C0758ze c0758ze = new C0758ze(kc);
        Objects.requireNonNull(kc);
        return new Cg(c0758ze, new Jc(kc), kc);
    }

    @Override // io.appmetrica.analytics.impl.C0699x5
    public final L9 a(Q9 q9, C0278g7 c0278g7, C0211dh c0211dh, J4 j4, C0400l5 c0400l5, C0385kf c0385kf) {
        return this.l.a(q9, c0278g7, c0211dh, j4, c0400l5, c0385kf).a();
    }
}
