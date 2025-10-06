package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Al {

    /* renamed from: a  reason: collision with root package name */
    public final C0175cd f355a;
    public final C0149bd b;

    public Al(PublicLogger publicLogger, String str) {
        this(new C0175cd(str, publicLogger), new C0149bd(str, publicLogger));
    }

    public final synchronized boolean a(C0252fd c0252fd, String str, String str2) {
        int size = c0252fd.size();
        int i = this.f355a.c.f532a;
        if (size >= i && (i != c0252fd.size() || !c0252fd.containsKey(str))) {
            C0175cd c0175cd = this.f355a;
            c0175cd.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", c0175cd.e, Integer.valueOf(c0175cd.c.f532a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0252fd.f878a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0252fd.containsKey(str)) {
            String str3 = (String) c0252fd.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            C0149bd c0149bd = this.b;
            c0149bd.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", c0149bd.f811a, 4500, str);
            return false;
        }
        c0252fd.put(str, str2);
        return true;
    }

    public final boolean b(C0252fd c0252fd, String str, String str2) {
        if (c0252fd != null) {
            String a2 = this.f355a.f824a.a(str);
            String a3 = this.f355a.b.a(str2);
            if (!c0252fd.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0252fd, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0252fd.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0252fd, a2, a3);
            }
            return false;
        }
        return false;
    }

    public Al(C0175cd c0175cd, C0149bd c0149bd) {
        this.f355a = c0175cd;
        this.b = c0149bd;
    }
}
