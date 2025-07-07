package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.Relay;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SimpleNavigation.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0013\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/arkivanov/decompose/router/children/SimpleNavigation;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "<init>", "()V", "relay", "Lcom/arkivanov/decompose/Relay;", "subscribe", "Lcom/arkivanov/decompose/Cancellation;", "observer", "Lkotlin/Function1;", "", "navigate", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/Object;)V", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleNavigation<T> implements NavigationSource<T> {
    private final Relay<T> relay = new Relay<>();

    @Override // com.arkivanov.decompose.router.children.NavigationSource
    public Cancellation subscribe(Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.relay.subscribe(observer);
    }

    public final void navigate(T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.relay.accept(event);
    }
}
