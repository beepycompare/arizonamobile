package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FamilyData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/family/data/Leader;", "", "name", "", "online", "", "role", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getOnline", "()I", "getRole", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Leader {
    private final String name;
    private final int online;
    private final String role;

    public static /* synthetic */ Leader copy$default(Leader leader, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = leader.name;
        }
        if ((i2 & 2) != 0) {
            i = leader.online;
        }
        if ((i2 & 4) != 0) {
            str2 = leader.role;
        }
        return leader.copy(str, i, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.online;
    }

    public final String component3() {
        return this.role;
    }

    public final Leader copy(String name, int i, String role) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(role, "role");
        return new Leader(name, i, role);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Leader) {
            Leader leader = (Leader) obj;
            return Intrinsics.areEqual(this.name, leader.name) && this.online == leader.online && Intrinsics.areEqual(this.role, leader.role);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Integer.hashCode(this.online)) * 31) + this.role.hashCode();
    }

    public String toString() {
        String str = this.name;
        int i = this.online;
        return "Leader(name=" + str + ", online=" + i + ", role=" + this.role + ")";
    }

    public Leader(String name, int i, String role) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(role, "role");
        this.name = name;
        this.online = i;
        this.role = role;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOnline() {
        return this.online;
    }

    public final String getRole() {
        return this.role;
    }
}
