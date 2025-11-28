package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Mn {

    /* renamed from: a  reason: collision with root package name */
    public final M3 f597a;
    public final Eo b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public Mn(Toggle toggle) {
        M3 m3 = new M3(C0620ua.k().z());
        this.f597a = m3;
        Eo eo = new Eo();
        this.b = eo;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = m3;
        toggleArr[1] = eo;
        toggleArr[2] = toggle == null ? new xo() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
