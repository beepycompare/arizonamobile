package ru.mrlargha.feature.battlepassWinter2025.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BpModalWindowModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/BpModalWindowModel;", "", "title", "", "info", "image", "buttonAcceptText", "buttonCloseText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getInfo", "getImage", "getButtonAcceptText", "getButtonCloseText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "battle-pass_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BpModalWindowModel {
    private final String buttonAcceptText;
    private final String buttonCloseText;
    private final String image;
    private final String info;
    private final String title;

    public static /* synthetic */ BpModalWindowModel copy$default(BpModalWindowModel bpModalWindowModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bpModalWindowModel.title;
        }
        if ((i & 2) != 0) {
            str2 = bpModalWindowModel.info;
        }
        if ((i & 4) != 0) {
            str3 = bpModalWindowModel.image;
        }
        if ((i & 8) != 0) {
            str4 = bpModalWindowModel.buttonAcceptText;
        }
        if ((i & 16) != 0) {
            str5 = bpModalWindowModel.buttonCloseText;
        }
        String str6 = str5;
        String str7 = str3;
        return bpModalWindowModel.copy(str, str2, str7, str4, str6);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.info;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.buttonAcceptText;
    }

    public final String component5() {
        return this.buttonCloseText;
    }

    public final BpModalWindowModel copy(String title, String info, String image, String buttonAcceptText, String buttonCloseText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(buttonAcceptText, "buttonAcceptText");
        Intrinsics.checkNotNullParameter(buttonCloseText, "buttonCloseText");
        return new BpModalWindowModel(title, info, image, buttonAcceptText, buttonCloseText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BpModalWindowModel) {
            BpModalWindowModel bpModalWindowModel = (BpModalWindowModel) obj;
            return Intrinsics.areEqual(this.title, bpModalWindowModel.title) && Intrinsics.areEqual(this.info, bpModalWindowModel.info) && Intrinsics.areEqual(this.image, bpModalWindowModel.image) && Intrinsics.areEqual(this.buttonAcceptText, bpModalWindowModel.buttonAcceptText) && Intrinsics.areEqual(this.buttonCloseText, bpModalWindowModel.buttonCloseText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.info.hashCode()) * 31) + this.image.hashCode()) * 31) + this.buttonAcceptText.hashCode()) * 31) + this.buttonCloseText.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = this.info;
        String str3 = this.image;
        String str4 = this.buttonAcceptText;
        return "BpModalWindowModel(title=" + str + ", info=" + str2 + ", image=" + str3 + ", buttonAcceptText=" + str4 + ", buttonCloseText=" + this.buttonCloseText + ")";
    }

    public BpModalWindowModel(String title, String info, String image, String buttonAcceptText, String buttonCloseText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(buttonAcceptText, "buttonAcceptText");
        Intrinsics.checkNotNullParameter(buttonCloseText, "buttonCloseText");
        this.title = title;
        this.info = info;
        this.image = image;
        this.buttonAcceptText = buttonAcceptText;
        this.buttonCloseText = buttonCloseText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getButtonAcceptText() {
        return this.buttonAcceptText;
    }

    public final String getButtonCloseText() {
        return this.buttonCloseText;
    }
}
