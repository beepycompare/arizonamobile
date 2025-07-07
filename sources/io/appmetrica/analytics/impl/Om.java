package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public abstract class Om {
    public final ProtobufStateStorage<Object> a(Context context) {
        return a(context, c(context));
    }

    public abstract ProtobufStateStorage<Object> a(Context context, IBinaryDataHelper iBinaryDataHelper);

    public final ProtobufStateStorage<Object> b(Context context) {
        return a(context, d(context));
    }

    public abstract IBinaryDataHelper c(Context context);

    public abstract IBinaryDataHelper d(Context context);
}
