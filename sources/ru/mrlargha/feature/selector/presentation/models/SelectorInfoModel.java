package ru.mrlargha.feature.selector.presentation.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectorInfoModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/feature/selector/presentation/models/SelectorInfoModel;", "", "title", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "selector_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectorInfoModel {
    private final String title;
    private final String value;

    public static /* synthetic */ SelectorInfoModel copy$default(SelectorInfoModel selectorInfoModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectorInfoModel.title;
        }
        if ((i & 2) != 0) {
            str2 = selectorInfoModel.value;
        }
        return selectorInfoModel.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.value;
    }

    public final SelectorInfoModel copy(String title, String value) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        return new SelectorInfoModel(title, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectorInfoModel) {
            SelectorInfoModel selectorInfoModel = (SelectorInfoModel) obj;
            return Intrinsics.areEqual(this.title, selectorInfoModel.title) && Intrinsics.areEqual(this.value, selectorInfoModel.value);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "SelectorInfoModel(title=" + str + ", value=" + this.value + ")";
    }

    public SelectorInfoModel(String title, String value) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        this.title = title;
        this.value = value;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getValue() {
        return this.value;
    }
}
