package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class Id {

    /* renamed from: a  reason: collision with root package name */
    public final Context f475a;
    public final InterfaceC0213db b;
    public final P9 c;
    public final Me d;
    public final jo e;
    public volatile IdentifiersResult f;

    public Id(Context context, InterfaceC0213db interfaceC0213db) {
        this(context, interfaceC0213db, Jd.a(context), new Me(context), new jo());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult a() {
        IdentifiersResult identifiersResult = this.f;
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            jo joVar = this.e;
            String str = identifiersResult.id;
            joVar.getClass();
            if (jo.a(str)) {
                return identifiersResult;
            }
        }
        try {
            P9 p9 = this.c;
            p9.f578a.lock();
            p9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            jo joVar2 = this.e;
            String str2 = identifiersResult.id;
            joVar2.getClass();
            if (jo.a(str2)) {
                P9 p92 = this.c;
                p92.b.b();
                p92.f578a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = AbstractC0187cb.a(FileUtils.getFileFromSdkStorage(this.d.f536a, "uuid.dat"));
        this.e.getClass();
        if (!jo.a(a2)) {
            a2 = this.d.a(this.b.a(this.f475a));
        }
        this.e.getClass();
        if (jo.a(a2)) {
            IdentifiersResult identifiersResult2 = new IdentifiersResult(a2, IdentifierStatus.OK, null);
            try {
                this.f = identifiersResult2;
            } catch (Throwable unused2) {
            }
            identifiersResult = identifiersResult2;
        }
        P9 p922 = this.c;
        p922.b.b();
        p922.f578a.unlock();
        if (identifiersResult == null) {
        }
    }

    public Id(Context context, InterfaceC0213db interfaceC0213db, P9 p9, Me me2, jo joVar) {
        this.f475a = context;
        this.b = interfaceC0213db;
        this.c = p9;
        this.d = me2;
        this.e = joVar;
        try {
            p9.a();
            me2.a();
            p9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
