package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class En {

    /* renamed from: a  reason: collision with root package name */
    public final C0128a4 f416a;
    public final wo b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public En(Toggle toggle) {
        C0128a4 c0128a4 = new C0128a4(Ga.j().x());
        this.f416a = c0128a4;
        wo woVar = new wo();
        this.b = woVar;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = c0128a4;
        toggleArr[1] = woVar;
        toggleArr[2] = toggle == null ? new po() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
