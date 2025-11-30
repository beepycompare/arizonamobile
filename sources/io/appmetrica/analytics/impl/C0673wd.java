package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* renamed from: io.appmetrica.analytics.impl.wd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0673wd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1183a;
    public final La b;
    public final C0719y9 c;
    public final Be d;
    public final qo e;
    public volatile IdentifiersResult f;

    public C0673wd(Context context, La la) {
        this(context, la, AbstractC0698xd.a(context), new Be(context), new qo());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult a() {
        IdentifiersResult identifiersResult = this.f;
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            qo qoVar = this.e;
            String str = identifiersResult.id;
            qoVar.getClass();
            if (qo.a(str)) {
                return identifiersResult;
            }
        }
        try {
            C0719y9 c0719y9 = this.c;
            c0719y9.f1215a.lock();
            c0719y9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            qo qoVar2 = this.e;
            String str2 = identifiersResult.id;
            qoVar2.getClass();
            if (qo.a(str2)) {
                C0719y9 c0719y92 = this.c;
                c0719y92.b.b();
                c0719y92.f1215a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = Ka.a(FileUtils.getFileFromSdkStorage(this.d.f411a, "uuid.dat"));
        this.e.getClass();
        if (!qo.a(a2)) {
            a2 = this.d.a(this.b.a(this.f1183a));
        }
        this.e.getClass();
        if (qo.a(a2)) {
            IdentifiersResult identifiersResult2 = new IdentifiersResult(a2, IdentifierStatus.OK, null);
            try {
                this.f = identifiersResult2;
            } catch (Throwable unused2) {
            }
            identifiersResult = identifiersResult2;
        }
        C0719y9 c0719y922 = this.c;
        c0719y922.b.b();
        c0719y922.f1215a.unlock();
        if (identifiersResult == null) {
        }
    }

    public C0673wd(Context context, La la, C0719y9 c0719y9, Be be, qo qoVar) {
        this.f1183a = context;
        this.b = la;
        this.c = c0719y9;
        this.d = be;
        this.e = qoVar;
        try {
            c0719y9.a();
            be.a();
            c0719y9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
