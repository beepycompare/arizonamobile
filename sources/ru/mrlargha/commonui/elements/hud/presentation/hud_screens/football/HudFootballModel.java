package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.football;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudFootballModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballModel;", "", "name", "", FirebaseAnalytics.Param.SCORE, "", "color", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getScore", "()I", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudFootballModel {
    private final String color;
    private final String name;
    private final int score;

    public static /* synthetic */ HudFootballModel copy$default(HudFootballModel hudFootballModel, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hudFootballModel.name;
        }
        if ((i2 & 2) != 0) {
            i = hudFootballModel.score;
        }
        if ((i2 & 4) != 0) {
            str2 = hudFootballModel.color;
        }
        return hudFootballModel.copy(str, i, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.score;
    }

    public final String component3() {
        return this.color;
    }

    public final HudFootballModel copy(String name, int i, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(color, "color");
        return new HudFootballModel(name, i, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudFootballModel) {
            HudFootballModel hudFootballModel = (HudFootballModel) obj;
            return Intrinsics.areEqual(this.name, hudFootballModel.name) && this.score == hudFootballModel.score && Intrinsics.areEqual(this.color, hudFootballModel.color);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Integer.hashCode(this.score)) * 31) + this.color.hashCode();
    }

    public String toString() {
        String str = this.name;
        int i = this.score;
        return "HudFootballModel(name=" + str + ", score=" + i + ", color=" + this.color + ")";
    }

    public HudFootballModel(String name, int i, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(color, "color");
        this.name = name;
        this.score = i;
        this.color = color;
    }

    public final String getName() {
        return this.name;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getColor() {
        return this.color;
    }
}
