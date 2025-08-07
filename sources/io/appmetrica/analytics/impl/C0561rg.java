package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.rg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0561rg {

    /* renamed from: a  reason: collision with root package name */
    public final C0736yg f1037a;
    public final Ua b;
    public final Jg c;
    public final Lazy d = LazyKt.lazy(new C0487og(this));
    public final Lazy e = LazyKt.lazy(new C0437mg(this));
    public final Lazy f = LazyKt.lazy(new C0537qg(this));
    public final ArrayList g = new ArrayList();

    public C0561rg(C0736yg c0736yg, Ig ig, Ua ua, Jg jg) {
        this.f1037a = c0736yg;
        this.b = ua;
        this.c = jg;
    }

    public static final InterfaceC0362jg a(C0561rg c0561rg) {
        return (InterfaceC0362jg) c0561rg.d.getValue();
    }

    public static final void a(C0561rg c0561rg, Ag ag, InterfaceC0362jg interfaceC0362jg) {
        boolean areEqual;
        c0561rg.g.add(ag);
        Jg jg = c0561rg.c;
        if (ag == null) {
            jg.getClass();
        } else {
            SafePackageManager safePackageManager = jg.b;
            Context context = jg.f507a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int ordinal = ag.d.ordinal();
            if (ordinal == 1) {
                areEqual = Intrinsics.areEqual(jg.f, installerPackageName);
            } else if (ordinal == 2) {
                areEqual = Intrinsics.areEqual(jg.g, installerPackageName);
            }
            if (areEqual) {
                c0561rg.a(ag);
                return;
            }
        }
        interfaceC0362jg.a();
    }

    public final void a(Ag ag) {
        C0736yg c0736yg = this.f1037a;
        synchronized (c0736yg) {
            c0736yg.b = ag;
            c0736yg.c = true;
            c0736yg.d.a(ag);
            c0736yg.d.d();
            c0736yg.a(c0736yg.b);
        }
    }
}
