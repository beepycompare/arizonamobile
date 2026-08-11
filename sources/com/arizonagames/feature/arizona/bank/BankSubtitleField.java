package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@JsonAdapter(BankSubtitleFieldJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\t0\u0013¨\u0006\u0010"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankSubtitleField;", "", "subtitle", "", "<init>", "(Ljava/lang/String;)V", "getSubtitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bank", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankSubtitleFieldJsonAdapter;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankSubtitleField {
    private final String subtitle;

    public BankSubtitleField() {
        this(null, 1, null);
    }

    public static /* synthetic */ BankSubtitleField copy$default(BankSubtitleField bankSubtitleField, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bankSubtitleField.subtitle;
        }
        return bankSubtitleField.copy(str);
    }

    public final String component1() {
        return this.subtitle;
    }

    public final BankSubtitleField copy(String subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        return new BankSubtitleField(subtitle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BankSubtitleField) && Intrinsics.areEqual(this.subtitle, ((BankSubtitleField) obj).subtitle);
    }

    public int hashCode() {
        return this.subtitle.hashCode();
    }

    public String toString() {
        return "BankSubtitleField(subtitle=" + this.subtitle + ")";
    }

    public BankSubtitleField(String subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        this.subtitle = subtitle;
    }

    public /* synthetic */ BankSubtitleField(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getSubtitle() {
        return this.subtitle;
    }
}
