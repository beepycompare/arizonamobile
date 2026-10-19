package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: EngineResourceGenerationStore.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J)\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001b\u0002\b ¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rÊ\u0001\u0002\b$Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0002¨\u0006#"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;", "", "preparedGeneration", "", "completedGeneration", "<init>", "(JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPreparedGeneration", "()J", "getCompletedGeneration", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class EngineResourceGenerationState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long completedGeneration;
    private final long preparedGeneration;

    public static /* synthetic */ EngineResourceGenerationState copy$default(EngineResourceGenerationState engineResourceGenerationState, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = engineResourceGenerationState.preparedGeneration;
        }
        if ((i & 2) != 0) {
            j2 = engineResourceGenerationState.completedGeneration;
        }
        return engineResourceGenerationState.copy(j, j2);
    }

    public final long component1() {
        return this.preparedGeneration;
    }

    public final long component2() {
        return this.completedGeneration;
    }

    public final EngineResourceGenerationState copy(long j, long j2) {
        return new EngineResourceGenerationState(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EngineResourceGenerationState) {
            EngineResourceGenerationState engineResourceGenerationState = (EngineResourceGenerationState) obj;
            return this.preparedGeneration == engineResourceGenerationState.preparedGeneration && this.completedGeneration == engineResourceGenerationState.completedGeneration;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.preparedGeneration) * 31) + Long.hashCode(this.completedGeneration);
    }

    public String toString() {
        long j = this.preparedGeneration;
        return "EngineResourceGenerationState(preparedGeneration=" + j + ", completedGeneration=" + this.completedGeneration + ")";
    }

    /* compiled from: EngineResourceGenerationStore.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<EngineResourceGenerationState> serializer() {
            return EngineResourceGenerationState$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EngineResourceGenerationState(int i, long j, long j2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, EngineResourceGenerationState$$serializer.INSTANCE.getDescriptor());
        }
        this.preparedGeneration = j;
        this.completedGeneration = j2;
    }

    public EngineResourceGenerationState(long j, long j2) {
        this.preparedGeneration = j;
        this.completedGeneration = j2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(EngineResourceGenerationState engineResourceGenerationState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeLongElement(serialDescriptor, 0, engineResourceGenerationState.preparedGeneration);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, engineResourceGenerationState.completedGeneration);
    }

    public final long getPreparedGeneration() {
        return this.preparedGeneration;
    }

    public final long getCompletedGeneration() {
        return this.completedGeneration;
    }
}
