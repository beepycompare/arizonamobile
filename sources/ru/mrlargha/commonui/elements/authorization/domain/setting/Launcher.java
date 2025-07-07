package ru.mrlargha.commonui.elements.authorization.domain.setting;

import com.arizona.launcher.model.settings.SettingsConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Launcher.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019JV\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001b¨\u0006-"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/setting/Launcher;", "", SettingsConstants.NICKNAME, "", "chatPagesize", "", "chatFontsize", "chatPrintTimestamp", "", "streamerMode", "headMoving", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "getChatPagesize", "()Ljava/lang/Integer;", "setChatPagesize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getChatFontsize", "setChatFontsize", "getChatPrintTimestamp", "()Ljava/lang/Boolean;", "setChatPrintTimestamp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStreamerMode", "setStreamerMode", "getHeadMoving", "setHeadMoving", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lru/mrlargha/commonui/elements/authorization/domain/setting/Launcher;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Launcher {
    @SerializedName(SettingsConstants.CHAT_FONT_SIZE)
    private Integer chatFontsize;
    @SerializedName(SettingsConstants.CHAT_PAGE_SIZE)
    private Integer chatPagesize;
    @SerializedName(SettingsConstants.CHAT_PRINT_TIMESTAMP)
    private Boolean chatPrintTimestamp;
    @SerializedName(SettingsConstants.IS_HEAD_MOVING)
    private Boolean headMoving;
    @SerializedName(SettingsConstants.NICKNAME)
    private String nickname;
    @SerializedName(SettingsConstants.STREAMER_MODE)
    private Boolean streamerMode;

    public Launcher() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Launcher copy$default(Launcher launcher, String str, Integer num, Integer num2, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = launcher.nickname;
        }
        if ((i & 2) != 0) {
            num = launcher.chatPagesize;
        }
        if ((i & 4) != 0) {
            num2 = launcher.chatFontsize;
        }
        if ((i & 8) != 0) {
            bool = launcher.chatPrintTimestamp;
        }
        if ((i & 16) != 0) {
            bool2 = launcher.streamerMode;
        }
        if ((i & 32) != 0) {
            bool3 = launcher.headMoving;
        }
        Boolean bool4 = bool2;
        Boolean bool5 = bool3;
        return launcher.copy(str, num, num2, bool, bool4, bool5);
    }

    public final String component1() {
        return this.nickname;
    }

    public final Integer component2() {
        return this.chatPagesize;
    }

    public final Integer component3() {
        return this.chatFontsize;
    }

    public final Boolean component4() {
        return this.chatPrintTimestamp;
    }

    public final Boolean component5() {
        return this.streamerMode;
    }

    public final Boolean component6() {
        return this.headMoving;
    }

    public final Launcher copy(String str, Integer num, Integer num2, Boolean bool, Boolean bool2, Boolean bool3) {
        return new Launcher(str, num, num2, bool, bool2, bool3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Launcher) {
            Launcher launcher = (Launcher) obj;
            return Intrinsics.areEqual(this.nickname, launcher.nickname) && Intrinsics.areEqual(this.chatPagesize, launcher.chatPagesize) && Intrinsics.areEqual(this.chatFontsize, launcher.chatFontsize) && Intrinsics.areEqual(this.chatPrintTimestamp, launcher.chatPrintTimestamp) && Intrinsics.areEqual(this.streamerMode, launcher.streamerMode) && Intrinsics.areEqual(this.headMoving, launcher.headMoving);
        }
        return false;
    }

    public int hashCode() {
        String str = this.nickname;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.chatPagesize;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.chatFontsize;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.chatPrintTimestamp;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.streamerMode;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.headMoving;
        return hashCode5 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        String str = this.nickname;
        Integer num = this.chatPagesize;
        Integer num2 = this.chatFontsize;
        Boolean bool = this.chatPrintTimestamp;
        Boolean bool2 = this.streamerMode;
        return "Launcher(nickname=" + str + ", chatPagesize=" + num + ", chatFontsize=" + num2 + ", chatPrintTimestamp=" + bool + ", streamerMode=" + bool2 + ", headMoving=" + this.headMoving + ")";
    }

    public Launcher(String str, Integer num, Integer num2, Boolean bool, Boolean bool2, Boolean bool3) {
        this.nickname = str;
        this.chatPagesize = num;
        this.chatFontsize = num2;
        this.chatPrintTimestamp = bool;
        this.streamerMode = bool2;
        this.headMoving = bool3;
    }

    public /* synthetic */ Launcher(String str, Integer num, Integer num2, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : bool3);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final Integer getChatPagesize() {
        return this.chatPagesize;
    }

    public final void setChatPagesize(Integer num) {
        this.chatPagesize = num;
    }

    public final Integer getChatFontsize() {
        return this.chatFontsize;
    }

    public final void setChatFontsize(Integer num) {
        this.chatFontsize = num;
    }

    public final Boolean getChatPrintTimestamp() {
        return this.chatPrintTimestamp;
    }

    public final void setChatPrintTimestamp(Boolean bool) {
        this.chatPrintTimestamp = bool;
    }

    public final Boolean getStreamerMode() {
        return this.streamerMode;
    }

    public final void setStreamerMode(Boolean bool) {
        this.streamerMode = bool;
    }

    public final Boolean getHeadMoving() {
        return this.headMoving;
    }

    public final void setHeadMoving(Boolean bool) {
        this.headMoving = bool;
    }
}
