package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* renamed from: io.appmetrica.analytics.impl.vd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0651vd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1271a;
    public final Ka b;
    public final C0697x9 c;
    public final Ae d;
    public final po e;
    public volatile IdentifiersResult f;

    public C0651vd(Context context, Ka ka) {
        this(context, ka, AbstractC0676wd.a(context), new Ae(context), new po());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult a() {
        IdentifiersResult identifiersResult = this.f;
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            po poVar = this.e;
            String str = identifiersResult.id;
            poVar.getClass();
            if (po.a(str)) {
                return identifiersResult;
            }
        }
        try {
            C0697x9 c0697x9 = this.c;
            c0697x9.f1302a.lock();
            c0697x9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            po poVar2 = this.e;
            String str2 = identifiersResult.id;
            poVar2.getClass();
            if (po.a(str2)) {
                C0697x9 c0697x92 = this.c;
                c0697x92.b.b();
                c0697x92.f1302a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = Ja.a(FileUtils.getFileFromSdkStorage(this.d.f499a, "uuid.dat"));
        this.e.getClass();
        if (!po.a(a2)) {
            a2 = this.d.a(this.b.a(this.f1271a));
        }
        this.e.getClass();
        if (po.a(a2)) {
            IdentifiersResult identifiersResult2 = new IdentifiersResult(a2, IdentifierStatus.OK, null);
            try {
                this.f = identifiersResult2;
            } catch (Throwable unused2) {
            }
            identifiersResult = identifiersResult2;
        }
        C0697x9 c0697x922 = this.c;
        c0697x922.b.b();
        c0697x922.f1302a.unlock();
        if (identifiersResult == null) {
        }
    }

    public C0651vd(Context context, Ka ka, C0697x9 c0697x9, Ae ae, po poVar) {
        this.f1271a = context;
        this.b = ka;
        this.c = c0697x9;
        this.d = ae;
        this.e = poVar;
        try {
            c0697x9.a();
            ae.a();
            c0697x9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
