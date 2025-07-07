package com.arkivanov.decompose.router.pages;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildPages.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002B)\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u001b\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J;\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/router/pages/ChildPages;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, FirebaseAnalytics.Param.ITEMS, "", "Lcom/arkivanov/decompose/Child;", "selectedIndex", "", "<init>", "(Ljava/util/List;I)V", "()V", "getItems", "()Ljava/util/List;", "getSelectedIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildPages<C, T> {
    private final List<Child<C, T>> items;
    private final int selectedIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChildPages copy$default(ChildPages childPages, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = childPages.items;
        }
        if ((i2 & 2) != 0) {
            i = childPages.selectedIndex;
        }
        return childPages.copy(list, i);
    }

    public final List<Child<C, T>> component1() {
        return this.items;
    }

    public final int component2() {
        return this.selectedIndex;
    }

    public final ChildPages<C, T> copy(List<? extends Child<? extends C, ? extends T>> items, int i) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new ChildPages<>(items, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChildPages) {
            ChildPages childPages = (ChildPages) obj;
            return Intrinsics.areEqual(this.items, childPages.items) && this.selectedIndex == childPages.selectedIndex;
        }
        return false;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + Integer.hashCode(this.selectedIndex);
    }

    public String toString() {
        return "ChildPages(items=" + this.items + ", selectedIndex=" + this.selectedIndex + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChildPages(List<? extends Child<? extends C, ? extends T>> items, int i) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.selectedIndex = i;
        if (items.isEmpty()) {
            return;
        }
        int size = items.size();
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final List<Child<C, T>> getItems() {
        return this.items;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public ChildPages() {
        this(CollectionsKt.emptyList(), -1);
    }
}
