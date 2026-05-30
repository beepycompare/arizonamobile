package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Bf implements Do {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f477a;

    public Bf(Df df) {
        boolean z;
        List<Cf> list = df.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Cf cf : list) {
                if (cf.c == EnumC0399l8.d) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f477a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<Cf> invoke(List<? extends Cf> list, Qf qf) {
        Cf cf = new Cf(qf.f733a, qf.b, qf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Cf cf2 : list) {
                if (cf2.c == qf.e) {
                    if (cf.c == EnumC0399l8.d && this.f477a) {
                        return CollectionsKt.plus((Collection<? extends Cf>) list, cf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends Cf>) list, cf);
    }
}
