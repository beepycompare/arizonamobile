package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.no  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0467no {

    /* renamed from: a  reason: collision with root package name */
    public final V3 f1123a;
    public final hp b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public C0467no(Toggle toggle) {
        V3 v3 = new V3(Na.k().y());
        this.f1123a = v3;
        hp hpVar = new hp();
        this.b = hpVar;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = v3;
        toggleArr[1] = hpVar;
        toggleArr[2] = toggle == null ? new Yo() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
