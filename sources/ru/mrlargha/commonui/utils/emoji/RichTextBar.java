package ru.mrlargha.commonui.utils.emoji;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextBarSpan.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/utils/emoji/RichTextBar;", "", FirebaseAnalytics.Param.LEVEL, "", "current", "", "max", Constants.ScionAnalytics.PARAM_LABEL, "", "<init>", "(IFFLjava/lang/String;)V", "getLevel", "()I", "getCurrent", "()F", "getMax", "getLabel", "()Ljava/lang/String;", "progress", "getProgress", "progressText", "getProgressText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RichTextBar {
    private final float current;
    private final String label;
    private final int level;
    private final float max;

    public static /* synthetic */ RichTextBar copy$default(RichTextBar richTextBar, int i, float f, float f2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = richTextBar.level;
        }
        if ((i2 & 2) != 0) {
            f = richTextBar.current;
        }
        if ((i2 & 4) != 0) {
            f2 = richTextBar.max;
        }
        if ((i2 & 8) != 0) {
            str = richTextBar.label;
        }
        return richTextBar.copy(i, f, f2, str);
    }

    public final int component1() {
        return this.level;
    }

    public final float component2() {
        return this.current;
    }

    public final float component3() {
        return this.max;
    }

    public final String component4() {
        return this.label;
    }

    public final RichTextBar copy(int i, float f, float f2, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new RichTextBar(i, f, f2, label);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RichTextBar) {
            RichTextBar richTextBar = (RichTextBar) obj;
            return this.level == richTextBar.level && Float.compare(this.current, richTextBar.current) == 0 && Float.compare(this.max, richTextBar.max) == 0 && Intrinsics.areEqual(this.label, richTextBar.label);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.level) * 31) + Float.hashCode(this.current)) * 31) + Float.hashCode(this.max)) * 31) + this.label.hashCode();
    }

    public String toString() {
        int i = this.level;
        float f = this.current;
        float f2 = this.max;
        return "RichTextBar(level=" + i + ", current=" + f + ", max=" + f2 + ", label=" + this.label + ")";
    }

    public RichTextBar(int i, float f, float f2, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.level = i;
        this.current = f;
        this.max = f2;
        this.label = label;
    }

    public final int getLevel() {
        return this.level;
    }

    public final float getCurrent() {
        return this.current;
    }

    public final float getMax() {
        return this.max;
    }

    public final String getLabel() {
        return this.label;
    }

    public final float getProgress() {
        float f = this.max;
        if (f <= 0.0f) {
            return 0.0f;
        }
        return RangesKt.coerceIn(this.current / f, 0.0f, 1.0f);
    }

    public final String getProgressText() {
        String barValueText;
        String barValueText2;
        barValueText = RichTextBarSpanKt.toBarValueText(this.current);
        barValueText2 = RichTextBarSpanKt.toBarValueText(this.max);
        return barValueText + " / " + barValueText2;
    }
}
