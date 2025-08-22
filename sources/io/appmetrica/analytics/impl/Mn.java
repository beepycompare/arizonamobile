package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Mn {

    /* renamed from: a  reason: collision with root package name */
    public final C0113a4 f567a;
    public final Eo b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public Mn(Toggle toggle) {
        C0113a4 c0113a4 = new C0113a4(Ka.j().x());
        this.f567a = c0113a4;
        Eo eo = new Eo();
        this.b = eo;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = c0113a4;
        toggleArr[1] = eo;
        toggleArr[2] = toggle == null ? new xo() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
