package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class Zk {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0387l2 f867a;

    public Zk(InterfaceC0387l2 interfaceC0387l2) {
        this.f867a = interfaceC0387l2;
    }

    public final ArrayList a(Iterable iterable) {
        String str;
        String a2;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            try {
                a2 = this.f867a.a(str2);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (a2 == null || (str = StringUtils.toHexString(MessageDigest.getInstance("SHA-256").digest(a2.getBytes(Charsets.UTF_8)))) == null) {
                PublicLogger.Companion.getAnonymousInstance().info("Input " + str2 + " is not a valid data", new Object[0]);
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
