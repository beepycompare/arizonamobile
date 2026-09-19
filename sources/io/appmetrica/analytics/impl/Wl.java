package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Wl {

    /* renamed from: a  reason: collision with root package name */
    public final C0196dd f832a;
    public final C0170cd b;

    public Wl(PublicLogger publicLogger, String str) {
        this(new C0196dd(str, publicLogger), new C0170cd(str, publicLogger));
    }

    public final synchronized boolean a(C0273gd c0273gd, String str, String str2) {
        int size = c0273gd.size();
        int i = this.f832a.c.f508a;
        if (size >= i && (i != c0273gd.size() || !c0273gd.containsKey(str))) {
            C0196dd c0196dd = this.f832a;
            c0196dd.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", c0196dd.e, Integer.valueOf(c0196dd.c.f508a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0273gd.f998a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0273gd.containsKey(str)) {
            String str3 = (String) c0273gd.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            C0170cd c0170cd = this.b;
            c0170cd.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", c0170cd.f927a, 4500, str);
            return false;
        }
        c0273gd.put(str, str2);
        return true;
    }

    public final boolean b(C0273gd c0273gd, String str, String str2) {
        if (c0273gd != null) {
            String a2 = this.f832a.f946a.a(str);
            String a3 = this.f832a.b.a(str2);
            if (!c0273gd.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0273gd, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0273gd.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0273gd, a2, a3);
            }
            return false;
        }
        return false;
    }

    public Wl(C0196dd c0196dd, C0170cd c0170cd) {
        this.f832a = c0196dd;
        this.b = c0170cd;
    }
}
