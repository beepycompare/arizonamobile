package com.miami.game.core.privacy;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StartDownloadEventGate.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/miami/game/core/privacy/StartDownloadEventGate;", "", "initiallyReported", "", "persistClaim", "Lkotlin/Function0;", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "reported", "claim", "Lcom/miami/game/core/privacy/StartDownloadClaimResult;", "Companion", "privacy"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartDownloadEventGate {
    public static final Companion Companion = new Companion(null);
    private final Function0<Boolean> persistClaim;
    private boolean reported;

    public StartDownloadEventGate(boolean z, Function0<Boolean> persistClaim) {
        Intrinsics.checkNotNullParameter(persistClaim, "persistClaim");
        this.persistClaim = persistClaim;
        this.reported = z;
    }

    public final synchronized StartDownloadClaimResult claim() {
        if (this.reported) {
            return StartDownloadClaimResult.ALREADY_REPORTED;
        }
        this.reported = true;
        Function0<Boolean> function0 = this.persistClaim;
        Result.Companion companion = Result.Companion;
        Object m9916constructorimpl = Result.m9916constructorimpl(function0.invoke());
        if (Result.m9922isFailureimpl(m9916constructorimpl)) {
            m9916constructorimpl = false;
        }
        if (!((Boolean) m9916constructorimpl).booleanValue()) {
            this.reported = false;
            return StartDownloadClaimResult.PERSISTENCE_FAILED;
        }
        return StartDownloadClaimResult.CLAIMED;
    }

    /* compiled from: StartDownloadEventGate.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/miami/game/core/privacy/StartDownloadEventGate$Companion;", "", "<init>", "()V", "wasPreviouslyReported", "", "explicitlyReported", "legacyDownloadPending", "privacyAccepted", "privacy"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean wasPreviouslyReported(boolean z, boolean z2, boolean z3) {
            return z || z2 || z3;
        }

        private Companion() {
        }
    }
}
