package ru.mrlargha.commonui.elements.employmentNote.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TasksResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/domain/FractionTasks;", "", "id", "", "title", "", "description", "type", "redwards", "", "Lru/mrlargha/commonui/elements/employmentNote/domain/RewardType;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getDescription", "getType", "getRedwards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FractionTasks {
    private final String description;
    private final int id;
    private final List<RewardType> redwards;
    private final String title;
    private final int type;

    public static /* synthetic */ FractionTasks copy$default(FractionTasks fractionTasks, int i, String str, String str2, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = fractionTasks.id;
        }
        if ((i3 & 2) != 0) {
            str = fractionTasks.title;
        }
        if ((i3 & 4) != 0) {
            str2 = fractionTasks.description;
        }
        if ((i3 & 8) != 0) {
            i2 = fractionTasks.type;
        }
        List<RewardType> list2 = list;
        if ((i3 & 16) != 0) {
            list2 = fractionTasks.redwards;
        }
        List list3 = list2;
        String str3 = str2;
        return fractionTasks.copy(i, str, str3, i2, list3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final int component4() {
        return this.type;
    }

    public final List<RewardType> component5() {
        return this.redwards;
    }

    public final FractionTasks copy(int i, String title, String description, int i2, List<RewardType> redwards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(redwards, "redwards");
        return new FractionTasks(i, title, description, i2, redwards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionTasks) {
            FractionTasks fractionTasks = (FractionTasks) obj;
            return this.id == fractionTasks.id && Intrinsics.areEqual(this.title, fractionTasks.title) && Intrinsics.areEqual(this.description, fractionTasks.description) && this.type == fractionTasks.type && Intrinsics.areEqual(this.redwards, fractionTasks.redwards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + this.redwards.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.description;
        int i2 = this.type;
        return "FractionTasks(id=" + i + ", title=" + str + ", description=" + str2 + ", type=" + i2 + ", redwards=" + this.redwards + ")";
    }

    public FractionTasks(int i, String title, String description, int i2, List<RewardType> redwards) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(redwards, "redwards");
        this.id = i;
        this.title = title;
        this.description = description;
        this.type = i2;
        this.redwards = redwards;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getType() {
        return this.type;
    }

    public final List<RewardType> getRedwards() {
        return this.redwards;
    }
}
