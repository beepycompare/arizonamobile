package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudTimer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudTimerModel;", "", "title", "", "type", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getType", "getTime", "()I", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudTimerType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
final class HudTimerModel {
    @SerializedName("time")
    private final int time;
    @SerializedName("title")
    private final String title;
    @SerializedName("type")
    private final String type;

    public static /* synthetic */ HudTimerModel copy$default(HudTimerModel hudTimerModel, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hudTimerModel.title;
        }
        if ((i2 & 2) != 0) {
            str2 = hudTimerModel.type;
        }
        if ((i2 & 4) != 0) {
            i = hudTimerModel.time;
        }
        return hudTimerModel.copy(str, str2, i);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.type;
    }

    public final int component3() {
        return this.time;
    }

    public final HudTimerModel copy(String title, String type, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        return new HudTimerModel(title, type, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudTimerModel) {
            HudTimerModel hudTimerModel = (HudTimerModel) obj;
            return Intrinsics.areEqual(this.title, hudTimerModel.title) && Intrinsics.areEqual(this.type, hudTimerModel.type) && this.time == hudTimerModel.time;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.type;
        return "HudTimerModel(title=" + str + ", type=" + str2 + ", time=" + this.time + ")";
    }

    public HudTimerModel(String title, String type, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        this.title = title;
        this.type = type;
        this.time = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final int getTime() {
        return this.time;
    }

    /* renamed from: getType  reason: collision with other method in class */
    public final HudTimerType m10633getType() {
        String str = this.type;
        return Intrinsics.areEqual(str, HudTimerType.DANGER.getType()) ? HudTimerType.DANGER : Intrinsics.areEqual(str, HudTimerType.WARNING.getType()) ? HudTimerType.WARNING : HudTimerType.DEFAULT;
    }
}
