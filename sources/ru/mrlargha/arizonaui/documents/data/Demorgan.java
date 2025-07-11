package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/Demorgan;", "", "count", "", "sub_text", "sub_text_color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCount", "()Ljava/lang/String;", "getSub_text", "getSub_text_color", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Demorgan {
    private final String count;
    private final String sub_text;
    private final String sub_text_color;

    public static /* synthetic */ Demorgan copy$default(Demorgan demorgan, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = demorgan.count;
        }
        if ((i & 2) != 0) {
            str2 = demorgan.sub_text;
        }
        if ((i & 4) != 0) {
            str3 = demorgan.sub_text_color;
        }
        return demorgan.copy(str, str2, str3);
    }

    public final String component1() {
        return this.count;
    }

    public final String component2() {
        return this.sub_text;
    }

    public final String component3() {
        return this.sub_text_color;
    }

    public final Demorgan copy(String count, String sub_text, String sub_text_color) {
        Intrinsics.checkNotNullParameter(count, "count");
        Intrinsics.checkNotNullParameter(sub_text, "sub_text");
        Intrinsics.checkNotNullParameter(sub_text_color, "sub_text_color");
        return new Demorgan(count, sub_text, sub_text_color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Demorgan) {
            Demorgan demorgan = (Demorgan) obj;
            return Intrinsics.areEqual(this.count, demorgan.count) && Intrinsics.areEqual(this.sub_text, demorgan.sub_text) && Intrinsics.areEqual(this.sub_text_color, demorgan.sub_text_color);
        }
        return false;
    }

    public int hashCode() {
        return (((this.count.hashCode() * 31) + this.sub_text.hashCode()) * 31) + this.sub_text_color.hashCode();
    }

    public String toString() {
        String str = this.count;
        String str2 = this.sub_text;
        return "Demorgan(count=" + str + ", sub_text=" + str2 + ", sub_text_color=" + this.sub_text_color + ")";
    }

    public Demorgan(String count, String sub_text, String sub_text_color) {
        Intrinsics.checkNotNullParameter(count, "count");
        Intrinsics.checkNotNullParameter(sub_text, "sub_text");
        Intrinsics.checkNotNullParameter(sub_text_color, "sub_text_color");
        this.count = count;
        this.sub_text = sub_text;
        this.sub_text_color = sub_text_color;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getSub_text() {
        return this.sub_text;
    }

    public final String getSub_text_color() {
        return this.sub_text_color;
    }
}
