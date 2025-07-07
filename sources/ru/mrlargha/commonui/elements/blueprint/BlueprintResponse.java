package ru.mrlargha.commonui.elements.blueprint;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BlueprintResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/blueprint/BlueprintResponse;", "", "title", "", "weaponId", "money", "", "experience", "drafts", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "getTitle", "()Ljava/lang/String;", "getWeaponId", "getMoney", "()I", "getExperience", "getDrafts", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BlueprintResponse {
    private final int drafts;
    private final int experience;
    private final int money;
    private final String title;
    private final String weaponId;

    public static /* synthetic */ BlueprintResponse copy$default(BlueprintResponse blueprintResponse, String str, String str2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = blueprintResponse.title;
        }
        if ((i4 & 2) != 0) {
            str2 = blueprintResponse.weaponId;
        }
        if ((i4 & 4) != 0) {
            i = blueprintResponse.money;
        }
        if ((i4 & 8) != 0) {
            i2 = blueprintResponse.experience;
        }
        if ((i4 & 16) != 0) {
            i3 = blueprintResponse.drafts;
        }
        int i5 = i3;
        int i6 = i;
        return blueprintResponse.copy(str, str2, i6, i2, i5);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.weaponId;
    }

    public final int component3() {
        return this.money;
    }

    public final int component4() {
        return this.experience;
    }

    public final int component5() {
        return this.drafts;
    }

    public final BlueprintResponse copy(String title, String weaponId, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(weaponId, "weaponId");
        return new BlueprintResponse(title, weaponId, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlueprintResponse) {
            BlueprintResponse blueprintResponse = (BlueprintResponse) obj;
            return Intrinsics.areEqual(this.title, blueprintResponse.title) && Intrinsics.areEqual(this.weaponId, blueprintResponse.weaponId) && this.money == blueprintResponse.money && this.experience == blueprintResponse.experience && this.drafts == blueprintResponse.drafts;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.weaponId.hashCode()) * 31) + Integer.hashCode(this.money)) * 31) + Integer.hashCode(this.experience)) * 31) + Integer.hashCode(this.drafts);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.weaponId;
        int i = this.money;
        int i2 = this.experience;
        return "BlueprintResponse(title=" + str + ", weaponId=" + str2 + ", money=" + i + ", experience=" + i2 + ", drafts=" + this.drafts + ")";
    }

    public BlueprintResponse(String title, String weaponId, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(weaponId, "weaponId");
        this.title = title;
        this.weaponId = weaponId;
        this.money = i;
        this.experience = i2;
        this.drafts = i3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getWeaponId() {
        return this.weaponId;
    }

    public final int getMoney() {
        return this.money;
    }

    public final int getExperience() {
        return this.experience;
    }

    public final int getDrafts() {
        return this.drafts;
    }
}
