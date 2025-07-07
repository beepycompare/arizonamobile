package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/ShowPopup;", "", "responseId", "", "color", "", "title", "text", "buttonSecondary", "Lru/mrlargha/commonui/elements/tuningAuto/domain/ButtonInfo;", "buttonPrimary", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/mrlargha/commonui/elements/tuningAuto/domain/ButtonInfo;Lru/mrlargha/commonui/elements/tuningAuto/domain/ButtonInfo;)V", "getResponseId", "()I", "getColor", "()Ljava/lang/String;", "getTitle", "getText", "getButtonSecondary", "()Lru/mrlargha/commonui/elements/tuningAuto/domain/ButtonInfo;", "getButtonPrimary", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShowPopup {
    private final ButtonInfo buttonPrimary;
    private final ButtonInfo buttonSecondary;
    private final String color;
    private final int responseId;
    private final String text;
    private final String title;

    public static /* synthetic */ ShowPopup copy$default(ShowPopup showPopup, int i, String str, String str2, String str3, ButtonInfo buttonInfo, ButtonInfo buttonInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = showPopup.responseId;
        }
        if ((i2 & 2) != 0) {
            str = showPopup.color;
        }
        if ((i2 & 4) != 0) {
            str2 = showPopup.title;
        }
        if ((i2 & 8) != 0) {
            str3 = showPopup.text;
        }
        if ((i2 & 16) != 0) {
            buttonInfo = showPopup.buttonSecondary;
        }
        if ((i2 & 32) != 0) {
            buttonInfo2 = showPopup.buttonPrimary;
        }
        ButtonInfo buttonInfo3 = buttonInfo;
        ButtonInfo buttonInfo4 = buttonInfo2;
        return showPopup.copy(i, str, str2, str3, buttonInfo3, buttonInfo4);
    }

    public final int component1() {
        return this.responseId;
    }

    public final String component2() {
        return this.color;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.text;
    }

    public final ButtonInfo component5() {
        return this.buttonSecondary;
    }

    public final ButtonInfo component6() {
        return this.buttonPrimary;
    }

    public final ShowPopup copy(int i, String color, String title, String text, ButtonInfo buttonSecondary, ButtonInfo buttonPrimary) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(buttonSecondary, "buttonSecondary");
        Intrinsics.checkNotNullParameter(buttonPrimary, "buttonPrimary");
        return new ShowPopup(i, color, title, text, buttonSecondary, buttonPrimary);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShowPopup) {
            ShowPopup showPopup = (ShowPopup) obj;
            return this.responseId == showPopup.responseId && Intrinsics.areEqual(this.color, showPopup.color) && Intrinsics.areEqual(this.title, showPopup.title) && Intrinsics.areEqual(this.text, showPopup.text) && Intrinsics.areEqual(this.buttonSecondary, showPopup.buttonSecondary) && Intrinsics.areEqual(this.buttonPrimary, showPopup.buttonPrimary);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.responseId) * 31) + this.color.hashCode()) * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31) + this.buttonSecondary.hashCode()) * 31) + this.buttonPrimary.hashCode();
    }

    public String toString() {
        int i = this.responseId;
        String str = this.color;
        String str2 = this.title;
        String str3 = this.text;
        ButtonInfo buttonInfo = this.buttonSecondary;
        return "ShowPopup(responseId=" + i + ", color=" + str + ", title=" + str2 + ", text=" + str3 + ", buttonSecondary=" + buttonInfo + ", buttonPrimary=" + this.buttonPrimary + ")";
    }

    public ShowPopup(int i, String color, String title, String text, ButtonInfo buttonSecondary, ButtonInfo buttonPrimary) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(buttonSecondary, "buttonSecondary");
        Intrinsics.checkNotNullParameter(buttonPrimary, "buttonPrimary");
        this.responseId = i;
        this.color = color;
        this.title = title;
        this.text = text;
        this.buttonSecondary = buttonSecondary;
        this.buttonPrimary = buttonPrimary;
    }

    public final int getResponseId() {
        return this.responseId;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getText() {
        return this.text;
    }

    public final ButtonInfo getButtonSecondary() {
        return this.buttonSecondary;
    }

    public final ButtonInfo getButtonPrimary() {
        return this.buttonPrimary;
    }
}
