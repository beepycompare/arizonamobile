package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudCaptModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemModel;", "", "name", "", "textColor", "kills", "", "peopleCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getName", "()Ljava/lang/String;", "getTextColor", "getKills", "()I", "getPeopleCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudCaptItemModel {
    private final int kills;
    private final String name;
    private final int peopleCount;
    private final String textColor;

    public static /* synthetic */ HudCaptItemModel copy$default(HudCaptItemModel hudCaptItemModel, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = hudCaptItemModel.name;
        }
        if ((i3 & 2) != 0) {
            str2 = hudCaptItemModel.textColor;
        }
        if ((i3 & 4) != 0) {
            i = hudCaptItemModel.kills;
        }
        if ((i3 & 8) != 0) {
            i2 = hudCaptItemModel.peopleCount;
        }
        return hudCaptItemModel.copy(str, str2, i, i2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.textColor;
    }

    public final int component3() {
        return this.kills;
    }

    public final int component4() {
        return this.peopleCount;
    }

    public final HudCaptItemModel copy(String name, String textColor, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        return new HudCaptItemModel(name, textColor, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudCaptItemModel) {
            HudCaptItemModel hudCaptItemModel = (HudCaptItemModel) obj;
            return Intrinsics.areEqual(this.name, hudCaptItemModel.name) && Intrinsics.areEqual(this.textColor, hudCaptItemModel.textColor) && this.kills == hudCaptItemModel.kills && this.peopleCount == hudCaptItemModel.peopleCount;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.textColor.hashCode()) * 31) + Integer.hashCode(this.kills)) * 31) + Integer.hashCode(this.peopleCount);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.textColor;
        int i = this.kills;
        return "HudCaptItemModel(name=" + str + ", textColor=" + str2 + ", kills=" + i + ", peopleCount=" + this.peopleCount + ")";
    }

    public HudCaptItemModel(String name, String textColor, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        this.name = name;
        this.textColor = textColor;
        this.kills = i;
        this.peopleCount = i2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final int getKills() {
        return this.kills;
    }

    public final int getPeopleCount() {
        return this.peopleCount;
    }
}
