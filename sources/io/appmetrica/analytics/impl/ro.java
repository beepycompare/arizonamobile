package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public final class ro implements so {
    @Override // io.appmetrica.analytics.impl.so
    public final qo a(List<qo> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (qo qoVar : list) {
            if (!qoVar.f1199a) {
                linkedList.add(qoVar.b);
                z = false;
            }
        }
        if (z) {
            return new qo(this, true, "");
        }
        return new qo(this, false, TextUtils.join(", ", linkedList));
    }
}
