package ru.mrlargha.commonui.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UIElementCompanionFlowTracker.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002%&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\u0010\u001cJ\r\u0010\u001d\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J\u001b\u0010\u001f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\n¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\n¢\u0006\u0002\u0010!J\u0006\u0010#\u001a\u00020\u0010J\b\u0010$\u001a\u00020\nH\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker;", "K", "", "<init>", "()V", TypedValues.AttributesType.S_TARGET, "Ljava/lang/Object;", TypedValues.CycleType.S_WAVE_PHASE, "Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$Phase;", "generation", "", "beginPendingOpen", "Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$PendingOpen;", "key", "(Ljava/lang/Object;)Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$PendingOpen;", "rollbackPendingOpen", "", "pendingOpen", "(Ljava/lang/Object;Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$PendingOpen;)V", "onVisibilityChanged", "", "visible", "(Ljava/lang/Object;Z)Z", "resolve", "(Ljava/lang/Object;)Z", "companionPayloadTarget", "elementExists", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "pendingOpenKey", "()Ljava/lang/Object;", "isPendingOpen", "expectedGeneration", "(Ljava/lang/Object;J)Z", "expirePendingOpen", "clear", "advanceGeneration", "Phase", "PendingOpen", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UIElementCompanionFlowTracker<K> {
    private long generation;
    private Phase phase;
    private K target;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UIElementCompanionFlowTracker.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING_OPEN", "VISIBLE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Phase {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase PENDING_OPEN = new Phase("PENDING_OPEN", 0);
        public static final Phase VISIBLE = new Phase("VISIBLE", 1);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{PENDING_OPEN, VISIBLE};
        }

        public static EnumEntries<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }

        private Phase(String str, int i) {
        }

        static {
            Phase[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: UIElementCompanionFlowTracker.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J@\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$PendingOpen;", "K", "", "previousTarget", "previousPhase", "Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$Phase;", "previousGeneration", "", "generation", "<init>", "(Ljava/lang/Object;Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$Phase;JJ)V", "getPreviousTarget", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPreviousPhase", "()Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$Phase;", "getPreviousGeneration", "()J", "getGeneration", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$Phase;JJ)Lru/mrlargha/commonui/core/UIElementCompanionFlowTracker$PendingOpen;", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PendingOpen<K> {
        private final long generation;
        private final long previousGeneration;
        private final Phase previousPhase;
        private final K previousTarget;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingOpen copy$default(PendingOpen pendingOpen, Object obj, Phase phase, long j, long j2, int i, Object obj2) {
            K k = obj;
            if ((i & 1) != 0) {
                k = pendingOpen.previousTarget;
            }
            if ((i & 2) != 0) {
                phase = pendingOpen.previousPhase;
            }
            if ((i & 4) != 0) {
                j = pendingOpen.previousGeneration;
            }
            if ((i & 8) != 0) {
                j2 = pendingOpen.generation;
            }
            long j3 = j2;
            return pendingOpen.copy(k, phase, j, j3);
        }

        public final K component1() {
            return this.previousTarget;
        }

        public final Phase component2() {
            return this.previousPhase;
        }

        public final long component3() {
            return this.previousGeneration;
        }

        public final long component4() {
            return this.generation;
        }

        public final PendingOpen<K> copy(K k, Phase phase, long j, long j2) {
            return new PendingOpen<>(k, phase, j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PendingOpen) {
                PendingOpen pendingOpen = (PendingOpen) obj;
                return Intrinsics.areEqual(this.previousTarget, pendingOpen.previousTarget) && this.previousPhase == pendingOpen.previousPhase && this.previousGeneration == pendingOpen.previousGeneration && this.generation == pendingOpen.generation;
            }
            return false;
        }

        public int hashCode() {
            K k = this.previousTarget;
            int hashCode = (k == null ? 0 : k.hashCode()) * 31;
            Phase phase = this.previousPhase;
            return ((((hashCode + (phase != null ? phase.hashCode() : 0)) * 31) + Long.hashCode(this.previousGeneration)) * 31) + Long.hashCode(this.generation);
        }

        public String toString() {
            K k = this.previousTarget;
            Phase phase = this.previousPhase;
            long j = this.previousGeneration;
            return "PendingOpen(previousTarget=" + k + ", previousPhase=" + phase + ", previousGeneration=" + j + ", generation=" + this.generation + ")";
        }

        public PendingOpen(K k, Phase phase, long j, long j2) {
            this.previousTarget = k;
            this.previousPhase = phase;
            this.previousGeneration = j;
            this.generation = j2;
        }

        public final K getPreviousTarget() {
            return this.previousTarget;
        }

        public final Phase getPreviousPhase() {
            return this.previousPhase;
        }

        public final long getPreviousGeneration() {
            return this.previousGeneration;
        }

        public final long getGeneration() {
            return this.generation;
        }
    }

    public final PendingOpen<K> beginPendingOpen(K k) {
        K k2 = this.target;
        Phase phase = this.phase;
        long j = this.generation;
        long advanceGeneration = advanceGeneration();
        this.target = k;
        this.phase = Phase.PENDING_OPEN;
        return new PendingOpen<>(k2, phase, j, advanceGeneration);
    }

    public final void rollbackPendingOpen(K k, PendingOpen<K> pendingOpen) {
        Intrinsics.checkNotNullParameter(pendingOpen, "pendingOpen");
        if (isPendingOpen(k, pendingOpen.getGeneration())) {
            this.target = pendingOpen.getPreviousTarget();
            this.phase = pendingOpen.getPreviousPhase();
            this.generation = pendingOpen.getPreviousGeneration();
        }
    }

    public final boolean onVisibilityChanged(K k, boolean z) {
        boolean z2 = this.phase == Phase.PENDING_OPEN && (z || Intrinsics.areEqual(this.target, k));
        if (z) {
            this.target = k;
            this.phase = Phase.VISIBLE;
            advanceGeneration();
            return z2;
        }
        resolve(k);
        return z2;
    }

    public final boolean resolve(K k) {
        boolean z = Intrinsics.areEqual(this.target, k) && this.phase == Phase.PENDING_OPEN;
        if (Intrinsics.areEqual(this.target, k)) {
            this.target = null;
            this.phase = null;
            advanceGeneration();
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, K] */
    public final K companionPayloadTarget(Function1<? super K, Boolean> elementExists) {
        Intrinsics.checkNotNullParameter(elementExists, "elementExists");
        K k = this.target;
        if (k == 0 || !elementExists.invoke(k).booleanValue()) {
            return null;
        }
        return k;
    }

    public final K pendingOpenKey() {
        K k = this.target;
        if (this.phase == Phase.PENDING_OPEN) {
            return k;
        }
        return null;
    }

    public final boolean isPendingOpen(K k) {
        return Intrinsics.areEqual(this.target, k) && this.phase == Phase.PENDING_OPEN;
    }

    public final boolean isPendingOpen(K k, long j) {
        return isPendingOpen(k) && this.generation == j;
    }

    public final boolean expirePendingOpen(K k, long j) {
        if (isPendingOpen(k, j)) {
            this.target = null;
            this.phase = null;
            advanceGeneration();
            return true;
        }
        return false;
    }

    public final void clear() {
        this.target = null;
        this.phase = null;
        advanceGeneration();
    }

    private final long advanceGeneration() {
        long j = this.generation;
        long j2 = j != Long.MAX_VALUE ? 1 + j : 1L;
        this.generation = j2;
        return j2;
    }
}
