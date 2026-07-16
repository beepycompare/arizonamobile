package io.appmetrica.analytics.identifiers.impl;

import android.content.Context;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
/* loaded from: classes5.dex */
public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    public final f f407a;

    public j(f fVar) {
        this.f407a = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v7, types: [io.appmetrica.analytics.identifiers.impl.f] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // io.appmetrica.analytics.identifiers.impl.b
    public final c a(Context context) {
        c cVar;
        try {
            try {
                try {
                    m mVar = (m) ((o) this.f407a.a(context));
                    cVar = new c(IdentifierStatus.OK, new a("huawei", mVar.a(), Boolean.valueOf(mVar.b())), null, 4);
                    this = this.f407a;
                } catch (Throwable unused) {
                }
            } catch (g e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "unknown exception during binding huawei services";
                }
                cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, message);
                this = this.f407a;
                this.b(context);
                return cVar;
            } catch (Throwable th) {
                cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, "exception while fetching hoaid: " + th.getMessage());
                this = this.f407a;
                this.b(context);
                return cVar;
            }
            this.b(context);
            return cVar;
        } catch (Throwable th2) {
            try {
                this.f407a.b(context);
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
        this(new f(r1, i.f406a, "huawei"));
        Intent intent;
        intent = k.f408a;
    }
}
