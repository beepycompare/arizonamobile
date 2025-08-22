package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Sa extends O2 {
    public final Pa b;
    public final Pa c;
    public final Ra d;

    public Sa(int i, int i2, int i3) {
        this(i, new Pa(i2), new Pa(i3));
    }

    public Sa(int i, Pa pa, Pa pa2) {
        super(i);
        this.d = new Ra();
        this.b = pa;
        this.c = pa2;
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.impl.Qa
    public final On a(Map<String, String> map) {
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
                On a2 = this.b.a((String) entry.getKey());
                On a3 = this.c.a((String) entry.getValue());
                int utf8BytesLength = StringUtils.getUtf8BytesLength((String) entry.getValue()) + StringUtils.getUtf8BytesLength((String) entry.getKey());
                int utf8BytesLength2 = StringUtils.getUtf8BytesLength((String) a3.f594a) + StringUtils.getUtf8BytesLength((String) a2.f594a);
                if (z || utf8BytesLength2 + i4 > this.f584a) {
                    i3++;
                    i += utf8BytesLength;
                    z = true;
                } else {
                    i = a3.b.getBytesTruncated() + a2.b.getBytesTruncated() + i;
                    int utf8BytesLength3 = StringUtils.getUtf8BytesLength((String) a3.f594a) + StringUtils.getUtf8BytesLength((String) a2.f594a) + i4;
                    hashMap.put((String) a2.f594a, (String) a3.f594a);
                    i4 = utf8BytesLength3;
                }
                i2++;
            }
            i2 = i3;
        } else {
            hashMap = null;
            i = 0;
        }
        return new On(hashMap, new I4(i2, i));
    }
}
