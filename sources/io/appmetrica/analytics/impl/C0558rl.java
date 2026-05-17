package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.rl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0558rl {

    /* renamed from: a  reason: collision with root package name */
    public final Cc f1216a;
    public final Bc b;

    public C0558rl(PublicLogger publicLogger, String str) {
        this(new Cc(str, publicLogger), new Bc(str, publicLogger));
    }

    public final synchronized boolean a(Fc fc, String str, String str2) {
        int size = fc.size();
        int i = this.f1216a.c.f1114a;
        if (size >= i && (i != fc.size() || !fc.containsKey(str))) {
            Cc cc = this.f1216a;
            cc.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", cc.e, Integer.valueOf(cc.c.f1114a), str);
            return false;
        }
        this.b.getClass();
        int i2 = fc.f585a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (fc.containsKey(str)) {
            String str3 = (String) fc.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            Bc bc = this.b;
            bc.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", bc.f522a, 4500, str);
            return false;
        }
        fc.put(str, str2);
        return true;
    }

    public final boolean b(Fc fc, String str, String str2) {
        if (fc != null) {
            String a2 = this.f1216a.f537a.a(str);
            String a3 = this.f1216a.b.a(str2);
            if (!fc.containsKey(a2)) {
                if (a3 != null) {
                    return a(fc, a2, a3);
                }
                return false;
            }
            String str3 = (String) fc.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(fc, a2, a3);
            }
            return false;
        }
        return false;
    }

    public C0558rl(Cc cc, Bc bc) {
        this.f1216a = cc;
        this.b = bc;
    }
}
