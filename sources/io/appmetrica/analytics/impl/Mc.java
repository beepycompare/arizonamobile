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
public final class Mc extends C0700x5 {
    public final C0565rk n;

    public Mc(Context context, C0401l5 c0401l5, J4 j4, AbstractC0526q5 abstractC0526q5, C0268fm c0268fm, InterfaceC0637uh interfaceC0637uh, ICommonExecutor iCommonExecutor, int i, C0565rk c0565rk, C0129ac c0129ac, N9 n9) {
        super(context, c0401l5, j4, abstractC0526q5, c0268fm, interfaceC0637uh, iCommonExecutor, i, c0129ac, n9);
        this.n = c0565rk;
    }

    public final C0449n3 a(Kc kc) {
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
        return new C0449n3(context, a2, f, billingType, new C0349j3(Qm.a(C0672w2.class).a(this.c)), new C0325i3(kc, Ia.j().w().e()));
    }

    public final Cg b(Kc kc) {
        C0759ze c0759ze = new C0759ze(kc);
        Objects.requireNonNull(kc);
        return new Cg(c0759ze, new Jc(kc), kc);
    }

    @Override // io.appmetrica.analytics.impl.C0700x5
    public final L9 a(Q9 q9, C0279g7 c0279g7, C0212dh c0212dh, J4 j4, C0401l5 c0401l5, C0386kf c0386kf) {
        return this.l.a(q9, c0279g7, c0212dh, j4, c0401l5, c0386kf).a();
    }
}
