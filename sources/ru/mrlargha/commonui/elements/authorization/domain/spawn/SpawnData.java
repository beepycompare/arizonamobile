package ru.mrlargha.commonui.elements.authorization.domain.spawn;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SpawnData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/spawn/SpawnData;", "", "id", "", "spawn", "", "clicked", "", "<init>", "(ILjava/lang/String;Z)V", "getId", "()I", "getSpawn", "()Ljava/lang/String;", "getClicked", "()Z", "setClicked", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpawnData {
    private boolean clicked;
    private final int id;
    private final String spawn;

    public static /* synthetic */ SpawnData copy$default(SpawnData spawnData, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = spawnData.id;
        }
        if ((i2 & 2) != 0) {
            str = spawnData.spawn;
        }
        if ((i2 & 4) != 0) {
            z = spawnData.clicked;
        }
        return spawnData.copy(i, str, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.spawn;
    }

    public final boolean component3() {
        return this.clicked;
    }

    public final SpawnData copy(int i, String spawn, boolean z) {
        Intrinsics.checkNotNullParameter(spawn, "spawn");
        return new SpawnData(i, spawn, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SpawnData) {
            SpawnData spawnData = (SpawnData) obj;
            return this.id == spawnData.id && Intrinsics.areEqual(this.spawn, spawnData.spawn) && this.clicked == spawnData.clicked;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.spawn.hashCode()) * 31) + Boolean.hashCode(this.clicked);
    }

    public String toString() {
        int i = this.id;
        String str = this.spawn;
        return "SpawnData(id=" + i + ", spawn=" + str + ", clicked=" + this.clicked + ")";
    }

    public SpawnData(int i, String spawn, boolean z) {
        Intrinsics.checkNotNullParameter(spawn, "spawn");
        this.id = i;
        this.spawn = spawn;
        this.clicked = z;
    }

    public /* synthetic */ SpawnData(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final boolean getClicked() {
        return this.clicked;
    }

    public final int getId() {
        return this.id;
    }

    public final String getSpawn() {
        return this.spawn;
    }

    public final void setClicked(boolean z) {
        this.clicked = z;
    }
}
