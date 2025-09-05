package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.vf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0661vf implements InterfaceC0314ho {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1121a;

    public C0661vf(C0711xf c0711xf) {
        boolean z;
        List<C0686wf> list = c0711xf.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0686wf c0686wf : list) {
                if (c0686wf.c == EnumC0530q8.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f1121a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0686wf> invoke(List<? extends C0686wf> list, Kf kf) {
        C0686wf c0686wf = new C0686wf(kf.f535a, kf.b, kf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0686wf c0686wf2 : list) {
                if (c0686wf2.c == kf.e) {
                    if (c0686wf.c == EnumC0530q8.c && this.f1121a) {
                        return CollectionsKt.plus((Collection<? extends C0686wf>) list, c0686wf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0686wf>) list, c0686wf);
    }
}
