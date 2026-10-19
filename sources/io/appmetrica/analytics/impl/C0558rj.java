package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.rj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0558rj implements N9 {
    @Override // io.appmetrica.analytics.impl.N9
    public final Integer a(C0290h9 c0290h9) {
        Db db = c0290h9.h;
        if (db == null) {
            Map map = AbstractC0530qg.f1169a;
            return null;
        }
        return (Integer) AbstractC0530qg.c.get(db);
    }
}
