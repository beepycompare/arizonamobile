package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public final class so implements to {
    @Override // io.appmetrica.analytics.impl.to
    public final ro a(List<ro> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (ro roVar : list) {
            if (!roVar.f1190a) {
                linkedList.add(roVar.b);
                z = false;
            }
        }
        if (z) {
            return new ro(this, true, "");
        }
        return new ro(this, false, TextUtils.join(", ", linkedList));
    }
}
