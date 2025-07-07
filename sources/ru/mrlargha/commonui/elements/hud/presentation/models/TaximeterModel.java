package ru.mrlargha.commonui.elements.hud.presentation.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TaximeterModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/models/TaximeterModel;", "", "show", "", "buttonText", "", "<init>", "(ILjava/lang/String;)V", "getShow", "()I", "getButtonText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaximeterModel {
    @SerializedName("button")
    private final String buttonText;
    @SerializedName("show")
    private final int show;

    public static /* synthetic */ TaximeterModel copy$default(TaximeterModel taximeterModel, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taximeterModel.show;
        }
        if ((i2 & 2) != 0) {
            str = taximeterModel.buttonText;
        }
        return taximeterModel.copy(i, str);
    }

    public final int component1() {
        return this.show;
    }

    public final String component2() {
        return this.buttonText;
    }

    public final TaximeterModel copy(int i, String buttonText) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new TaximeterModel(i, buttonText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TaximeterModel) {
            TaximeterModel taximeterModel = (TaximeterModel) obj;
            return this.show == taximeterModel.show && Intrinsics.areEqual(this.buttonText, taximeterModel.buttonText);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.show) * 31) + this.buttonText.hashCode();
    }

    public String toString() {
        int i = this.show;
        return "TaximeterModel(show=" + i + ", buttonText=" + this.buttonText + ")";
    }

    public TaximeterModel(int i, String buttonText) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.show = i;
        this.buttonText = buttonText;
    }

    public final int getShow() {
        return this.show;
    }

    public final String getButtonText() {
        return this.buttonText;
    }
}
