package io.appmetrica.analytics.networktasks.internal;

import android.net.Uri;
/* loaded from: classes5.dex */
public interface IParamsAppender<T> {
    void appendParams(Uri.Builder builder, T t);
}
