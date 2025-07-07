package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JoinClan.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lru/mrlargha/arizonaui/family/data/JoinClanData;", "", "id", "", "top", "icon", "name", "", "type", "members", "<init>", "(IIILjava/lang/String;II)V", "getId", "()I", "getTop", "getIcon", "getName", "()Ljava/lang/String;", "getType", "getMembers", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JoinClanData {
    private final int icon;
    private final int id;
    private final int members;
    private final String name;
    private final int top;
    private final int type;

    public static /* synthetic */ JoinClanData copy$default(JoinClanData joinClanData, int i, int i2, int i3, String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = joinClanData.id;
        }
        if ((i6 & 2) != 0) {
            i2 = joinClanData.top;
        }
        if ((i6 & 4) != 0) {
            i3 = joinClanData.icon;
        }
        if ((i6 & 8) != 0) {
            str = joinClanData.name;
        }
        if ((i6 & 16) != 0) {
            i4 = joinClanData.type;
        }
        if ((i6 & 32) != 0) {
            i5 = joinClanData.members;
        }
        int i7 = i4;
        int i8 = i5;
        return joinClanData.copy(i, i2, i3, str, i7, i8);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.icon;
    }

    public final String component4() {
        return this.name;
    }

    public final int component5() {
        return this.type;
    }

    public final int component6() {
        return this.members;
    }

    public final JoinClanData copy(int i, int i2, int i3, String name, int i4, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new JoinClanData(i, i2, i3, name, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JoinClanData) {
            JoinClanData joinClanData = (JoinClanData) obj;
            return this.id == joinClanData.id && this.top == joinClanData.top && this.icon == joinClanData.icon && Intrinsics.areEqual(this.name, joinClanData.name) && this.type == joinClanData.type && this.members == joinClanData.members;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.icon)) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.members);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.top;
        int i3 = this.icon;
        String str = this.name;
        int i4 = this.type;
        return "JoinClanData(id=" + i + ", top=" + i2 + ", icon=" + i3 + ", name=" + str + ", type=" + i4 + ", members=" + this.members + ")";
    }

    public JoinClanData(int i, int i2, int i3, String name, int i4, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.top = i2;
        this.icon = i3;
        this.name = name;
        this.type = i4;
        this.members = i5;
    }

    public final int getId() {
        return this.id;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public final int getMembers() {
        return this.members;
    }
}
