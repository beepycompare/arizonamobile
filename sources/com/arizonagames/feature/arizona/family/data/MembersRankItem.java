package com.arizonagames.feature.arizona.family.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/arizona/family/data/MembersRankItem;", "", "id", "", "name", "", "rankName", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getRankName", "Lcom/google/gson/annotations/SerializedName;", "value", "rankname", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MembersRankItem {
    private final int id;
    private final String name;
    @SerializedName("rankname")
    private final String rankName;

    public static /* synthetic */ MembersRankItem copy$default(MembersRankItem membersRankItem, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = membersRankItem.id;
        }
        if ((i2 & 2) != 0) {
            str = membersRankItem.name;
        }
        if ((i2 & 4) != 0) {
            str2 = membersRankItem.rankName;
        }
        return membersRankItem.copy(i, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.rankName;
    }

    public final MembersRankItem copy(int i, String name, String rankName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rankName, "rankName");
        return new MembersRankItem(i, name, rankName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MembersRankItem) {
            MembersRankItem membersRankItem = (MembersRankItem) obj;
            return this.id == membersRankItem.id && Intrinsics.areEqual(this.name, membersRankItem.name) && Intrinsics.areEqual(this.rankName, membersRankItem.rankName);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.rankName.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        return "MembersRankItem(id=" + i + ", name=" + str + ", rankName=" + this.rankName + ")";
    }

    public MembersRankItem(int i, String name, String rankName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rankName, "rankName");
        this.id = i;
        this.name = name;
        this.rankName = rankName;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRankName() {
        return this.rankName;
    }
}
