package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes5.dex */
public final class Cd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f424a;
    public final Ra b;
    public final E9 c;
    public final Ge d;
    public final ro e;
    public volatile IdentifiersResult f;

    public Cd(Context context, Ra ra) {
        this(context, ra, Dd.a(context), new Ge(context), new ro());
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
            E9 e9 = this.c;
            e9.f456a.lock();
            e9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            ro roVar2 = this.e;
            String str2 = identifiersResult.id;
            roVar2.getClass();
            if (ro.a(str2)) {
                E9 e92 = this.c;
                e92.b.b();
                e92.f456a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = Qa.a(FileUtils.getFileFromSdkStorage(this.d.f491a, "uuid.dat"));
        this.e.getClass();
        if (!ro.a(a2)) {
            a2 = this.d.a(this.b.a(this.f424a));
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
        E9 e922 = this.c;
        e922.b.b();
        e922.f456a.unlock();
        if (identifiersResult == null) {
        }
    }

    public Cd(Context context, Ra ra, E9 e9, Ge ge, ro roVar) {
        this.f424a = context;
        this.b = ra;
        this.c = e9;
        this.d = ge;
        this.e = roVar;
        try {
            e9.a();
            ge.a();
            e9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
