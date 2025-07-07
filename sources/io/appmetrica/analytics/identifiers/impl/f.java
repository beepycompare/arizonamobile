package io.appmetrica.analytics.identifiers.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.media3.common.C;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import kotlin.jvm.functions.Function1;
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final e f316a;
    public final Function1 b;
    public final String c;
    public final SafePackageManager d;

    public f(e eVar, Function1 function1, String str, SafePackageManager safePackageManager) {
        this.f316a = eVar;
        this.b = function1;
        this.c = str;
        this.d = safePackageManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Context context) {
        IBinder iBinder;
        e eVar;
        if (this.d.resolveService(context, this.f316a.f315a, 0) != null) {
            try {
                eVar = this.f316a;
            } catch (Throwable unused) {
            }
            if (context.bindService(eVar.f315a, eVar, 1)) {
                e eVar2 = this.f316a;
                if (eVar2.b == null) {
                    synchronized (eVar2.c) {
                        if (eVar2.b == null) {
                            try {
                                eVar2.c.wait(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                }
                iBinder = eVar2.b;
                if (iBinder == null) {
                    return this.b.invoke(iBinder);
                }
                throw new g("could not bind to " + this.c + " services");
            }
            iBinder = null;
            if (iBinder == null) {
            }
        } else {
            throw new l("could not resolve " + this.c + " services");
        }
    }

    public final void b(Context context) {
        try {
            this.f316a.a(context);
        } catch (Throwable unused) {
        }
    }

    public f(Intent intent, Function1 function1, String str) {
        this(new e(intent, str), function1, str, new SafePackageManager());
    }
}
