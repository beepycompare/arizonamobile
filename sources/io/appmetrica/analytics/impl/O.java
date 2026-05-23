package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import io.appmetrica.analytics.coreutils.internal.toggle.OuterStateToggle;
import io.appmetrica.analytics.coreutils.internal.toggle.SavableToggle;
import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class O {

    /* renamed from: a  reason: collision with root package name */
    public final C0769zf f691a = Na.k().y();
    public final SavableToggle b;
    public final OuterStateToggle c;
    public final OuterStateToggle d;
    public final ConjunctiveCompositeThreadSafeToggle e;
    public final ConjunctiveCompositeThreadSafeToggle f;
    public final SavableToggle g;

    public O(Hm hm) {
        SavableToggle savableToggle = new SavableToggle("advIdsFromClientApi", new N(this));
        this.b = savableToggle;
        OuterStateToggle outerStateToggle = new OuterStateToggle(false, "GAID-remote-config");
        this.c = outerStateToggle;
        OuterStateToggle outerStateToggle2 = new OuterStateToggle(false, "HOAID-remote-config");
        this.d = outerStateToggle2;
        this.e = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) new SimpleThreadSafeToggle[]{savableToggle, outerStateToggle}), "GAID");
        this.f = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) new SimpleThreadSafeToggle[]{savableToggle, outerStateToggle2}), "HOAID");
        this.g = savableToggle;
        a(hm);
    }

    public final void a(Hm hm) {
        boolean z = hm.p;
        boolean z2 = false;
        this.c.update(!z || hm.n.c);
        OuterStateToggle outerStateToggle = this.d;
        if (!z || hm.n.e) {
            z2 = true;
        }
        outerStateToggle.update(z2);
    }

    public final L a() {
        M m;
        M m2;
        M m3;
        if (this.e.getActualState()) {
            m = M.f653a;
        } else if (this.b.getActualState()) {
            m = !this.c.getActualState() ? M.c : M.d;
        } else {
            m = M.b;
        }
        if (this.f.getActualState()) {
            m2 = M.f653a;
        } else if (this.b.getActualState()) {
            m2 = !this.d.getActualState() ? M.c : M.d;
        } else {
            m2 = M.b;
        }
        if (this.g.getActualState()) {
            m3 = M.f653a;
        } else {
            m3 = !this.b.getActualState() ? M.b : M.d;
        }
        return new L(m, m2, m3);
    }
}
