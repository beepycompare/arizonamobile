package com.arkivanov.decompose.router.webhistory;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.value.Value;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: WebNavigation.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0011J\b\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", ExifInterface.GPS_DIRECTION_TRUE, "", "serializer", "Lkotlinx/serialization/KSerializer;", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "history", "Lcom/arkivanov/decompose/value/Value;", "", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation$HistoryItem;", "getHistory", "()Lcom/arkivanov/decompose/value/Value;", "onBeforeNavigate", "", "navigate", "", "HistoryItem", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WebNavigation<T> {
    Value<List<HistoryItem<T>>> getHistory();

    KSerializer<T> getSerializer();

    void navigate(List<? extends T> list);

    boolean onBeforeNavigate();

    /* compiled from: WebNavigation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/arkivanov/decompose/router/webhistory/WebNavigation$HistoryItem;", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "path", "", "parameters", "", "child", "Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPath", "()Ljava/lang/String;", "getParameters", "()Ljava/util/Map;", "getChild", "()Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class HistoryItem<T> {
        private final WebNavigationOwner child;
        private final T key;
        private final Map<String, String> parameters;
        private final String path;

        public HistoryItem(T t, String path, Map<String, String> parameters, WebNavigationOwner webNavigationOwner) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.key = t;
            this.path = path;
            this.parameters = parameters;
            this.child = webNavigationOwner;
        }

        public final T getKey() {
            return this.key;
        }

        public final String getPath() {
            return this.path;
        }

        public final Map<String, String> getParameters() {
            return this.parameters;
        }

        public final WebNavigationOwner getChild() {
            return this.child;
        }
    }
}
