package com.arkivanov.decompose;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GettingList.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/GettingList;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "size", "", "get", "Lkotlin/Function1;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "getSize", "()I", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GettingList<T> extends AbstractList<T> {
    private final Function1<Integer, T> get;
    private final int size;

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GettingList(int i, Function1<? super Integer, ? extends T> get) {
        Intrinsics.checkNotNullParameter(get, "get");
        this.size = i;
        this.get = get;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        return this.get.invoke(Integer.valueOf(i));
    }
}
