package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudChickenGameInfoModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameInfoModel;", "", "id", "", "flag", "title", "", "<init>", "(IILjava/lang/String;)V", "getId", "()I", "getFlag", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudChickenGameInfoModel {
    private final int flag;
    private final int id;
    private final String title;

    public static /* synthetic */ HudChickenGameInfoModel copy$default(HudChickenGameInfoModel hudChickenGameInfoModel, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = hudChickenGameInfoModel.id;
        }
        if ((i3 & 2) != 0) {
            i2 = hudChickenGameInfoModel.flag;
        }
        if ((i3 & 4) != 0) {
            str = hudChickenGameInfoModel.title;
        }
        return hudChickenGameInfoModel.copy(i, i2, str);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.flag;
    }

    public final String component3() {
        return this.title;
    }

    public final HudChickenGameInfoModel copy(int i, int i2, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new HudChickenGameInfoModel(i, i2, title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudChickenGameInfoModel) {
            HudChickenGameInfoModel hudChickenGameInfoModel = (HudChickenGameInfoModel) obj;
            return this.id == hudChickenGameInfoModel.id && this.flag == hudChickenGameInfoModel.flag && Intrinsics.areEqual(this.title, hudChickenGameInfoModel.title);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.flag)) * 31) + this.title.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.flag;
        return "HudChickenGameInfoModel(id=" + i + ", flag=" + i2 + ", title=" + this.title + ")";
    }

    public HudChickenGameInfoModel(int i, int i2, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.flag = i2;
        this.title = title;
    }

    public final int getId() {
        return this.id;
    }

    public final int getFlag() {
        return this.flag;
    }

    public final String getTitle() {
        return this.title;
    }
}
