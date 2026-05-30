package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Wl {

    /* renamed from: a  reason: collision with root package name */
    public final C0198dd f830a;
    public final C0172cd b;

    public Wl(PublicLogger publicLogger, String str) {
        this(new C0198dd(str, publicLogger), new C0172cd(str, publicLogger));
    }

    public final synchronized boolean a(C0275gd c0275gd, String str, String str2) {
        int size = c0275gd.size();
        int i = this.f830a.c.f506a;
        if (size >= i && (i != c0275gd.size() || !c0275gd.containsKey(str))) {
            C0198dd c0198dd = this.f830a;
            c0198dd.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", c0198dd.e, Integer.valueOf(c0198dd.c.f506a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0275gd.f996a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0275gd.containsKey(str)) {
            String str3 = (String) c0275gd.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            C0172cd c0172cd = this.b;
            c0172cd.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", c0172cd.f925a, 4500, str);
            return false;
        }
        c0275gd.put(str, str2);
        return true;
    }

    public final boolean b(C0275gd c0275gd, String str, String str2) {
        if (c0275gd != null) {
            String a2 = this.f830a.f944a.a(str);
            String a3 = this.f830a.b.a(str2);
            if (!c0275gd.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0275gd, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0275gd.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0275gd, a2, a3);
            }
            return false;
        }
        return false;
    }

    public Wl(C0198dd c0198dd, C0172cd c0172cd) {
        this.f830a = c0198dd;
        this.b = c0172cd;
    }
}
