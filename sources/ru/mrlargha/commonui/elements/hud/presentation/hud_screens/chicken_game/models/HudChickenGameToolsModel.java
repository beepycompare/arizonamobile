package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudChickenGameToolsModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameToolsModel;", "", "id", "", "image", "", "key", "count", "selected", "locked", "<init>", "(ILjava/lang/String;Ljava/lang/String;III)V", "getId", "()I", "getImage", "()Ljava/lang/String;", "getKey", "getCount", "getSelected", "getLocked", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudChickenGameToolsModel {
    private final int count;
    private final int id;
    private final String image;
    private final String key;
    private final int locked;
    private final int selected;

    public static /* synthetic */ HudChickenGameToolsModel copy$default(HudChickenGameToolsModel hudChickenGameToolsModel, int i, String str, String str2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = hudChickenGameToolsModel.id;
        }
        if ((i5 & 2) != 0) {
            str = hudChickenGameToolsModel.image;
        }
        if ((i5 & 4) != 0) {
            str2 = hudChickenGameToolsModel.key;
        }
        if ((i5 & 8) != 0) {
            i2 = hudChickenGameToolsModel.count;
        }
        if ((i5 & 16) != 0) {
            i3 = hudChickenGameToolsModel.selected;
        }
        if ((i5 & 32) != 0) {
            i4 = hudChickenGameToolsModel.locked;
        }
        int i6 = i3;
        int i7 = i4;
        return hudChickenGameToolsModel.copy(i, str, str2, i2, i6, i7);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.key;
    }

    public final int component4() {
        return this.count;
    }

    public final int component5() {
        return this.selected;
    }

    public final int component6() {
        return this.locked;
    }

    public final HudChickenGameToolsModel copy(int i, String image, String key, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(key, "key");
        return new HudChickenGameToolsModel(i, image, key, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudChickenGameToolsModel) {
            HudChickenGameToolsModel hudChickenGameToolsModel = (HudChickenGameToolsModel) obj;
            return this.id == hudChickenGameToolsModel.id && Intrinsics.areEqual(this.image, hudChickenGameToolsModel.image) && Intrinsics.areEqual(this.key, hudChickenGameToolsModel.key) && this.count == hudChickenGameToolsModel.count && this.selected == hudChickenGameToolsModel.selected && this.locked == hudChickenGameToolsModel.locked;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.image.hashCode()) * 31) + this.key.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.selected)) * 31) + Integer.hashCode(this.locked);
    }

    public String toString() {
        int i = this.id;
        String str = this.image;
        String str2 = this.key;
        int i2 = this.count;
        int i3 = this.selected;
        return "HudChickenGameToolsModel(id=" + i + ", image=" + str + ", key=" + str2 + ", count=" + i2 + ", selected=" + i3 + ", locked=" + this.locked + ")";
    }

    public HudChickenGameToolsModel(int i, String image, String key, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(key, "key");
        this.id = i;
        this.image = image;
        this.key = key;
        this.count = i2;
        this.selected = i3;
        this.locked = i4;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getSelected() {
        return this.selected;
    }

    public final int getLocked() {
        return this.locked;
    }
}
