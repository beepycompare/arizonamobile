package ru.mrlargha.arizonaui.family.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/family/data/MemberRequestItem;", "", "id", "", "name", "", FirebaseAnalytics.Param.LEVEL, "online", "<init>", "(ILjava/lang/String;II)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getLevel", "getOnline", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemberRequestItem {
    private final int id;
    private final int level;
    private final String name;
    private final int online;

    public static /* synthetic */ MemberRequestItem copy$default(MemberRequestItem memberRequestItem, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = memberRequestItem.id;
        }
        if ((i4 & 2) != 0) {
            str = memberRequestItem.name;
        }
        if ((i4 & 4) != 0) {
            i2 = memberRequestItem.level;
        }
        if ((i4 & 8) != 0) {
            i3 = memberRequestItem.online;
        }
        return memberRequestItem.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.level;
    }

    public final int component4() {
        return this.online;
    }

    public final MemberRequestItem copy(int i, String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MemberRequestItem(i, name, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemberRequestItem) {
            MemberRequestItem memberRequestItem = (MemberRequestItem) obj;
            return this.id == memberRequestItem.id && Intrinsics.areEqual(this.name, memberRequestItem.name) && this.level == memberRequestItem.level && this.online == memberRequestItem.online;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.online);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.level;
        return "MemberRequestItem(id=" + i + ", name=" + str + ", level=" + i2 + ", online=" + this.online + ")";
    }

    public MemberRequestItem(int i, String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.level = i2;
        this.online = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getOnline() {
        return this.online;
    }
}
