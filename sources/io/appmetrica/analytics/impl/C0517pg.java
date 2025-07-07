package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.pg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0517pg {

    /* renamed from: a  reason: collision with root package name */
    public final C0691wg f991a;
    public final Sa b;
    public final Hg c;
    public final Lazy d = LazyKt.lazy(new C0442mg(this));
    public final Lazy e = LazyKt.lazy(new C0392kg(this));
    public final Lazy f = LazyKt.lazy(new C0492og(this));
    public final ArrayList g = new ArrayList();

    public C0517pg(C0691wg c0691wg, Gg gg, Sa sa, Hg hg) {
        this.f991a = c0691wg;
        this.b = sa;
        this.c = hg;
    }

    public static final InterfaceC0318hg a(C0517pg c0517pg) {
        return (InterfaceC0318hg) c0517pg.d.getValue();
    }

    public static final void a(C0517pg c0517pg, C0741yg c0741yg, InterfaceC0318hg interfaceC0318hg) {
        boolean areEqual;
        c0517pg.g.add(c0741yg);
        Hg hg = c0517pg.c;
        if (c0741yg == null) {
            hg.getClass();
        } else {
            SafePackageManager safePackageManager = hg.b;
            Context context = hg.f462a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = c0741yg.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(hg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(hg.g, installerPackageName);
            }
            if (areEqual) {
                c0517pg.a(c0741yg);
                return;
            }
        }
        interfaceC0318hg.a();
    }

    public final void a(C0741yg c0741yg) {
        C0691wg c0691wg = this.f991a;
        synchronized (c0691wg) {
            c0691wg.b = c0741yg;
            c0691wg.c = true;
            c0691wg.d.a(c0741yg);
            c0691wg.d.d();
            c0691wg.a(c0691wg.b);
        }
    }
}
