package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public final class to implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final so a(List<so> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (so soVar : list) {
            if (!soVar.f1120a) {
                linkedList.add(soVar.b);
                z = false;
            }
        }
        if (z) {
            return new so(this, true, "");
        }
        return new so(this, false, TextUtils.join(", ", linkedList));
    }
}
