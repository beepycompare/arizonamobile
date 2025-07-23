package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.rl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0565rl {

    /* renamed from: a  reason: collision with root package name */
    public final Xc f1041a;
    public final Wc b;

    public C0565rl(PublicLogger publicLogger, String str) {
        this(new Xc(str, publicLogger), new Wc(str, publicLogger));
    }

    public final synchronized boolean a(C0129ad c0129ad, String str, String str2) {
        int size = c0129ad.size();
        int i = this.f1041a.c.f464a;
        if (size >= i && (i != c0129ad.size() || !c0129ad.containsKey(str))) {
            Xc xc = this.f1041a;
            xc.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", xc.e, Integer.valueOf(xc.c.f464a), str);
            return false;
        }
        this.b.getClass();
        int i2 = c0129ad.f767a;
        if (str2 != null) {
            i2 += str2.length();
        }
        if (c0129ad.containsKey(str)) {
            String str3 = (String) c0129ad.get(str);
            if (str3 != null) {
                i2 -= str3.length();
            }
        } else {
            i2 += str.length();
        }
        if (i2 > 4500) {
            Wc wc = this.b;
            wc.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", wc.f701a, 4500, str);
            return false;
        }
        c0129ad.put(str, str2);
        return true;
    }

    public final boolean b(C0129ad c0129ad, String str, String str2) {
        if (c0129ad != null) {
            String a2 = this.f1041a.f716a.a(str);
            String a3 = this.f1041a.b.a(str2);
            if (!c0129ad.containsKey(a2)) {
                if (a3 != null) {
                    return a(c0129ad, a2, a3);
                }
                return false;
            }
            String str3 = (String) c0129ad.get(a2);
            if (a3 == null || !a3.equals(str3)) {
                return a(c0129ad, a2, a3);
            }
            return false;
        }
        return false;
    }

    public C0565rl(Xc xc, Wc wc) {
        this.f1041a = xc;
        this.b = wc;
    }
}
