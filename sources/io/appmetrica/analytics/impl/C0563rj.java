package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0563rj implements N9 {
    @Override // io.appmetrica.analytics.impl.N9
    public final Integer a(C0295h9 c0295h9) {
        Db db = c0295h9.h;
        if (db == null) {
            Map map = AbstractC0535qg.f1166a;
            return null;
        }
        return (Integer) AbstractC0535qg.c.get(db);
    }
}
