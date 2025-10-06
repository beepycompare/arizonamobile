package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.vf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0662vf implements InterfaceC0315ho {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1126a;

    public C0662vf(C0712xf c0712xf) {
        boolean z;
        List<C0687wf> list = c0712xf.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0687wf c0687wf : list) {
                if (c0687wf.c == EnumC0531q8.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f1126a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0687wf> invoke(List<? extends C0687wf> list, Kf kf) {
        C0687wf c0687wf = new C0687wf(kf.f540a, kf.b, kf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0687wf c0687wf2 : list) {
                if (c0687wf2.c == kf.e) {
                    if (c0687wf.c == EnumC0531q8.c && this.f1126a) {
                        return CollectionsKt.plus((Collection<? extends C0687wf>) list, c0687wf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0687wf>) list, c0687wf);
    }
}
