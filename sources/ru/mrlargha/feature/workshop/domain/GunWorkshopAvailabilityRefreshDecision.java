package ru.mrlargha.feature.workshop.domain;

import kotlin.Metadata;
/* compiled from: GunWorkshopRules.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/feature/workshop/domain/GunWorkshopAvailabilityRefreshDecision;", "", "keepPending", "", "requestServerAvailability", "<init>", "(ZZ)V", "getKeepPending", "()Z", "getRequestServerAvailability", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GunWorkshopAvailabilityRefreshDecision {
    private final boolean keepPending;
    private final boolean requestServerAvailability;

    public static /* synthetic */ GunWorkshopAvailabilityRefreshDecision copy$default(GunWorkshopAvailabilityRefreshDecision gunWorkshopAvailabilityRefreshDecision, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = gunWorkshopAvailabilityRefreshDecision.keepPending;
        }
        if ((i & 2) != 0) {
            z2 = gunWorkshopAvailabilityRefreshDecision.requestServerAvailability;
        }
        return gunWorkshopAvailabilityRefreshDecision.copy(z, z2);
    }

    public final boolean component1() {
        return this.keepPending;
    }

    public final boolean component2() {
        return this.requestServerAvailability;
    }

    public final GunWorkshopAvailabilityRefreshDecision copy(boolean z, boolean z2) {
        return new GunWorkshopAvailabilityRefreshDecision(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GunWorkshopAvailabilityRefreshDecision) {
            GunWorkshopAvailabilityRefreshDecision gunWorkshopAvailabilityRefreshDecision = (GunWorkshopAvailabilityRefreshDecision) obj;
            return this.keepPending == gunWorkshopAvailabilityRefreshDecision.keepPending && this.requestServerAvailability == gunWorkshopAvailabilityRefreshDecision.requestServerAvailability;
        }
        return false;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.keepPending) * 31) + Boolean.hashCode(this.requestServerAvailability);
    }

    public String toString() {
        boolean z = this.keepPending;
        return "GunWorkshopAvailabilityRefreshDecision(keepPending=" + z + ", requestServerAvailability=" + this.requestServerAvailability + ")";
    }

    public GunWorkshopAvailabilityRefreshDecision(boolean z, boolean z2) {
        this.keepPending = z;
        this.requestServerAvailability = z2;
    }

    public final boolean getKeepPending() {
        return this.keepPending;
    }

    public final boolean getRequestServerAvailability() {
        return this.requestServerAvailability;
    }
}
