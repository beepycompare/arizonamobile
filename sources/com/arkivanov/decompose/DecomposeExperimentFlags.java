package com.arkivanov.decompose;

import kotlin.Deprecated;
import kotlin.Metadata;
/* compiled from: DecomposeExperimentFlags.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/arkivanov/decompose/DecomposeExperimentFlags;", "", "<init>", "()V", "value", "", "duplicateConfigurationsEnabled", "getDuplicateConfigurationsEnabled$annotations", "getDuplicateConfigurationsEnabled", "()Z", "setDuplicateConfigurationsEnabled", "(Z)V", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DecomposeExperimentFlags {
    public static final DecomposeExperimentFlags INSTANCE = new DecomposeExperimentFlags();

    @Deprecated(message = "The feature has been promoted to stable. Please use DecomposeSettings.duplicateConfigurationsEnabled instead.")
    public static /* synthetic */ void getDuplicateConfigurationsEnabled$annotations() {
    }

    private DecomposeExperimentFlags() {
    }

    public final boolean getDuplicateConfigurationsEnabled() {
        return DecomposeSettings.Companion.getSettings().getDuplicateConfigurationsEnabled();
    }

    public final void setDuplicateConfigurationsEnabled(boolean z) {
        DecomposeSettings.Companion.setSettings(DecomposeSettings.copy$default(DecomposeSettings.Companion.getSettings(), z, false, null, 6, null));
    }
}
