package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class Vd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f808a;
    public final InterfaceC0428mb b;
    public final R9 c;
    public final C0148bf d;
    public final So e;
    public volatile IdentifiersResult f;

    public Vd(Context context, InterfaceC0428mb interfaceC0428mb) {
        this(context, interfaceC0428mb, Wd.a(context), new C0148bf(context), new So());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
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
            r9.f741a.lock();
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
                r92.f741a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = AbstractC0402lb.a(FileUtils.getFileFromSdkStorage(this.d.f907a, "uuid.dat"));
        this.e.getClass();
        if (!So.a(a2)) {
            a2 = this.d.a(this.b.a(this.f808a));
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
        r922.f741a.unlock();
        if (identifiersResult == null) {
        }
    }

    public Vd(Context context, InterfaceC0428mb interfaceC0428mb, R9 r9, C0148bf c0148bf, So so) {
        this.f808a = context;
        this.b = interfaceC0428mb;
        this.c = r9;
        this.d = c0148bf;
        this.e = so;
        try {
            r9.a();
            c0148bf.a();
            r9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
