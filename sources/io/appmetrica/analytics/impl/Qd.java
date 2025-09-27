package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
/* loaded from: classes4.dex */
public final class Qd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f640a;
    public final InterfaceC0378kb b;
    public final X9 c;
    public final Ue d;
    public final vo e;
    public volatile IdentifiersResult f;

    public Qd(Context context, InterfaceC0378kb interfaceC0378kb) {
        this(context, interfaceC0378kb, Rd.a(context), new Ue(context), new vo());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult a() {
        IdentifiersResult identifiersResult = this.f;
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            vo voVar = this.e;
            String str = identifiersResult.id;
            voVar.getClass();
            if (vo.a(str)) {
                return identifiersResult;
            }
        }
        try {
            X9 x9 = this.c;
            x9.f740a.lock();
            x9.b.a();
            identifiersResult = this.f;
        } catch (Throwable unused) {
        }
        if (identifiersResult != null && identifiersResult.status == IdentifierStatus.OK) {
            vo voVar2 = this.e;
            String str2 = identifiersResult.id;
            voVar2.getClass();
            if (vo.a(str2)) {
                X9 x92 = this.c;
                x92.b.b();
                x92.f740a.unlock();
                return identifiersResult == null ? identifiersResult : new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "Uuid must be obtained via async API AppMetrica#requestStartupParams(Context, StartupParamsCallback, List<String>)");
            }
        }
        String a2 = AbstractC0352jb.a(FileUtils.getFileFromSdkStorage(this.d.f701a, "uuid.dat"));
        this.e.getClass();
        if (!vo.a(a2)) {
            a2 = this.d.a(this.b.a(this.f640a));
        }
        this.e.getClass();
        if (vo.a(a2)) {
            IdentifiersResult identifiersResult2 = new IdentifiersResult(a2, IdentifierStatus.OK, null);
            try {
                this.f = identifiersResult2;
            } catch (Throwable unused2) {
            }
            identifiersResult = identifiersResult2;
        }
        X9 x922 = this.c;
        x922.b.b();
        x922.f740a.unlock();
        if (identifiersResult == null) {
        }
    }

    public Qd(Context context, InterfaceC0378kb interfaceC0378kb, X9 x9, Ue ue, vo voVar) {
        this.f640a = context;
        this.b = interfaceC0378kb;
        this.c = x9;
        this.d = ue;
        this.e = voVar;
        try {
            x9.a();
            ue.a();
            x9.b();
        } catch (Throwable unused) {
            this.c.b();
        }
    }
}
