package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Qn {

    /* renamed from: a  reason: collision with root package name */
    public final C0191d4 f642a;
    public final Io b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public Qn(Toggle toggle) {
        C0191d4 c0191d4 = new C0191d4(Na.j().x());
        this.f642a = c0191d4;
        Io io2 = new Io();
        this.b = io2;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = c0191d4;
        toggleArr[1] = io2;
        toggleArr[2] = toggle == null ? new Bo() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
