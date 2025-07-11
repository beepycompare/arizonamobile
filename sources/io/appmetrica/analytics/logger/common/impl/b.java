package io.appmetrica.analytics.logger.common.impl;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final e f1204a;

    public b() {
        this(new e());
    }

    public final ArrayList a(String str) {
        String[] split = str.split("\\n");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            int i = 0;
            while (str2.length() > i) {
                int length = str2.length();
                int i2 = i + 3800;
                int min = Math.min(length, i2);
                if (length > i2) {
                    int a2 = e.a(this.f1204a.f1207a.matcher(str2), i, min);
                    length = a2 == -1 ? min : a2 + 1;
                }
                arrayList.add(str2.substring(i, length));
                i = length;
            }
        }
        return arrayList;
    }

    public b(e eVar) {
        this.f1204a = eVar;
    }
}
