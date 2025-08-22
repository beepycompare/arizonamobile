package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0557rf implements Cdo {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1044a;

    public C0557rf(C0607tf c0607tf) {
        boolean z;
        List<C0582sf> list = c0607tf.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0582sf c0582sf : list) {
                if (c0582sf.c == EnumC0451n8.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f1044a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0582sf> invoke(List<? extends C0582sf> list, Gf gf) {
        C0582sf c0582sf = new C0582sf(gf.f457a, gf.b, gf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0582sf c0582sf2 : list) {
                if (c0582sf2.c == gf.e) {
                    if (c0582sf.c == EnumC0451n8.c && this.f1044a) {
                        return CollectionsKt.plus((Collection<? extends C0582sf>) list, c0582sf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0582sf>) list, c0582sf);
    }
}
