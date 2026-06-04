package ru.mrlargha.commonui.elements.event;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* compiled from: BpEventChoice.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/event/ChoiceData;", "", NotificationCompat.CATEGORY_EVENT, "", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "getMain", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChoiceData {
    private final String event;
    private final String main;

    public static /* synthetic */ ChoiceData copy$default(ChoiceData choiceData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = choiceData.event;
        }
        if ((i & 2) != 0) {
            str2 = choiceData.main;
        }
        return choiceData.copy(str, str2);
    }

    public final String component1() {
        return this.event;
    }

    public final String component2() {
        return this.main;
    }

    public final ChoiceData copy(String event, String main) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(main, "main");
        return new ChoiceData(event, main);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChoiceData) {
            ChoiceData choiceData = (ChoiceData) obj;
            return Intrinsics.areEqual(this.event, choiceData.event) && Intrinsics.areEqual(this.main, choiceData.main);
        }
        return false;
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + this.main.hashCode();
    }

    public String toString() {
        String str = this.event;
        return "ChoiceData(event=" + str + ", main=" + this.main + ")";
    }

    public ChoiceData(String event, String main) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(main, "main");
        this.event = event;
        this.main = main;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getMain() {
        return this.main;
    }
}
