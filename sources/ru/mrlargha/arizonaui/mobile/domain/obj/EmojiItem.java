package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/EmojiItem;", "", "unicodeServer", "", "unicodeAndroid", "", "<init>", "(Ljava/lang/String;I)V", "getUnicodeServer", "()Ljava/lang/String;", "getUnicodeAndroid", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmojiItem {
    private final int unicodeAndroid;
    private final String unicodeServer;

    public static /* synthetic */ EmojiItem copy$default(EmojiItem emojiItem, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = emojiItem.unicodeServer;
        }
        if ((i2 & 2) != 0) {
            i = emojiItem.unicodeAndroid;
        }
        return emojiItem.copy(str, i);
    }

    public final String component1() {
        return this.unicodeServer;
    }

    public final int component2() {
        return this.unicodeAndroid;
    }

    public final EmojiItem copy(String unicodeServer, int i) {
        Intrinsics.checkNotNullParameter(unicodeServer, "unicodeServer");
        return new EmojiItem(unicodeServer, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmojiItem) {
            EmojiItem emojiItem = (EmojiItem) obj;
            return Intrinsics.areEqual(this.unicodeServer, emojiItem.unicodeServer) && this.unicodeAndroid == emojiItem.unicodeAndroid;
        }
        return false;
    }

    public int hashCode() {
        return (this.unicodeServer.hashCode() * 31) + Integer.hashCode(this.unicodeAndroid);
    }

    public String toString() {
        String str = this.unicodeServer;
        return "EmojiItem(unicodeServer=" + str + ", unicodeAndroid=" + this.unicodeAndroid + ")";
    }

    public EmojiItem(String unicodeServer, int i) {
        Intrinsics.checkNotNullParameter(unicodeServer, "unicodeServer");
        this.unicodeServer = unicodeServer;
        this.unicodeAndroid = i;
    }

    public final String getUnicodeServer() {
        return this.unicodeServer;
    }

    public final int getUnicodeAndroid() {
        return this.unicodeAndroid;
    }
}
