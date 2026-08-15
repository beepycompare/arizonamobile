package com.miami.game.core.settings.game_test;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0018\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0018\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123¨\u00064"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep;", "", "<init>", "()V", "NotifyClick", "Chat", "Sleep", "Tap", "Swipe", "Screenshot", "ShowUi", "HideUi", "BackendMessage", "WaitBackendMessage", "WaitVisibility", "Authorize", "LoginAndSpawn", "AddBackendMessageListener", "RemoveBackendMessageListener", "ReplayBackendFixture", "StartBackendTrace", "StartBackendValidation", "Repeat", "Log", "CloseAll", "StopBackendTrace", "StopBackendValidation", "ClearBackendMessageListeners", "Lcom/miami/game/core/settings/game_test/GameTestStep$AddBackendMessageListener;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Authorize;", "Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Chat;", "Lcom/miami/game/core/settings/game_test/GameTestStep$ClearBackendMessageListeners;", "Lcom/miami/game/core/settings/game_test/GameTestStep$CloseAll;", "Lcom/miami/game/core/settings/game_test/GameTestStep$HideUi;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Log;", "Lcom/miami/game/core/settings/game_test/GameTestStep$LoginAndSpawn;", "Lcom/miami/game/core/settings/game_test/GameTestStep$NotifyClick;", "Lcom/miami/game/core/settings/game_test/GameTestStep$RemoveBackendMessageListener;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Repeat;", "Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Screenshot;", "Lcom/miami/game/core/settings/game_test/GameTestStep$ShowUi;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Sleep;", "Lcom/miami/game/core/settings/game_test/GameTestStep$StartBackendTrace;", "Lcom/miami/game/core/settings/game_test/GameTestStep$StartBackendValidation;", "Lcom/miami/game/core/settings/game_test/GameTestStep$StopBackendTrace;", "Lcom/miami/game/core/settings/game_test/GameTestStep$StopBackendValidation;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Swipe;", "Lcom/miami/game/core/settings/game_test/GameTestStep$Tap;", "Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;", "Lcom/miami/game/core/settings/game_test/GameTestStep$WaitVisibility;", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GameTestStep {
    public /* synthetic */ GameTestStep(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JD\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$NotifyClick;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "backendId", "", "backendName", "", TtmlNode.ATTR_ID, "subId", "message", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/String;)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getId", "()I", "getSubId", "getMessage", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/String;)Lcom/miami/game/core/settings/game_test/GameTestStep$NotifyClick;", "equals", "", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NotifyClick extends GameTestStep {
        private final Integer backendId;
        private final String backendName;
        private final int id;
        private final String message;
        private final int subId;

        public static /* synthetic */ NotifyClick copy$default(NotifyClick notifyClick, Integer num, String str, int i, int i2, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                num = notifyClick.backendId;
            }
            if ((i3 & 2) != 0) {
                str = notifyClick.backendName;
            }
            if ((i3 & 4) != 0) {
                i = notifyClick.id;
            }
            if ((i3 & 8) != 0) {
                i2 = notifyClick.subId;
            }
            if ((i3 & 16) != 0) {
                str2 = notifyClick.message;
            }
            String str3 = str2;
            int i4 = i;
            return notifyClick.copy(num, str, i4, i2, str3);
        }

        public final Integer component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final int component3() {
            return this.id;
        }

        public final int component4() {
            return this.subId;
        }

        public final String component5() {
            return this.message;
        }

        public final NotifyClick copy(Integer num, String str, int i, int i2, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NotifyClick(num, str, i, i2, message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotifyClick) {
                NotifyClick notifyClick = (NotifyClick) obj;
                return Intrinsics.areEqual(this.backendId, notifyClick.backendId) && Intrinsics.areEqual(this.backendName, notifyClick.backendName) && this.id == notifyClick.id && this.subId == notifyClick.subId && Intrinsics.areEqual(this.message, notifyClick.message);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.backendId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.backendName;
            return ((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.id)) * 31) + Integer.hashCode(this.subId)) * 31) + this.message.hashCode();
        }

        public String toString() {
            Integer num = this.backendId;
            String str = this.backendName;
            int i = this.id;
            int i2 = this.subId;
            return "NotifyClick(backendId=" + num + ", backendName=" + str + ", id=" + i + ", subId=" + i2 + ", message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotifyClick(Integer num, String str, int i, int i2, String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.backendId = num;
            this.backendName = str;
            this.id = i;
            this.subId = i2;
            this.message = message;
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public final String getBackendName() {
            return this.backendName;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSubId() {
            return this.subId;
        }

        public /* synthetic */ NotifyClick(Integer num, String str, int i, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, i, (i3 & 8) != 0 ? -1 : i2, (i3 & 16) != 0 ? "" : str2);
        }

        public final String getMessage() {
            return this.message;
        }
    }

    private GameTestStep() {
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Chat;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Chat extends GameTestStep {
        private final String text;

        public static /* synthetic */ Chat copy$default(Chat chat, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = chat.text;
            }
            return chat.copy(str);
        }

        public final String component1() {
            return this.text;
        }

        public final Chat copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Chat(text);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Chat) && Intrinsics.areEqual(this.text, ((Chat) obj).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Chat(text=" + this.text + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Chat(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Sleep;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "delayMs", "", "<init>", "(J)V", "getDelayMs", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Sleep extends GameTestStep {
        private final long delayMs;

        public static /* synthetic */ Sleep copy$default(Sleep sleep, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = sleep.delayMs;
            }
            return sleep.copy(j);
        }

        public final long component1() {
            return this.delayMs;
        }

        public final Sleep copy(long j) {
            return new Sleep(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Sleep) && this.delayMs == ((Sleep) obj).delayMs;
        }

        public int hashCode() {
            return Long.hashCode(this.delayMs);
        }

        public String toString() {
            return "Sleep(delayMs=" + this.delayMs + ")";
        }

        public Sleep(long j) {
            super(null);
            this.delayMs = j;
        }

        public final long getDelayMs() {
            return this.delayMs;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Tap;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "xPercent", "", "yPercent", "holdMs", "", "<init>", "(DDJ)V", "getXPercent", "()D", "getYPercent", "getHoldMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Tap extends GameTestStep {
        private final long holdMs;
        private final double xPercent;
        private final double yPercent;

        public static /* synthetic */ Tap copy$default(Tap tap, double d, double d2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                d = tap.xPercent;
            }
            double d3 = d;
            if ((i & 2) != 0) {
                d2 = tap.yPercent;
            }
            double d4 = d2;
            if ((i & 4) != 0) {
                j = tap.holdMs;
            }
            return tap.copy(d3, d4, j);
        }

        public final double component1() {
            return this.xPercent;
        }

        public final double component2() {
            return this.yPercent;
        }

        public final long component3() {
            return this.holdMs;
        }

        public final Tap copy(double d, double d2, long j) {
            return new Tap(d, d2, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tap) {
                Tap tap = (Tap) obj;
                return Double.compare(this.xPercent, tap.xPercent) == 0 && Double.compare(this.yPercent, tap.yPercent) == 0 && this.holdMs == tap.holdMs;
            }
            return false;
        }

        public int hashCode() {
            return (((Double.hashCode(this.xPercent) * 31) + Double.hashCode(this.yPercent)) * 31) + Long.hashCode(this.holdMs);
        }

        public String toString() {
            double d = this.xPercent;
            double d2 = this.yPercent;
            return "Tap(xPercent=" + d + ", yPercent=" + d2 + ", holdMs=" + this.holdMs + ")";
        }

        public Tap(double d, double d2, long j) {
            super(null);
            this.xPercent = d;
            this.yPercent = d2;
            this.holdMs = j;
        }

        public /* synthetic */ Tap(double d, double d2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, d2, (i & 4) != 0 ? 60L : j);
        }

        public final double getXPercent() {
            return this.xPercent;
        }

        public final double getYPercent() {
            return this.yPercent;
        }

        public final long getHoldMs() {
            return this.holdMs;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Swipe;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "fromXPercent", "", "fromYPercent", "toXPercent", "toYPercent", "durationMs", "", "<init>", "(DDDDJ)V", "getFromXPercent", "()D", "getFromYPercent", "getToXPercent", "getToYPercent", "getDurationMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Swipe extends GameTestStep {
        private final long durationMs;
        private final double fromXPercent;
        private final double fromYPercent;
        private final double toXPercent;
        private final double toYPercent;

        public static /* synthetic */ Swipe copy$default(Swipe swipe, double d, double d2, double d3, double d4, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                d = swipe.fromXPercent;
            }
            double d5 = d;
            if ((i & 2) != 0) {
                d2 = swipe.fromYPercent;
            }
            return swipe.copy(d5, d2, (i & 4) != 0 ? swipe.toXPercent : d3, (i & 8) != 0 ? swipe.toYPercent : d4, (i & 16) != 0 ? swipe.durationMs : j);
        }

        public final double component1() {
            return this.fromXPercent;
        }

        public final double component2() {
            return this.fromYPercent;
        }

        public final double component3() {
            return this.toXPercent;
        }

        public final double component4() {
            return this.toYPercent;
        }

        public final long component5() {
            return this.durationMs;
        }

        public final Swipe copy(double d, double d2, double d3, double d4, long j) {
            return new Swipe(d, d2, d3, d4, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Swipe) {
                Swipe swipe = (Swipe) obj;
                return Double.compare(this.fromXPercent, swipe.fromXPercent) == 0 && Double.compare(this.fromYPercent, swipe.fromYPercent) == 0 && Double.compare(this.toXPercent, swipe.toXPercent) == 0 && Double.compare(this.toYPercent, swipe.toYPercent) == 0 && this.durationMs == swipe.durationMs;
            }
            return false;
        }

        public int hashCode() {
            return (((((((Double.hashCode(this.fromXPercent) * 31) + Double.hashCode(this.fromYPercent)) * 31) + Double.hashCode(this.toXPercent)) * 31) + Double.hashCode(this.toYPercent)) * 31) + Long.hashCode(this.durationMs);
        }

        public String toString() {
            double d = this.fromXPercent;
            double d2 = this.fromYPercent;
            double d3 = this.toXPercent;
            double d4 = this.toYPercent;
            return "Swipe(fromXPercent=" + d + ", fromYPercent=" + d2 + ", toXPercent=" + d3 + ", toYPercent=" + d4 + ", durationMs=" + this.durationMs + ")";
        }

        public Swipe(double d, double d2, double d3, double d4, long j) {
            super(null);
            this.fromXPercent = d;
            this.fromYPercent = d2;
            this.toXPercent = d3;
            this.toYPercent = d4;
            this.durationMs = j;
        }

        public /* synthetic */ Swipe(double d, double d2, double d3, double d4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, d2, d3, d4, (i & 16) != 0 ? 300L : j);
        }

        public final double getFromXPercent() {
            return this.fromXPercent;
        }

        public final double getFromYPercent() {
            return this.fromYPercent;
        }

        public final double getToXPercent() {
            return this.toXPercent;
        }

        public final double getToYPercent() {
            return this.toYPercent;
        }

        public final long getDurationMs() {
            return this.durationMs;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Screenshot;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "fileName", "", "<init>", "(Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Screenshot extends GameTestStep {
        private final String fileName;

        public Screenshot() {
            this(null, 1, null);
        }

        public static /* synthetic */ Screenshot copy$default(Screenshot screenshot, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = screenshot.fileName;
            }
            return screenshot.copy(str);
        }

        public final String component1() {
            return this.fileName;
        }

        public final Screenshot copy(String str) {
            return new Screenshot(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Screenshot) && Intrinsics.areEqual(this.fileName, ((Screenshot) obj).fileName);
        }

        public int hashCode() {
            String str = this.fileName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Screenshot(fileName=" + this.fileName + ")";
        }

        public Screenshot(String str) {
            super(null);
            this.fileName = str;
        }

        public /* synthetic */ Screenshot(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getFileName() {
            return this.fileName;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$ShowUi;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "backendId", "", "backendName", "", "exclusive", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getExclusive", "()Z", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/miami/game/core/settings/game_test/GameTestStep$ShowUi;", "equals", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShowUi extends GameTestStep {
        private final Integer backendId;
        private final String backendName;
        private final boolean exclusive;

        public ShowUi() {
            this(null, null, false, 7, null);
        }

        public static /* synthetic */ ShowUi copy$default(ShowUi showUi, Integer num, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                num = showUi.backendId;
            }
            if ((i & 2) != 0) {
                str = showUi.backendName;
            }
            if ((i & 4) != 0) {
                z = showUi.exclusive;
            }
            return showUi.copy(num, str, z);
        }

        public final Integer component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final boolean component3() {
            return this.exclusive;
        }

        public final ShowUi copy(Integer num, String str, boolean z) {
            return new ShowUi(num, str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowUi) {
                ShowUi showUi = (ShowUi) obj;
                return Intrinsics.areEqual(this.backendId, showUi.backendId) && Intrinsics.areEqual(this.backendName, showUi.backendName) && this.exclusive == showUi.exclusive;
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.backendId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.backendName;
            return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.exclusive);
        }

        public String toString() {
            Integer num = this.backendId;
            String str = this.backendName;
            return "ShowUi(backendId=" + num + ", backendName=" + str + ", exclusive=" + this.exclusive + ")";
        }

        public ShowUi(Integer num, String str, boolean z) {
            super(null);
            this.backendId = num;
            this.backendName = str;
            this.exclusive = z;
        }

        public /* synthetic */ ShowUi(Integer num, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public final String getBackendName() {
            return this.backendName;
        }

        public final boolean getExclusive() {
            return this.exclusive;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$HideUi;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "backendId", "", "backendName", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/miami/game/core/settings/game_test/GameTestStep$HideUi;", "equals", "", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class HideUi extends GameTestStep {
        private final Integer backendId;
        private final String backendName;

        public HideUi() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ HideUi copy$default(HideUi hideUi, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = hideUi.backendId;
            }
            if ((i & 2) != 0) {
                str = hideUi.backendName;
            }
            return hideUi.copy(num, str);
        }

        public final Integer component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final HideUi copy(Integer num, String str) {
            return new HideUi(num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HideUi) {
                HideUi hideUi = (HideUi) obj;
                return Intrinsics.areEqual(this.backendId, hideUi.backendId) && Intrinsics.areEqual(this.backendName, hideUi.backendName);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.backendId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.backendName;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.backendId;
            return "HideUi(backendId=" + num + ", backendName=" + this.backendName + ")";
        }

        public HideUi(Integer num, String str) {
            super(null);
            this.backendId = num;
            this.backendName = str;
        }

        public /* synthetic */ HideUi(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public final String getBackendName() {
            return this.backendName;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "backendId", "", "backendName", "", "subId", "message", TypedValues.AttributesType.S_TARGET, "Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "provider", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Lcom/miami/game/core/settings/game_test/BackendReplayTarget;Ljava/lang/String;)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getSubId", "()I", "getMessage", "getTarget", "()Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "getProvider", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Lcom/miami/game/core/settings/game_test/BackendReplayTarget;Ljava/lang/String;)Lcom/miami/game/core/settings/game_test/GameTestStep$BackendMessage;", "equals", "", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BackendMessage extends GameTestStep {
        private final Integer backendId;
        private final String backendName;
        private final String message;
        private final String provider;
        private final int subId;
        private final BackendReplayTarget target;

        public static /* synthetic */ BackendMessage copy$default(BackendMessage backendMessage, Integer num, String str, int i, String str2, BackendReplayTarget backendReplayTarget, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = backendMessage.backendId;
            }
            if ((i2 & 2) != 0) {
                str = backendMessage.backendName;
            }
            if ((i2 & 4) != 0) {
                i = backendMessage.subId;
            }
            if ((i2 & 8) != 0) {
                str2 = backendMessage.message;
            }
            if ((i2 & 16) != 0) {
                backendReplayTarget = backendMessage.target;
            }
            if ((i2 & 32) != 0) {
                str3 = backendMessage.provider;
            }
            BackendReplayTarget backendReplayTarget2 = backendReplayTarget;
            String str4 = str3;
            return backendMessage.copy(num, str, i, str2, backendReplayTarget2, str4);
        }

        public final Integer component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final int component3() {
            return this.subId;
        }

        public final String component4() {
            return this.message;
        }

        public final BackendReplayTarget component5() {
            return this.target;
        }

        public final String component6() {
            return this.provider;
        }

        public final BackendMessage copy(Integer num, String str, int i, String message, BackendReplayTarget target, String str2) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(target, "target");
            return new BackendMessage(num, str, i, message, target, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BackendMessage) {
                BackendMessage backendMessage = (BackendMessage) obj;
                return Intrinsics.areEqual(this.backendId, backendMessage.backendId) && Intrinsics.areEqual(this.backendName, backendMessage.backendName) && this.subId == backendMessage.subId && Intrinsics.areEqual(this.message, backendMessage.message) && this.target == backendMessage.target && Intrinsics.areEqual(this.provider, backendMessage.provider);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.backendId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.backendName;
            int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.subId)) * 31) + this.message.hashCode()) * 31) + this.target.hashCode()) * 31;
            String str2 = this.provider;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.backendId;
            String str = this.backendName;
            int i = this.subId;
            String str2 = this.message;
            BackendReplayTarget backendReplayTarget = this.target;
            return "BackendMessage(backendId=" + num + ", backendName=" + str + ", subId=" + i + ", message=" + str2 + ", target=" + backendReplayTarget + ", provider=" + this.provider + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BackendMessage(Integer num, String str, int i, String message, BackendReplayTarget target, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(target, "target");
            this.backendId = num;
            this.backendName = str;
            this.subId = i;
            this.message = message;
            this.target = target;
            this.provider = str2;
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public final String getBackendName() {
            return this.backendName;
        }

        public final int getSubId() {
            return this.subId;
        }

        public /* synthetic */ BackendMessage(Integer num, String str, int i, String str2, BackendReplayTarget backendReplayTarget, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, i, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? BackendReplayTarget.UI : backendReplayTarget, (i2 & 32) != 0 ? null : str3);
        }

        public final String getMessage() {
            return this.message;
        }

        public final BackendReplayTarget getTarget() {
            return this.target;
        }

        public final String getProvider() {
            return this.provider;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006 "}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "matcher", "Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "timeoutMs", "", "includePast", "", "failOnTimeout", "<init>", "(Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;Ljava/lang/Long;ZZ)V", "getMatcher", "()Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "getTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIncludePast", "()Z", "getFailOnTimeout", "component1", "component2", "component3", "component4", "copy", "(Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;Ljava/lang/Long;ZZ)Lcom/miami/game/core/settings/game_test/GameTestStep$WaitBackendMessage;", "equals", "other", "", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class WaitBackendMessage extends GameTestStep {
        private final boolean failOnTimeout;
        private final boolean includePast;
        private final BackendMessageMatcher matcher;
        private final Long timeoutMs;

        public static /* synthetic */ WaitBackendMessage copy$default(WaitBackendMessage waitBackendMessage, BackendMessageMatcher backendMessageMatcher, Long l, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                backendMessageMatcher = waitBackendMessage.matcher;
            }
            if ((i & 2) != 0) {
                l = waitBackendMessage.timeoutMs;
            }
            if ((i & 4) != 0) {
                z = waitBackendMessage.includePast;
            }
            if ((i & 8) != 0) {
                z2 = waitBackendMessage.failOnTimeout;
            }
            return waitBackendMessage.copy(backendMessageMatcher, l, z, z2);
        }

        public final BackendMessageMatcher component1() {
            return this.matcher;
        }

        public final Long component2() {
            return this.timeoutMs;
        }

        public final boolean component3() {
            return this.includePast;
        }

        public final boolean component4() {
            return this.failOnTimeout;
        }

        public final WaitBackendMessage copy(BackendMessageMatcher matcher, Long l, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(matcher, "matcher");
            return new WaitBackendMessage(matcher, l, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WaitBackendMessage) {
                WaitBackendMessage waitBackendMessage = (WaitBackendMessage) obj;
                return Intrinsics.areEqual(this.matcher, waitBackendMessage.matcher) && Intrinsics.areEqual(this.timeoutMs, waitBackendMessage.timeoutMs) && this.includePast == waitBackendMessage.includePast && this.failOnTimeout == waitBackendMessage.failOnTimeout;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.matcher.hashCode() * 31;
            Long l = this.timeoutMs;
            return ((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.includePast)) * 31) + Boolean.hashCode(this.failOnTimeout);
        }

        public String toString() {
            BackendMessageMatcher backendMessageMatcher = this.matcher;
            Long l = this.timeoutMs;
            boolean z = this.includePast;
            return "WaitBackendMessage(matcher=" + backendMessageMatcher + ", timeoutMs=" + l + ", includePast=" + z + ", failOnTimeout=" + this.failOnTimeout + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitBackendMessage(BackendMessageMatcher matcher, Long l, boolean z, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(matcher, "matcher");
            this.matcher = matcher;
            this.timeoutMs = l;
            this.includePast = z;
            this.failOnTimeout = z2;
        }

        public final BackendMessageMatcher getMatcher() {
            return this.matcher;
        }

        public /* synthetic */ WaitBackendMessage(BackendMessageMatcher backendMessageMatcher, Long l, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(backendMessageMatcher, (i & 2) != 0 ? 10000L : l, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2);
        }

        public final Long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final boolean getIncludePast() {
            return this.includePast;
        }

        public final boolean getFailOnTimeout() {
            return this.failOnTimeout;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003JP\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006'"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$WaitVisibility;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "backendId", "", "backendName", "", "visible", "", "timeoutMs", "", "includePast", "failOnTimeout", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Long;ZZ)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getVisible", "()Z", "getTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIncludePast", "getFailOnTimeout", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Long;ZZ)Lcom/miami/game/core/settings/game_test/GameTestStep$WaitVisibility;", "equals", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class WaitVisibility extends GameTestStep {
        private final Integer backendId;
        private final String backendName;
        private final boolean failOnTimeout;
        private final boolean includePast;
        private final Long timeoutMs;
        private final boolean visible;

        public static /* synthetic */ WaitVisibility copy$default(WaitVisibility waitVisibility, Integer num, String str, boolean z, Long l, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = waitVisibility.backendId;
            }
            if ((i & 2) != 0) {
                str = waitVisibility.backendName;
            }
            if ((i & 4) != 0) {
                z = waitVisibility.visible;
            }
            if ((i & 8) != 0) {
                l = waitVisibility.timeoutMs;
            }
            if ((i & 16) != 0) {
                z2 = waitVisibility.includePast;
            }
            if ((i & 32) != 0) {
                z3 = waitVisibility.failOnTimeout;
            }
            boolean z4 = z2;
            boolean z5 = z3;
            return waitVisibility.copy(num, str, z, l, z4, z5);
        }

        public final Integer component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final boolean component3() {
            return this.visible;
        }

        public final Long component4() {
            return this.timeoutMs;
        }

        public final boolean component5() {
            return this.includePast;
        }

        public final boolean component6() {
            return this.failOnTimeout;
        }

        public final WaitVisibility copy(Integer num, String str, boolean z, Long l, boolean z2, boolean z3) {
            return new WaitVisibility(num, str, z, l, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WaitVisibility) {
                WaitVisibility waitVisibility = (WaitVisibility) obj;
                return Intrinsics.areEqual(this.backendId, waitVisibility.backendId) && Intrinsics.areEqual(this.backendName, waitVisibility.backendName) && this.visible == waitVisibility.visible && Intrinsics.areEqual(this.timeoutMs, waitVisibility.timeoutMs) && this.includePast == waitVisibility.includePast && this.failOnTimeout == waitVisibility.failOnTimeout;
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.backendId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.backendName;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.visible)) * 31;
            Long l = this.timeoutMs;
            return ((((hashCode2 + (l != null ? l.hashCode() : 0)) * 31) + Boolean.hashCode(this.includePast)) * 31) + Boolean.hashCode(this.failOnTimeout);
        }

        public String toString() {
            Integer num = this.backendId;
            String str = this.backendName;
            boolean z = this.visible;
            Long l = this.timeoutMs;
            boolean z2 = this.includePast;
            return "WaitVisibility(backendId=" + num + ", backendName=" + str + ", visible=" + z + ", timeoutMs=" + l + ", includePast=" + z2 + ", failOnTimeout=" + this.failOnTimeout + ")";
        }

        public WaitVisibility(Integer num, String str, boolean z, Long l, boolean z2, boolean z3) {
            super(null);
            this.backendId = num;
            this.backendName = str;
            this.visible = z;
            this.timeoutMs = l;
            this.includePast = z2;
            this.failOnTimeout = z3;
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public final String getBackendName() {
            return this.backendName;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public /* synthetic */ WaitVisibility(Integer num, String str, boolean z, Long l, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, z, (i & 8) != 0 ? 10000L : l, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3);
        }

        public final Long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final boolean getIncludePast() {
            return this.includePast;
        }

        public final boolean getFailOnTimeout() {
            return this.failOnTimeout;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Authorize;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "backendId", "", "backendName", "", HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getUsername", "getPassword", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/miami/game/core/settings/game_test/GameTestStep$Authorize;", "equals", "", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Authorize extends GameTestStep {
        private final Integer backendId;
        private final String backendName;
        private final String password;
        private final String username;

        public Authorize() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Authorize copy$default(Authorize authorize, Integer num, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = authorize.backendId;
            }
            if ((i & 2) != 0) {
                str = authorize.backendName;
            }
            if ((i & 4) != 0) {
                str2 = authorize.username;
            }
            if ((i & 8) != 0) {
                str3 = authorize.password;
            }
            return authorize.copy(num, str, str2, str3);
        }

        public final Integer component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final String component3() {
            return this.username;
        }

        public final String component4() {
            return this.password;
        }

        public final Authorize copy(Integer num, String str, String str2, String str3) {
            return new Authorize(num, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Authorize) {
                Authorize authorize = (Authorize) obj;
                return Intrinsics.areEqual(this.backendId, authorize.backendId) && Intrinsics.areEqual(this.backendName, authorize.backendName) && Intrinsics.areEqual(this.username, authorize.username) && Intrinsics.areEqual(this.password, authorize.password);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.backendId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.backendName;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.username;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.password;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.backendId;
            String str = this.backendName;
            String str2 = this.username;
            return "Authorize(backendId=" + num + ", backendName=" + str + ", username=" + str2 + ", password=" + this.password + ")";
        }

        public Authorize(Integer num, String str, String str2, String str3) {
            super(null);
            this.backendId = num;
            this.backendName = str;
            this.username = str2;
            this.password = str3;
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public /* synthetic */ Authorize(Integer num, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? "AUTHORIZATION" : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final String getBackendName() {
            return this.backendName;
        }

        public final String getUsername() {
            return this.username;
        }

        public final String getPassword() {
            return this.password;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010#\u001a\u00020\fHÆ\u0003J^\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$LoginAndSpawn;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "backendId", "", "backendName", "", HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_PASSWORD, "spawnIndex", "timeoutMs", "", "waitClosed", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Z)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getUsername", "getPassword", "getSpawnIndex", "()I", "getTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWaitClosed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Z)Lcom/miami/game/core/settings/game_test/GameTestStep$LoginAndSpawn;", "equals", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LoginAndSpawn extends GameTestStep {
        private final Integer backendId;
        private final String backendName;
        private final String password;
        private final int spawnIndex;
        private final Long timeoutMs;
        private final String username;
        private final boolean waitClosed;

        public LoginAndSpawn() {
            this(null, null, null, null, 0, null, false, 127, null);
        }

        public static /* synthetic */ LoginAndSpawn copy$default(LoginAndSpawn loginAndSpawn, Integer num, String str, String str2, String str3, int i, Long l, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = loginAndSpawn.backendId;
            }
            if ((i2 & 2) != 0) {
                str = loginAndSpawn.backendName;
            }
            if ((i2 & 4) != 0) {
                str2 = loginAndSpawn.username;
            }
            if ((i2 & 8) != 0) {
                str3 = loginAndSpawn.password;
            }
            if ((i2 & 16) != 0) {
                i = loginAndSpawn.spawnIndex;
            }
            if ((i2 & 32) != 0) {
                l = loginAndSpawn.timeoutMs;
            }
            if ((i2 & 64) != 0) {
                z = loginAndSpawn.waitClosed;
            }
            Long l2 = l;
            boolean z2 = z;
            int i3 = i;
            String str4 = str2;
            return loginAndSpawn.copy(num, str, str4, str3, i3, l2, z2);
        }

        public final Integer component1() {
            return this.backendId;
        }

        public final String component2() {
            return this.backendName;
        }

        public final String component3() {
            return this.username;
        }

        public final String component4() {
            return this.password;
        }

        public final int component5() {
            return this.spawnIndex;
        }

        public final Long component6() {
            return this.timeoutMs;
        }

        public final boolean component7() {
            return this.waitClosed;
        }

        public final LoginAndSpawn copy(Integer num, String str, String str2, String str3, int i, Long l, boolean z) {
            return new LoginAndSpawn(num, str, str2, str3, i, l, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoginAndSpawn) {
                LoginAndSpawn loginAndSpawn = (LoginAndSpawn) obj;
                return Intrinsics.areEqual(this.backendId, loginAndSpawn.backendId) && Intrinsics.areEqual(this.backendName, loginAndSpawn.backendName) && Intrinsics.areEqual(this.username, loginAndSpawn.username) && Intrinsics.areEqual(this.password, loginAndSpawn.password) && this.spawnIndex == loginAndSpawn.spawnIndex && Intrinsics.areEqual(this.timeoutMs, loginAndSpawn.timeoutMs) && this.waitClosed == loginAndSpawn.waitClosed;
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.backendId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.backendName;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.username;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.password;
            int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.spawnIndex)) * 31;
            Long l = this.timeoutMs;
            return ((hashCode4 + (l != null ? l.hashCode() : 0)) * 31) + Boolean.hashCode(this.waitClosed);
        }

        public String toString() {
            Integer num = this.backendId;
            String str = this.backendName;
            String str2 = this.username;
            String str3 = this.password;
            int i = this.spawnIndex;
            Long l = this.timeoutMs;
            return "LoginAndSpawn(backendId=" + num + ", backendName=" + str + ", username=" + str2 + ", password=" + str3 + ", spawnIndex=" + i + ", timeoutMs=" + l + ", waitClosed=" + this.waitClosed + ")";
        }

        public LoginAndSpawn(Integer num, String str, String str2, String str3, int i, Long l, boolean z) {
            super(null);
            this.backendId = num;
            this.backendName = str;
            this.username = str2;
            this.password = str3;
            this.spawnIndex = i;
            this.timeoutMs = l;
            this.waitClosed = z;
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public /* synthetic */ LoginAndSpawn(Integer num, String str, String str2, String str3, int i, Long l, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? "AUTHORIZATION" : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? Long.valueOf((long) GameTestScriptModelKt.DEFAULT_LOGIN_AND_SPAWN_TIMEOUT_MS) : l, (i2 & 64) != 0 ? true : z);
        }

        public final String getBackendName() {
            return this.backendName;
        }

        public final String getUsername() {
            return this.username;
        }

        public final String getPassword() {
            return this.password;
        }

        public final int getSpawnIndex() {
            return this.spawnIndex;
        }

        public final Long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final boolean getWaitClosed() {
            return this.waitClosed;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$AddBackendMessageListener;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "<init>", "(Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;)V", "getListener", "()Lcom/miami/game/core/settings/game_test/GameTestBackendMessageListener;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class AddBackendMessageListener extends GameTestStep {
        private final GameTestBackendMessageListener listener;

        public static /* synthetic */ AddBackendMessageListener copy$default(AddBackendMessageListener addBackendMessageListener, GameTestBackendMessageListener gameTestBackendMessageListener, int i, Object obj) {
            if ((i & 1) != 0) {
                gameTestBackendMessageListener = addBackendMessageListener.listener;
            }
            return addBackendMessageListener.copy(gameTestBackendMessageListener);
        }

        public final GameTestBackendMessageListener component1() {
            return this.listener;
        }

        public final AddBackendMessageListener copy(GameTestBackendMessageListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            return new AddBackendMessageListener(listener);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AddBackendMessageListener) && Intrinsics.areEqual(this.listener, ((AddBackendMessageListener) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public String toString() {
            return "AddBackendMessageListener(listener=" + this.listener + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddBackendMessageListener(GameTestBackendMessageListener listener) {
            super(null);
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        public final GameTestBackendMessageListener getListener() {
            return this.listener;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$RemoveBackendMessageListener;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RemoveBackendMessageListener extends GameTestStep {
        private final String name;

        public static /* synthetic */ RemoveBackendMessageListener copy$default(RemoveBackendMessageListener removeBackendMessageListener, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = removeBackendMessageListener.name;
            }
            return removeBackendMessageListener.copy(str);
        }

        public final String component1() {
            return this.name;
        }

        public final RemoveBackendMessageListener copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new RemoveBackendMessageListener(name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RemoveBackendMessageListener) && Intrinsics.areEqual(this.name, ((RemoveBackendMessageListener) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "RemoveBackendMessageListener(name=" + this.name + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveBackendMessageListener(String name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$ReplayBackendFixture;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "fixturePath", "", TypedValues.AttributesType.S_TARGET, "Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "provider", "<init>", "(Ljava/lang/String;Lcom/miami/game/core/settings/game_test/BackendReplayTarget;Ljava/lang/String;)V", "getFixturePath", "()Ljava/lang/String;", "getTarget", "()Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "getProvider", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ReplayBackendFixture extends GameTestStep {
        private final String fixturePath;
        private final String provider;
        private final BackendReplayTarget target;

        public static /* synthetic */ ReplayBackendFixture copy$default(ReplayBackendFixture replayBackendFixture, String str, BackendReplayTarget backendReplayTarget, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = replayBackendFixture.fixturePath;
            }
            if ((i & 2) != 0) {
                backendReplayTarget = replayBackendFixture.target;
            }
            if ((i & 4) != 0) {
                str2 = replayBackendFixture.provider;
            }
            return replayBackendFixture.copy(str, backendReplayTarget, str2);
        }

        public final String component1() {
            return this.fixturePath;
        }

        public final BackendReplayTarget component2() {
            return this.target;
        }

        public final String component3() {
            return this.provider;
        }

        public final ReplayBackendFixture copy(String fixturePath, BackendReplayTarget target, String str) {
            Intrinsics.checkNotNullParameter(fixturePath, "fixturePath");
            Intrinsics.checkNotNullParameter(target, "target");
            return new ReplayBackendFixture(fixturePath, target, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReplayBackendFixture) {
                ReplayBackendFixture replayBackendFixture = (ReplayBackendFixture) obj;
                return Intrinsics.areEqual(this.fixturePath, replayBackendFixture.fixturePath) && this.target == replayBackendFixture.target && Intrinsics.areEqual(this.provider, replayBackendFixture.provider);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.fixturePath.hashCode() * 31) + this.target.hashCode()) * 31;
            String str = this.provider;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.fixturePath;
            BackendReplayTarget backendReplayTarget = this.target;
            return "ReplayBackendFixture(fixturePath=" + str + ", target=" + backendReplayTarget + ", provider=" + this.provider + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplayBackendFixture(String fixturePath, BackendReplayTarget target, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(fixturePath, "fixturePath");
            Intrinsics.checkNotNullParameter(target, "target");
            this.fixturePath = fixturePath;
            this.target = target;
            this.provider = str;
        }

        public final String getFixturePath() {
            return this.fixturePath;
        }

        public /* synthetic */ ReplayBackendFixture(String str, BackendReplayTarget backendReplayTarget, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? BackendReplayTarget.UI : backendReplayTarget, (i & 4) != 0 ? null : str2);
        }

        public final BackendReplayTarget getTarget() {
            return this.target;
        }

        public final String getProvider() {
            return this.provider;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$StartBackendTrace;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "traceName", "", "<init>", "(Ljava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StartBackendTrace extends GameTestStep {
        private final String traceName;

        public StartBackendTrace() {
            this(null, 1, null);
        }

        public static /* synthetic */ StartBackendTrace copy$default(StartBackendTrace startBackendTrace, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = startBackendTrace.traceName;
            }
            return startBackendTrace.copy(str);
        }

        public final String component1() {
            return this.traceName;
        }

        public final StartBackendTrace copy(String str) {
            return new StartBackendTrace(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartBackendTrace) && Intrinsics.areEqual(this.traceName, ((StartBackendTrace) obj).traceName);
        }

        public int hashCode() {
            String str = this.traceName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "StartBackendTrace(traceName=" + this.traceName + ")";
        }

        public StartBackendTrace(String str) {
            super(null);
            this.traceName = str;
        }

        public /* synthetic */ StartBackendTrace(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getTraceName() {
            return this.traceName;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$StartBackendValidation;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "validationName", "", "provider", "backendId", "", "backendName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getValidationName", "()Ljava/lang/String;", "getProvider", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/miami/game/core/settings/game_test/GameTestStep$StartBackendValidation;", "equals", "", "other", "", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StartBackendValidation extends GameTestStep {
        private final Integer backendId;
        private final String backendName;
        private final String provider;
        private final String validationName;

        public StartBackendValidation() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ StartBackendValidation copy$default(StartBackendValidation startBackendValidation, String str, String str2, Integer num, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = startBackendValidation.validationName;
            }
            if ((i & 2) != 0) {
                str2 = startBackendValidation.provider;
            }
            if ((i & 4) != 0) {
                num = startBackendValidation.backendId;
            }
            if ((i & 8) != 0) {
                str3 = startBackendValidation.backendName;
            }
            return startBackendValidation.copy(str, str2, num, str3);
        }

        public final String component1() {
            return this.validationName;
        }

        public final String component2() {
            return this.provider;
        }

        public final Integer component3() {
            return this.backendId;
        }

        public final String component4() {
            return this.backendName;
        }

        public final StartBackendValidation copy(String str, String str2, Integer num, String str3) {
            return new StartBackendValidation(str, str2, num, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StartBackendValidation) {
                StartBackendValidation startBackendValidation = (StartBackendValidation) obj;
                return Intrinsics.areEqual(this.validationName, startBackendValidation.validationName) && Intrinsics.areEqual(this.provider, startBackendValidation.provider) && Intrinsics.areEqual(this.backendId, startBackendValidation.backendId) && Intrinsics.areEqual(this.backendName, startBackendValidation.backendName);
            }
            return false;
        }

        public int hashCode() {
            String str = this.validationName;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.provider;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.backendId;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            String str3 = this.backendName;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            String str = this.validationName;
            String str2 = this.provider;
            Integer num = this.backendId;
            return "StartBackendValidation(validationName=" + str + ", provider=" + str2 + ", backendId=" + num + ", backendName=" + this.backendName + ")";
        }

        public StartBackendValidation(String str, String str2, Integer num, String str3) {
            super(null);
            this.validationName = str;
            this.provider = str2;
            this.backendId = num;
            this.backendName = str3;
        }

        public /* synthetic */ StartBackendValidation(String str, String str2, Integer num, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3);
        }

        public final String getValidationName() {
            return this.validationName;
        }

        public final String getProvider() {
            return this.provider;
        }

        public final Integer getBackendId() {
            return this.backendId;
        }

        public final String getBackendName() {
            return this.backendName;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Repeat;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "times", "", "steps", "", "<init>", "(ILjava/util/List;)V", "getTimes", "()I", "getSteps", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Repeat extends GameTestStep {
        private final List<GameTestStep> steps;
        private final int times;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Repeat copy$default(Repeat repeat, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = repeat.times;
            }
            if ((i2 & 2) != 0) {
                list = repeat.steps;
            }
            return repeat.copy(i, list);
        }

        public final int component1() {
            return this.times;
        }

        public final List<GameTestStep> component2() {
            return this.steps;
        }

        public final Repeat copy(int i, List<? extends GameTestStep> steps) {
            Intrinsics.checkNotNullParameter(steps, "steps");
            return new Repeat(i, steps);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Repeat) {
                Repeat repeat = (Repeat) obj;
                return this.times == repeat.times && Intrinsics.areEqual(this.steps, repeat.steps);
            }
            return false;
        }

        public int hashCode() {
            return (Integer.hashCode(this.times) * 31) + this.steps.hashCode();
        }

        public String toString() {
            int i = this.times;
            return "Repeat(times=" + i + ", steps=" + this.steps + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Repeat(int i, List<? extends GameTestStep> steps) {
            super(null);
            Intrinsics.checkNotNullParameter(steps, "steps");
            this.times = i;
            this.steps = steps;
        }

        public final int getTimes() {
            return this.times;
        }

        public final List<GameTestStep> getSteps() {
            return this.steps;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$Log;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Log extends GameTestStep {
        private final String message;

        public static /* synthetic */ Log copy$default(Log log, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = log.message;
            }
            return log.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Log copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Log(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Log) && Intrinsics.areEqual(this.message, ((Log) obj).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Log(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Log(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$CloseAll;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "<init>", "()V", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CloseAll extends GameTestStep {
        public static final CloseAll INSTANCE = new CloseAll();

        private CloseAll() {
            super(null);
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$StopBackendTrace;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "<init>", "()V", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StopBackendTrace extends GameTestStep {
        public static final StopBackendTrace INSTANCE = new StopBackendTrace();

        private StopBackendTrace() {
            super(null);
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$StopBackendValidation;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "<init>", "()V", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StopBackendValidation extends GameTestStep {
        public static final StopBackendValidation INSTANCE = new StopBackendValidation();

        private StopBackendValidation() {
            super(null);
        }
    }

    /* compiled from: GameTestScriptModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestStep$ClearBackendMessageListeners;", "Lcom/miami/game/core/settings/game_test/GameTestStep;", "<init>", "()V", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ClearBackendMessageListeners extends GameTestStep {
        public static final ClearBackendMessageListeners INSTANCE = new ClearBackendMessageListeners();

        private ClearBackendMessageListeners() {
            super(null);
        }
    }
}
