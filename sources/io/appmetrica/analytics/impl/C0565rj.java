package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0565rj implements N9 {
    @Override // io.appmetrica.analytics.impl.N9
    public final Integer a(C0297h9 c0297h9) {
        Db db = c0297h9.h;
        if (db == null) {
            Map map = AbstractC0537qg.f1166a;
            return null;
        }
        return (Integer) AbstractC0537qg.c.get(db);
    }
}
