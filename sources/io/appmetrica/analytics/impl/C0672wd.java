package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* renamed from: io.appmetrica.analytics.impl.wd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0672wd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1280a;
    public final La b;
    public final C0718y9 c;
    public final Be d;
    public final qo e;
    public volatile IdentifiersResult f;

    public C0672wd(Context context, La la) {
        this(context, la, AbstractC0697xd.a(context), new Be(context), new qo());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
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
            C0718y9 c0718y9 = this.c;
            c0718y9.f1312a.lock();
            c0718y9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            qo qoVar2 = this.e;
            String str2 = identifiersResult.id;
            qoVar2.getClass();
            if (qo.a(str2)) {
                C0718y9 c0718y92 = this.c;
                c0718y92.b.b();
                c0718y92.f1312a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = Ka.a(FileUtils.getFileFromSdkStorage(this.d.f508a, "uuid.dat"));
        this.e.getClass();
        if (!qo.a(a2)) {
            a2 = this.d.a(this.b.a(this.f1280a));
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
        C0718y9 c0718y922 = this.c;
        c0718y922.b.b();
        c0718y922.f1312a.unlock();
        if (identifiersResult == null) {
        }
    }

    public C0672wd(Context context, La la, C0718y9 c0718y9, Be be, qo qoVar) {
        this.f1280a = context;
        this.b = la;
        this.c = c0718y9;
        this.d = be;
        this.e = qoVar;
        try {
            c0718y9.a();
            be.a();
            c0718y9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
