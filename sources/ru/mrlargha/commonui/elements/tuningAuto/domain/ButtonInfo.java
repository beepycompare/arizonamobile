package ru.mrlargha.commonui.elements.tuningAuto.domain;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/ButtonInfo;", "", "name", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getBackgroundColor", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ButtonInfo {
    private final String backgroundColor;
    private final String color;
    private final String name;

    public static /* synthetic */ ButtonInfo copy$default(ButtonInfo buttonInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buttonInfo.name;
        }
        if ((i & 2) != 0) {
            str2 = buttonInfo.backgroundColor;
        }
        if ((i & 4) != 0) {
            str3 = buttonInfo.color;
        }
        return buttonInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.backgroundColor;
    }

    public final String component3() {
        return this.color;
    }

    public final ButtonInfo copy(String name, String backgroundColor, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(color, "color");
        return new ButtonInfo(name, backgroundColor, color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ButtonInfo) {
            ButtonInfo buttonInfo = (ButtonInfo) obj;
            return Intrinsics.areEqual(this.name, buttonInfo.name) && Intrinsics.areEqual(this.backgroundColor, buttonInfo.backgroundColor) && Intrinsics.areEqual(this.color, buttonInfo.color);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.backgroundColor.hashCode()) * 31) + this.color.hashCode();
    }

    public String toString() {
        String str = this.name;
        String str2 = this.backgroundColor;
        return "ButtonInfo(name=" + str + ", backgroundColor=" + str2 + ", color=" + this.color + ")";
    }

    public ButtonInfo(String name, String backgroundColor, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(color, "color");
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public final String getName() {
        return this.name;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getColor() {
        return this.color;
    }
}
