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
public final class Rc extends A5 {
    public final Ak n;

    public Rc(Context context, C0476o5 c0476o5, M4 m4, AbstractC0601t5 abstractC0601t5, C0493om c0493om, Dh dh, ICommonExecutor iCommonExecutor, int i, Ak ak, C0250fc c0250fc, S9 s9) {
        super(context, c0476o5, m4, abstractC0601t5, c0493om, dh, iCommonExecutor, i, c0250fc, s9);
        this.n = ak;
    }

    public final C0525q3 a(Pc pc) {
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
        return new C0525q3(context, a2, f, billingType, new C0422m3(Zm.a(C0748z2.class).a(this.c)), new C0396l3(pc, Na.j().w().e()));
    }

    public final Lg b(Pc pc) {
        Fe fe = new Fe(pc);
        Objects.requireNonNull(pc);
        return new Lg(fe, new Oc(pc), pc);
    }

    @Override // io.appmetrica.analytics.impl.A5
    public final Q9 a(V9 v9, C0374k7 c0374k7, C0436mh c0436mh, M4 m4, C0476o5 c0476o5, C0537qf c0537qf) {
        return this.l.a(v9, c0374k7, c0436mh, m4, c0476o5, c0537qf).a();
    }
}
