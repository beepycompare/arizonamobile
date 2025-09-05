package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public final class xo implements yo {
    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(List<wo> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (wo woVar : list) {
            if (!woVar.f1141a) {
                linkedList.add(woVar.b);
                z = false;
            }
        }
        if (z) {
            return new wo(this, true, "");
        }
        return new wo(this, false, TextUtils.join(", ", linkedList));
    }
}
