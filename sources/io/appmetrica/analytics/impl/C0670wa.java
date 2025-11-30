package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.wa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0670wa extends D2 {
    public final C0595ta b;
    public final C0595ta c;
    public final C0645va d;

    public C0670wa(int i, int i2, int i3) {
        this(i, new C0595ta(i2), new C0595ta(i3));
    }

    public C0670wa(int i, C0595ta c0595ta, C0595ta c0595ta2) {
        super(i);
        this.d = new C0645va();
        this.b = c0595ta;
        this.c = c0595ta2;
    }

    @Override // io.appmetrica.analytics.impl.D2, io.appmetrica.analytics.impl.InterfaceC0620ua
    public final Nn a(Map<String, String> map) {
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
                Nn a2 = this.b.a((String) entry.getKey());
                Nn a3 = this.c.a((String) entry.getValue());
                int utf8BytesLength = StringUtils.getUtf8BytesLength((String) entry.getValue()) + StringUtils.getUtf8BytesLength((String) entry.getKey());
                int utf8BytesLength2 = StringUtils.getUtf8BytesLength((String) a3.f611a) + StringUtils.getUtf8BytesLength((String) a2.f611a);
                if (z || utf8BytesLength2 + i4 > this.f439a) {
                    i3++;
                    i += utf8BytesLength;
                    z = true;
                } else {
                    i = a3.b.getBytesTruncated() + a2.b.getBytesTruncated() + i;
                    int utf8BytesLength3 = StringUtils.getUtf8BytesLength((String) a3.f611a) + StringUtils.getUtf8BytesLength((String) a2.f611a) + i4;
                    hashMap.put((String) a2.f611a, (String) a3.f611a);
                    i4 = utf8BytesLength3;
                }
                i2++;
            }
            i2 = i3;
        } else {
            hashMap = null;
            i = 0;
        }
        return new Nn(hashMap, new C0465o4(i2, i));
    }
}
