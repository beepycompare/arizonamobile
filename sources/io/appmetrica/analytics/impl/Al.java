package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Al {

    /* renamed from: a  reason: collision with root package name */
    public final C0174cd f350a;
    public final C0148bd b;

    public Al(PublicLogger publicLogger, String str) {
        this(new C0174cd(str, publicLogger), new C0148bd(str, publicLogger));
    }

    public final synchronized boolean a(C0251fd c0251fd, String str, String str2) {
        int size = c0251fd.size();
        int i = this.f350a.c.f527a;
        if (size >= i && (i != c0251fd.size() || !c0251fd.containsKey(str))) {
            C0174cd c0174cd = this.f350a;
            c0174cd.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", c0174cd.e, Integer.valueOf(c0174cd.c.f527a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0251fd.f873a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0251fd.containsKey(str)) {
            String str3 = (String) c0251fd.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            C0148bd c0148bd = this.b;
            c0148bd.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", c0148bd.f806a, 4500, str);
            return false;
        }
        c0251fd.put(str, str2);
        return true;
    }

    public final boolean b(C0251fd c0251fd, String str, String str2) {
        if (c0251fd != null) {
            String a2 = this.f350a.f819a.a(str);
            String a3 = this.f350a.b.a(str2);
            if (!c0251fd.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0251fd, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0251fd.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0251fd, a2, a3);
            }
            return false;
        }
        return false;
    }

    public Al(C0174cd c0174cd, C0148bd c0148bd) {
        this.f350a = c0174cd;
        this.b = c0148bd;
    }
}
