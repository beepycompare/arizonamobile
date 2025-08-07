package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Hn {

    /* renamed from: a  reason: collision with root package name */
    public final C0121a4 f478a;
    public final zo b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public Hn(Toggle toggle) {
        C0121a4 c0121a4 = new C0121a4(Ia.j().x());
        this.f478a = c0121a4;
        zo zoVar = new zo();
        this.b = zoVar;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = c0121a4;
        toggleArr[1] = zoVar;
        toggleArr[2] = toggle == null ? new so() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
