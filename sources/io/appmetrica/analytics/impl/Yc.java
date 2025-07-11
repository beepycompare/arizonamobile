package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Yc extends HashMap {

    /* renamed from: a  reason: collision with root package name */
    public int f721a;

    public Yc() {
        this.f721a = 0;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public final String put(String str, String str2) {
        if (!containsKey(str)) {
            if (str2 != null) {
                this.f721a = str2.length() + str.length() + this.f721a;
                return (String) super.put(str, str2);
            }
            return null;
        }
        if (str2 == null) {
            if (containsKey(str)) {
                String str3 = (String) get(str);
                this.f721a -= str.length() + (str3 != null ? str3.length() : 0);
            }
            return (String) super.remove(str);
        }
        String str4 = (String) get(str);
        this.f721a = (str2.length() - (str4 != null ? str4.length() : 0)) + this.f721a;
        return (String) super.put(str, str2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (containsKey(obj)) {
            String str = (String) get(obj);
            this.f721a -= ((String) obj).length() + (str == null ? 0 : str.length());
        }
        return (String) super.remove(obj);
    }

    public Yc(String str) {
        super(AbstractC0753zb.d(str));
        this.f721a = 0;
        for (String str2 : keySet()) {
            String str3 = (String) get(str2);
            this.f721a = str2.length() + (str3 == null ? 0 : str3.length()) + this.f721a;
        }
    }
}
