package com.arkivanov.decompose.router.stack;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.value.Value;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValueExt.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\"G\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"M\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\n\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"M\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\n\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Lcom/arkivanov/decompose/Child$Created;", "C", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "getActive", "(Lcom/arkivanov/decompose/value/Value;)Lcom/arkivanov/decompose/Child$Created;", "backStack", "", "getBackStack", "(Lcom/arkivanov/decompose/value/Value;)Ljava/util/List;", FirebaseAnalytics.Param.ITEMS, "getItems", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValueExtKt {
    public static final <C, T> Child.Created<C, T> getActive(Value<? extends ChildStack<? extends C, ? extends T>> value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        return (Child.Created<? extends C, ? extends T>) value.getValue().getActive();
    }

    public static final <C, T> List<Child.Created<C, T>> getBackStack(Value<? extends ChildStack<? extends C, ? extends T>> value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        return (List<Child.Created<? extends C, ? extends T>>) value.getValue().getBackStack();
    }

    public static final <C, T> List<Child.Created<C, T>> getItems(Value<? extends ChildStack<? extends C, ? extends T>> value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        return (List<Child.Created<? extends C, ? extends T>>) value.getValue().getItems();
    }
}
