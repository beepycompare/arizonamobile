package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudChickenGameRatingModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameRatingModel;", "", TtmlNode.ATTR_ID, "", "position", "name", "", "points", "<init>", "(IILjava/lang/String;I)V", "getId", "()I", "getPosition", "getName", "()Ljava/lang/String;", "getPoints", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudChickenGameRatingModel {
    private final int id;
    private final String name;
    private final int points;
    private final int position;

    public static /* synthetic */ HudChickenGameRatingModel copy$default(HudChickenGameRatingModel hudChickenGameRatingModel, int i, int i2, String str, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = hudChickenGameRatingModel.id;
        }
        if ((i4 & 2) != 0) {
            i2 = hudChickenGameRatingModel.position;
        }
        if ((i4 & 4) != 0) {
            str = hudChickenGameRatingModel.name;
        }
        if ((i4 & 8) != 0) {
            i3 = hudChickenGameRatingModel.points;
        }
        return hudChickenGameRatingModel.copy(i, i2, str, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.position;
    }

    public final String component3() {
        return this.name;
    }

    public final int component4() {
        return this.points;
    }

    public final HudChickenGameRatingModel copy(int i, int i2, String name, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new HudChickenGameRatingModel(i, i2, name, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudChickenGameRatingModel) {
            HudChickenGameRatingModel hudChickenGameRatingModel = (HudChickenGameRatingModel) obj;
            return this.id == hudChickenGameRatingModel.id && this.position == hudChickenGameRatingModel.position && Intrinsics.areEqual(this.name, hudChickenGameRatingModel.name) && this.points == hudChickenGameRatingModel.points;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.position)) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.points);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.position;
        String str = this.name;
        return "HudChickenGameRatingModel(id=" + i + ", position=" + i2 + ", name=" + str + ", points=" + this.points + ")";
    }

    public HudChickenGameRatingModel(int i, int i2, String name, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.position = i2;
        this.name = name;
        this.points = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPoints() {
        return this.points;
    }
}
