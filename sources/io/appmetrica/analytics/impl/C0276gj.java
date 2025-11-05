package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.gj  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0276gj implements InterfaceC0385l {

    /* renamed from: a  reason: collision with root package name */
    public C0117af f899a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final C0250fj e = new C0250fj();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f899a == null) {
                this.f899a = new C0117af(C0264g7.a(activity).a());
            }
            C0117af c0117af = this.f899a;
            Intrinsics.checkNotNull(c0117af);
            this.b = c0117af.p();
            if (this.f899a == null) {
                this.f899a = new C0117af(C0264g7.a(activity).a());
            }
            C0117af c0117af2 = this.f899a;
            Intrinsics.checkNotNull(c0117af2);
            this.c = c0117af2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo a2 = C0250fj.a(context);
            if (a2 == null || Intrinsics.areEqual(a2, this.b)) {
                return;
            }
            this.b = a2;
            if (this.f899a == null) {
                this.f899a = new C0117af(C0264g7.a(context).a());
            }
            C0117af c0117af = this.f899a;
            Intrinsics.checkNotNull(c0117af);
            c0117af.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f899a == null) {
                this.f899a = new C0117af(C0264g7.a(context).a());
            }
            C0117af c0117af = this.f899a;
            Intrinsics.checkNotNull(c0117af);
            this.b = c0117af.p();
            if (this.f899a == null) {
                this.f899a = new C0117af(C0264g7.a(context).a());
            }
            C0117af c0117af2 = this.f899a;
            Intrinsics.checkNotNull(c0117af2);
            this.c = c0117af2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f899a == null) {
                        this.f899a = new C0117af(C0264g7.a(context).a());
                    }
                    C0117af c0117af3 = this.f899a;
                    Intrinsics.checkNotNull(c0117af3);
                    c0117af3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(C0117af c0117af) {
        this.f899a = c0117af;
    }
}
