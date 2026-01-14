package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.bj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0151bj implements InterfaceC0388l {

    /* renamed from: a  reason: collision with root package name */
    public Ve f925a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0125aj e = new C0125aj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            this.b = a((Context) activity).p();
            this.c = a((Context) activity).t();
            this.d = true;
        }
        if (this.b == null) {
            c(activity);
        }
    }

    public final synchronized ScreenInfo b(Context context) {
        if (!this.d) {
            this.b = a(context).p();
            this.c = a(context).t();
            this.d = true;
        }
        c((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    c(context);
                    this.c = true;
                    a(context).v();
                }
            } else {
                c(context);
            }
        }
        return this.b;
    }

    public final void c(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0125aj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            a(context).a(this.b);
        }
    }

    public final Ve a(Context context) {
        if (this.f925a == null) {
            this.f925a = new Ve(C0136b4.l().c(context).a(context));
        }
        Ve ve = this.f925a;
        Intrinsics.checkNotNull(ve);
        return ve;
    }

    public final void a(Ve ve) {
        this.f925a = ve;
    }
}
