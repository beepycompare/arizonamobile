package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.pg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0509pg {

    /* renamed from: a  reason: collision with root package name */
    public final C0683wg f992a;
    public final Sa b;
    public final Hg c;
    public final Lazy d = LazyKt.lazy(new C0434mg(this));
    public final Lazy e = LazyKt.lazy(new C0384kg(this));
    public final Lazy f = LazyKt.lazy(new C0484og(this));
    public final ArrayList g = new ArrayList();

    public C0509pg(C0683wg c0683wg, Gg gg, Sa sa, Hg hg) {
        this.f992a = c0683wg;
        this.b = sa;
        this.c = hg;
    }

    public static final InterfaceC0310hg a(C0509pg c0509pg) {
        return (InterfaceC0310hg) c0509pg.d.getValue();
    }

    public static final void a(C0509pg c0509pg, C0733yg c0733yg, InterfaceC0310hg interfaceC0310hg) {
        boolean areEqual;
        c0509pg.g.add(c0733yg);
        Hg hg = c0509pg.c;
        if (c0733yg == null) {
            hg.getClass();
        } else {
            SafePackageManager safePackageManager = hg.b;
            Context context = hg.f463a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = c0733yg.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(hg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(hg.g, installerPackageName);
            }
            if (areEqual) {
                c0509pg.a(c0733yg);
                return;
            }
        }
        interfaceC0310hg.a();
    }

    public final void a(C0733yg c0733yg) {
        C0683wg c0683wg = this.f992a;
        synchronized (c0683wg) {
            c0683wg.b = c0733yg;
            c0683wg.c = true;
            c0683wg.d.a(c0733yg);
            c0683wg.d.d();
            c0683wg.a(c0683wg.b);
        }
    }
}
