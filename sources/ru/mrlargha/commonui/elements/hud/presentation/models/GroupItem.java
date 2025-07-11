package ru.mrlargha.commonui.elements.hud.presentation.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GroupItem.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ<\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/models/GroupItem;", "", "id", "", "name", "", "health", "armor", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getHealth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getArmor", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/hud/presentation/models/GroupItem;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupItem {
    private final Integer armor;
    private final Integer health;
    private final int id;
    private final String name;

    public static /* synthetic */ GroupItem copy$default(GroupItem groupItem, int i, String str, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = groupItem.id;
        }
        if ((i2 & 2) != 0) {
            str = groupItem.name;
        }
        if ((i2 & 4) != 0) {
            num = groupItem.health;
        }
        if ((i2 & 8) != 0) {
            num2 = groupItem.armor;
        }
        return groupItem.copy(i, str, num, num2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.health;
    }

    public final Integer component4() {
        return this.armor;
    }

    public final GroupItem copy(int i, String str, Integer num, Integer num2) {
        return new GroupItem(i, str, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GroupItem) {
            GroupItem groupItem = (GroupItem) obj;
            return this.id == groupItem.id && Intrinsics.areEqual(this.name, groupItem.name) && Intrinsics.areEqual(this.health, groupItem.health) && Intrinsics.areEqual(this.armor, groupItem.armor);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.health;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.armor;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        Integer num = this.health;
        return "GroupItem(id=" + i + ", name=" + str + ", health=" + num + ", armor=" + this.armor + ")";
    }

    public GroupItem(int i, String str, Integer num, Integer num2) {
        this.id = i;
        this.name = str;
        this.health = num;
        this.armor = num2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getHealth() {
        return this.health;
    }

    public final Integer getArmor() {
        return this.armor;
    }
}
