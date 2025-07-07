package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public final class lo implements mo {
    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(List<ko> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (ko koVar : list) {
            if (!koVar.f912a) {
                linkedList.add(koVar.b);
                z = false;
            }
        }
        if (z) {
            return new ko(this, true, "");
        }
        return new ko(this, false, TextUtils.join(", ", linkedList));
    }
}
