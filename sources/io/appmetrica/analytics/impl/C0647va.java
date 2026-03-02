package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.va  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0647va extends C2 {
    public final C0572sa b;
    public final C0572sa c;
    public final C0622ua d;

    public C0647va(int i, int i2, int i3) {
        this(i, new C0572sa(i2), new C0572sa(i3));
    }

    public C0647va(int i, C0572sa c0572sa, C0572sa c0572sa2) {
        super(i);
        this.d = new C0622ua();
        this.b = c0572sa;
        this.c = c0572sa2;
    }

    @Override // io.appmetrica.analytics.impl.C2, io.appmetrica.analytics.impl.InterfaceC0597ta
    public final Mn a(Map<String, String> map) {
        HashMap hashMap;
        int i;
        int i2 = 0;
        if (map != null) {
            hashMap = new HashMap();
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            Map.Entry[] entryArr = (Map.Entry[]) entrySet.toArray(new Map.Entry[entrySet.size()]);
            Arrays.sort(entryArr, this.d);
            int length = entryArr.length;
            i = 0;
            int i3 = 0;
            boolean z = false;
            int i4 = 0;
            while (i2 < length) {
                Map.Entry entry = entryArr[i2];
                Mn a2 = this.b.a((String) entry.getKey());
                Mn a3 = this.c.a((String) entry.getValue());
                int utf8BytesLength = StringUtils.getUtf8BytesLength((String) entry.getValue()) + StringUtils.getUtf8BytesLength((String) entry.getKey());
                int utf8BytesLength2 = StringUtils.getUtf8BytesLength((String) a3.f699a) + StringUtils.getUtf8BytesLength((String) a2.f699a);
                if (z || utf8BytesLength2 + i4 > this.f528a) {
                    i3++;
                    i += utf8BytesLength;
                    z = true;
                } else {
                    i = a3.b.getBytesTruncated() + a2.b.getBytesTruncated() + i;
                    int utf8BytesLength3 = StringUtils.getUtf8BytesLength((String) a3.f699a) + StringUtils.getUtf8BytesLength((String) a2.f699a) + i4;
                    hashMap.put((String) a2.f699a, (String) a3.f699a);
                    i4 = utf8BytesLength3;
                }
                i2++;
            }
            i2 = i3;
        } else {
            hashMap = null;
            i = 0;
        }
        return new Mn(hashMap, new C0442n4(i2, i));
    }
}
