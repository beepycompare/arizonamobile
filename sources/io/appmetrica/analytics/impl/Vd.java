package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class Vd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f814a;
    public final InterfaceC0421mb b;
    public final R9 c;
    public final C0141bf d;
    public final So e;
    public volatile IdentifiersResult f;

    public Vd(Context context, InterfaceC0421mb interfaceC0421mb) {
        this(context, interfaceC0421mb, Wd.a(context), new C0141bf(context), new So());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult a() {
        IdentifiersResult identifiersResult = this.f;
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            So so = this.e;
            String str = identifiersResult.id;
            so.getClass();
            if (So.a(str)) {
                return identifiersResult;
            }
        }
        try {
            R9 r9 = this.c;
            r9.f747a.lock();
            r9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            So so2 = this.e;
            String str2 = identifiersResult.id;
            so2.getClass();
            if (So.a(str2)) {
                R9 r92 = this.c;
                r92.b.b();
                r92.f747a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = AbstractC0395lb.a(FileUtils.getFileFromSdkStorage(this.d.f913a, "uuid.dat"));
        this.e.getClass();
        if (!So.a(a2)) {
            a2 = this.d.a(this.b.a(this.f814a));
        }
        this.e.getClass();
        if (So.a(a2)) {
            IdentifiersResult identifiersResult2 = new IdentifiersResult(a2, IdentifierStatus.OK, null);
            try {
                this.f = identifiersResult2;
            } catch (Throwable unused2) {
            }
            identifiersResult = identifiersResult2;
        }
        R9 r922 = this.c;
        r922.b.b();
        r922.f747a.unlock();
        if (identifiersResult == null) {
        }
    }

    public Vd(Context context, InterfaceC0421mb interfaceC0421mb, R9 r9, C0141bf c0141bf, So so) {
        this.f814a = context;
        this.b = interfaceC0421mb;
        this.c = r9;
        this.d = c0141bf;
        this.e = so;
        try {
            r9.a();
            c0141bf.a();
            r9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
