package com.arizona.game.diagnostics;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: ReportingPolicyState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0011R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0014"}, d2 = {"Lcom/arizona/game/diagnostics/ReportingPolicyState;", "", "<init>", "()V", "value", "", "restartRequired", "getRestartRequired", "()Z", "persistenceReady", "getPersistenceReady", "restartAbandoned", "getRestartAbandoned", "observe", "disableReporting", "collectionEnabled", "persisted", "", FirebaseAnalytics.Param.SUCCESS, "abandonRestart", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReportingPolicyState {
    public static final int $stable = 8;
    private boolean persistenceReady;
    private boolean restartAbandoned;
    private boolean restartRequired;

    public final boolean getRestartRequired() {
        return this.restartRequired;
    }

    public final boolean getPersistenceReady() {
        return this.persistenceReady;
    }

    public final boolean getRestartAbandoned() {
        return this.restartAbandoned;
    }

    public final boolean observe(boolean z, boolean z2) {
        if (z && z2) {
            this.restartRequired = true;
            return true;
        }
        return false;
    }

    public final void persisted(boolean z) {
        this.persistenceReady = z;
    }

    public final void abandonRestart() {
        this.restartAbandoned = true;
    }
}
