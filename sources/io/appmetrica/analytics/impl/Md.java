package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class Md {

    /* renamed from: a  reason: collision with root package name */
    public final Context f560a;
    public final InterfaceC0301hb b;
    public final U9 c;
    public final Qe d;
    public final ro e;
    public volatile IdentifiersResult f;

    public Md(Context context, InterfaceC0301hb interfaceC0301hb) {
        this(context, interfaceC0301hb, Nd.a(context), new Qe(context), new ro());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult a() {
        IdentifiersResult identifiersResult = this.f;
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            ro roVar = this.e;
            String str = identifiersResult.id;
            roVar.getClass();
            if (ro.a(str)) {
                return identifiersResult;
            }
        }
        try {
            U9 u9 = this.c;
            u9.f675a.lock();
            u9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            ro roVar2 = this.e;
            String str2 = identifiersResult.id;
            roVar2.getClass();
            if (ro.a(str2)) {
                U9 u92 = this.c;
                u92.b.b();
                u92.f675a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = AbstractC0275gb.a(FileUtils.getFileFromSdkStorage(this.d.f621a, "uuid.dat"));
        this.e.getClass();
        if (!ro.a(a2)) {
            a2 = this.d.a(this.b.a(this.f560a));
        }
        this.e.getClass();
        if (ro.a(a2)) {
            IdentifiersResult identifiersResult2 = new IdentifiersResult(a2, IdentifierStatus.OK, null);
            try {
                this.f = identifiersResult2;
            } catch (Throwable unused2) {
            }
            identifiersResult = identifiersResult2;
        }
        U9 u922 = this.c;
        u922.b.b();
        u922.f675a.unlock();
        if (identifiersResult == null) {
        }
    }

    public Md(Context context, InterfaceC0301hb interfaceC0301hb, U9 u9, Qe qe, ro roVar) {
        this.f560a = context;
        this.b = interfaceC0301hb;
        this.c = u9;
        this.d = qe;
        this.e = roVar;
        try {
            u9.a();
            qe.a();
            u9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
