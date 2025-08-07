package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class Kd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f521a;
    public final InterfaceC0257fb b;
    public final S9 c;
    public final Oe d;
    public final mo e;
    public volatile IdentifiersResult f;

    public Kd(Context context, InterfaceC0257fb interfaceC0257fb) {
        this(context, interfaceC0257fb, Ld.a(context), new Oe(context), new mo());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult a() {
        IdentifiersResult identifiersResult = this.f;
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            mo moVar = this.e;
            String str = identifiersResult.id;
            moVar.getClass();
            if (mo.a(str)) {
                return identifiersResult;
            }
        }
        try {
            S9 s9 = this.c;
            s9.f637a.lock();
            s9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            mo moVar2 = this.e;
            String str2 = identifiersResult.id;
            moVar2.getClass();
            if (mo.a(str2)) {
                S9 s92 = this.c;
                s92.b.b();
                s92.f637a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = AbstractC0231eb.a(FileUtils.getFileFromSdkStorage(this.d.f579a, "uuid.dat"));
        this.e.getClass();
        if (!mo.a(a2)) {
            a2 = this.d.a(this.b.a(this.f521a));
        }
        this.e.getClass();
        if (mo.a(a2)) {
            IdentifiersResult identifiersResult2 = new IdentifiersResult(a2, IdentifierStatus.OK, null);
            try {
                this.f = identifiersResult2;
            } catch (Throwable unused2) {
            }
            identifiersResult = identifiersResult2;
        }
        S9 s922 = this.c;
        s922.b.b();
        s922.f637a.unlock();
        if (identifiersResult == null) {
        }
    }

    public Kd(Context context, InterfaceC0257fb interfaceC0257fb, S9 s9, Oe oe, mo moVar) {
        this.f521a = context;
        this.b = interfaceC0257fb;
        this.c = s9;
        this.d = oe;
        this.e = moVar;
        try {
            s9.a();
            oe.a();
            s9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
