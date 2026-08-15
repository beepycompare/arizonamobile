package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Ya extends P2 {
    public final Va b;
    public final Va c;
    public final Xa d;

    public Ya(int i, int i2, int i3) {
        this(i, new Va(i2), new Va(i3));
    }

    public Ya(int i, Va va, Va va2) {
        super(i);
        this.d = new Xa();
        this.b = va;
        this.c = va2;
    }

    @Override // io.appmetrica.analytics.impl.P2, io.appmetrica.analytics.impl.Wa
    public final C0518po a(Map<String, String> map) {
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
                C0518po a2 = this.b.a((String) entry.getKey());
                C0518po a3 = this.c.a((String) entry.getValue());
                int utf8BytesLength = StringUtils.getUtf8BytesLength((String) entry.getValue()) + StringUtils.getUtf8BytesLength((String) entry.getKey());
                int utf8BytesLength2 = StringUtils.getUtf8BytesLength((String) a3.f1155a) + StringUtils.getUtf8BytesLength((String) a2.f1155a);
                if (z || utf8BytesLength2 + i4 > this.f713a) {
                    i3++;
                    i += utf8BytesLength;
                    z = true;
                } else {
                    i = a3.b.getBytesTruncated() + a2.b.getBytesTruncated() + i;
                    int utf8BytesLength3 = StringUtils.getUtf8BytesLength((String) a3.f1155a) + StringUtils.getUtf8BytesLength((String) a2.f1155a) + i4;
                    hashMap.put((String) a2.f1155a, (String) a3.f1155a);
                    i4 = utf8BytesLength3;
                }
                i2++;
            }
            i2 = i3;
        } else {
            hashMap = null;
            i = 0;
        }
        return new C0518po(hashMap, new E4(i2, i));
    }
}
