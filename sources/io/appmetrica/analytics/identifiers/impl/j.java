package io.appmetrica.analytics.identifiers.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes4.dex */
public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    public final f f320a;

    public j(f fVar) {
        this.f320a = fVar;
    }

    @Override // io.appmetrica.analytics.identifiers.impl.b
    public final c a(Context context) {
        c cVar;
        f fVar;
        try {
            try {
                try {
                    m mVar = (m) ((o) this.f320a.a(context));
                    cVar = new c(IdentifierStatus.OK, new a("huawei", mVar.a(), Boolean.valueOf(mVar.b())), null, 4);
                    fVar = this.f320a;
                } catch (Throwable unused) {
                }
            } catch (g e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "unknown exception during binding huawei services";
                }
                cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, message);
                fVar = this.f320a;
                fVar.b(context);
                return cVar;
            } catch (Throwable th) {
                cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, "exception while fetching hoaid: " + th.getMessage());
                fVar = this.f320a;
                fVar.b(context);
                return cVar;
            }
            fVar.b(context);
            return cVar;
        } catch (Throwable th2) {
            try {
                this.f320a.b(context);
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j() {
        this(new f(r1, i.f319a, "huawei"));
        Intent intent;
        intent = k.f321a;
    }
}
