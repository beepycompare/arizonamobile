package com.arkivanov.decompose.router.slot;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.value.Value;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValueExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"I\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"child", "Lcom/arkivanov/decompose/Child$Created;", "C", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/slot/ChildSlot;", "getChild", "(Lcom/arkivanov/decompose/value/Value;)Lcom/arkivanov/decompose/Child$Created;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValueExtKt {
    public static final <C, T> Child.Created<C, T> getChild(Value<? extends ChildSlot<? extends C, ? extends T>> value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        return (Child.Created<? extends C, ? extends T>) value.getValue().getChild();
    }
}
