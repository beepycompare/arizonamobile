package ru.mrlargha.commonui.elements.dice;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Dice.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceChatMessageData;", "", "text", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiceChatMessageData {
    private final String name;
    private final String text;

    public static /* synthetic */ DiceChatMessageData copy$default(DiceChatMessageData diceChatMessageData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diceChatMessageData.text;
        }
        if ((i & 2) != 0) {
            str2 = diceChatMessageData.name;
        }
        return diceChatMessageData.copy(str, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.name;
    }

    public final DiceChatMessageData copy(String text, String name) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(name, "name");
        return new DiceChatMessageData(text, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiceChatMessageData) {
            DiceChatMessageData diceChatMessageData = (DiceChatMessageData) obj;
            return Intrinsics.areEqual(this.text, diceChatMessageData.text) && Intrinsics.areEqual(this.name, diceChatMessageData.name);
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        String str = this.text;
        return "DiceChatMessageData(text=" + str + ", name=" + this.name + ")";
    }

    public DiceChatMessageData(String text, String name) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(name, "name");
        this.text = text;
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final String getText() {
        return this.text;
    }
}
