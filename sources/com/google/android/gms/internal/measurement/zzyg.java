package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzyg extends Exception {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyg(Throwable th, zzyv zzyvVar, StackTraceElement[] stackTraceElementArr) {
        super(zzyvVar.toString(), th);
        setStackTrace(stackTraceElementArr);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
