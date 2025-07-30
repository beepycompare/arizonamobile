package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public final class oo implements po {
    @Override // io.appmetrica.analytics.impl.po
    public final no a(List<no> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (no noVar : list) {
            if (!noVar.f976a) {
                linkedList.add(noVar.b);
                z = false;
            }
        }
        if (z) {
            return new no(this, true, "");
        }
        return new no(this, false, TextUtils.join(", ", linkedList));
    }
}
