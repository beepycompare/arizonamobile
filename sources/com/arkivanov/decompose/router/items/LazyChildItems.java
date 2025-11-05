package com.arkivanov.decompose.router.items;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.value.Value;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: LazyChildItems.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00050\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u000bJN\u0010\f\u001a\u00020\r2\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000f2$\u0010\u0011\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0004\u0012\u00020\r0\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/arkivanov/decompose/router/items/LazyChildItems;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/items/ChildItems;", "Lcom/arkivanov/decompose/router/items/ItemsNavigator;", "<init>", "()V", "get", "configuration", "(Ljava/lang/Object;)Ljava/lang/Object;", "navigate", "", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/items/Items;", "onComplete", "Lkotlin/Function2;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class LazyChildItems<C, T> extends Value<ChildItems<C, ? extends T>> implements ItemsNavigator<C> {
    public abstract T get(C c);

    public abstract void navigate(Function1<? super Items<C>, Items<C>> function1, Function2<? super Items<C>, ? super Items<C>, Unit> function2);
}
