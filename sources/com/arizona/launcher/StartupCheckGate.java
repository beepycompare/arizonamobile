package com.arizona.launcher;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StartupCheckGate.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/StartupCheckGate;", "", "onReady", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "lock", "serviceReady", "", "configurationReady", "dispatched", "closed", "onServiceReady", "onConfigurationReady", "onServiceUnavailable", "close", "markReady", NotificationCompat.CATEGORY_SERVICE, "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StartupCheckGate {
    public static final int $stable = 8;
    private boolean closed;
    private boolean configurationReady;
    private boolean dispatched;
    private final Object lock;
    private final Function0<Unit> onReady;
    private boolean serviceReady;

    public StartupCheckGate(Function0<Unit> onReady) {
        Intrinsics.checkNotNullParameter(onReady, "onReady");
        this.onReady = onReady;
        this.lock = new Object();
    }

    public final void onServiceReady() {
        markReady(true);
    }

    public final void onConfigurationReady() {
        markReady(false);
    }

    public final void onServiceUnavailable() {
        synchronized (this.lock) {
            if (!this.dispatched) {
                this.serviceReady = false;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void close() {
        synchronized (this.lock) {
            this.closed = true;
            this.serviceReady = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void markReady(boolean z) {
        boolean z2;
        synchronized (this.lock) {
            z2 = false;
            if (!this.closed) {
                if (z) {
                    this.serviceReady = true;
                } else {
                    this.configurationReady = true;
                }
                if (this.serviceReady && this.configurationReady && !this.dispatched) {
                    this.dispatched = true;
                    z2 = true;
                }
            }
        }
        if (z2) {
            this.onReady.invoke();
        }
    }
}
