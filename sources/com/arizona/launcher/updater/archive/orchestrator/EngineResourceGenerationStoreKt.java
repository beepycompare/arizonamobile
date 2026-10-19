package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.RangesKt;
/* compiled from: EngineResourceGenerationStore.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ENGINE_RESOURCE_GENERATION", "", "engineResourceGenerationTarget", "remoteGeneration", "preparedGeneration", "completedGeneration", "engineResourceGenerationAction", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationAction;", TypedValues.AttributesType.S_TARGET, "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineResourceGenerationStoreKt {
    public static final long ENGINE_RESOURCE_GENERATION = 2;

    public static final long engineResourceGenerationTarget(long j, long j2, long j3) {
        return ComparisonsKt.maxOf(2L, RangesKt.coerceAtLeast(j, 0L), RangesKt.coerceAtLeast(j2, 0L), RangesKt.coerceAtLeast(j3, 0L));
    }

    public static final EngineResourceGenerationAction engineResourceGenerationAction(long j, long j2, long j3) {
        if (j3 < j || j2 < j) {
            if (j2 >= j) {
                return EngineResourceGenerationAction.RESUME;
            }
            return EngineResourceGenerationAction.MIGRATE;
        }
        return EngineResourceGenerationAction.UP_TO_DATE;
    }
}
