package ru.mrlargha.commonui.elements.dialogs;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogPlaceholderModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;", "", "text", "", "value", "percent", "", "tiers", "", "Lru/mrlargha/commonui/elements/dialogs/DialogInputCommissionTier;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getValue", "getPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogInputHeaderInfo {
    private final Integer percent;
    private final String text;
    private final List<DialogInputCommissionTier> tiers;
    private final String value;

    public DialogInputHeaderInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DialogInputHeaderInfo copy$default(DialogInputHeaderInfo dialogInputHeaderInfo, String str, String str2, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dialogInputHeaderInfo.text;
        }
        if ((i & 2) != 0) {
            str2 = dialogInputHeaderInfo.value;
        }
        if ((i & 4) != 0) {
            num = dialogInputHeaderInfo.percent;
        }
        if ((i & 8) != 0) {
            list = dialogInputHeaderInfo.tiers;
        }
        return dialogInputHeaderInfo.copy(str, str2, num, list);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.value;
    }

    public final Integer component3() {
        return this.percent;
    }

    public final List<DialogInputCommissionTier> component4() {
        return this.tiers;
    }

    public final DialogInputHeaderInfo copy(String text, String value, Integer num, List<DialogInputCommissionTier> tiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tiers, "tiers");
        return new DialogInputHeaderInfo(text, value, num, tiers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogInputHeaderInfo) {
            DialogInputHeaderInfo dialogInputHeaderInfo = (DialogInputHeaderInfo) obj;
            return Intrinsics.areEqual(this.text, dialogInputHeaderInfo.text) && Intrinsics.areEqual(this.value, dialogInputHeaderInfo.value) && Intrinsics.areEqual(this.percent, dialogInputHeaderInfo.percent) && Intrinsics.areEqual(this.tiers, dialogInputHeaderInfo.tiers);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + this.value.hashCode()) * 31;
        Integer num = this.percent;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.tiers.hashCode();
    }

    public String toString() {
        String str = this.text;
        String str2 = this.value;
        Integer num = this.percent;
        return "DialogInputHeaderInfo(text=" + str + ", value=" + str2 + ", percent=" + num + ", tiers=" + this.tiers + ")";
    }

    public DialogInputHeaderInfo(String text, String value, Integer num, List<DialogInputCommissionTier> tiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tiers, "tiers");
        this.text = text;
        this.value = value;
        this.percent = num;
        this.tiers = tiers;
    }

    public /* synthetic */ DialogInputHeaderInfo(String str, String str2, Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getText() {
        return this.text;
    }

    public final String getValue() {
        return this.value;
    }

    public final Integer getPercent() {
        return this.percent;
    }

    public final List<DialogInputCommissionTier> getTiers() {
        return this.tiers;
    }
}
