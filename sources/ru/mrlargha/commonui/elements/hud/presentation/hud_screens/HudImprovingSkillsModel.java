package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HudImprovingSkills.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudImprovingSkillsModel;", "", "title", "", "description", "currentLevel", "", "nextLevel", "currentExp", "nextExp", "maxExp", TypedValues.TransitionType.S_DURATION, "<init>", "(Ljava/lang/String;Ljava/lang/String;DDDDDD)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getCurrentLevel", "()D", "getNextLevel", "getCurrentExp", "getNextExp", "getMaxExp", "getDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudImprovingSkillsModel {
    @SerializedName("currentExp")
    private final double currentExp;
    @SerializedName("currentLevel")
    private final double currentLevel;
    @SerializedName("description")
    private final String description;
    @SerializedName(TypedValues.TransitionType.S_DURATION)
    private final double duration;
    @SerializedName("maxExp")
    private final double maxExp;
    @SerializedName("nextExp")
    private final double nextExp;
    @SerializedName("nextLevel")
    private final double nextLevel;
    @SerializedName("title")
    private final String title;

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final double component3() {
        return this.currentLevel;
    }

    public final double component4() {
        return this.nextLevel;
    }

    public final double component5() {
        return this.currentExp;
    }

    public final double component6() {
        return this.nextExp;
    }

    public final double component7() {
        return this.maxExp;
    }

    public final double component8() {
        return this.duration;
    }

    public final HudImprovingSkillsModel copy(String title, String description, double d, double d2, double d3, double d4, double d5, double d6) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new HudImprovingSkillsModel(title, description, d, d2, d3, d4, d5, d6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudImprovingSkillsModel) {
            HudImprovingSkillsModel hudImprovingSkillsModel = (HudImprovingSkillsModel) obj;
            return Intrinsics.areEqual(this.title, hudImprovingSkillsModel.title) && Intrinsics.areEqual(this.description, hudImprovingSkillsModel.description) && Double.compare(this.currentLevel, hudImprovingSkillsModel.currentLevel) == 0 && Double.compare(this.nextLevel, hudImprovingSkillsModel.nextLevel) == 0 && Double.compare(this.currentExp, hudImprovingSkillsModel.currentExp) == 0 && Double.compare(this.nextExp, hudImprovingSkillsModel.nextExp) == 0 && Double.compare(this.maxExp, hudImprovingSkillsModel.maxExp) == 0 && Double.compare(this.duration, hudImprovingSkillsModel.duration) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + Double.hashCode(this.currentLevel)) * 31) + Double.hashCode(this.nextLevel)) * 31) + Double.hashCode(this.currentExp)) * 31) + Double.hashCode(this.nextExp)) * 31) + Double.hashCode(this.maxExp)) * 31) + Double.hashCode(this.duration);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.description;
        double d = this.currentLevel;
        double d2 = this.nextLevel;
        double d3 = this.currentExp;
        double d4 = this.nextExp;
        double d5 = this.maxExp;
        return "HudImprovingSkillsModel(title=" + str + ", description=" + str2 + ", currentLevel=" + d + ", nextLevel=" + d2 + ", currentExp=" + d3 + ", nextExp=" + d4 + ", maxExp=" + d5 + ", duration=" + this.duration + ")";
    }

    public HudImprovingSkillsModel(String title, String description, double d, double d2, double d3, double d4, double d5, double d6) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.title = title;
        this.description = description;
        this.currentLevel = d;
        this.nextLevel = d2;
        this.currentExp = d3;
        this.nextExp = d4;
        this.maxExp = d5;
        this.duration = d6;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final double getCurrentLevel() {
        return this.currentLevel;
    }

    public final double getNextLevel() {
        return this.nextLevel;
    }

    public final double getCurrentExp() {
        return this.currentExp;
    }

    public final double getNextExp() {
        return this.nextExp;
    }

    public final double getMaxExp() {
        return this.maxExp;
    }

    public final double getDuration() {
        return this.duration;
    }
}
