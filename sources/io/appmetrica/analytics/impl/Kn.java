package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Kn {

    /* renamed from: a  reason: collision with root package name */
    public final E3 f665a;
    public final Do b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public Kn(Toggle toggle) {
        E3 e3 = new E3(C0449na.k().y());
        this.f665a = e3;
        Do r1 = new Do();
        this.b = r1;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = e3;
        toggleArr[1] = r1;
        toggleArr[2] = toggle == null ? new vo() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
