package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.wl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0688wl {

    /* renamed from: a  reason: collision with root package name */
    public final Zc f1127a;
    public final Yc b;

    public C0688wl(PublicLogger publicLogger, String str) {
        this(new Zc(str, publicLogger), new Yc(str, publicLogger));
    }

    public final synchronized boolean a(C0174cd c0174cd, String str, String str2) {
        int size = c0174cd.size();
        int i = this.f1127a.c.f469a;
        if (size >= i && (i != c0174cd.size() || !c0174cd.containsKey(str))) {
            Zc zc = this.f1127a;
            zc.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", zc.e, Integer.valueOf(zc.c.f469a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0174cd.f810a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0174cd.containsKey(str)) {
            String str3 = (String) c0174cd.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            Yc yc = this.b;
            yc.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", yc.f741a, 4500, str);
            return false;
        }
        c0174cd.put(str, str2);
        return true;
    }

    public final boolean b(C0174cd c0174cd, String str, String str2) {
        if (c0174cd != null) {
            String a2 = this.f1127a.f756a.a(str);
            String a3 = this.f1127a.b.a(str2);
            if (!c0174cd.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0174cd, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0174cd.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0174cd, a2, a3);
            }
            return false;
        }
        return false;
    }

    public C0688wl(Zc zc, Yc yc) {
        this.f1127a = zc;
        this.b = yc;
    }
}
