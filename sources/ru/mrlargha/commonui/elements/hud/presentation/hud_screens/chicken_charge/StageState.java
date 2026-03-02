package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/StageState;", "", "stage", "", "stageTotal", TtmlNode.START, "width", "speed", "isMyState", "infoUser", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/StageUserInfo;", "<init>", "(IIIIIILjava/util/List;)V", "getStage", "()I", "getStageTotal", "getStart", "getWidth", "getSpeed", "getInfoUser", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StageState {
    private final List<StageUserInfo> infoUser;
    private final int isMyState;
    private final int speed;
    private final int stage;
    private final int stageTotal;
    private final int start;
    private final int width;

    public static /* synthetic */ StageState copy$default(StageState stageState, int i, int i2, int i3, int i4, int i5, int i6, List list, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = stageState.stage;
        }
        if ((i7 & 2) != 0) {
            i2 = stageState.stageTotal;
        }
        if ((i7 & 4) != 0) {
            i3 = stageState.start;
        }
        if ((i7 & 8) != 0) {
            i4 = stageState.width;
        }
        if ((i7 & 16) != 0) {
            i5 = stageState.speed;
        }
        if ((i7 & 32) != 0) {
            i6 = stageState.isMyState;
        }
        List<StageUserInfo> list2 = list;
        if ((i7 & 64) != 0) {
            list2 = stageState.infoUser;
        }
        int i8 = i6;
        List list3 = list2;
        int i9 = i5;
        int i10 = i3;
        return stageState.copy(i, i2, i10, i4, i9, i8, list3);
    }

    public final int component1() {
        return this.stage;
    }

    public final int component2() {
        return this.stageTotal;
    }

    public final int component3() {
        return this.start;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.speed;
    }

    public final int component6() {
        return this.isMyState;
    }

    public final List<StageUserInfo> component7() {
        return this.infoUser;
    }

    public final StageState copy(int i, int i2, int i3, int i4, int i5, int i6, List<StageUserInfo> infoUser) {
        Intrinsics.checkNotNullParameter(infoUser, "infoUser");
        return new StageState(i, i2, i3, i4, i5, i6, infoUser);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StageState) {
            StageState stageState = (StageState) obj;
            return this.stage == stageState.stage && this.stageTotal == stageState.stageTotal && this.start == stageState.start && this.width == stageState.width && this.speed == stageState.speed && this.isMyState == stageState.isMyState && Intrinsics.areEqual(this.infoUser, stageState.infoUser);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.stage) * 31) + Integer.hashCode(this.stageTotal)) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.speed)) * 31) + Integer.hashCode(this.isMyState)) * 31) + this.infoUser.hashCode();
    }

    public String toString() {
        int i = this.stage;
        int i2 = this.stageTotal;
        int i3 = this.start;
        int i4 = this.width;
        int i5 = this.speed;
        int i6 = this.isMyState;
        return "StageState(stage=" + i + ", stageTotal=" + i2 + ", start=" + i3 + ", width=" + i4 + ", speed=" + i5 + ", isMyState=" + i6 + ", infoUser=" + this.infoUser + ")";
    }

    public StageState(int i, int i2, int i3, int i4, int i5, int i6, List<StageUserInfo> infoUser) {
        Intrinsics.checkNotNullParameter(infoUser, "infoUser");
        this.stage = i;
        this.stageTotal = i2;
        this.start = i3;
        this.width = i4;
        this.speed = i5;
        this.isMyState = i6;
        this.infoUser = infoUser;
    }

    public final int getStage() {
        return this.stage;
    }

    public final int getStageTotal() {
        return this.stageTotal;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final int isMyState() {
        return this.isMyState;
    }

    public final List<StageUserInfo> getInfoUser() {
        return this.infoUser;
    }
}
