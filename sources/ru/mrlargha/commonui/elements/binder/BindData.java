package ru.mrlargha.commonui.elements.binder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BindData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/binder/BindData;", "", "id", "", "binderName", "", "binderState", "", "<init>", "(ILjava/lang/String;Z)V", "getId", "()I", "getBinderName", "()Ljava/lang/String;", "setBinderName", "(Ljava/lang/String;)V", "getBinderState", "()Z", "setBinderState", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BindData {
    private String binderName;
    private boolean binderState;
    private final int id;

    public static /* synthetic */ BindData copy$default(BindData bindData, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bindData.id;
        }
        if ((i2 & 2) != 0) {
            str = bindData.binderName;
        }
        if ((i2 & 4) != 0) {
            z = bindData.binderState;
        }
        return bindData.copy(i, str, z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.binderName;
    }

    public final boolean component3() {
        return this.binderState;
    }

    public final BindData copy(int i, String binderName, boolean z) {
        Intrinsics.checkNotNullParameter(binderName, "binderName");
        return new BindData(i, binderName, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BindData) {
            BindData bindData = (BindData) obj;
            return this.id == bindData.id && Intrinsics.areEqual(this.binderName, bindData.binderName) && this.binderState == bindData.binderState;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.binderName.hashCode()) * 31) + Boolean.hashCode(this.binderState);
    }

    public String toString() {
        int i = this.id;
        String str = this.binderName;
        return "BindData(id=" + i + ", binderName=" + str + ", binderState=" + this.binderState + ")";
    }

    public BindData(int i, String binderName, boolean z) {
        Intrinsics.checkNotNullParameter(binderName, "binderName");
        this.id = i;
        this.binderName = binderName;
        this.binderState = z;
    }

    public /* synthetic */ BindData(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final String getBinderName() {
        return this.binderName;
    }

    public final boolean getBinderState() {
        return this.binderState;
    }

    public final int getId() {
        return this.id;
    }

    public final void setBinderName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.binderName = str;
    }

    public final void setBinderState(boolean z) {
        this.binderState = z;
    }
}
