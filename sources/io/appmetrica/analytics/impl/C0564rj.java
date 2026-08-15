package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0564rj implements N9 {
    @Override // io.appmetrica.analytics.impl.N9
    public final Integer a(C0296h9 c0296h9) {
        Db db = c0296h9.h;
        if (db == null) {
            Map map = AbstractC0536qg.f1166a;
            return null;
        }
        return (Integer) AbstractC0536qg.c.get(db);
    }
}
