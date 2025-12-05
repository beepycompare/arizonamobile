package io.appmetrica.analytics.impl;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/impl/Ef;", "Lio/appmetrica/analytics/impl/Df;", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "mProcessName", "<init>", "()V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class Ef implements Df {

    /* renamed from: a  reason: collision with root package name */
    private volatile String f544a;

    private final String b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (invoke != null) {
                return (String) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // io.appmetrica.analytics.impl.Df
    public String a() {
        if (this.f544a != null) {
            return this.f544a;
        }
        synchronized (this) {
            if (this.f544a == null) {
                this.f544a = b();
            }
            Unit unit = Unit.INSTANCE;
        }
        return this.f544a;
    }
}
